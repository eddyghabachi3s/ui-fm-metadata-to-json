package fr.unice.i3s.knowledgeflows.json.generator;

import fr.unice.i3s.knowledgeflows.json.model.FMAnnotation;
import net.sf.json.JSONSerializer;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Created by urli on 04/04/2016.
 */
public class XSVParser {

    private static final String DEFAULT_SEPARATION_CHARACTER = ";";
    private static final String DEFAULT_FILENAME = "output.json";

    private String separationCharacter;
    private String outputPath;
    private BufferedReader xsvreader;
    private Map<ColumnNames,Integer> columnsOrder;

    public XSVParser(String inputPath, String outputPath, ColumnNames[] columns) throws IOException, GeneratorException {
        this.xsvreader = new BufferedReader(new FileReader(inputPath));
        this.outputPath = outputPath;
        this.guessSeparationCharacterFromInputPath(inputPath);
        this.initColumns(columns);
    }

    private void guessSeparationCharacterFromInputPath(String inputPath) {
        if (inputPath.endsWith("csv")) {
            this.separationCharacter = ";";
        } else if (inputPath.endsWith("tsv")) {
            this.separationCharacter = "\t";
        } else {
            this.separationCharacter = DEFAULT_SEPARATION_CHARACTER;
        }
    }

    private String[] readAndSplit() throws IOException {
        return this.xsvreader.readLine().split(this.separationCharacter);
    }

    private void initColumns(ColumnNames[] columns) throws IOException, GeneratorException {
        String[] readColumns = this.readAndSplit();
        int i = 0;
        for (String c : readColumns) {
            for (ColumnNames cn : columns) {
                if (cn.getRealName().equals(c.trim())) {
                    System.out.println(c.trim());
                    this.columnsOrder.put(cn, i);
                    break;
                }
            }
            i++;
        }

        if (this.columnsOrder.size() != columns.length) {
            if (this.separationCharacter.equals(";")) {
                this.separationCharacter = ",";
                this.initColumns(columns);
            } else {
                throw new GeneratorException("Some columns are missing ! Character used for separation: "+this.separationCharacter+". Columns read:"+readColumns);
            }
        }
    }

    private void prepareOutput() {
        File output = new File(this.outputPath);

        if (output.isDirectory()) {
            output.mkdirs();
            this.outputPath = output.getAbsolutePath()+File.separator+DEFAULT_FILENAME;
        } else {
            File dir = output.getParentFile();
            dir.mkdirs();
        }
    }

    public void readAndParse() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FMAnnotation annotation = new FMAnnotation();

        int lineNumber = 0;
        while (this.xsvreader.ready()) {
            lineNumber++;
            String[] chunks = this.readAndSplit();
            LineParser parser = new LineParser();

            for (ColumnNames cn : this.columnsOrder.keySet()) {
                int col = this.columnsOrder.get(cn);
                if (col >= chunks.length) {
                    System.out.println("[WARNING] Some columns must be empty: column #"+col+" named "+cn.getRealName()+" on line #"+lineNumber);
                } else {
                    Method method = LineParser.class.getMethod(cn.getMethodName(), String.class);
                    String input = chunks[col].trim();

                    if (input.startsWith("\"") && input.endsWith("\"")) {
                        input = input.substring(1, input.length()-2).trim();
                    }

                    method.invoke(parser, input);
                }
            }

            annotation.addFeature(parser.getResult());
        }

        DateFormat dateFormatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, new Locale("fr","FR"));
        Date today = new Date();
        String dateOut = dateFormatter.format(today);
        annotation.setDate(dateOut);

        this.prepareOutput();

        OutputStreamWriter fw = new OutputStreamWriter(
                new FileOutputStream(this.outputPath),
                Charset.forName("UTF-8").newEncoder()
        );

        fw.write(JSONSerializer.toJSON(annotation).toString());
        fw.flush();
        fw.close();
    }
}
