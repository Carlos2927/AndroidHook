package android.graphics.drawable;




public abstract  class Drawable {
    public interface Callback {
        /**
         * Called when the drawable needs to be redrawn.  A view at this point
         * should invalidate itself (or at least the part of itself where the
         * drawable appears).
         *
         * @param who The drawable that is requesting the update.
         */
        void invalidateDrawable(Drawable who);


        void scheduleDrawable(Drawable who, Runnable what, long when);

        void unscheduleDrawable(Drawable who, Runnable what);
    }

    public final void setCallback(Callback cb) {
    }
}
