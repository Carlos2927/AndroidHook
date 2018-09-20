package android.app;

import android.content.Context;

public class Activity extends Context{
    public boolean isFinishing(){
        return false;
    }

    public boolean isDestroyed(){
        return false;
    }
}
