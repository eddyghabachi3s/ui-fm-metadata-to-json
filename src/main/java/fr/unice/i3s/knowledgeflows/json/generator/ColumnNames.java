package fr.unice.i3s.knowledgeflows.json.generator;

/**
 * Created by urli on 04/04/2016.
 */
public enum ColumnNames {
    ID("id","setId"),
    TYPE("type","setType");

    private String realName;
    private String methodName;

    ColumnNames(String realName, String methodName) {
        this.realName = realName;
        this.methodName = methodName;
    }

    public String getRealName() {
        return realName;
    }

    public String getMethodName() {
        return methodName;
    }
}
