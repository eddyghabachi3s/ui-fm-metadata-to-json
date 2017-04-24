package fr.unice.i3s.knowledgeflows.json.model;

import net.sf.json.JSONArray;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by urli on 04/04/2016.
 */
@XmlRootElement
public class FMAnnotation {

    private String date;
    private JSONArray filters = JSONArray.fromObject("[\n" +
            "    {\n" +
            "      \"id\": \"METRICS\",\n" +
            "      \"elements\": [\n" +
            "        {\n" +
            "          \"name\": \"Estimate\",\n" +
            "          \"id\": \"pred\",\n" +
            "          \"type\": \"double\",\n" +
            "          \"decimalplaces\": 3,\n" +
            "          \"better\": \"high\",\n" +
            "          \"unknownValue\": -1\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Standard Deviation\",\n" +
            "          \"id\": \"stdev\",\n" +
            "          \"type\": \"double\",\n" +
            "          \"decimalplaces\": 3,\n" +
            "          \"better\": \"low\",\n" +
            "          \"unknownValue\": -1\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Rank\",\n" +
            "          \"id\": \"rank\",\n" +
            "          \"type\": \"int\",\n" +
            "          \"better\": \"low\",\n" +
            "          \"unknownValue\": -1\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Class\",\n" +
            "          \"id\": \"status\",\n" +
            "          \"type\": \"ordinal\",\n" +
            "          \"canBeUnknown\": true,\n" +
            "          \"unknownValue\": \"Unknown\",\n" +
            "          \"orderedValues\": [\n" +
            "            \"Best\",\n" +
            "            \"Great\",\n" +
            "            \"Good\",\n" +
            "            \"Average\",\n" +
            "            \"Bad\",\n" +
            "            \"Worst\"\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"columns\": [\n" +
            "        {\n" +
            "          \"name\": \"Accuracy\",\n" +
            "          \"id\": \"acc\",\n" +
            "          \"elements\": [\n" +
            "            {\n" +
            "              \"element\": \"pred\",\n" +
            "              \"unit\": \"%\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"element\": \"stdev\",\n" +
            "              \"unit\": \"%\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"element\": \"rank\",\n" +
            "              \"unit\": \"NONE\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"element\": \"status\",\n" +
            "              \"unit\": \"NONE\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Execution Time\",\n" +
            "          \"id\": \"time\",\n" +
            "          \"elements\": [\n" +
            "            {\n" +
            "              \"element\": \"pred\",\n" +
            "              \"better\": \"low\",\n" +
            "              \"unit\": \"ms\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"element\": \"stdev\",\n" +
            "              \"unit\": \"ms\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"element\": \"rank\",\n" +
            "              \"unit\": \"NONE\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"element\": \"status\",\n" +
            "              \"unit\": \"NONE\"\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Model Size\",\n" +
            "          \"id\": \"size\",\n" +
            "          \"elements\": [\n" +
            "            {\n" +
            "              \"element\": \"pred\",\n" +
            "              \"better\": \"low\",\n" +
            "              \"decimalplaces\": 2,\n" +
            "              \"unit\": \"bytes\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"element\": \"stdev\",\n" +
            "              \"decimalplaces\": 2,\n" +
            "              \"unit\": \"bytes\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"element\": \"rank\",\n" +
            "              \"unit\": \"NONE\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"element\": \"status\",\n" +
            "              \"unit\": \"NONE\"\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ]");
    private List<FeatureAnnotation> features;

    public FMAnnotation() {
        features = new ArrayList<FeatureAnnotation>();
    }

    public List<FeatureAnnotation> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureAnnotation> features) {
        this.features = features;
    }

    public void addFeature(FeatureAnnotation feature) {
        this.features.add(feature);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public JSONArray getFilters() {
        return filters;
    }

    public void setFilters(JSONArray filters) {
        this.filters = filters;
    }
}
