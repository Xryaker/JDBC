package enums;

public enum FieldsPersonTable {
    P_ID("p_id"),NAME("personName"),EMAIL("email"),PASS("pass");
    String fiels;

    FieldsPersonTable(String fiels) {
        this.fiels = fiels;
    }

    public String getFiels() {
        return fiels;
    }
}
