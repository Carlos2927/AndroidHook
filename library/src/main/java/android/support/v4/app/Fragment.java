package android.support.v4.app;

import android.app.Activity;
import android.content.Context;

public class Fragment {
    public boolean isRemoving(){
        return false;
    }

    public boolean isDetached(){
        return false;
    }

    public Activity getActivity(){
        return null;
    }

    public Context getContext(){
        return null;
    }
}
