package mx.com.cceo.diccionariopurepecha.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mx.com.cceo.diccionariopurepecha.R;
import mx.com.cceo.diccionariopurepecha.linker.OnSliderClick;

/**
 * Created by Hugo on 9/23/2015.
 */
public class AdapterLetters extends RecyclerView.Adapter<AdapterLetters.ViewHolderLetters> {

    public String letters[];

    private OnSliderClick onSliderClick;

    public AdapterLetters(String[] letters, OnSliderClick onSliderClick)
    {
        this.letters = letters;
        this.onSliderClick = onSliderClick;
    }

    @Override
    public ViewHolderLetters onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_slider, parent, false);

        ViewHolderLetters vH = new ViewHolderLetters(view);

        return vH;
    }

    @Override
    public void onBindViewHolder(ViewHolderLetters holder, final int position) {
        holder.textViewLetter.setText(letters[position]);

        holder.sliderItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSliderClick.onClick(v,letters[position]);
            }
        });
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
        public RelativeLayout sliderItem;

        public ViewHolderLetters(View v)
        {
            super(v);
            textViewLetter = (TextView) v.findViewById(R.id.list_item_slider_letter);
            sliderItem = (RelativeLayout) v.findViewById(R.id.list_item_slider);
        }
    }
}
