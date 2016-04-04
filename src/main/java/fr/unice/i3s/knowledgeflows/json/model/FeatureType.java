package fr.unice.i3s.knowledgeflows.json.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by urli on 04/04/2016.
 */
@XmlRootElement
public enum FeatureType {
    LEAF,
    MANDATORY,
    XOR,
    OR,
    OPTIONAL
}
