package com.example.android.coursenotes;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import static com.example.android.coursenotes.R.id.file;


public class SyllabusFragment extends Fragment{

    File file;



    public SyllabusFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.word_list, container, false);


        final ArrayList<FileInfo> subject=new ArrayList<>();

        subject.add(new FileInfo("Applied Mathematics 3",R.raw.am3));
        subject.add(new FileInfo("Object Oriented Programming",R.raw.oopm));
        subject.add(new FileInfo("Data Structures",R.raw.data_structures));
        subject.add(new FileInfo("COA",R.raw.coa));
        subject.add(new FileInfo("Discrete Structures and Graph Theory",R.raw.dsgt));
        subject.add(new FileInfo("Digital Design",R.raw.dd));

        //ArrayAdapter adapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,subject);
        FileAdapter adapter=new FileAdapter(getActivity(),subject);
        ListView listView=(ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FileInfo fileinfo=subject.get(i);
                String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/CourseNotes";
                File nd=new File(path);
                String filen="";
                if(nd.isDirectory() && nd.exists())
                {
                    filen=fileinfo.getFileId()+".pdf";
                    try{
                        CopyRAWtoSDCard(fileinfo.getFileId(),path+File.separator+filen);
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
                file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/CourseNotes/"+filen);
                Uri upath=Uri.fromFile(file);
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(upath, "application/pdf");
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                Intent cintent=Intent.createChooser(intent,"Open File");
                try{
                    startActivity(cintent);
                    //file.delete();
                }
                catch (ActivityNotFoundException e){
                    Toast.makeText(getContext(),"No PDF Viewer Application Found",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;
    }

    private void CopyRAWtoSDCard(int id, String path) throws IOException {
        InputStream in = getResources().openRawResource(id);
        FileOutputStream out = new FileOutputStream(path);
        byte[] buff = new byte[1024];
        int read;
        try {
            while ((read = in.read(buff)) > 0) {
                out.write(buff, 0, read);
            }
        } finally {
            in.close();
            out.close();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
