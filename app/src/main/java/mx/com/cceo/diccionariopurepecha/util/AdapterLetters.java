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
public class AdapterLetters extends RecyclerView.Adapter<AdapterLetters.ViewHolderLetters> {

    public String letters[];

    public AdapterLetters(String[] letters)
    {
        this.letters = letters;
    }

    @Override
    public ViewHolderLetters onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_slider, parent, false);

        ViewHolderLetters vH = new ViewHolderLetters(view);

        return vH;
    }

    @Override
    public void onBindViewHolder(ViewHolderLetters holder, int position) {
        holder.textViewLetter.setText(letters[position]);
    }


    @Override
    public int getItemCount()
    {
        return letters.length;
        //return Integer.MAX_VALUE;
    }

    public static class ViewHolderLetters extends RecyclerView.ViewHolder
    {
        public TextView textViewLetter;

        public ViewHolderLetters(View v)
        {
            super(v);
            textViewLetter = (TextView) v.findViewById(R.id.list_item_slider_letter);
        }
    }
}
