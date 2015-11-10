package com.gorulia.android.runcrmrun.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SourceResultModelRealm extends RealmObject {
    @PrimaryKey
    private String primary_field;
    private String secondary_field;

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
