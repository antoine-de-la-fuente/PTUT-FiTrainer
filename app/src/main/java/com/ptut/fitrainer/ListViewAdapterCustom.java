package com.ptut.fitrainer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// nom de la classe pour l'entrainement
import com.ptut.fitrainer.Training;

import java.util.List;

public class ListViewAdapterCustom extends BaseAdapter {

    private final List<ARENSEIGNER> values;
    private final LayoutInflater inflater;

    public ListViewAdapterCustom(Context context, List<ARENSEIGNER> values) {
        this.values = values;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.values.size();
    }

    @Override
    public ARENSEIGNER getItem(int position) {
        return this.values.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = this.inflater.inflate(R.layout.layout_listview_training, null);
        }

        ARENSEIGNER arenseigner = getItem(position);

        TextView textView = view.findViewById(R.id.textView_listview);
        textView.setText(arenseigner.getName());

        ImageView imageView1 = view.findViewById(R.id.imageView_listview);
        switch (arenseigner.getSpeed()) {
            case 1:
                imageView1.setImageResource(R.drawable.ic_difficulty_easy);
                break;
            case 2:
                imageView1.setImageResource(R.drawable.ic_difficulty_medium);
                break;
            default:
                imageView1.setImageResource(R.drawable.ic_difficulty_hard);
        }

        ImageView imageView2 = view.findViewById(R.id.imageView2);
        switch (arenseigner.getResistance()) {
            case 1:
                imageView2.setImageResource(R.drawable.ic_difficulty_easy);
                break;
            case 2:
                imageView2.setImageResource(R.drawable.ic_difficulty_medium);
                break;
            default:
                imageView2.setImageResource(R.drawable.ic_difficulty_hard);
        }

        return view;
    }

}
