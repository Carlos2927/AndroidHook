package android.os;

public class Build {
    public static class VERSION{
        /**
         * The user-visible SDK version of the framework; its possible
         * values are defined in {@link VERSION_CODES}.
         */
        public static final int SDK_INT = 0;
    }
    public static class VERSION_CODES {

        /**
         * October 2008: The original, first, version of Android.  Yay!
         */
        public static final int BASE = 1;

        /**
         * February 2009: First Android update, officially called 1.1.
         */
        public static final int BASE_1_1 = 2;

        /**
         * May 2009: Android 1.5.
         */
        public static final int CUPCAKE = 3;

        /**
         * September 2009: Android 1.6.
         */
        public static final int DONUT = 4;

        /**
         * November 2009: Android 2.0
         */
        public static final int ECLAIR = 5;

        /**
         * December 2009: Android 2.0.1
         */
        public static final int ECLAIR_0_1 = 6;

        /**
         * January 2010: Android 2.1
         */
        public static final int ECLAIR_MR1 = 7;

        /**
         * June 2010: Android 2.2
         */
        public static final int FROYO = 8;

        /**
         * November 2010: Android 2.3
         */
        public static final int GINGERBREAD = 9;

        /**
         * February 2011: Android 2.3.3.
         */
        public static final int GINGERBREAD_MR1 = 10;

        /**
         * February 2011: Android 3.0.
         */
        public static final int HONEYCOMB = 11;

        /**
         * May 2011: Android 3.1.
         */
        public static final int HONEYCOMB_MR1 = 12;

        /**
         * June 2011: Android 3.2.
         */
        public static final int HONEYCOMB_MR2 = 13;

        /**
         * October 2011: Android 4.0.
         */
        public static final int ICE_CREAM_SANDWICH = 14;

        /**
         * December 2011: Android 4.0.3.
         */
        public static final int ICE_CREAM_SANDWICH_MR1 = 15;

        /**
         * June 2012: Android 4.1.
         */
        public static final int JELLY_BEAN = 16;

        /**
         * November 2012: Android 4.2, Moar jelly beans!
         */
        public static final int JELLY_BEAN_MR1 = 17;

        /**
         * July 2013: Android 4.3, the revenge of the beans.
         */
        public static final int JELLY_BEAN_MR2 = 18;

        /**
         * October 2013: Android 4.4, KitKat, another tasty treat.
         */
        public static final int KITKAT = 19;

        /**
         * June 2014: Android 4.4W. KitKat for watches, snacks on the run.
         */
        public static final int KITKAT_WATCH = 20;

        /**
         * Temporary until we completely switch to {@link #LOLLIPOP}.
         * @hide
         */
        public static final int L = 21;

        /**
         * November 2014: Lollipop.  A flat one with beautiful shadows.  But still tasty.
         */
        public static final int LOLLIPOP = 21;

        /**
         * March 2015: Lollipop with an extra sugar coating on the outside!
         */
        public static final int LOLLIPOP_MR1 = 22;

        /**
         * M is for Marshmallow!
         */
        public static final int M = 23;

        /**
         * N is for Nougat.
         */
        public static final int N = 24;

        /**
         * N MR1: Nougat++.
         */
        public static final int N_MR1 = 25;

        /**
         * O.
         *
         * <p>Applications targeting this or a later release will get these
         */
        public static final int O = 26;

        /**
         * O MR1.
         */
        public static final int O_MR1 = 27;
    }
}
