package com.gorulia.android.runcrmrun.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SourceModelRealm extends RealmObject{

    @PrimaryKey
    private String id;

    private String name;
    private String description;
    private String status;
    private String created_time;
    private String updated_time;
    private String icon;
    private String colot_tag;
    private String primary_field;
    private String secondary_field;
    private int countResult;

    public int getCountResult() {
        return countResult;
    }

    public void setCountResult(int countResult) {
        this.countResult = countResult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColot_tag() {
        return colot_tag;
    }

    public void setColot_tag(String colot_tag) {
        this.colot_tag = colot_tag;
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
