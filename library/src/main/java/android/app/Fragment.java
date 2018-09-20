package android.app;

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
