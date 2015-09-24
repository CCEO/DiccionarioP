package mx.com.cceo.diccionariopurepecha.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mx.com.cceo.diccionariopurepecha.R;
import mx.com.cceo.diccionariopurepecha.model.Entry;

/**
 * Created by Hugo on 9/23/2015.
 */
public class AdapterEmpty extends RecyclerView.Adapter<AdapterEmpty.ViewHolderWords> {

    private ArrayList<Entry> entries;

    public AdapterEmpty()
    {

    }

    @Override
    public ViewHolderWords onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_words, parent, false);

        ViewHolderWords vH = new ViewHolderWords(view);

        return vH;
    }

    @Override
    public void onBindViewHolder(ViewHolderWords holder, int position) {

    }


    @Override
    public int getItemCount()
    {
        return 10;
    }

    public static class ViewHolderWords extends RecyclerView.ViewHolder
    {
        public TextView textViewWord;
        public TextView textViewMeaning;

        public ViewHolderWords(View v)
        {
            super(v);

        }
    }
}
