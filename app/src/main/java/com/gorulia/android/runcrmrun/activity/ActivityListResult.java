package com.gorulia.android.runcrmrun.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gorulia.android.runcrmrun.pojo.ObjectItemListResult;
import com.gorulia.android.runcrmrun.R;
import com.gorulia.android.runcrmrun.adapter.LazyAdapterListResult;
import com.gorulia.android.runcrmrun.realm.SourceListResultModelRealm;
import com.gorulia.android.runcrmrun.realm.SourceResultModelRealm;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class ActivityListResult extends AppCompatActivity {
    private ListView listView;
    private LazyAdapterListResult adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_result2);
        listView = (ListView) findViewById(R.id.listResult2);
        adapter = new LazyAdapterListResult(this, initData());
        listView.setAdapter(adapter);

        // По клику будем выводить текст элемента
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(getApplicationContext(), ActivityOneResult.class);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });
    }
    private ArrayList<ObjectItemListResult> initData() {
        ArrayList<ObjectItemListResult> maps = new ArrayList<>();
        Realm realm = Realm.getInstance(getApplicationContext());
        RealmResults<SourceListResultModelRealm> query = realm.where(SourceListResultModelRealm.class).findAll();

        for (SourceResultModelRealm temp : query.get(0).getList()){
            ObjectItemListResult objectItem = new ObjectItemListResult(temp.getPrimary_field(),
                    temp.getSecondary_field());
            maps.add(objectItem);
        }
        return maps;
    }
}
