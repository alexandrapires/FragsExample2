package com.example.alexandrapires.fragsexample2;

import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

//ch2 - server change
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
        if(itemFrag.getIsList())
            itemFrag.setIsList(false);  //change to grid if is list
        else
            itemFrag.setIsList(true);   //change to list if is grid


        fm.beginTransaction()
                .detach(itemFrag)   //detach and attach causes refresh view (don't use replace in this case, because it's the same fragment
                .attach(itemFrag)
                .addToBackStack(null)   //Before you call commit(), however, you might want to call addToBackStack(), in order to add the transaction to a back stack of fragment transactions. This back stack is managed by the activity and allows the user to return to the previous fragment state, by pressing the Back button.
                .commit();  //saves changes
    }




    @Override
    public void onFragmentInteraction(String id){

        String x = id;

    }




}
