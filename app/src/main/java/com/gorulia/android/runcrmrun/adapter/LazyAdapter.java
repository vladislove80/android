package com.gorulia.android.runcrmrun.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gorulia.android.runcrmrun.pojo.ObjectItem;
import com.gorulia.android.runcrmrun.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LazyAdapter extends ArrayAdapter<String> {
    private List<ObjectItem> data;
    private Context context;

    public LazyAdapter(Context context, List<ObjectItem> data) {
        super(context, R.layout.listview);
        this.data = data;
        this.context = context;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position).getTitle();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview, parent, false);
        TextView title = (TextView)view.findViewById(R.id.title);
        TextView subTitle = (TextView)view.findViewById(R.id.subTitle);
        TextView time = (TextView)view.findViewById(R.id.time);
        TextView x1 = (TextView)view.findViewById(R.id.x1);
        TextView x2 = (TextView)view.findViewById(R.id.x2);
        ImageView thumbImage = (ImageView)view.findViewById(R.id.imageView);
        ObjectItem objectItem = data.get(position);

        // устанавливаем значения компонентам одного эелемента списка
        title.setText(objectItem.getTitle());
        time.setText(objectItem.getDate().toString());
        subTitle.setText(objectItem.getSubTitle());
        x1.setText(Integer.toString(objectItem.getX1()));
        x2.setText(Integer.toString(objectItem.getX2()));

        if (objectItem.getIcon() != null && objectItem.getIcon() != "") {
            Picasso.with(context)
                    .load(objectItem.getIcon())
                    .resize(60, 60)
                    .into(thumbImage);
        } else
            thumbImage.setImageResource(R.mipmap.ic_launcher);
        return view;
    }
}

