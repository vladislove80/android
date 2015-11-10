package com.gorulia.android.runcrmrun.realm;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SourceListResultModelRealm extends RealmObject {
    private RealmList<SourceResultModelRealm> list = new RealmList<>();
    @PrimaryKey
    private String id;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public RealmList<SourceResultModelRealm> getList() {
        return list;
    }
    public void setList(RealmList<SourceResultModelRealm> list) {
        this.list = list;
    }
}
