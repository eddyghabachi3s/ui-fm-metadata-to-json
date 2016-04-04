package fr.unice.i3s.knowledgeflows.main;

/**
 * Created by urli on 04/04/2016.
 */
public class Main {

    public void usage() {
        String cmdName = "java -jar ui-fm-metadata-generator.jar";

        String usage = "Utility tool to generate asset JSON file for configuration interface of Knowledge Flows project: "+
                "\nUsage:"+
                "\n"+cmdName+" -h"+
                "\n"+cmdName+" <input.csv> [output]"+
                "\n\t -h: display this usage"+
                "\n\t <input.csv>: path to the CSV file containing metadata information"+
                "\n\t [output]: optionnal output path to store datas. If omitted the produced file will be output.json in the current directory.";

        System.out.println(usage);
        System.exit(0);
    }

    public static void main(String[] args) {

    }
}
