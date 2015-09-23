package mx.com.cceo.diccionariopurepecha.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mx.com.cceo.diccionariopurepecha.R;

/**
 * Created by Hugo on 9/23/2015.
 */
public class AdapterWords extends RecyclerView.Adapter<AdapterWords.ViewHolderWords> {

    public AdapterWords()
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
