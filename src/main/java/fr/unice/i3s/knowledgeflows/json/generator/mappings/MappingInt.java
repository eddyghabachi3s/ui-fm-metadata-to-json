package fr.unice.i3s.knowledgeflows.json.generator.mappings;

/**
 * Created by urli on 04/04/2016.
 */
public class MappingInt {

    public static int checkValue(String input) {
        try {
            return (Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
