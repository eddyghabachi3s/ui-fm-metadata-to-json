package fr.unice.i3s.knowledgeflows.json.generator;

import fr.unice.i3s.knowledgeflows.json.model.FeatureAnnotation;

/**
 * Created by urli on 04/04/2016.
 */
public class LineParser {

    private FeatureAnnotation annotation;

    public LineParser() {
        this.annotation = new FeatureAnnotation();
    }

    public void setId(String input) {
        this.annotation.setId(input);
    }

    public FeatureAnnotation getResult() {
        return this.annotation;
    }
}
