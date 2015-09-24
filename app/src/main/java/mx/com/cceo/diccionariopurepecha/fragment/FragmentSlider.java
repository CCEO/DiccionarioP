package mx.com.cceo.diccionariopurepecha.fragment;

import android.app.Fragment;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.cceo.diccionariopurepecha.R;
import mx.com.cceo.diccionariopurepecha.adapter.AdapterLetters;
import mx.com.cceo.diccionariopurepecha.adapter.AdapterWords;
import mx.com.cceo.diccionariopurepecha.database.DBEntry;
import mx.com.cceo.diccionariopurepecha.linker.OnSliderClick;
import mx.com.cceo.diccionariopurepecha.model.Entry;

/**
 * Created by Hugo on 9/23/2015.
 */
public class FragmentSlider extends Fragment{

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private AdapterLetters adapterLetters;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_slider, container,
                false);

        //initializes the recycler view in the fragment
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_recycler_view_slider);

        //creates data set. Fills array with capital letters from A to Z
        String letters[] = new String[78];
        int charAscii = 65;
        for (int i=0; i<78;i++)
        {
            letters[i]= Character.toString((char) charAscii);
            charAscii++;

            if(charAscii>90)
                charAscii = 65;
        }

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager

        mLayoutManager = new LinearLayoutManager(rootView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
       // adapterLetters = new AdapterLetters(letters);
        mRecyclerView.setAdapter(adapterLetters);



        return rootView;

    }



}
