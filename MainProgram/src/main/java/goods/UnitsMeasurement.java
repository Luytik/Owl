package goods;

public enum UnitsMeasurement {
    g("грам"), kg("кілограм"), l("літр"), ml("мілілітр"), pc("штук");

    private String fullname;


    UnitsMeasurement(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }


    public static UnitsMeasurement fromString(String text) {
        for (UnitsMeasurement u : UnitsMeasurement.values()) {
            if (u.fullname.equalsIgnoreCase(text)) {
                return u;
            }
        }
        throw new IllegalArgumentException();
    }
}
