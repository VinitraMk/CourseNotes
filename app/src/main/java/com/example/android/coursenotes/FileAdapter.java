package com.example.android.coursenotes;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mikasa on 29/12/16.
 */

public class FileAdapter extends ArrayAdapter<FileInfo> {

    public FileAdapter(Activity context, ArrayList<FileInfo> files){
        super(context,0,files);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView=convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        FileInfo currfile=getItem(position);
        TextView textView=(TextView)listItemView.findViewById(R.id.file);
        textView.setText(currfile.getFileName());
        return listItemView;
    }
}
