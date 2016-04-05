package fr.unice.i3s.knowledgeflows.json.generator;

import fr.unice.i3s.knowledgeflows.json.generator.mappings.MappingBoolean;
import fr.unice.i3s.knowledgeflows.json.generator.mappings.MappingFeatureType;
import fr.unice.i3s.knowledgeflows.json.model.FMAnnotation;
import fr.unice.i3s.knowledgeflows.json.model.FeatureAnnotation;
import net.sf.json.JSONSerializer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by urli on 04/04/2016.
 */
public class XSVParser {

    private String outputPath;
    private BufferedReader xsvreader;
    private CSVFormat format;

    public XSVParser(String inputPath, String outputPath) throws IOException {
        this.xsvreader = new BufferedReader(new FileReader(inputPath));
        this.outputPath = outputPath;
        this.guessSeparationCharacterFromInputPath(inputPath);
    }

    private void guessSeparationCharacterFromInputPath(String inputPath) {
        if (inputPath.endsWith(".excel.csv")) {
            this.format = CSVFormat.EXCEL.withHeader(ColumnNames.getAllNames());
        } else if (inputPath.endsWith("tsv")) {
            this.format = CSVFormat.TDF.withHeader(ColumnNames.getAllNames());
        } else {
            this.format = CSVFormat.DEFAULT.withHeader(ColumnNames.getAllNames());
        }
    }

    public void readAndParse() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FMAnnotation annotation = new FMAnnotation();

        CSVParser parser = format.parse(this.xsvreader);
        int i = 0;
        for (CSVRecord record : parser.getRecords()) {
            if (i++ > 0) {
                FeatureAnnotation feature = new FeatureAnnotation();

                feature.setId(record.get(ColumnNames.ID.getRealName()));

                for (MappingFeatureType mft : MappingFeatureType.values()) {
                    if (mft.getCode().equals(record.get(ColumnNames.TYPE.getRealName()))) {
                        feature.setType(mft.getType());
                    }
                }
                feature.setLogo(record.get(ColumnNames.LOGO.getRealName()));
                feature.setPhrase(record.get(ColumnNames.PHRASE.getRealName()));
                feature.setReferences(record.get(ColumnNames.REFERENCES.getRealName()));
                feature.setDisplayIfSelected(MappingBoolean.checkValue(record.get(ColumnNames.DISPLAYIFSELECTED.getRealName())));
                feature.setDescription(record.get(ColumnNames.DESC.getRealName()));
                feature.setShortDescription(record.get(ColumnNames.SHORTDESC.getRealName()));
                feature.setQuestionable(MappingBoolean.checkValue(record.get(ColumnNames.QUESTION.getRealName())));
                feature.setName(record.get(ColumnNames.NAME.getRealName()));
                feature.setVisible(MappingBoolean.checkValue(record.get(ColumnNames.VISIBLE.getRealName())));

                annotation.addFeature(feature);
            }
        }

        DateFormat dateFormatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, new Locale("fr","FR"));
        Date today = new Date();
        String dateOut = dateFormatter.format(today);
        annotation.setDate(dateOut);

        OutputStreamWriter fw = new OutputStreamWriter(
                new FileOutputStream(this.outputPath),
                Charset.forName("UTF-8").newEncoder()
        );

        fw.write(JSONSerializer.toJSON(annotation).toString());
        fw.flush();
        fw.close();

        System.out.println("[SUCCESS] Output written in "+this.outputPath);
    }
}
