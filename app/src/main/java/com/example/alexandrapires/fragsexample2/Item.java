package com.example.alexandrapires.fragsexample2;

import android.graphics.drawable.Drawable;

/**
 * Created by alexandrapires on 7/22/15.
 */
 
 // Change made on server test
    //change made on local
public class Item {

    int id;
    String title;
    String subTitle;
    Drawable drawableSrc;

    public Item(String title,String subTitle,Drawable drawableSrc)
    {
        this.title=title;
        this.subTitle=subTitle;
        this.drawableSrc= drawableSrc;
    }

    public int getId() {
        return id;
    }

    public Drawable getDrawableSrc() {
        return drawableSrc;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
