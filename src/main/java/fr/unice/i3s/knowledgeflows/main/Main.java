package fr.unice.i3s.knowledgeflows.main;

import fr.unice.i3s.knowledgeflows.json.generator.XSVParser;

import java.io.File;

/**
 * Created by urli on 04/04/2016.
 */
public class Main {

    private static final String DEFAULT_FILENAME = "output.json";

    private static void usage() {
        String cmdName = "java -jar ui-fm-metadata-generator.jar";

        String usage = "Utility tool to generate asset JSON file for configuration interface of Knowledge Flows project: "+
                "\nUsage:"+
                "\n"+cmdName+" -h"+
                "\n"+cmdName+" <input.csv> [output]"+
                "\n\t -h: display this usage"+
                "\n\t <input>: path to the CSV/TSV file containing metadata information. Extension of the file will be used to parse file: .tsv means the separating character use tabulation, .csv means it is a default CSV, .excel.csv means it's an excel CSV."+
                "\n\t [output]: optionnal output path to store datas. If omitted the produced file will be "+DEFAULT_FILENAME+" in the current directory.";

        System.out.println(usage);
        System.exit(0);
    }

    private static void checkInput(String inputPath) {
        File input = new File(inputPath);

        if (!input.exists() || !input.canRead()) {
            System.err.println("The following file does not exist or cannot be read: "+inputPath);
            System.exit(0);
        }
    }

    private static String checkAndCompleteOutput(String outputPath) {

        String result = outputPath;
        File output = new File(outputPath);

        if (!output.exists()) {
            if (output.isDirectory()) {
                output.mkdirs();
            } else {
                output.getParentFile().mkdirs();
            }
        } else {
            if (output.isFile()) {
                System.err.println("Error: the following file already exists: "+outputPath);
                System.exit(0);
            }
        }

        if (output.isDirectory()) {
            result = output.getAbsolutePath()+File.separator+DEFAULT_FILENAME;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1 || args[0].equals("-h")) {
            usage();
        }

        String inputPath = args[0];
        checkInput(inputPath);

        String outputPath;
        if (args.length == 1) {
            outputPath = ".";
        } else {
            outputPath = args[1];
        }

        outputPath = checkAndCompleteOutput(outputPath);


        XSVParser parser = new XSVParser(inputPath, outputPath);
        parser.readAndParse();

    }
}
