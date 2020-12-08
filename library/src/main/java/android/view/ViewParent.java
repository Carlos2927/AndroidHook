package android.view;

import android.annotation.NonNull;

public interface ViewParent {

    public void requestLayout();


    public boolean isLayoutRequested();


    public void requestTransparentRegion(View child);









    public ViewParent getParent();


    public void requestChildFocus(View child, View focused);


    public void recomputeViewAttributes(View child);


    public void clearChildFocus(View child);



    public View focusSearch(View v, int direction);


    View keyboardNavigationClusterSearch(View currentCluster, int direction);



    public void focusableViewAvailable(View v);


    public boolean showContextMenuForChild(View originalView);


    boolean showContextMenuForChild(View originalView, float x, float y);




    public void childDrawableStateChanged(View child);


    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept);





    public void childHasTransientStateChanged(View child, boolean hasTransientState);

    public void requestFitSystemWindows();

    public ViewParent getParentForAccessibility();


    public void notifySubtreeAccessibilityStateChanged(
            View child, @NonNull View source, int changeType);


    public boolean canResolveLayoutDirection();


    public boolean isLayoutDirectionResolved();


    public int getLayoutDirection();


    public boolean canResolveTextDirection();


    public boolean isTextDirectionResolved();


    public int getTextDirection();


    public boolean canResolveTextAlignment();


    public boolean isTextAlignmentResolved();


    public int getTextAlignment();


    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes);


    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes);


    public void onStopNestedScroll(View target);


    public void onNestedScroll(View target, int dxConsumed, int dyConsumed,
                               int dxUnconsumed, int dyUnconsumed);

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed);


    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed);


    public boolean onNestedPreFling(View target, float velocityX, float velocityY);



}
