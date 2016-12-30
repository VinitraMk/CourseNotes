package com.example.android.coursenotes;

/**
 * Created by mikasa on 29/12/16.
 */

public class FileInfo {

    private String mfilename;
    int mfileid;
    public FileInfo(String filename,int fileid){
        mfilename=filename;
        mfileid=fileid;
    }

    public String getFileName(){
        return mfilename;
    }

    public int getFileId(){
        return mfileid;
    }
}
