package fr.unice.i3s.knowledgeflows.json.generator;

import java.io.*;
import java.util.Map;

/**
 * Created by urli on 04/04/2016.
 */
public class XSVParser {

    private static final String DEFAULT_SEPARATION_CHARACTER = ";";
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
        String extension = inputPath.substring(inputPath.length()-4);
        if (extension.equals("csv")) {
            this.separationCharacter = ";";
        } else if (extension.equals("tsv")) {
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


}
