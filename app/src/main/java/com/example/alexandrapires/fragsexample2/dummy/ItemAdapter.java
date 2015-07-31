package com.example.alexandrapires.fragsexample2.dummy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexandrapires.fragsexample2.Item;
import com.example.alexandrapires.fragsexample2.R;

import java.util.List;

/**
 * Created by alexandrapires on 7/22/15.
 */
public class ItemAdapter extends BaseAdapter {

    List<Item> lItens;
    Context c;
    boolean isList=true;

    public ItemAdapter(Context context, List <Item> lItems){

        this.lItens = lItems;
        c = context;
    }

    @Override
    public int getCount() {
        return lItens.size();
    }

    @Override
    public Object getItem(int position) {
        return lItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((Item) getItem(position)).getId();
    }

    public void setIsList(boolean isList) {
        this.isList = isList;
    }

    public boolean isList() {
        return isList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if(convertView == null) {
            if(isList)
                convertView = inflater.inflate(R.layout.list_item, null);
            else
                convertView = inflater.inflate(R.layout.list_item_grid, null);
        }

        Item item = lItens.get(position);

        TextView txTitle = (TextView)convertView.findViewById(R.id.txTitle);
        txTitle.setText(item.getTitle());

        TextView txSubTitle = (TextView)convertView.findViewById(R.id.txSubtitle);
        txSubTitle.setText(item.getSubTitle());

        ImageView img = (ImageView)convertView.findViewById(R.id.imageView);
        img.setImageDrawable(item.getDrawableSrc());


        return convertView;
    }
}
