package com.gorulia.android.runcrmrun.POJO;

public class ObjectItemListResult {
    private String primary_field;
    private String secondary_field;

    public ObjectItemListResult(String primary_field, String secondary_field) {
        this.primary_field = primary_field;
        this.secondary_field = secondary_field;
    }
    public String getPrimary_field() {
        return primary_field;
    }
    public void setPrimary_field(String primary_field) {
        this.primary_field = primary_field;
    }
    public String getSecondary_field() {
        return secondary_field;
    }
    public void setSecondary_field(String secondary_field) {
        this.secondary_field = secondary_field;
    }
}
