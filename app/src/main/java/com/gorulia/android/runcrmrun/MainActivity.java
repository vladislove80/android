package com.gorulia.android.runcrmrun;
import com.gorulia.android.runcrmrun.POJO.ObjectItem;
import com.gorulia.android.runcrmrun.POJO.SourceModel;
import com.gorulia.android.runcrmrun.adapter.LazyAdapter;
import com.gorulia.android.runcrmrun.realm.SourceListResultModelRealm;
import com.gorulia.android.runcrmrun.realm.SourceModelRealm;
import com.gorulia.android.runcrmrun.realm.SourceResultModelRealm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private LazyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrofit *****************************
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mobilecrm.herokuapp.com/api/sources/561bddd7e4b060b59d7ca78b/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SourceService service = retrofit.create(SourceService.class);
        Call<List<SourceModel>> sourcesRequest = service.getSources();
        sourcesRequest.enqueue(new Callback<List<SourceModel>>() {
            @Override
            public void onResponse(Response<List<SourceModel>> response, Retrofit retrofit) {
                fromRetrofitToLog_d(response); // get DATA to Log from retrofit response
                // add first screen data to Realm-objects from retrofit
                SourceModelRealm obj = getSourceModelRealm(response);
                //add second screen RESULTS-data to RealmList from retrofit
                SourceListResultModelRealm listResults = getSourceListResultModelRealm(response, obj);
                //set data from Realm
                Realm realm = Realm.getInstance(getApplicationContext());
                realm.beginTransaction();
                realm.copyToRealmOrUpdate(obj);
                realm.copyToRealmOrUpdate(listResults);
                realm.commitTransaction();
                Log.d("GOR", "!!!!!!!!!!!!!!!!!!!!!!!0000!!!!!!!!!!!!!");
/*                RealmResults<SourceModelRealm> query = realm.where(SourceModelRealm.class).findAll();
                Log.d("GOR", query.toString());
                Log.d("GOR", query.get(0).getId());
                Log.d("GOR", query.get(0).getName());
                Log.d("GOR", "!!!!!!!!!!!!!!!!!!!!!!!111111111111111111111111111111111111111111111111111!!!!!!!!!!!!!");*/
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("GOR", t.toString() + " *********8888888888888888****************************************");
            }
        });
        // initiate LazyAdapter
        listView = (ListView) findViewById(R.id.list);
        adapter = new LazyAdapter(this, initData());
        listView.setAdapter(adapter);
        // По клику будем выводить текст элемента
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), ActivityListResult.class);
                    startActivity(intent);
                }
            }
        });
    }

    private SourceListResultModelRealm getSourceListResultModelRealm(Response<List<SourceModel>> response, SourceModelRealm obj) {
        RealmList<SourceResultModelRealm> tempList = new RealmList<>();
        LinkedList<HashMap<String, String>> resultsTempList = new LinkedList<>(response.body().get(0).getResults());

        for (HashMap<String, String> oneFormResult : resultsTempList) {
            Set<Map.Entry<String, String>> resultSet = oneFormResult.entrySet();
            SourceResultModelRealm result = new SourceResultModelRealm();

            // primary_field can't be null
            if (!oneFormResult.containsKey(obj.getPrimary_field())) {
                result.setPrimary_field("empty comment");
            }
            for (Map.Entry<String, String> resultFormElement : resultSet) {
                if(resultFormElement.getKey().equals(obj.getSecondary_field())                                ) {
                        result.setSecondary_field(resultFormElement.getValue());
                }
                if (resultFormElement.getKey().equals(obj.getPrimary_field())) {
                        result.setPrimary_field(resultFormElement.getValue());
                }
            }
            tempList.add(result);
        }
        SourceListResultModelRealm listResults = new SourceListResultModelRealm();
        listResults.setId(response.body().get(0).getId());
        listResults.setList(tempList);
        return listResults;
    }

    private SourceModelRealm getSourceModelRealm(Response<List<SourceModel>> response) {
        SourceModelRealm obj = new SourceModelRealm();
        obj.setId(response.body().get(0).getId());
        obj.setName(response.body().get(0).getName());
        obj.setDescription(response.body().get(0).getDescription());
        obj.setStatus(response.body().get(0).isStatus());
        obj.setCreated_time(response.body().get(0).getCreated_time());
        obj.setUpdated_time(response.body().get(0).getUpdated_time());
        obj.setIcon(response.body().get(0).getIcon());
        obj.setColot_tag(response.body().get(0).getColot_tag());
        obj.setCountResult(response.body().get(0).getResults().size());
        obj.setIcon(response.body().get(0).getIcon());
        obj.setPrimary_field(response.body().get(0).getResults_layout_config().get("primary_field"));
        obj.setSecondary_field(response.body().get(0).getResults_layout_config().get("primary_field"));
        return obj;
    }

    private void fromRetrofitToLog_d(Response<List<SourceModel>> response) {
        Log.d("GOR", "ID");
        Log.d("GOR", response.body().get(0).getId());
        Log.d("GOR", "NAME");
        Log.d("GOR", response.body().get(0).getName());
        Log.d("GOR", "description");
        Log.d("GOR", response.body().get(0).getDescription());
        Log.d("GOR", "status");
        Log.d("GOR", response.body().get(0).isStatus());
        Log.d("GOR", "created_time");
        Log.d("GOR", response.body().get(0).getCreated_time());
        Log.d("GOR", "updated_time");
        Log.d("GOR", response.body().get(0).getUpdated_time());
        Log.d("GOR", "icon");
        Log.d("GOR", response.body().get(0).getIcon());
        Log.d("GOR", "color_tag");
        Log.d("GOR", response.body().get(0).getColot_tag());

        HashMap<String, String> results_layout_config = new HashMap<>(response.body().get(0).getResults_layout_config());
        Log.d("GOR", "******************************");
        for (Map.Entry<String, String> field : results_layout_config.entrySet()) {
            Log.d("GOR", field.getKey() + ": " + field.getValue());
        }

        Log.d("GOR", "RESULTS");
        LinkedList<HashMap<String, String>> resultsList = new LinkedList<>(response.body().get(0).getResults());
        for (HashMap<String, String> oneFormResult : resultsList) {
            Set<Map.Entry<String, String>> resultSet = oneFormResult.entrySet();
            Log.d("GOR", "******************************");
            for (Map.Entry<String, String> resultFormElement : resultSet) {
                Log.d("GOR", resultFormElement.getKey() + ": " + resultFormElement.getValue());
            }
        }
        Log.d("GOR", "ITEMS");
        LinkedList<HashMap<String, String>> itemsList = new  LinkedList<>(response.body().get(0).getItems());
        for (HashMap<String, String> oneItem : itemsList) {
            Set<Map.Entry<String, String>> itemsSet = oneItem.entrySet();
            Log.d("GOR", "******************************");
            for (Map.Entry<String, String> itemProperty : itemsSet) {
                Log.d("GOR", itemProperty.getKey() + ": " + itemProperty.getValue());
                }
            }
        Log.d("GOR", "******************************");
        Log.d("GOR", "******************************");
        Log.d("GOR", "******************************");
        Log.d("GOR", "******************************");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<ObjectItem> initData() {
        Realm realm = Realm.getInstance(getApplicationContext());
        RealmResults<SourceModelRealm> query = realm.where(SourceModelRealm.class).findAll();
        ArrayList<ObjectItem> maps = new ArrayList<>();

        ObjectItem objectItem1 = new ObjectItem(query.get(0).getName(),
                query.get(0).getDescription(),
                GregorianCalendar.getInstance().getTime(),
                query.get(0).getCountResult(), 2,
                query.get(0).getIcon());
        /*ObjectItem objectItem1 = new ObjectItem("",
                "",
                GregorianCalendar.getInstance().getTime(),
                2, 2,
                "");*/
        maps.add(objectItem1);

        ObjectItem objectItem2 = new ObjectItem("Another form",
                "Some description if exist222",
                GregorianCalendar.getInstance().getTime(),
                15, 5,
                null);
        maps.add(objectItem2);

        ObjectItem objectItem3 = new ObjectItem("My Shoes shoop",
                "Some description if exist333",
                GregorianCalendar.getInstance().getTime(),
                0, 2,
                "");
        maps.add(objectItem3);
        return maps;
    }
}
