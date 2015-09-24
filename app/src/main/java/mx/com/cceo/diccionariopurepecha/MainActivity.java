package mx.com.cceo.diccionariopurepecha;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.cceo.diccionariopurepecha.adapter.AdapterEmpty;
import mx.com.cceo.diccionariopurepecha.adapter.AdapterLetters;
import mx.com.cceo.diccionariopurepecha.database.DBEntry;
import mx.com.cceo.diccionariopurepecha.fragment.FragmentSlider;
import mx.com.cceo.diccionariopurepecha.adapter.AdapterWords;
import mx.com.cceo.diccionariopurepecha.linker.OnSliderClick;
import mx.com.cceo.diccionariopurepecha.model.Entry;

public class MainActivity extends Activity implements OnSliderClick{

    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerViewLetters;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.LayoutManager mLayoutManagerLetter;
    private AdapterEmpty adapterEmpty;
    private AdapterLetters adapterLetters;

    private RelativeLayout frameContainer;

    private DBEntry dbEntry;
    private ArrayList<Entry> entries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameContainer = (RelativeLayout) findViewById(R.id.home_fragment);

        //test
        testRun();

        //Init entries list
        mRecyclerView = (RecyclerView) findViewById(R.id.home_recycler_view_words);

        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        adapterEmpty = new AdapterEmpty();
        mRecyclerView.setAdapter(adapterEmpty);

        //initi slider list
        mRecyclerViewLetters = (RecyclerView) findViewById(R.id.fragment_recycler_view_slider);

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

        mRecyclerViewLetters.setHasFixedSize(true);

        // use a horizontal linear layout manager
        mLayoutManagerLetter = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerViewLetters.setLayoutManager(mLayoutManagerLetter);

        // specify an adapter
        adapterLetters = new AdapterLetters(letters,this);
        mRecyclerViewLetters.setAdapter(adapterLetters);


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

    @Override
    public void onClick(View v, String letter) {
       // Toast.makeText(this, letter + " selected", Toast.LENGTH_SHORT).show();
        entries = dbEntry.getEntriesStartingWith(letter);
        //Toast.makeText(this, String.valueOf(entries.size()), Toast.LENGTH_SHORT).show();
        AdapterWords adapterWordsSelection = new AdapterWords(entries);
        mRecyclerView.setAdapter(adapterWordsSelection);
    }


    private void testRun() {

        dbEntry = new DBEntry(this);

        Entry entryA = new Entry(0,"arbol","tree");
        Entry entryB = new Entry(1,"barco","ship");
        Entry entryC = new Entry(2,"casa","house");

        dbEntry.insertEntry(entryA);
        dbEntry.insertEntry(entryB);
        dbEntry.insertEntry(entryC);

    }

}
