package fr.unice.i3s.knowledgeflows.json.generator;

/**
 * Created by urli on 04/04/2016.
 */
public enum ColumnNames {
    ID("Id"),
    TYPE("Type"),
    NAME("Name"),
    SHORTDESC("Short description (name)"),
    QUESTION("Question (y/n)"),
    PHRASE("Question/Affirmation"),
    DESC("Description"),
    EXAMPLES("Examples"),
    LOGO("Logo (url)"),
    VISIBLE("Visible (y/n)"),
    DISPLAYIFSELECTED("Display if selected (y/n)"),
    REFERENCES("Reference(s)");

    private String realName;

    ColumnNames(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public static String[] getAllNames() {
        ColumnNames[] values = ColumnNames.values();
        String[] result = new String[values.length];
        int i = 0;
        for (ColumnNames cn : values) {
            result[i++] = cn.getRealName();
        }
        return result;
    }

}
