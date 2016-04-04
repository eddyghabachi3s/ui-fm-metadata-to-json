package fr.unice.i3s.knowledgeflows.json.metadata.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by urli on 04/04/2016.
 */
@XmlRootElement
public enum FeatureType {
    LEAF,
    MANDATORY,
    GROUP,
    OPTIONAL
}
