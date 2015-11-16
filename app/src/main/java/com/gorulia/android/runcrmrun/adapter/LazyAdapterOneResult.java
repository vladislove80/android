package com.gorulia.android.runcrmrun.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.gorulia.android.runcrmrun.pojo.ObjectItemListResult;
import com.gorulia.android.runcrmrun.R;

import java.util.List;

public class LazyAdapterOneResult  extends ArrayAdapter<String> {
    private  List<ObjectItemListResult> data;
    private Context context;

    public LazyAdapterOneResult(Context context,  List<ObjectItemListResult> data) {
        super(context, R.layout.listview_oneresult);
        this.data = data;
        this.context = context;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position).getPrimary_field();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_oneresult, parent, false);
        TextView primary_field = (TextView)view.findViewById(R.id.primary_field);
        TextView secondary_field = (TextView)view.findViewById(R.id.secondary_field);
        ObjectItemListResult objectItem = data.get(0);
        // устанавливаем значения компонентам одного эелемента списка
        primary_field.setText(objectItem.getPrimary_field());
        secondary_field.setText(objectItem.getSecondary_field());
        return view;
    }
}
