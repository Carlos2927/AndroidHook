package android.os;

public class Message {
    /**
     * User-defined message code so that the recipient can identify
     * what this message is about. Each {@link Handler} has its own name-space
     * for message codes, so you do not need to worry about yours conflicting
     * with other handlers.
     */
    public int what;

    public int arg1;

    public int arg2;

    public Object obj;


    public int sendingUid = -1;

    /** If set message is in use.
     * This flag is set when the message is enqueued and remains set while it
     * is delivered and afterwards when it is recycled.  The flag is only cleared
     * when a new message is created or obtained since that is the only time that
     * applications are allowed to modify the contents of the message.
     *
     * It is an error to attempt to enqueue or recycle a message that is already in use.
     */
    /*package*/ static final int FLAG_IN_USE = 1 << 0;

    /** If set message is asynchronous */
    /*package*/ static final int FLAG_ASYNCHRONOUS = 1 << 1;

    /** Flags to clear in the copyFrom method */
    /*package*/ static final int FLAGS_TO_CLEAR_ON_COPY_FROM = FLAG_IN_USE;

    /*package*/ int flags;

    /*package*/ long when;


    /*package*/ Handler target;

    /*package*/ Runnable callback;



    /**
     * Return a new Message instance from the global pool. Allows us to
     * avoid allocating new objects in many cases.
     */
    public static Message obtain() {
        return null;
    }

    /**
     * Same as {@link #obtain()}, but copies the values of an existing
     * message (including its target) into the new one.
     * @param orig Original message to copy.
     * @return A Message object from the global pool.
     */
    public static Message obtain(Message orig) {

        return null;
    }

    /**
     * Same as {@link #obtain()}, but sets the value for the <em>target</em> member on the Message returned.
     * @param h  Handler to assign to the returned Message object's <em>target</em> member.
     * @return A Message object from the global pool.
     */
    public static Message obtain(Handler h) {

        return null;
    }

    /**
     * Same as {@link #obtain(Handler)}, but assigns a callback Runnable on
     * the Message that is returned.
     * @param h  Handler to assign to the returned Message object's <em>target</em> member.
     * @param callback Runnable that will execute when the message is handled.
     * @return A Message object from the global pool.
     */
    public static Message obtain(Handler h, Runnable callback) {

        return null;
    }

    /**
     * Same as {@link #obtain()}, but sets the values for both <em>target</em> and
     * <em>what</em> members on the Message.
     * @param h  Value to assign to the <em>target</em> member.
     * @param what  Value to assign to the <em>what</em> member.
     * @return A Message object from the global pool.
     */
    public static Message obtain(Handler h, int what) {

        return null;
    }

    /**
     * Same as {@link #obtain()}, but sets the values of the <em>target</em>, <em>what</em>, and <em>obj</em>
     * members.
     * @param h  The <em>target</em> value to set.
     * @param what  The <em>what</em> value to set.
     * @param obj  The <em>object</em> method to set.
     * @return  A Message object from the global pool.
     */
    public static Message obtain(Handler h, int what, Object obj) {

        return null;
    }

    /**
     * Same as {@link #obtain()}, but sets the values of the <em>target</em>, <em>what</em>,
     * <em>arg1</em>, and <em>arg2</em> members.
     *
     * @param h  The <em>target</em> value to set.
     * @param what  The <em>what</em> value to set.
     * @param arg1  The <em>arg1</em> value to set.
     * @param arg2  The <em>arg2</em> value to set.
     * @return  A Message object from the global pool.
     */
    public static Message obtain(Handler h, int what, int arg1, int arg2) {

        return null;
    }

    /**
     * Same as {@link #obtain()}, but sets the values of the <em>target</em>, <em>what</em>,
     * <em>arg1</em>, <em>arg2</em>, and <em>obj</em> members.
     *
     * @param h  The <em>target</em> value to set.
     * @param what  The <em>what</em> value to set.
     * @param arg1  The <em>arg1</em> value to set.
     * @param arg2  The <em>arg2</em> value to set.
     * @param obj  The <em>obj</em> value to set.
     * @return  A Message object from the global pool.
     */
    public static Message obtain(Handler h, int what,
                                 int arg1, int arg2, Object obj) {

        return null;
    }

    /** @hide */
    public static void updateCheckRecycle(int targetSdkVersion) {
    }

    /**
     * Return a Message instance to the global pool.
     * <p>
     * You MUST NOT touch the Message after calling this function because it has
     * effectively been freed.  It is an error to recycle a message that is currently
     * enqueued or that is in the process of being delivered to a Handler.
     * </p>
     */
    public void recycle() {
    }


    /**
     * Make this message like o.  Performs a shallow copy of the data field.
     * Does not copy the linked list fields, nor the timestamp or
     * target/callback of the original message.
     */
    public void copyFrom(Message o) {
    }

    /**
     * Return the targeted delivery time of this message, in milliseconds.
     */
    public long getWhen() {
        return when;
    }

    public void setTarget(Handler target) {
        this.target = target;
    }

    /**
     * Retrieve the a {@link android.os.Handler Handler} implementation that
     * will receive this message. The object must implement
     * {@link android.os.Handler#handleMessage(Message)
     * Handler.handleMessage()}. Each Handler has its own name-space for
     * message codes, so you do not need to
     * worry about yours conflicting with other handlers.
     */
    public Handler getTarget() {
        return target;
    }

    /**
     * Retrieve callback object that will execute when this message is handled.
     * This object must implement Runnable. This is called by
     * the <em>target</em> {@link Handler} that is receiving this Message to
     * dispatch it.  If
     * not set, the message will be dispatched to the receiving Handler's
     * {@link Handler#handleMessage(Message Handler.handleMessage())}.
     */
    public Runnable getCallback() {
        return callback;
    }




    /**
     * Sends this Message to the Handler specified by {@link #getTarget}.
     * Throws a null pointer exception if this field has not been set.
     */
    public void sendToTarget() {
    }

    public boolean isAsynchronous() {
        return (flags & FLAG_ASYNCHRONOUS) != 0;
    }
    public void setAsynchronous(boolean async) {
    }

    /*package*/ boolean isInUse() {
        return ((flags & FLAG_IN_USE) == FLAG_IN_USE);
    }

    /*package*/ void markInUse() {
        flags |= FLAG_IN_USE;
    }

    /** Constructor (but the preferred way to get a Message is to call {@link #obtain() Message.obtain()}).
     */
    public Message() {
    }

    @Override
    public String toString() {
        return null;
    }


}
