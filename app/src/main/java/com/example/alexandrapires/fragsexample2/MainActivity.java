package com.example.alexandrapires.fragsexample2;

import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

//Changed: 1st change after putting the project in github
public class MainActivity extends FragmentActivity implements ItemFragment.OnFragmentInteractionListener   {


    ItemFragment itemFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemFrag = new ItemFragment();

        if(savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .add(R.id.container, itemFrag, "ItemFragment").commit();
        }


    }


    public void ClickMenuImages(View item)
    {
        ImageView v = (ImageView) item;
        switch(item.getId())
        {
            case R.id.imMenu :
                final Animation myRotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                item.startAnimation(myRotation);

                transListAndGrid();
                break;
        }
    }


    public void transListAndGrid()
    {
        FragmentManager fm =  getFragmentManager();
        itemFrag =  (ItemFragment) fm.findFragmentByTag("ItemFragment");

        //equivalent to if
        boolean value = itemFrag.getIsList() ? false : true;
        itemFrag.setIsList(value);

        fm.beginTransaction()
                .detach(itemFrag)   //detach and attach causes refresh view (don't use replace in this case, because it's the same fragment
                .attach(itemFrag)
                .addToBackStack(null)   //Before you call commit(), however, you might want to call addToBackStack(), in order to add the transaction to a back stack of fragment transactions. This back stack is managed by the activity and allows the user to return to the previous fragment state, by pressing the Back button.
                .commit();  //saves changes
    }



    @Override
    public void onFragmentInteraction(String id){


    }




}
