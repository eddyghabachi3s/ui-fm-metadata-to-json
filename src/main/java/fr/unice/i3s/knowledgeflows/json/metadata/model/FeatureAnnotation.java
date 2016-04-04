package fr.unice.i3s.knowledgeflows.json.metadata.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by urli on 04/04/2016.
 */
@XmlRootElement
public class FeatureAnnotation {

    private String id;
    private FeatureType type;
    private String name;
    private String shortDescription;
    private boolean questionable;
    private String phrase;
    private String description;
    private String examples;
    private String logo;
    private boolean visible;
    private boolean displayIfVisible;
    private String references;

    public FeatureAnnotation() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FeatureType getType() {
        return type;
    }

    public void setType(FeatureType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public boolean isQuestionable() {
        return questionable;
    }

    public void setQuestionable(boolean questionable) {
        this.questionable = questionable;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExamples() {
        return examples;
    }

    public void setExamples(String examples) {
        this.examples = examples;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isDisplayIfVisible() {
        return displayIfVisible;
    }

    public void setDisplayIfVisible(boolean displayIfVisible) {
        this.displayIfVisible = displayIfVisible;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }
}
