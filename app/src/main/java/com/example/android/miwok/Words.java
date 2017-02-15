package com.example.android.miwok;

/**
 * Created by Rijul on 1/10/2017.
 */

public class Words {

    private String Default;
    private String Miwok;

    Words(String a, String b)
    {
        Default=a;
        Miwok=b;
    }
    public String getDefaultTranslation()
    {
        return Default;
    }
    public String getMiwokTranslation()
    {
        return Miwok;
    }
}
