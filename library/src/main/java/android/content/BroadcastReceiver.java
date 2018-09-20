/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.content;

public abstract class BroadcastReceiver {
        public final void finish() {
        }




    public BroadcastReceiver() {
    }

    public abstract void onReceive(Context context, Intent intent);



    public final void setResultCode(int code) {
    }

    /**
     * Retrieve the current result code, as set by the previous receiver.
     *
     * @return int The current result code.
     */
    public final int getResultCode() {
        return  0;
    }

    public final void setResultData(String data) {
    }

    /**
     * Retrieve the current result data, as set by the previous receiver.
     * Often this is null.
     *
     * @return String The current result data; may be null.
     */
    public final String getResultData() {
        return null;
    }



    /**
     * Returns the flag indicating whether or not this receiver should
     * abort the current broadcast.
     *
     * @return True if the broadcast should be aborted.
     */
    public final boolean getAbortBroadcast() {
        return false;
    }

    public final void abortBroadcast() {
    }

    /**
     * Clears the flag indicating that this receiver should abort the current
     * broadcast.
     */
    public final void clearAbortBroadcast() {
    }

    /**
     * Returns true if the receiver is currently processing an ordered
     * broadcast.
     */
    public final boolean isOrderedBroadcast() {
        return false;
    }

    /**
     * Returns true if the receiver is currently processing the initial
     * value of a sticky broadcast -- that is, the value that was last
     * broadcast and is currently held in the sticky cache, so this is
     * not directly the result of a broadcast right now.
     */
    public final boolean isInitialStickyBroadcast() {
        return false;
    }

    /**
     * For internal use, sets the hint about whether this BroadcastReceiver is
     * running in ordered mode.
     */
    public final void setOrderedHint(boolean isOrdered) {
        // Accidentally left in the SDK.
    }



    public final void setDebugUnregister(boolean debug) {
    }

    /**
     * Return the last value given to {@link #setDebugUnregister}.
     */
    public final boolean getDebugUnregister() {
        return false;
    }

}

