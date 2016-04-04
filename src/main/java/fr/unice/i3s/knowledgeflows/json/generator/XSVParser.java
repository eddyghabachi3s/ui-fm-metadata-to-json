package fr.unice.i3s.knowledgeflows.json.generator;

import java.io.*;
import java.util.Map;

/**
 * Created by urli on 04/04/2016.
 */
public class XSVParser {

    protected String separationCharacter;
    protected String outputPath;
    protected BufferedReader xsvreader;
    protected Map<ColumnNames,Integer> columnsOrder;

    public XSVParser(String inputPath, String outputPath, ColumnNames[] columns, String separationCharacter) throws IOException, GeneratorException {
        this.xsvreader = new BufferedReader(new FileReader(inputPath));
        this.outputPath = outputPath;
        this.separationCharacter = separationCharacter;
        this.initColumns(columns);
    }

    protected String[] readAndSplit() throws IOException {
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

        if (this.columnsOrder.size() != columns.length)
            throw new GeneratorException("Some columns are missing !"+this.columnsOrder);
    }
}
