package com.example.android.miwok;

import static android.R.attr.id;

/**
 * Created by Rijul on 1/10/2017.
 */

public class Words {

    private String Default;
    private String Miwok;
    private int Rid=NO_IMAGE_SET;
    private int Mid=NO_IMAGE_SET;
    private static final int NO_IMAGE_SET = -1;
    Words(String a, String b,int id)
    {
        Default=a;
        Miwok=b;
        Rid=id;
    }
    Words(String a, String b)
    {
        Default=a;
        Miwok=b;
        //Rid=R.mipmap.ic_launcher;
    }
    Words(String a, String b,int id ,int mid)
    {
        Default=a;
        Miwok=b;
        Rid=id;
        Mid=mid;
    }

    public String getDefaultTranslation()
    {
        return Default;
    }
    public String getMiwokTranslation()
    {
        return Miwok;
    }
    public int getImage()
    {
        return Rid;
    }
    public int getAudio()
    {
        return Mid;
    }
    public boolean hasImage()
    {
        if(Rid==NO_IMAGE_SET)
        return false;
        else
            return true;
    }
    public boolean hasAudio()
    {
        if(Mid==NO_IMAGE_SET)
            return false;
        else
            return true;
    }
}
