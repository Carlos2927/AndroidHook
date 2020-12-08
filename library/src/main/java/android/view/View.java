package android.view;

import android.annotation.Nullable;
import android.content.Context;
import android.util.AttributeSet;

public class View {
    public Context getContext(){
        return null;
    }
    public View(Context context){}
    public View(Context context, @Nullable AttributeSet attrs){}
    public View(Context context, @Nullable AttributeSet attrs, int defStyleAttr){}
    public View(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes){}

    void setAlphaInternal(float alpha){

    }
}
