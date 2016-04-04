package fr.unice.i3s.knowledgeflows.json.generator;

/**
 * Created by urli on 04/04/2016.
 */
public enum ColumnNames {
    ID("id","setId"),
    TYPE("Type","setType"),
    NAME("Name","setName"),
    SHORTDESC("Short description","setShortDesc"),
    QUESTION("Question (y/n)","setQuestion"),
    PHRASE("Question/Affirmation","setPhrase"),
    DESC("Description","setDesc"),
    EXAMPLES("Examples","setExamples"),
    LOGO("Logo (url)","setLogo"),
    VISIBLE("Visible (y/n)","setVisible"),
    DISPLAYIFSELECTED("Display if selected (y/n)","setDisplayIfSelected"),
    REFERENCES("Reference(s)","setReference");

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
