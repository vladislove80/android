package com.gorulia.android.runcrmrun.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.gorulia.android.runcrmrun.R;
import com.gorulia.android.runcrmrun.adapter.LazyAdapterOneResult;
import com.gorulia.android.runcrmrun.pojo.ObjectItemListResult;
import com.gorulia.android.runcrmrun.realm.SourceListResultModelRealm;
import com.gorulia.android.runcrmrun.realm.SourceModelRealm;
import com.gorulia.android.runcrmrun.realm.SourceResultModelRealm;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class ActivityOneResult extends AppCompatActivity {
    private ListView listView;
    private LazyAdapterOneResult adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneresultform);
        listView = (ListView) findViewById(R.id.oneResult);
        adapter = new LazyAdapterOneResult(this, initData());
        listView.setAdapter(adapter);
    }

    private ArrayList<ObjectItemListResult> initData() {
        ArrayList<ObjectItemListResult> maps = new ArrayList<>();
        Realm realm = Realm.getInstance(getApplicationContext());
        RealmResults<SourceListResultModelRealm> query = realm.where(SourceListResultModelRealm.class).findAll();

        SourceResultModelRealm temp = query.get(0).getList().get(getIntent().getIntExtra("position", 0));
            ObjectItemListResult objectItem = new ObjectItemListResult(temp.getPrimary_field(),
                    temp.getSecondary_field());
            maps.add(objectItem);

        return maps;
    }
}
