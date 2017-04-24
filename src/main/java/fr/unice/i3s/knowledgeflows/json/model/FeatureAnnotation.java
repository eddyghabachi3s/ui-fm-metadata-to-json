package fr.unice.i3s.knowledgeflows.json.model;

import net.sf.json.JSONObject;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by urli on 04/04/2016.
 */
@XmlRootElement
public class FeatureAnnotation {

    private String id;
    private String shortDescription;
    private int order;
    private boolean questionable;
    private String phrase;
    private String description;
    private String examples;
    private String logo;
    private boolean visible;
    private boolean displayIfSelected;
    private boolean delayable;
    private String references;
    private String filterBy;
    private JSONObject values;

    public FeatureAnnotation() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isDisplayIfSelected() {
        return displayIfSelected;
    }

    public void setDisplayIfSelected(boolean displayIfSelected) {
        this.displayIfSelected = displayIfSelected;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isDelayable() {
        return this.delayable;
    }

    public void setDelayable(boolean delayable) {
        this.delayable = delayable;
    }

    public String getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }

    public JSONObject getValues() {
        return values;
    }

    public void setValues(JSONObject values) {
        this.values = values;
    }
}
