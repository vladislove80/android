package com.gorulia.android.runcrmrun.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.LinkedList;

import io.realm.annotations.PrimaryKey;

public class SourceModel {

    private LinkedList<HashMap<String,String>> results;
    private LinkedList<HashMap<String,String>> items;
    private HashMap<String,String> results_layout_config;

    private String name;
    private String description;
    private String status;
    private String created_time;
    private String updated_time;
    private String icon;
    private String colot_tag;

    @PrimaryKey
    @SerializedName("_id")
    private String id;

    public HashMap<String, String> getResults_layout_config() {
        return results_layout_config;
    }

    public void setResults_layout_config(HashMap<String, String> results_layout_config) {
        this.results_layout_config = results_layout_config;
    }
    public LinkedList<HashMap<String, String>> getResults() {
        return results;
    }

    public void setResults(LinkedList<HashMap<String, String>> results) {
        this.results = results;
    }

    public LinkedList<HashMap<String, String>> getItems() {
        return items;
    }

    public void setItems(LinkedList<HashMap<String, String>> items) {
        this.items = items;
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
}
