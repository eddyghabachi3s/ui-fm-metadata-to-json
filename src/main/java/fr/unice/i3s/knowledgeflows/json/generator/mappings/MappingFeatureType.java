package fr.unice.i3s.knowledgeflows.json.generator.mappings;

import fr.unice.i3s.knowledgeflows.json.model.FeatureType;

/**
 * Created by urli on 04/04/2016.
 */
public enum MappingFeatureType {
    XOR("g",FeatureType.XOR),
    OPT("o", FeatureType.OPTIONAL),
    LEAF("", FeatureType.LEAF),
    MAND("m",FeatureType.MANDATORY)
    ;

    private String code;
    private FeatureType type;

    MappingFeatureType(String code, FeatureType type) {
        this.code = code;
        this.type = type;
    }

    public FeatureType getType() {
        return type;
    }

    public String getCode() {
        return code;
    }
}
