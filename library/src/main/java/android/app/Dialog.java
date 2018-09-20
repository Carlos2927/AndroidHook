package android.app;

import android.content.Context;
import android.view.View;

public class Dialog {
    public boolean isShowing(){
        return false;
    }

    public View getContentView(){
        return null;
    }
    public Context getContext(){
        return null;
    }

    public Activity getOwnerActivity(){
        return null;
    }
}
