package android.view;

import android.content.Context;
import android.util.AttributeSet;

public abstract class ViewGroup extends View  implements ViewParent, ViewManager{
    public ViewGroup(Context context) {
        super(context);
    }

    public ViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void requestLayout() {

    }

    @Override
    public boolean isLayoutRequested() {
        return false;
    }

    @Override
    public void requestTransparentRegion(View child) {

    }

    @Override
    public ViewParent getParent() {
        return null;
    }

    @Override
    public void requestChildFocus(View child, View focused) {

    }

    @Override
    public void recomputeViewAttributes(View child) {

    }

    @Override
    public void clearChildFocus(View child) {

    }

    @Override
    public View focusSearch(View v, int direction) {
        return null;
    }

    @Override
    public View keyboardNavigationClusterSearch(View currentCluster, int direction) {
        return null;
    }

    @Override
    public void focusableViewAvailable(View v) {

    }

    @Override
    public boolean showContextMenuForChild(View originalView) {
        return false;
    }

    @Override
    public boolean showContextMenuForChild(View originalView, float x, float y) {
        return false;
    }

    @Override
    public void childDrawableStateChanged(View child) {

    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    @Override
    public void childHasTransientStateChanged(View child, boolean hasTransientState) {

    }

    @Override
    public void requestFitSystemWindows() {

    }

    @Override
    public ViewParent getParentForAccessibility() {
        return null;
    }

    @Override
    public void notifySubtreeAccessibilityStateChanged(View child, View source, int changeType) {

    }

    @Override
    public boolean canResolveLayoutDirection() {
        return false;
    }

    @Override
    public boolean isLayoutDirectionResolved() {
        return false;
    }

    @Override
    public int getLayoutDirection() {
        return 0;
    }

    @Override
    public boolean canResolveTextDirection() {
        return false;
    }

    @Override
    public boolean isTextDirectionResolved() {
        return false;
    }

    @Override
    public int getTextDirection() {
        return 0;
    }

    @Override
    public boolean canResolveTextAlignment() {
        return false;
    }

    @Override
    public boolean isTextAlignmentResolved() {
        return false;
    }

    @Override
    public int getTextAlignment() {
        return 0;
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return false;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {

    }

    @Override
    public void onStopNestedScroll(View target) {

    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {

    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    public static class LayoutParams{}

    @Override
    public void addView(View view, LayoutParams params) {

    }

    @Override
    public void updateViewLayout(View view, ViewGroup.LayoutParams params){}

    @Override
    public void removeView(View view) {

    }


}
