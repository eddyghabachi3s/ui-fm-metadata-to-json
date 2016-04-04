package fr.unice.i3s.knowledgeflows.json.generator;

import fr.unice.i3s.knowledgeflows.json.generator.mappings.MappingBoolean;
import fr.unice.i3s.knowledgeflows.json.generator.mappings.MappingFeatureType;
import fr.unice.i3s.knowledgeflows.json.model.FeatureAnnotation;

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

    public void setName(String input) {
        this.annotation.setName(input);
    }

    public void setShortDesc(String input) {
        this.annotation.setShortDescription(input);
    }

    public void setQuestion(String input) {
        this.annotation.setQuestionable(MappingBoolean.checkValue(input));
    }

    public void setPhrase(String input) {
        this.annotation.setPhrase(input);
    }

    public void setDesc(String input) {
        this.annotation.setDescription(input);
    }

    public void setExamples(String input) {
        this.annotation.setExamples(input);
    }

    public void setLogo(String input) {
        this.annotation.setLogo(input);
    }

    public void setVisible(String input) {
        this.annotation.setVisible(MappingBoolean.checkValue(input));
    }

    public void setDisplayIfSelected(String input) {
        this.annotation.setDisplayIfVisible(MappingBoolean.checkValue(input));
    }

    public void setReference(String input) {
        this.annotation.setReferences(input);
    }

}
