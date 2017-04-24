package fr.unice.i3s.knowledgeflows.json.generator.mappings;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * Created by camillie on 12/04/2017.
 */
public class MappingJsonObject {

    public static JSONObject checkValue(String input) {
        try {
            return (JSONObject.fromObject(input));
        } catch (JSONException e) {
            return new JSONObject();
        }
    }
}
