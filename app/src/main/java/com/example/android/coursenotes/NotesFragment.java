package com.example.android.coursenotes;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class NotesFragment extends Fragment  {


    public NotesFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.word_list, container, false);
        ArrayList<FileInfo> subject=new ArrayList<>();



        //ArrayAdapter adapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,subject);
        /*FileAdapter adapter=new FileAdapter(getActivity(),subject);
        ListView listView=(ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);*/



        return rootView;
    }


}
