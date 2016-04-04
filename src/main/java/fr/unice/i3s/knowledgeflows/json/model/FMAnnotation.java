package fr.unice.i3s.knowledgeflows.json.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by urli on 04/04/2016.
 */
@XmlRootElement
public class FMAnnotation {

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
}
