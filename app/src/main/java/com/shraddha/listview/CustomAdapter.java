package com.shraddha.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


import static com.shraddha.listview.MainActivity.string_titel_selected;

public class CustomAdapter extends ArrayAdapter<OneComponentBindingItem> {

    public CustomAdapter(@NonNull Context context, @NonNull List<OneComponentBindingItem> objects) {
        super(context, 0, objects);
    }
    /*
     * Get a View that displays the data at the specified position in the data set.
     *  You can either create a View manually or inflate it from an XML layout file.
     * When the View is inflated, the parent View (GridView, ListView...) will apply default layout parameters unless you use
     * LayoutInflater.inflate(int, android.view.ViewGroup, boolean) to specify a root view and to prevent attachment to the root.*/
    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_items,parent,false);

        final OneComponentBindingItem item = getItem(position);
        System.out.println(position);

        TextView textViewtitle=convertView.findViewById(R.id.texttitle);
        assert item != null;
        textViewtitle.setText(item.getTextViewtitle());
        string_titel_selected=item.getTextViewtitle();


        TextView textViewtitledesc=convertView.findViewById(R.id.textdescp);
        textViewtitledesc.setText(item.getDesc());

        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(item.getImage_res());

        Animation animation= AnimationUtils.loadAnimation(getContext(), R.anim.my_anim);
        convertView.startAnimation(animation);
        return convertView;
    }
}