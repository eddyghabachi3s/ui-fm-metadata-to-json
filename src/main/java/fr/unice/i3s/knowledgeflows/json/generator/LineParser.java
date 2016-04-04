package fr.unice.i3s.knowledgeflows.json.generator;

import fr.unice.i3s.knowledgeflows.json.model.FeatureAnnotation;
import fr.unice.i3s.knowledgeflows.json.model.FeatureType;

/**
 * Created by urli on 04/04/2016.
 */
public class LineParser {

    private FeatureAnnotation annotation;

    public LineParser() {
        this.annotation = new FeatureAnnotation();
    }

    public FeatureAnnotation getResult() {
        return this.annotation;
    }

    public void setId(String input) {
        this.annotation.setId(input);
    }

    public void setType(String input) {
        for (MappingFeatureType mft : MappingFeatureType.values()) {
            if (mft.getCode().equals(input)) {
                this.annotation.setType(mft.getType());
            }
        }
    }

}
