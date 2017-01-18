package com.example.android.coursenotes;

/**
 * Created by mikasa on 29/12/16.
 */

public class FileInfo {

    private String mfilename,mcode;

    public FileInfo(String filename,String code){
        mfilename=filename;
        mcode=code;
    }

    public String getFileName(){
        return mfilename;
    }

    public String getCode(){
        return mcode;
    }
}
