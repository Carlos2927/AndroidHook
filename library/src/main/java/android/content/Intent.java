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


import com.sun.jndi.toolkit.url.Uri;

import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;


public class Intent implements Cloneable {
    private static final String ATTR_ACTION = "action";
    private static final String TAG_CATEGORIES = "categories";
    private static final String ATTR_CATEGORY = "category";
    private static final String TAG_EXTRA = "extra";
    private static final String ATTR_TYPE = "type";
    private static final String ATTR_COMPONENT = "component";
    private static final String ATTR_DATA = "data";
    private static final String ATTR_FLAGS = "flags";
    public static final int FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET = 0x00080000;

    // ---------------------------------------------------------------------
    // ---------------------------------------------------------------------
    // Standard intent activity actions (see action variable).

       
    public static final String ACTION_MAIN = "android.intent.action.MAIN";

       
    public static final String ACTION_VIEW = "android.intent.action.VIEW";

    /**
     * Extra that can be included on activity intents coming from the storage UI
     * when it launches sub-activities to manage various types of storage.  For example,
     * it may use {@link #ACTION_VIEW} with a "image/*" MIME type to have an app show
     * the images on the device, and in that case also include this extra to tell the
     * app it is coming from the storage UI so should help the user manage storage of
     * this type.
     */
    public static final String EXTRA_FROM_STORAGE = "android.intent.extra.FROM_STORAGE";

       public static final String ACTION_DEFAULT = ACTION_VIEW;

       
    public static final String ACTION_QUICK_VIEW = "android.intent.action.QUICK_VIEW";

       
    public static final String ACTION_ATTACH_DATA = "android.intent.action.ATTACH_DATA";

       
    public static final String ACTION_EDIT = "android.intent.action.EDIT";

    /**
     * Activity Action: Pick an existing item, or insert a new item, and then edit it.
     * <p>Input: {@link #getType} is the desired MIME type of the item to create or edit.
     * The extras can contain type specific data to pass through to the editing/creating
     * activity.
     * <p>Output: The URI of the item that was picked.  This must be a content:
     * URI so that any receiver can access it.
     */
    
    public static final String ACTION_INSERT_OR_EDIT = "android.intent.action.INSERT_OR_EDIT";

    /**
     * Activity Action: Pick an item from the data, returning what was selected.
     * <p>Input: {@link #getData} is URI containing a directory of data
     * (vnd.android.cursor.dir/*) from which to pick an item.
     * <p>Output: The URI of the item that was picked.
     */
    
    public static final String ACTION_PICK = "android.intent.action.PICK";
    public static final String ACTION_CREATE_SHORTCUT = "android.intent.action.CREATE_SHORTCUT";

       @Deprecated
    public static final String EXTRA_SHORTCUT_INTENT = "android.intent.extra.shortcut.INTENT";
       @Deprecated
    public static final String EXTRA_SHORTCUT_NAME = "android.intent.extra.shortcut.NAME";
       @Deprecated
    public static final String EXTRA_SHORTCUT_ICON = "android.intent.extra.shortcut.ICON";
       @Deprecated
    public static final String EXTRA_SHORTCUT_ICON_RESOURCE =
            "android.intent.extra.shortcut.ICON_RESOURCE";

       
    public static final String ACTION_APPLICATION_PREFERENCES
            = "android.intent.action.APPLICATION_PREFERENCES";

       
    public static final String ACTION_SHOW_APP_INFO
            = "android.intent.action.SHOW_APP_INFO";



    public static final String ACTION_CHOOSER = "android.intent.action.CHOOSER";

       public static Intent createChooser(Intent target, CharSequence title) {
        return null;
    }


    public static final String ACTION_GET_CONTENT = "android.intent.action.GET_CONTENT";
       
    public static final String ACTION_DIAL = "android.intent.action.DIAL";

    public static final String ACTION_CALL = "android.intent.action.CALL";
       
    
    public static final String ACTION_CALL_EMERGENCY = "android.intent.action.CALL_EMERGENCY";
       
    
    public static final String ACTION_CALL_PRIVILEGED = "android.intent.action.CALL_PRIVILEGED";

       
    public static final String ACTION_CARRIER_SETUP = "android.intent.action.CARRIER_SETUP";
       
    public static final String ACTION_SENDTO = "android.intent.action.SENDTO";

    public static final String ACTION_SEND = "android.intent.action.SEND";

    public static final String ACTION_SEND_MULTIPLE = "android.intent.action.SEND_MULTIPLE";
       
    public static final String ACTION_ANSWER = "android.intent.action.ANSWER";
    /**
     * Activity Action: Insert an empty item into the given container.
     * <p>Input: {@link #getData} is URI of the directory (vnd.android.cursor.dir/*)
     * in which to place the data.
     * <p>Output: URI of the new data that was created.
     */
    
    public static final String ACTION_INSERT = "android.intent.action.INSERT";
    /**
     * Activity Action: Create a new item in the given container, initializing it
     * from the current contents of the clipboard.
     * <p>Input: {@link #getData} is URI of the directory (vnd.android.cursor.dir/*)
     * in which to place the data.
     * <p>Output: URI of the new data that was created.
     */
    
    public static final String ACTION_PASTE = "android.intent.action.PASTE";
       
    public static final String ACTION_DELETE = "android.intent.action.DELETE";
       
    public static final String ACTION_RUN = "android.intent.action.RUN";
       
    public static final String ACTION_SYNC = "android.intent.action.SYNC";
       
    public static final String ACTION_PICK_ACTIVITY = "android.intent.action.PICK_ACTIVITY";
       
    public static final String ACTION_SEARCH = "android.intent.action.SEARCH";
       
    public static final String ACTION_SYSTEM_TUTORIAL = "android.intent.action.SYSTEM_TUTORIAL";
       
    public static final String ACTION_WEB_SEARCH = "android.intent.action.WEB_SEARCH";

       
    public static final String ACTION_ASSIST = "android.intent.action.ASSIST";

       
    
    public static final String ACTION_VOICE_ASSIST = "android.intent.action.VOICE_ASSIST";

       public static final String EXTRA_ASSIST_PACKAGE
            = "android.intent.extra.ASSIST_PACKAGE";

       public static final String EXTRA_ASSIST_UID
            = "android.intent.extra.ASSIST_UID";

       public static final String EXTRA_ASSIST_CONTEXT
            = "android.intent.extra.ASSIST_CONTEXT";

       public static final String EXTRA_ASSIST_INPUT_HINT_KEYBOARD =
            "android.intent.extra.ASSIST_INPUT_HINT_KEYBOARD";

       public static final String EXTRA_ASSIST_INPUT_DEVICE_ID =
            "android.intent.extra.ASSIST_INPUT_DEVICE_ID";

       
    public static final String ACTION_ALL_APPS = "android.intent.action.ALL_APPS";
       
    public static final String ACTION_SET_WALLPAPER = "android.intent.action.SET_WALLPAPER";

       
    public static final String ACTION_BUG_REPORT = "android.intent.action.BUG_REPORT";

       
    public static final String ACTION_FACTORY_TEST = "android.intent.action.FACTORY_TEST";

       
    public static final String ACTION_CALL_BUTTON = "android.intent.action.CALL_BUTTON";

       
    public static final String ACTION_VOICE_COMMAND = "android.intent.action.VOICE_COMMAND";

       
    public static final String ACTION_SEARCH_LONG_PRESS = "android.intent.action.SEARCH_LONG_PRESS";

    /**
     * Activity Action: The user pressed the "Report" button in the crash/ANR dialog.
     * This intent is delivered to the package which installed the application, usually
     * Google Play.
     * <p>Input: No data is specified. The bug report is passed in using
     * an {@link #EXTRA_BUG_REPORT} field.
     * <p>Output: Nothing.
     *
     * @see #EXTRA_BUG_REPORT
     */
    
    public static final String ACTION_APP_ERROR = "android.intent.action.APP_ERROR";

       
    public static final String ACTION_POWER_USAGE_SUMMARY = "android.intent.action.POWER_USAGE_SUMMARY";

       @Deprecated
    
    public static final String ACTION_DEVICE_INITIALIZATION_WIZARD =
            "android.intent.action.DEVICE_INITIALIZATION_WIZARD";

       
    
    public static final String ACTION_UPGRADE_SETUP = "android.intent.action.UPGRADE_SETUP";

       
    public static final String ACTION_SHOW_KEYBOARD_SHORTCUTS =
            "com.android.intent.action.SHOW_KEYBOARD_SHORTCUTS";

       
    public static final String ACTION_DISMISS_KEYBOARD_SHORTCUTS =
            "com.android.intent.action.DISMISS_KEYBOARD_SHORTCUTS";

       
    public static final String ACTION_MANAGE_NETWORK_USAGE =
            "android.intent.action.MANAGE_NETWORK_USAGE";

    public static final String ACTION_INSTALL_PACKAGE = "android.intent.action.INSTALL_PACKAGE";

       
    public static final String ACTION_INSTALL_FAILURE = "android.intent.action.INSTALL_FAILURE";

       
    
    public static final String ACTION_INSTALL_EPHEMERAL_PACKAGE
            = "android.intent.action.INSTALL_EPHEMERAL_PACKAGE";
    /**
     * Activity Action: Launch instant application installer.
     * <p class="note">
     * This is a protected intent that can only be sent by the system.
     * </p>
     *
     * @hide
     */
    
    
    public static final String ACTION_INSTALL_INSTANT_APP_PACKAGE
            = "android.intent.action.INSTALL_INSTANT_APP_PACKAGE";

       
    
    public static final String ACTION_RESOLVE_EPHEMERAL_PACKAGE
            = "android.intent.action.RESOLVE_EPHEMERAL_PACKAGE";
    /**
     * Service Action: Resolve instant application.
     * <p>
     * The system will have a persistent connection to this service.
     * This is a protected intent that can only be sent by the system.
     * </p>
     *
     * @hide
     */
    
    
    public static final String ACTION_RESOLVE_INSTANT_APP_PACKAGE
            = "android.intent.action.RESOLVE_INSTANT_APP_PACKAGE";

       
    
    public static final String ACTION_EPHEMERAL_RESOLVER_SETTINGS
            = "android.intent.action.EPHEMERAL_RESOLVER_SETTINGS";
    /**
     * Activity Action: Launch instant app settings.
     *
     * <p class="note">
     * This is a protected intent that can only be sent by the system.
     * </p>
     *
     * @hide
     */
    
    
    public static final String ACTION_INSTANT_APP_RESOLVER_SETTINGS
            = "android.intent.action.INSTANT_APP_RESOLVER_SETTINGS";

       public static final String EXTRA_INSTALLER_PACKAGE_NAME
            = "android.intent.extra.INSTALLER_PACKAGE_NAME";

       public static final String EXTRA_NOT_UNKNOWN_SOURCE
            = "android.intent.extra.NOT_UNKNOWN_SOURCE";

       public static final String EXTRA_ORIGINATING_URI
            = "android.intent.extra.ORIGINATING_URI";

    public static final String EXTRA_REFERRER
            = "android.intent.extra.REFERRER";

       public static final String EXTRA_REFERRER_NAME
            = "android.intent.extra.REFERRER_NAME";

       
    public static final String EXTRA_ORIGINATING_UID
            = "android.intent.extra.ORIGINATING_UID";

       @Deprecated
    public static final String EXTRA_ALLOW_REPLACE
            = "android.intent.extra.ALLOW_REPLACE";

    public static final String EXTRA_RETURN_RESULT
            = "android.intent.extra.RETURN_RESULT";

       public static final String EXTRA_INSTALL_RESULT
            = "android.intent.extra.INSTALL_RESULT";

       
    public static final String ACTION_UNINSTALL_PACKAGE = "android.intent.action.UNINSTALL_PACKAGE";

       public static final String EXTRA_UNINSTALL_ALL_USERS
            = "android.intent.extra.UNINSTALL_ALL_USERS";

       public static final String METADATA_SETUP_VERSION = "android.SETUP_VERSION";

    /**
     * Activity action: Launch UI to manage the permissions of an app.
     * <p>
     * Input: {@link #EXTRA_PACKAGE_NAME} specifies the package whose permissions
     * will be managed by the launched UI.
     * </p>
     * <p>
     * Output: Nothing.
     * </p>
     *
     * @see #EXTRA_PACKAGE_NAME
     *
     * @hide
     */
    
    
    public static final String ACTION_MANAGE_APP_PERMISSIONS =
            "android.intent.action.MANAGE_APP_PERMISSIONS";

    /**
     * Activity action: Launch UI to manage permissions.
     * <p>
     * Input: Nothing.
     * </p>
     * <p>
     * Output: Nothing.
     * </p>
     *
     * @hide
     */
    
    
    public static final String ACTION_MANAGE_PERMISSIONS =
            "android.intent.action.MANAGE_PERMISSIONS";

    /**
     * Activity action: Launch UI to review permissions for an app.
     * The system uses this intent if permission review for apps not
     * supporting the new runtime permissions model is enabled. In
     * this mode a permission review is required before any of the
     * app components can run.
     * <p>
     * Input: {@link #EXTRA_PACKAGE_NAME} specifies the package whose
     * permissions will be reviewed (mandatory).
     * </p>
     * <p>
     * Input: {@link #EXTRA_INTENT} specifies a pending intent to
     * be fired after the permission review (optional).
     * </p>
     * <p>
     * Input: {@link #EXTRA_REMOTE_CALLBACK} specifies a callback to
     * be invoked after the permission review (optional).
     * </p>
     * <p>
     * Input: {@link #EXTRA_RESULT_NEEDED} specifies whether the intent
     * passed via {@link #EXTRA_INTENT} needs a result (optional).
     * </p>
     * <p>
     * Output: Nothing.
     * </p>
     *
     * @see #EXTRA_PACKAGE_NAME
     * @see #EXTRA_INTENT
     * @see #EXTRA_REMOTE_CALLBACK
     * @see #EXTRA_RESULT_NEEDED
     *
     * @hide
     */
    
    
    public static final String ACTION_REVIEW_PERMISSIONS =
            "android.intent.action.REVIEW_PERMISSIONS";

    /**
     * Intent extra: A callback for reporting remote result as a bundle.
     * <p>
     * Type: IRemoteCallback
     * </p>
     *
     * @hide
     */
    
    public static final String EXTRA_REMOTE_CALLBACK = "android.intent.extra.REMOTE_CALLBACK";

    /**
     * Intent extra: An app package name.
     * <p>
     * Type: String
     * </p>
     *
     */
    public static final String EXTRA_PACKAGE_NAME = "android.intent.extra.PACKAGE_NAME";

    /**
     * Intent extra: An app split name.
     * <p>
     * Type: String
     * </p>
     */
    public static final String EXTRA_SPLIT_NAME = "android.intent.extra.SPLIT_NAME";

    /**
     * Intent extra: A {@link ComponentName} value.
     * <p>
     * Type: String
     * </p>
     */
    public static final String EXTRA_COMPONENT_NAME = "android.intent.extra.COMPONENT_NAME";

    /**
     * Intent extra: An extra for specifying whether a result is needed.
     * <p>
     * Type: boolean
     * </p>
     *
     * @hide
     */
    
    public static final String EXTRA_RESULT_NEEDED = "android.intent.extra.RESULT_NEEDED";

    /**
     * Activity action: Launch UI to manage which apps have a given permission.
     * <p>
     * Input: {@link #EXTRA_PERMISSION_NAME} specifies the permission access
     * to which will be managed by the launched UI.
     * </p>
     * <p>
     * Output: Nothing.
     * </p>
     *
     * @see #EXTRA_PERMISSION_NAME
     *
     * @hide
     */
    
    
    public static final String ACTION_MANAGE_PERMISSION_APPS =
            "android.intent.action.MANAGE_PERMISSION_APPS";

    /**
     * Intent extra: The name of a permission.
     * <p>
     * Type: String
     * </p>
     *
     * @hide
     */
    
    public static final String EXTRA_PERMISSION_NAME = "android.intent.extra.PERMISSION_NAME";

    // ---------------------------------------------------------------------
    // ---------------------------------------------------------------------
    // Standard intent broadcast actions (see action variable).


    public static final String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";


    public static final String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";

    /**
     * Broadcast Action: Sent after the system stops dreaming.
     *
     * <p class="note">This is a protected intent that can only be sent by the system.
     * It is only sent to registered receivers.</p>
     */
    
    public static final String ACTION_DREAMING_STOPPED = "android.intent.action.DREAMING_STOPPED";

    /**
     * Broadcast Action: Sent after the system starts dreaming.
     *
     * <p class="note">This is a protected intent that can only be sent by the system.
     * It is only sent to registered receivers.</p>
     */
    
    public static final String ACTION_DREAMING_STARTED = "android.intent.action.DREAMING_STARTED";

       
    public static final String ACTION_USER_PRESENT = "android.intent.action.USER_PRESENT";

    public static final String ACTION_TIME_TICK = "android.intent.action.TIME_TICK";
       
    public static final String ACTION_TIME_CHANGED = "android.intent.action.TIME_SET";
       
    public static final String ACTION_DATE_CHANGED = "android.intent.action.DATE_CHANGED";
    /**
     * Broadcast Action: The timezone has changed. The intent will have the following extra values:</p>
     * <ul>
     *   <li><em>time-zone</em> - The java.util.TimeZone.getID() value identifying the new time zone.</li>
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    public static final String ACTION_TIMEZONE_CHANGED = "android.intent.action.TIMEZONE_CHANGED";
       
    public static final String ACTION_CLEAR_DNS_CACHE = "android.intent.action.CLEAR_DNS_CACHE";
       
    public static final String ACTION_ALARM_CHANGED = "android.intent.action.ALARM_CHANGED";

       
    public static final String ACTION_LOCKED_BOOT_COMPLETED = "android.intent.action.LOCKED_BOOT_COMPLETED";

       
    public static final String ACTION_BOOT_COMPLETED = "android.intent.action.BOOT_COMPLETED";

       
    public static final String ACTION_CLOSE_SYSTEM_DIALOGS = "android.intent.action.CLOSE_SYSTEM_DIALOGS";
       @Deprecated
    
    public static final String ACTION_PACKAGE_INSTALL = "android.intent.action.PACKAGE_INSTALL";
    /**
     * Broadcast Action: A new application package has been installed on the
     * device. The data contains the name of the package.  Note that the
     * newly installed package does <em>not</em> receive this broadcast.
     * <p>May include the following extras:
     * <ul>
     * <li> {@link #EXTRA_UID} containing the integer uid assigned to the new package.
     * <li> {@link #EXTRA_REPLACING} is set to true if this is following
     * an {@link #ACTION_PACKAGE_REMOVED} broadcast for the same package.
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    public static final String ACTION_PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    /**
     * Broadcast Action: A new version of an application package has been
     * installed, replacing an existing version that was previously installed.
     * The data contains the name of the package.
     * <p>May include the following extras:
     * <ul>
     * <li> {@link #EXTRA_UID} containing the integer uid assigned to the new package.
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    public static final String ACTION_PACKAGE_REPLACED = "android.intent.action.PACKAGE_REPLACED";
       
    public static final String ACTION_MY_PACKAGE_REPLACED = "android.intent.action.MY_PACKAGE_REPLACED";
    /**
     * Broadcast Action: An existing application package has been removed from
     * the device.  The data contains the name of the package.  The package
     * that is being removed does <em>not</em> receive this Intent.
     * <ul>
     * <li> {@link #EXTRA_UID} containing the integer uid previously assigned
     * to the package.
     * <li> {@link #EXTRA_DATA_REMOVED} is set to true if the entire
     * application -- data and code -- is being removed.
     * <li> {@link #EXTRA_REPLACING} is set to true if this will be followed
     * by an {@link #ACTION_PACKAGE_ADDED} broadcast for the same package.
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    public static final String ACTION_PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
    /**
     * Broadcast Action: An existing application package has been completely
     * removed from the device.  The data contains the name of the package.
     * This is like {@link #ACTION_PACKAGE_REMOVED}, but only set when
     * {@link #EXTRA_DATA_REMOVED} is true and
     * {@link #EXTRA_REPLACING} is false of that broadcast.
     *
     * <ul>
     * <li> {@link #EXTRA_UID} containing the integer uid previously assigned
     * to the package.
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    public static final String ACTION_PACKAGE_FULLY_REMOVED
            = "android.intent.action.PACKAGE_FULLY_REMOVED";
    /**
     * Broadcast Action: An existing application package has been changed (for
     * example, a component has been enabled or disabled).  The data contains
     * the name of the package.
     * <ul>
     * <li> {@link #EXTRA_UID} containing the integer uid assigned to the package.
     * <li> {@link #EXTRA_CHANGED_COMPONENT_NAME_LIST} containing the class name
     * of the changed components (or the package name itself).
     * <li> {@link #EXTRA_DONT_KILL_APP} containing boolean field to override the
     * default action of restarting the application.
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    public static final String ACTION_PACKAGE_CHANGED = "android.intent.action.PACKAGE_CHANGED";
    /**
     * @hide
     * Broadcast Action: Ask system services if there is any reason to
     * restart the given package.  The data contains the name of the
     * package.
     * <ul>
     * <li> {@link #EXTRA_UID} containing the integer uid assigned to the package.
     * <li> {@link #EXTRA_PACKAGES} String array of all packages to check.
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    
    public static final String ACTION_QUERY_PACKAGE_RESTART = "android.intent.action.QUERY_PACKAGE_RESTART";
    /**
     * Broadcast Action: The user has restarted a package, and all of its
     * processes have been killed.  All runtime state
     * associated with it (processes, alarms, notifications, etc) should
     * be removed.  Note that the restarted package does <em>not</em>
     * receive this broadcast.
     * The data contains the name of the package.
     * <ul>
     * <li> {@link #EXTRA_UID} containing the integer uid assigned to the package.
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    public static final String ACTION_PACKAGE_RESTARTED = "android.intent.action.PACKAGE_RESTARTED";
    /**
     * Broadcast Action: The user has cleared the data of a package.  This should
     * be preceded by {@link #ACTION_PACKAGE_RESTARTED}, after which all of
     * its persistent data is erased and this broadcast sent.
     * Note that the cleared package does <em>not</em>
     * receive this broadcast. The data contains the name of the package.
     * <ul>
     * <li> {@link #EXTRA_UID} containing the integer uid assigned to the package. If the
     *      package whose data was cleared is an uninstalled instant app, then the UID
     *      will be -1. The platform keeps some meta-data associated with instant apps
     *      after they are uninstalled.
     * <li> {@link #EXTRA_PACKAGE_NAME} containing the package name only if the cleared
     *      data was for an instant app.
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    public static final String ACTION_PACKAGE_DATA_CLEARED = "android.intent.action.PACKAGE_DATA_CLEARED";
    /**
     * Broadcast Action: Packages have been suspended.
     * <p>Includes the following extras:
     * <ul>
     * <li> {@link #EXTRA_CHANGED_PACKAGE_LIST} is the set of packages which have been suspended
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system. It is only sent to registered receivers.
     */
    
    public static final String ACTION_PACKAGES_SUSPENDED = "android.intent.action.PACKAGES_SUSPENDED";
    /**
     * Broadcast Action: Packages have been unsuspended.
     * <p>Includes the following extras:
     * <ul>
     * <li> {@link #EXTRA_CHANGED_PACKAGE_LIST} is the set of packages which have been unsuspended
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system. It is only sent to registered receivers.
     */
    
    public static final String ACTION_PACKAGES_UNSUSPENDED = "android.intent.action.PACKAGES_UNSUSPENDED";
       
    public static final String ACTION_UID_REMOVED = "android.intent.action.UID_REMOVED";

       
    public static final String ACTION_PACKAGE_FIRST_LAUNCH = "android.intent.action.PACKAGE_FIRST_LAUNCH";

    /**
     * Broadcast Action: Sent to the system package verifier when a package
     * needs to be verified. The data contains the package URI.
     * <p class="note">
     * This is a protected intent that can only be sent by the system.
     * </p>
     */
    
    public static final String ACTION_PACKAGE_NEEDS_VERIFICATION = "android.intent.action.PACKAGE_NEEDS_VERIFICATION";

       
    public static final String ACTION_PACKAGE_VERIFIED = "android.intent.action.PACKAGE_VERIFIED";

    /**
     * Broadcast Action: Sent to the system intent filter verifier when an
     * intent filter needs to be verified. The data contains the filter data
     * hosts to be verified against.
     * <p class="note">
     * This is a protected intent that can only be sent by the system.
     * </p>
     *
     * @hide
     */
    
    
    public static final String ACTION_INTENT_FILTER_NEEDS_VERIFICATION = "android.intent.action.INTENT_FILTER_NEEDS_VERIFICATION";

    /**
     * Broadcast Action: Resources for a set of packages (which were
     * previously unavailable) are currently
     * available since the media on which they exist is available.
     * The extra data {@link #EXTRA_CHANGED_PACKAGE_LIST} contains a
     * list of packages whose availability changed.
     * The extra data {@link #EXTRA_CHANGED_UID_LIST} contains a
     * list of uids of packages whose availability changed.
     * Note that the
     * packages in this list do <em>not</em> receive this broadcast.
     * The specified set of packages are now available on the system.
     * <p>Includes the following extras:
     * <ul>
     * <li> {@link #EXTRA_CHANGED_PACKAGE_LIST} is the set of packages
     * whose resources(were previously unavailable) are currently available.
     * {@link #EXTRA_CHANGED_UID_LIST} is the set of uids of the
     * packages whose resources(were previously unavailable)
     * are  currently available.
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE =
            "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";

    /**
     * Broadcast Action: Resources for a set of packages are currently
     * unavailable since the media on which they exist is unavailable.
     * The extra data {@link #EXTRA_CHANGED_PACKAGE_LIST} contains a
     * list of packages whose availability changed.
     * The extra data {@link #EXTRA_CHANGED_UID_LIST} contains a
     * list of uids of packages whose availability changed.
     * The specified set of packages can no longer be
     * launched and are practically unavailable on the system.
     * <p>Inclues the following extras:
     * <ul>
     * <li> {@link #EXTRA_CHANGED_PACKAGE_LIST} is the set of packages
     * whose resources are no longer available.
     * {@link #EXTRA_CHANGED_UID_LIST} is the set of packages
     * whose resources are no longer available.
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     */
    
    public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE =
            "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";

       
    public static final String ACTION_PREFERRED_ACTIVITY_CHANGED =
            "android.intent.action.ACTION_PREFERRED_ACTIVITY_CHANGED";

    public static final String ACTION_WALLPAPER_CHANGED = "android.intent.action.WALLPAPER_CHANGED";

    public static final String ACTION_CONFIGURATION_CHANGED = "android.intent.action.CONFIGURATION_CHANGED";
       
    public static final String ACTION_LOCALE_CHANGED = "android.intent.action.LOCALE_CHANGED";

    public static final String ACTION_BATTERY_CHANGED = "android.intent.action.BATTERY_CHANGED";
       
    public static final String ACTION_BATTERY_LOW = "android.intent.action.BATTERY_LOW";
       
    public static final String ACTION_BATTERY_OKAY = "android.intent.action.BATTERY_OKAY";
       
    public static final String ACTION_POWER_CONNECTED = "android.intent.action.ACTION_POWER_CONNECTED";
       
    public static final String ACTION_POWER_DISCONNECTED =
            "android.intent.action.ACTION_POWER_DISCONNECTED";
    /**
     * Broadcast Action:  Device is shutting down.
     * This is broadcast when the device is being shut down (completely turned
     * off, not sleeping).  Once the broadcast is complete, the final shutdown
     * will proceed and all unsaved data lost.  Apps will not normally need
     * to handle this, since the foreground activity will be paused as well.
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     * <p>May include the following extras:
     * <ul>
     * <li> {@link #EXTRA_SHUTDOWN_USERSPACE_ONLY} a boolean that is set to true if this
     * shutdown is only for userspace processes.  If not set, assumed to be false.
     * </ul>
     */
    
    public static final String ACTION_SHUTDOWN = "android.intent.action.ACTION_SHUTDOWN";
       public static final String ACTION_REQUEST_SHUTDOWN
            = "com.android.internal.intent.action.REQUEST_SHUTDOWN";
       
    @Deprecated
    public static final String ACTION_DEVICE_STORAGE_LOW = "android.intent.action.DEVICE_STORAGE_LOW";
       
    @Deprecated
    public static final String ACTION_DEVICE_STORAGE_OK = "android.intent.action.DEVICE_STORAGE_OK";
       
    @Deprecated
    public static final String ACTION_DEVICE_STORAGE_FULL = "android.intent.action.DEVICE_STORAGE_FULL";
       
    @Deprecated
    public static final String ACTION_DEVICE_STORAGE_NOT_FULL = "android.intent.action.DEVICE_STORAGE_NOT_FULL";
       
    public static final String ACTION_MANAGE_PACKAGE_STORAGE = "android.intent.action.MANAGE_PACKAGE_STORAGE";
       @Deprecated
    
    public static final String ACTION_UMS_CONNECTED = "android.intent.action.UMS_CONNECTED";

       @Deprecated
    
    public static final String ACTION_UMS_DISCONNECTED = "android.intent.action.UMS_DISCONNECTED";

       
    public static final String ACTION_MEDIA_REMOVED = "android.intent.action.MEDIA_REMOVED";

       
    public static final String ACTION_MEDIA_UNMOUNTED = "android.intent.action.MEDIA_UNMOUNTED";

       
    public static final String ACTION_MEDIA_CHECKING = "android.intent.action.MEDIA_CHECKING";

       
    public static final String ACTION_MEDIA_NOFS = "android.intent.action.MEDIA_NOFS";

       
    public static final String ACTION_MEDIA_MOUNTED = "android.intent.action.MEDIA_MOUNTED";

       
    public static final String ACTION_MEDIA_SHARED = "android.intent.action.MEDIA_SHARED";

       public static final String ACTION_MEDIA_UNSHARED = "android.intent.action.MEDIA_UNSHARED";

       
    public static final String ACTION_MEDIA_BAD_REMOVAL = "android.intent.action.MEDIA_BAD_REMOVAL";

       
    public static final String ACTION_MEDIA_UNMOUNTABLE = "android.intent.action.MEDIA_UNMOUNTABLE";

       
    public static final String ACTION_MEDIA_EJECT = "android.intent.action.MEDIA_EJECT";

       
    public static final String ACTION_MEDIA_SCANNER_STARTED = "android.intent.action.MEDIA_SCANNER_STARTED";

       
    public static final String ACTION_MEDIA_SCANNER_FINISHED = "android.intent.action.MEDIA_SCANNER_FINISHED";

       
    public static final String ACTION_MEDIA_SCANNER_SCAN_FILE = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";

       
    public static final String ACTION_MEDIA_BUTTON = "android.intent.action.MEDIA_BUTTON";

       
    public static final String ACTION_CAMERA_BUTTON = "android.intent.action.CAMERA_BUTTON";

    // *** NOTE: @todo(*) The following really should go into a more domain-specific
    // location; they are not general-purpose actions.

       
    public static final String ACTION_GTALK_SERVICE_CONNECTED =
            "android.intent.action.GTALK_CONNECTED";

       
    public static final String ACTION_GTALK_SERVICE_DISCONNECTED =
            "android.intent.action.GTALK_DISCONNECTED";

       
    public static final String ACTION_INPUT_METHOD_CHANGED =
            "android.intent.action.INPUT_METHOD_CHANGED";

    /**
     * <p>Broadcast Action: The user has switched the phone into or out of Airplane Mode. One or
     * more radios have been turned off or on. The intent will have the following extra value:</p>
     * <ul>
     *   <li><em>state</em> - A boolean value indicating whether Airplane Mode is on. If true,
     *   then cell radio and possibly other radios such as bluetooth or WiFi may have also been
     *   turned off</li>
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent by the system.</p>
     */
    
    public static final String ACTION_AIRPLANE_MODE_CHANGED = "android.intent.action.AIRPLANE_MODE";

    /**
     * Broadcast Action: Some content providers have parts of their namespace
     * where they publish new events or items that the user may be especially
     * interested in. For these things, they may broadcast this action when the
     * set of interesting items change.
     *
     * For example, GmailProvider sends this notification when the set of unread
     * mail in the inbox changes.
     *
     * <p>The data of the intent identifies which part of which provider
     * changed. When queried through the content resolver, the data URI will
     * return the data set in question.
     *
     * <p>The intent will have the following extra values:
     * <ul>
     *   <li><em>count</em> - The number of items in the data set. This is the
     *       same as the number of items in the cursor returned by querying the
     *       data URI. </li>
     * </ul>
     *
     * This intent will be sent at boot (if the count is non-zero) and when the
     * data set changes. It is possible for the data set to change without the
     * count changing (for example, if a new unread message arrives in the same
     * sync operation in which a message is archived). The phone should still
     * ring/vibrate/etc as normal in this case.
     */
    
    public static final String ACTION_PROVIDER_CHANGED =
            "android.intent.action.PROVIDER_CHANGED";


    public static final String ACTION_HEADSET_PLUG = "android.intent.action.HEADSET_PLUG";

    /**
     * <p>Broadcast Action: The user has switched on advanced settings in the settings app:</p>
     * <ul>
     *   <li><em>state</em> - A boolean value indicating whether the settings is on or off.</li>
     * </ul>
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.
     *
     * @hide
     */
    //
    public static final String ACTION_ADVANCED_SETTINGS_CHANGED
            = "android.intent.action.ADVANCED_SETTINGS";

    /**
     *  Broadcast Action: Sent after application restrictions are changed.
     *
     * <p class="note">This is a protected intent that can only be sent
     * by the system.</p>
     */
    
    public static final String ACTION_APPLICATION_RESTRICTIONS_CHANGED =
            "android.intent.action.APPLICATION_RESTRICTIONS_CHANGED";


    public static final String ACTION_NEW_OUTGOING_CALL =
            "android.intent.action.NEW_OUTGOING_CALL";

       
    public static final String ACTION_REBOOT =
            "android.intent.action.REBOOT";


    public static final String ACTION_DOCK_EVENT =
            "android.intent.action.DOCK_EVENT";


    public static final String ACTION_IDLE_MAINTENANCE_START =
            "android.intent.action.ACTION_IDLE_MAINTENANCE_START";


    public static final String ACTION_IDLE_MAINTENANCE_END =
            "android.intent.action.ACTION_IDLE_MAINTENANCE_END";

       public static final String ACTION_REMOTE_INTENT =
            "com.google.android.c2dm.intent.RECEIVE";

       
    public static final String ACTION_PRE_BOOT_COMPLETED =
            "android.intent.action.PRE_BOOT_COMPLETED";

    public static final String ACTION_GET_RESTRICTION_ENTRIES =
            "android.intent.action.GET_RESTRICTION_ENTRIES";

       public static final String ACTION_USER_INITIALIZE =
            "android.intent.action.USER_INITIALIZE";

       public static final String ACTION_USER_FOREGROUND =
            "android.intent.action.USER_FOREGROUND";

       public static final String ACTION_USER_BACKGROUND =
            "android.intent.action.USER_BACKGROUND";

       public static final String ACTION_USER_ADDED =
            "android.intent.action.USER_ADDED";

       public static final String ACTION_USER_STARTED =
            "android.intent.action.USER_STARTED";
    public static final String ACTION_USER_STARTING =
            "android.intent.action.USER_STARTING";

    public static final String ACTION_USER_STOPPING =
            "android.intent.action.USER_STOPPING";

    /**
     * Broadcast sent to the system when a user is stopped. Carries an extra
     * EXTRA_USER_HANDLE that has the userHandle of the user.  This is similar to
     * {@link #ACTION_PACKAGE_RESTARTED}, but for an entire user instead of a
     * specific package.  This is only sent to registered receivers, not manifest
     * receivers.  It is sent to all running users <em>except</em> the one that
     * has just been stopped (which is no longer running).
     * @hide
     */
    public static final String ACTION_USER_STOPPED =
            "android.intent.action.USER_STOPPED";

       
    public static final String ACTION_USER_REMOVED =
            "android.intent.action.USER_REMOVED";

       public static final String ACTION_USER_SWITCHED =
            "android.intent.action.USER_SWITCHED";

       
    public static final String ACTION_USER_UNLOCKED = "android.intent.action.USER_UNLOCKED";

       public static final String ACTION_USER_INFO_CHANGED =
            "android.intent.action.USER_INFO_CHANGED";

       public static final String ACTION_MANAGED_PROFILE_ADDED =
            "android.intent.action.MANAGED_PROFILE_ADDED";

       public static final String ACTION_MANAGED_PROFILE_REMOVED =
            "android.intent.action.MANAGED_PROFILE_REMOVED";

       public static final String ACTION_MANAGED_PROFILE_UNLOCKED =
            "android.intent.action.MANAGED_PROFILE_UNLOCKED";

       public static final String ACTION_MANAGED_PROFILE_AVAILABLE =
            "android.intent.action.MANAGED_PROFILE_AVAILABLE";

       public static final String ACTION_MANAGED_PROFILE_UNAVAILABLE =
            "android.intent.action.MANAGED_PROFILE_UNAVAILABLE";

       public static final String ACTION_DEVICE_LOCKED_CHANGED =
            "android.intent.action.DEVICE_LOCKED_CHANGED";

       public static final String ACTION_QUICK_CLOCK =
            "android.intent.action.QUICK_CLOCK";

       public static final String ACTION_SHOW_BRIGHTNESS_DIALOG =
            "com.android.intent.action.SHOW_BRIGHTNESS_DIALOG";

       
    public static final String ACTION_GLOBAL_BUTTON = "android.intent.action.GLOBAL_BUTTON";

    public static final String ACTION_MEDIA_RESOURCE_GRANTED =
            "android.intent.action.MEDIA_RESOURCE_GRANTED";

       public static final String ACTION_OVERLAY_CHANGED = "android.intent.action.OVERLAY_CHANGED";

    public static final String ACTION_OPEN_DOCUMENT = "android.intent.action.OPEN_DOCUMENT";


    public static final String ACTION_CREATE_DOCUMENT = "android.intent.action.CREATE_DOCUMENT";

       
    public static final String
            ACTION_OPEN_DOCUMENT_TREE = "android.intent.action.OPEN_DOCUMENT_TREE";

    /**
     * Broadcast Action: List of dynamic sensor is changed due to new sensor being connected or
     * exisiting sensor being disconnected.
     *
     * <p class="note">This is a protected intent that can only be sent by the system.</p>
     *
     * {@hide}
     */
    
    public static final String
            ACTION_DYNAMIC_SENSOR_CHANGED = "android.intent.action.DYNAMIC_SENSOR_CHANGED";

       @Deprecated
    
    public static final String ACTION_MASTER_CLEAR = "android.intent.action.MASTER_CLEAR";

       
    
    public static final String ACTION_MASTER_CLEAR_NOTIFICATION
            = "android.intent.action.MASTER_CLEAR_NOTIFICATION";

       @Deprecated
    public static final String EXTRA_FORCE_MASTER_CLEAR =
            "android.intent.extra.FORCE_MASTER_CLEAR";

       
    
    public static final String ACTION_FACTORY_RESET = "android.intent.action.FACTORY_RESET";

       
    public static final String EXTRA_FORCE_FACTORY_RESET =
            "android.intent.extra.FORCE_FACTORY_RESET";

       public static final String ACTION_SETTING_RESTORED = "android.os.action.SETTING_RESTORED";

       public static final String EXTRA_SETTING_NAME = "setting_name";
       public static final String EXTRA_SETTING_PREVIOUS_VALUE = "previous_value";
       public static final String EXTRA_SETTING_NEW_VALUE = "new_value";
       public static final String EXTRA_SETTING_RESTORED_FROM_SDK_INT = "restored_from_sdk_int";

    /**
     * Activity Action: Process a piece of text.
     * <p>Input: {@link #EXTRA_PROCESS_TEXT} contains the text to be processed.
     * {@link #EXTRA_PROCESS_TEXT_READONLY} states if the resulting text will be read-only.</p>
     * <p>Output: {@link #EXTRA_PROCESS_TEXT} contains the processed text.</p>
     */
    
    public static final String ACTION_PROCESS_TEXT = "android.intent.action.PROCESS_TEXT";

       
    
    public static final String ACTION_SIM_STATE_CHANGED = "android.intent.action.SIM_STATE_CHANGED";

    /**
     * Broadcast Action: indicate that the phone service state has changed.
     * The intent will have the following extra values:</p>
     * <p>
     * @see #EXTRA_VOICE_REG_STATE
     * @see #EXTRA_DATA_REG_STATE
     * @see #EXTRA_VOICE_ROAMING_TYPE
     * @see #EXTRA_DATA_ROAMING_TYPE
     * @see #EXTRA_OPERATOR_ALPHA_LONG
     * @see #EXTRA_OPERATOR_ALPHA_SHORT
     * @see #EXTRA_OPERATOR_NUMERIC
     * @see #EXTRA_DATA_OPERATOR_ALPHA_LONG
     * @see #EXTRA_DATA_OPERATOR_ALPHA_SHORT
     * @see #EXTRA_DATA_OPERATOR_NUMERIC
     * @see #EXTRA_MANUAL
     * @see #EXTRA_VOICE_RADIO_TECH
     * @see #EXTRA_DATA_RADIO_TECH
     * @see #EXTRA_CSS_INDICATOR
     * @see #EXTRA_NETWORK_ID
     * @see #EXTRA_SYSTEM_ID
     * @see #EXTRA_CDMA_ROAMING_INDICATOR
     * @see #EXTRA_CDMA_DEFAULT_ROAMING_INDICATOR
     * @see #EXTRA_EMERGENCY_ONLY
     * @see #EXTRA_IS_DATA_ROAMING_FROM_REGISTRATION
     * @see #EXTRA_IS_USING_CARRIER_AGGREGATION
     * @see #EXTRA_LTE_EARFCN_RSRP_BOOST
     *
     * <p class="note">
     * Requires the READ_PHONE_STATE permission.
     *
     * <p class="note">This is a protected intent that can only be sent by the system.
     * @hide
     * @removed
     */
    @Deprecated
    
    
    public static final String ACTION_SERVICE_STATE = "android.intent.action.SERVICE_STATE";

       @Deprecated
    
    public static final String EXTRA_VOICE_REG_STATE = "voiceRegState";

       @Deprecated
    
    public static final String EXTRA_DATA_REG_STATE = "dataRegState";

       @Deprecated
    
    public static final String EXTRA_VOICE_ROAMING_TYPE = "voiceRoamingType";

       @Deprecated
    
    public static final String EXTRA_DATA_ROAMING_TYPE = "dataRoamingType";

       @Deprecated
    
    public static final String EXTRA_OPERATOR_ALPHA_LONG = "operator-alpha-long";

       @Deprecated
    
    public static final String EXTRA_OPERATOR_ALPHA_SHORT = "operator-alpha-short";

       @Deprecated
    
    public static final String EXTRA_OPERATOR_NUMERIC = "operator-numeric";

       @Deprecated
    
    public static final String EXTRA_DATA_OPERATOR_ALPHA_LONG = "data-operator-alpha-long";

       @Deprecated
    
    public static final String EXTRA_DATA_OPERATOR_ALPHA_SHORT = "data-operator-alpha-short";

       @Deprecated
    
    public static final String EXTRA_DATA_OPERATOR_NUMERIC = "data-operator-numeric";

       @Deprecated
    
    public static final String EXTRA_MANUAL = "manual";

       @Deprecated
    
    public static final String EXTRA_VOICE_RADIO_TECH = "radioTechnology";

       @Deprecated
    
    public static final String EXTRA_DATA_RADIO_TECH = "dataRadioTechnology";

       @Deprecated
    
    public static final String EXTRA_CSS_INDICATOR = "cssIndicator";

       @Deprecated
    
    public static final String EXTRA_NETWORK_ID = "networkId";

       @Deprecated
    
    public static final String EXTRA_SYSTEM_ID = "systemId";

       @Deprecated
    
    public static final String EXTRA_CDMA_ROAMING_INDICATOR = "cdmaRoamingIndicator";

       @Deprecated
    
    public static final String EXTRA_CDMA_DEFAULT_ROAMING_INDICATOR = "cdmaDefaultRoamingIndicator";

       @Deprecated
    
    public static final String EXTRA_EMERGENCY_ONLY = "emergencyOnly";

       @Deprecated
    
    public static final String EXTRA_IS_DATA_ROAMING_FROM_REGISTRATION =
            "isDataRoamingFromRegistration";

       @Deprecated
    
    public static final String EXTRA_IS_USING_CARRIER_AGGREGATION = "isUsingCarrierAggregation";

       @Deprecated
    
    public static final String EXTRA_LTE_EARFCN_RSRP_BOOST = "LteEarfcnRsrpBoost";

       public static final String EXTRA_PROCESS_TEXT = "android.intent.extra.PROCESS_TEXT";
       public static final String EXTRA_PROCESS_TEXT_READONLY =
            "android.intent.extra.PROCESS_TEXT_READONLY";

       
    public static final String ACTION_THERMAL_EVENT = "android.intent.action.THERMAL_EVENT";

       public static final String EXTRA_THERMAL_STATE = "android.intent.extra.THERMAL_STATE";

       public static final int EXTRA_THERMAL_STATE_NORMAL = 0;

       public static final int EXTRA_THERMAL_STATE_WARNING = 1;

       public static final int EXTRA_THERMAL_STATE_EXCEEDED = 2;


    // ---------------------------------------------------------------------
    // ---------------------------------------------------------------------
    // Standard intent categories (see addCategory()).

       
    public static final String CATEGORY_DEFAULT = "android.intent.category.DEFAULT";
       
    public static final String CATEGORY_BROWSABLE = "android.intent.category.BROWSABLE";
       
    public static final String CATEGORY_VOICE = "android.intent.category.VOICE";
       
    public static final String CATEGORY_ALTERNATIVE = "android.intent.category.ALTERNATIVE";
       
    public static final String CATEGORY_SELECTED_ALTERNATIVE = "android.intent.category.SELECTED_ALTERNATIVE";
       
    public static final String CATEGORY_TAB = "android.intent.category.TAB";
       
    public static final String CATEGORY_LAUNCHER = "android.intent.category.LAUNCHER";
       
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
       
    public static final String CATEGORY_LEANBACK_SETTINGS = "android.intent.category.LEANBACK_SETTINGS";
       
    public static final String CATEGORY_INFO = "android.intent.category.INFO";
       
    public static final String CATEGORY_HOME = "android.intent.category.HOME";
       
    public static final String CATEGORY_HOME_MAIN = "android.intent.category.HOME_MAIN";
       
    public static final String CATEGORY_SETUP_WIZARD = "android.intent.category.SETUP_WIZARD";
    /**
     * This is the home activity, that is the activity that serves as the launcher app
     * from there the user can start other apps. Often components with lower/higher
     * priority intent filters handle the home intent, for example SetupWizard, to
     * setup the device and we need to be able to distinguish the home app from these
     * setup helpers.
     * @hide
     */
    
    public static final String CATEGORY_LAUNCHER_APP = "android.intent.category.LAUNCHER_APP";
       
    public static final String CATEGORY_PREFERENCE = "android.intent.category.PREFERENCE";
       
    public static final String CATEGORY_DEVELOPMENT_PREFERENCE = "android.intent.category.DEVELOPMENT_PREFERENCE";
       
    public static final String CATEGORY_EMBED = "android.intent.category.EMBED";
       
    public static final String CATEGORY_APP_MARKET = "android.intent.category.APP_MARKET";
       
    public static final String CATEGORY_MONKEY = "android.intent.category.MONKEY";
       public static final String CATEGORY_TEST = "android.intent.category.TEST";
       public static final String CATEGORY_UNIT_TEST = "android.intent.category.UNIT_TEST";
       public static final String CATEGORY_SAMPLE_CODE = "android.intent.category.SAMPLE_CODE";

       
    public static final String CATEGORY_OPENABLE = "android.intent.category.OPENABLE";

       
    public static final String CATEGORY_TYPED_OPENABLE  =
            "android.intent.category.TYPED_OPENABLE";

       public static final String CATEGORY_FRAMEWORK_INSTRUMENTATION_TEST =
            "android.intent.category.FRAMEWORK_INSTRUMENTATION_TEST";
       
    public static final String CATEGORY_CAR_DOCK = "android.intent.category.CAR_DOCK";
       
    public static final String CATEGORY_DESK_DOCK = "android.intent.category.DESK_DOCK";
       
    public static final String CATEGORY_LE_DESK_DOCK = "android.intent.category.LE_DESK_DOCK";

       
    public static final String CATEGORY_HE_DESK_DOCK = "android.intent.category.HE_DESK_DOCK";

       
    public static final String CATEGORY_CAR_MODE = "android.intent.category.CAR_MODE";

       
    public static final String CATEGORY_VR_HOME = "android.intent.category.VR_HOME";
    // ---------------------------------------------------------------------
    // ---------------------------------------------------------------------
    // Application launch intent categories (see addCategory()).

    /**
     * Used with {@link #ACTION_MAIN} to launch the browser application.
     * The activity should be able to browse the Internet.
     * <p>NOTE: This should not be used as the primary key of an Intent,
     * since it will not result in the app launching with the correct
     * action and category.  Instead, use this with
     * {@link #makeMainSelectorActivity(String, String)} to generate a main
     * Intent with this category in the selector.</p>
     */
    
    public static final String CATEGORY_APP_BROWSER = "android.intent.category.APP_BROWSER";

    /**
     * Used with {@link #ACTION_MAIN} to launch the calculator application.
     * The activity should be able to perform standard arithmetic operations.
     * <p>NOTE: This should not be used as the primary key of an Intent,
     * since it will not result in the app launching with the correct
     * action and category.  Instead, use this with
     * {@link #makeMainSelectorActivity(String, String)} to generate a main
     * Intent with this category in the selector.</p>
     */
    
    public static final String CATEGORY_APP_CALCULATOR = "android.intent.category.APP_CALCULATOR";

    /**
     * Used with {@link #ACTION_MAIN} to launch the calendar application.
     * The activity should be able to view and manipulate calendar entries.
     * <p>NOTE: This should not be used as the primary key of an Intent,
     * since it will not result in the app launching with the correct
     * action and category.  Instead, use this with
     * {@link #makeMainSelectorActivity(String, String)} to generate a main
     * Intent with this category in the selector.</p>
     */
    
    public static final String CATEGORY_APP_CALENDAR = "android.intent.category.APP_CALENDAR";

    /**
     * Used with {@link #ACTION_MAIN} to launch the contacts application.
     * The activity should be able to view and manipulate address book entries.
     * <p>NOTE: This should not be used as the primary key of an Intent,
     * since it will not result in the app launching with the correct
     * action and category.  Instead, use this with
     * {@link #makeMainSelectorActivity(String, String)} to generate a main
     * Intent with this category in the selector.</p>
     */
    
    public static final String CATEGORY_APP_CONTACTS = "android.intent.category.APP_CONTACTS";

    /**
     * Used with {@link #ACTION_MAIN} to launch the email application.
     * The activity should be able to send and receive email.
     * <p>NOTE: This should not be used as the primary key of an Intent,
     * since it will not result in the app launching with the correct
     * action and category.  Instead, use this with
     * {@link #makeMainSelectorActivity(String, String)} to generate a main
     * Intent with this category in the selector.</p>
     */
    
    public static final String CATEGORY_APP_EMAIL = "android.intent.category.APP_EMAIL";

    /**
     * Used with {@link #ACTION_MAIN} to launch the gallery application.
     * The activity should be able to view and manipulate image and video files
     * stored on the device.
     * <p>NOTE: This should not be used as the primary key of an Intent,
     * since it will not result in the app launching with the correct
     * action and category.  Instead, use this with
     * {@link #makeMainSelectorActivity(String, String)} to generate a main
     * Intent with this category in the selector.</p>
     */
    
    public static final String CATEGORY_APP_GALLERY = "android.intent.category.APP_GALLERY";

    /**
     * Used with {@link #ACTION_MAIN} to launch the maps application.
     * The activity should be able to show the user's current location and surroundings.
     * <p>NOTE: This should not be used as the primary key of an Intent,
     * since it will not result in the app launching with the correct
     * action and category.  Instead, use this with
     * {@link #makeMainSelectorActivity(String, String)} to generate a main
     * Intent with this category in the selector.</p>
     */
    
    public static final String CATEGORY_APP_MAPS = "android.intent.category.APP_MAPS";

    /**
     * Used with {@link #ACTION_MAIN} to launch the messaging application.
     * The activity should be able to send and receive text messages.
     * <p>NOTE: This should not be used as the primary key of an Intent,
     * since it will not result in the app launching with the correct
     * action and category.  Instead, use this with
     * {@link #makeMainSelectorActivity(String, String)} to generate a main
     * Intent with this category in the selector.</p>
     */
    
    public static final String CATEGORY_APP_MESSAGING = "android.intent.category.APP_MESSAGING";

    /**
     * Used with {@link #ACTION_MAIN} to launch the music application.
     * The activity should be able to play, browse, or manipulate music files
     * stored on the device.
     * <p>NOTE: This should not be used as the primary key of an Intent,
     * since it will not result in the app launching with the correct
     * action and category.  Instead, use this with
     * {@link #makeMainSelectorActivity(String, String)} to generate a main
     * Intent with this category in the selector.</p>
     */
    
    public static final String CATEGORY_APP_MUSIC = "android.intent.category.APP_MUSIC";

    // ---------------------------------------------------------------------
    // ---------------------------------------------------------------------
    // Standard extra data keys.

       public static final String EXTRA_TEMPLATE = "android.intent.extra.TEMPLATE";

       public static final String EXTRA_TEXT = "android.intent.extra.TEXT";

    /**
     * A constant String that is associated with the Intent, used with
     * {@link #ACTION_SEND} to supply an alternative to {@link #EXTRA_TEXT}
     * as HTML formatted text.  Note that you <em>must</em> also supply
     * {@link #EXTRA_TEXT}.
     */
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";

       public static final String EXTRA_STREAM = "android.intent.extra.STREAM";

       public static final String EXTRA_EMAIL       = "android.intent.extra.EMAIL";

       public static final String EXTRA_CC       = "android.intent.extra.CC";

       public static final String EXTRA_BCC      = "android.intent.extra.BCC";

       public static final String EXTRA_SUBJECT  = "android.intent.extra.SUBJECT";

       public static final String EXTRA_INTENT = "android.intent.extra.INTENT";

       public static final String EXTRA_USER_ID = "android.intent.extra.USER_ID";

       public static final String EXTRA_TASK_ID = "android.intent.extra.TASK_ID";

    /**
     * An Intent[] describing additional, alternate choices you would like shown with
     * {@link #ACTION_CHOOSER}.
     *
     * <p>An app may be capable of providing several different payload types to complete a
     * user's intended action. For example, an app invoking {@link #ACTION_SEND} to share photos
     * with another app may use EXTRA_ALTERNATE_INTENTS to have the chooser transparently offer
     * several different supported sending mechanisms for sharing, such as the actual "image/*"
     * photo data or a hosted link where the photos can be viewed.</p>
     *
     * <p>The intent present in {@link #EXTRA_INTENT} will be treated as the
     * first/primary/preferred intent in the set. Additional intents specified in
     * this extra are ordered; by default intents that appear earlier in the array will be
     * preferred over intents that appear later in the array as matches for the same
     * target component. To alter this preference, a calling app may also supply
     * {@link #EXTRA_CHOOSER_REFINEMENT_INTENT_SENDER}.</p>
     */
    public static final String EXTRA_ALTERNATE_INTENTS = "android.intent.extra.ALTERNATE_INTENTS";

    /**
     * A {@link ComponentName ComponentName[]} describing components that should be filtered out
     * and omitted from a list of components presented to the user.
     *
     * <p>When used with {@link #ACTION_CHOOSER}, the chooser will omit any of the components
     * in this array if it otherwise would have shown them. Useful for omitting specific targets
     * from your own package or other apps from your organization if the idea of sending to those
     * targets would be redundant with other app functionality. Filtered components will not
     * be able to present targets from an associated <code>ChooserTargetService</code>.</p>
     */
    public static final String EXTRA_EXCLUDE_COMPONENTS
            = "android.intent.extra.EXCLUDE_COMPONENTS";
    public static final String EXTRA_CHOOSER_TARGETS = "android.intent.extra.CHOOSER_TARGETS";
    public static final String EXTRA_CHOOSER_REFINEMENT_INTENT_SENDER
            = "android.intent.extra.CHOOSER_REFINEMENT_INTENT_SENDER";

    /**
     * An {@code ArrayList} of {@code String} annotations describing content for
     * {@link #ACTION_CHOOSER}.
     *
     * <p>If {@link #EXTRA_CONTENT_ANNOTATIONS} is present in an intent used to start a
     * {@link #ACTION_CHOOSER} activity, the first three annotations will be used to rank apps.</p>
     *
     * <p>Annotations should describe the major components or topics of the content. It is up to
     * apps initiating {@link #ACTION_CHOOSER} to learn and add annotations. Annotations should be
     * learned in advance, e.g., when creating or saving content, to avoid increasing latency to
     * start {@link #ACTION_CHOOSER}. Names of customized annotations should not contain the colon
     * character. Performance on customized annotations can suffer, if they are rarely used for
     * {@link #ACTION_CHOOSER} in the past 14 days. Therefore, it is recommended to use the
     * following annotations when applicable.</p>
     * <ul>
     *     <li>"product" represents that the topic of the content is mainly about products, e.g.,
     *     health & beauty, and office supplies.</li>
     *     <li>"emotion" represents that the topic of the content is mainly about emotions, e.g.,
     *     happy, and sad.</li>
     *     <li>"person" represents that the topic of the content is mainly about persons, e.g.,
     *     face, finger, standing, and walking.</li>
     *     <li>"child" represents that the topic of the content is mainly about children, e.g.,
     *     child, and baby.</li>
     *     <li>"selfie" represents that the topic of the content is mainly about selfies.</li>
     *     <li>"crowd" represents that the topic of the content is mainly about crowds.</li>
     *     <li>"party" represents that the topic of the content is mainly about parties.</li>
     *     <li>"animal" represent that the topic of the content is mainly about animals.</li>
     *     <li>"plant" represents that the topic of the content is mainly about plants, e.g.,
     *     flowers.</li>
     *     <li>"vacation" represents that the topic of the content is mainly about vacations.</li>
     *     <li>"fashion" represents that the topic of the content is mainly about fashion, e.g.
     *     sunglasses, jewelry, handbags and clothing.</li>
     *     <li>"material" represents that the topic of the content is mainly about materials, e.g.,
     *     paper, and silk.</li>
     *     <li>"vehicle" represents that the topic of the content is mainly about vehicles, like
     *     cars, and boats.</li>
     *     <li>"document" represents that the topic of the content is mainly about documents, e.g.
     *     posters.</li>
     *     <li>"design" represents that the topic of the content is mainly about design, e.g. arts
     *     and designs of houses.</li>
     *     <li>"holiday" represents that the topic of the content is mainly about holidays, e.g.,
     *     Christmas and Thanksgiving.</li>
     * </ul>
     */
    public static final String EXTRA_CONTENT_ANNOTATIONS
            = "android.intent.extra.CONTENT_ANNOTATIONS";

    public static final String EXTRA_RESULT_RECEIVER
            = "android.intent.extra.RESULT_RECEIVER";

       public static final String EXTRA_TITLE = "android.intent.extra.TITLE";

       public static final String EXTRA_INITIAL_INTENTS = "android.intent.extra.INITIAL_INTENTS";

       public static final String EXTRA_EPHEMERAL_SUCCESS = "android.intent.extra.EPHEMERAL_SUCCESS";

       public static final String EXTRA_EPHEMERAL_FAILURE = "android.intent.extra.EPHEMERAL_FAILURE";

       public static final String EXTRA_EPHEMERAL_HOSTNAME = "android.intent.extra.EPHEMERAL_HOSTNAME";

       public static final String EXTRA_EPHEMERAL_TOKEN = "android.intent.extra.EPHEMERAL_TOKEN";

       public static final String EXTRA_VERSION_CODE = "android.intent.extra.VERSION_CODE";

       public static final String EXTRA_CALLING_PACKAGE
            = "android.intent.extra.CALLING_PACKAGE";

       public static final String EXTRA_VERIFICATION_BUNDLE
            = "android.intent.extra.VERIFICATION_BUNDLE";

    /**
     * A Bundle forming a mapping of potential target package names to different extras Bundles
     * to add to the default intent extras in {@link #EXTRA_INTENT} when used with
     * {@link #ACTION_CHOOSER}. Each key should be a package name. The package need not
     * be currently installed on the device.
     *
     * <p>An application may choose to provide alternate extras for the case where a user
     * selects an activity from a predetermined set of target packages. If the activity
     * the user selects from the chooser belongs to a package with its package name as
     * a key in this bundle, the corresponding extras for that package will be merged with
     * the extras already present in the intent at {@link #EXTRA_INTENT}. If a replacement
     * extra has the same key as an extra already present in the intent it will overwrite
     * the extra from the intent.</p>
     *
     * <p><em>Examples:</em>
     * <ul>
     *     <li>An application may offer different {@link #EXTRA_TEXT} to an application
     *     when sharing with it via {@link #ACTION_SEND}, augmenting a link with additional query
     *     parameters for that target.</li>
     *     <li>An application may offer additional metadata for known targets of a given intent
     *     to pass along information only relevant to that target such as account or content
     *     identifiers already known to that application.</li>
     * </ul></p>
     */
    public static final String EXTRA_REPLACEMENT_EXTRAS =
            "android.intent.extra.REPLACEMENT_EXTRAS";

    public static final String EXTRA_CHOSEN_COMPONENT_INTENT_SENDER =
            "android.intent.extra.CHOSEN_COMPONENT_INTENT_SENDER";

       public static final String EXTRA_CHOSEN_COMPONENT = "android.intent.extra.CHOSEN_COMPONENT";

       public static final String EXTRA_KEY_EVENT = "android.intent.extra.KEY_EVENT";

       public static final String EXTRA_KEY_CONFIRM = "android.intent.extra.KEY_CONFIRM";

       public static final String EXTRA_USER_REQUESTED_SHUTDOWN =
            "android.intent.extra.USER_REQUESTED_SHUTDOWN";

       public static final String EXTRA_DONT_KILL_APP = "android.intent.extra.DONT_KILL_APP";

       public static final String EXTRA_PHONE_NUMBER = "android.intent.extra.PHONE_NUMBER";

       public static final String EXTRA_UID = "android.intent.extra.UID";

    public static final String EXTRA_PACKAGES = "android.intent.extra.PACKAGES";

       public static final String EXTRA_DATA_REMOVED = "android.intent.extra.DATA_REMOVED";

       public static final String EXTRA_REMOVED_FOR_ALL_USERS
            = "android.intent.extra.REMOVED_FOR_ALL_USERS";

       public static final String EXTRA_REPLACING = "android.intent.extra.REPLACING";

       public static final String EXTRA_ALARM_COUNT = "android.intent.extra.ALARM_COUNT";

       public static final String EXTRA_DOCK_STATE = "android.intent.extra.DOCK_STATE";

       public static final int EXTRA_DOCK_STATE_UNDOCKED = 0;

       public static final int EXTRA_DOCK_STATE_DESK = 1;

       public static final int EXTRA_DOCK_STATE_CAR = 2;

       public static final int EXTRA_DOCK_STATE_LE_DESK = 3;

       public static final int EXTRA_DOCK_STATE_HE_DESK = 4;

       public static final String METADATA_DOCK_HOME = "android.dock_home";

       public static final String EXTRA_BUG_REPORT = "android.intent.extra.BUG_REPORT";

       public static final String EXTRA_REMOTE_INTENT_TOKEN =
            "android.intent.extra.remote_intent_token";

       @Deprecated public static final String EXTRA_CHANGED_COMPONENT_NAME =
            "android.intent.extra.changed_component_name";

       public static final String EXTRA_CHANGED_COMPONENT_NAME_LIST =
            "android.intent.extra.changed_component_name_list";

       public static final String EXTRA_CHANGED_PACKAGE_LIST =
            "android.intent.extra.changed_package_list";

       public static final String EXTRA_CHANGED_UID_LIST =
            "android.intent.extra.changed_uid_list";

       public static final String EXTRA_CLIENT_LABEL =
            "android.intent.extra.client_label";

       public static final String EXTRA_CLIENT_INTENT =
            "android.intent.extra.client_intent";

       public static final String EXTRA_LOCAL_ONLY =
            "android.intent.extra.LOCAL_ONLY";

       public static final String EXTRA_ALLOW_MULTIPLE =
            "android.intent.extra.ALLOW_MULTIPLE";

       public static final String EXTRA_USER_HANDLE =
            "android.intent.extra.user_handle";

       public static final String EXTRA_USER =
            "android.intent.extra.USER";

    /**
     * Extra used in the response from a BroadcastReceiver that handles
     * {@link #ACTION_GET_RESTRICTION_ENTRIES}. The type of the extra is
     * <code>ArrayList&lt;RestrictionEntry&gt;</code>.
     */
    public static final String EXTRA_RESTRICTIONS_LIST = "android.intent.extra.restrictions_list";

    /**
     * Extra sent in the intent to the BroadcastReceiver that handles
     * {@link #ACTION_GET_RESTRICTION_ENTRIES}. The type of the extra is a Bundle containing
     * the restrictions as key/value pairs.
     */
    public static final String EXTRA_RESTRICTIONS_BUNDLE =
            "android.intent.extra.restrictions_bundle";

       public static final String EXTRA_RESTRICTIONS_INTENT =
            "android.intent.extra.restrictions_intent";

    /**
     * Extra used to communicate a set of acceptable MIME types. The type of the
     * extra is {@code String[]}. Values may be a combination of concrete MIME
     * types (such as "image/png") and/or partial MIME types (such as
     * "audio/*").
     *
     * @see #ACTION_GET_CONTENT
     * @see #ACTION_OPEN_DOCUMENT
     */
    public static final String EXTRA_MIME_TYPES = "android.intent.extra.MIME_TYPES";

       public static final String EXTRA_SHUTDOWN_USERSPACE_ONLY
            = "android.intent.extra.SHUTDOWN_USERSPACE_ONLY";

       public static final String EXTRA_TIME_PREF_24_HOUR_FORMAT =
            "android.intent.extra.TIME_PREF_24_HOUR_FORMAT";
       public static final int EXTRA_TIME_PREF_VALUE_USE_12_HOUR = 0;
       public static final int EXTRA_TIME_PREF_VALUE_USE_24_HOUR = 1;
       public static final int EXTRA_TIME_PREF_VALUE_USE_LOCALE_DEFAULT = 2;

       public static final String EXTRA_REASON = "android.intent.extra.REASON";

       public static final String EXTRA_WIPE_EXTERNAL_STORAGE = "android.intent.extra.WIPE_EXTERNAL_STORAGE";

       public static final String EXTRA_WIPE_ESIMS = "com.android.internal.intent.extra.WIPE_ESIMS";

       public static final String EXTRA_SIM_ACTIVATION_RESPONSE =
            "android.intent.extra.SIM_ACTIVATION_RESPONSE";

       public static final String EXTRA_INDEX = "android.intent.extra.INDEX";

       @Deprecated
    public static final String EXTRA_QUICK_VIEW_ADVANCED =
            "android.intent.extra.QUICK_VIEW_ADVANCED";

       public static final String EXTRA_QUICK_VIEW_FEATURES =
            "android.intent.extra.QUICK_VIEW_FEATURES";

       public static final String EXTRA_QUIET_MODE = "android.intent.extra.QUIET_MODE";

       public static final String EXTRA_MEDIA_RESOURCE_TYPE =
            "android.intent.extra.MEDIA_RESOURCE_TYPE";

       public static final String EXTRA_AUTO_LAUNCH_SINGLE_CHOICE =
            "android.intent.extra.AUTO_LAUNCH_SINGLE_CHOICE";

       public static final int EXTRA_MEDIA_RESOURCE_TYPE_VIDEO_CODEC = 0;

       public static final int EXTRA_MEDIA_RESOURCE_TYPE_AUDIO_CODEC = 1;

    // ---------------------------------------------------------------------
    // ---------------------------------------------------------------------
    // Intent flags (see mFlags variable).

    @Retention(RetentionPolicy.SOURCE)
    public @interface GrantUriMode {}

    @Retention(RetentionPolicy.SOURCE)
    public @interface AccessUriMode {}

    /**
     * Test if given mode flags specify an access mode, which must be at least
     * read and/or write.
     *
     * @hide
     */
    public static boolean isAccessUriMode(int modeFlags) {
        return (modeFlags & (Intent.FLAG_GRANT_READ_URI_PERMISSION
                | Intent.FLAG_GRANT_WRITE_URI_PERMISSION)) != 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {}

    @Retention(RetentionPolicy.SOURCE)
    public @interface MutableFlags {}

       public static final int FLAG_GRANT_READ_URI_PERMISSION = 0x00000001;
       public static final int FLAG_GRANT_WRITE_URI_PERMISSION = 0x00000002;
       public static final int FLAG_FROM_BACKGROUND = 0x00000004;
       public static final int FLAG_DEBUG_LOG_RESOLUTION = 0x00000008;
       public static final int FLAG_EXCLUDE_STOPPED_PACKAGES = 0x00000010;
       public static final int FLAG_INCLUDE_STOPPED_PACKAGES = 0x00000020;

    public static final int FLAG_GRANT_PERSISTABLE_URI_PERMISSION = 0x00000040;

    /**
     * When combined with {@link #FLAG_GRANT_READ_URI_PERMISSION} and/or
     * {@link #FLAG_GRANT_WRITE_URI_PERMISSION}, the URI permission grant
     * applies to any URI that is a prefix match against the original granted
     * URI. (Without this flag, the URI must match exactly for access to be
     * granted.) Another URI is considered a prefix match only when scheme,
     * authority, and all path segments defined by the prefix are an exact
     * match.
     */
    public static final int FLAG_GRANT_PREFIX_URI_PERMISSION = 0x00000080;

    /**
     * Internal flag used to indicate that a system component has done their
     * homework and verified that they correctly handle packages and components
     * that come and go over time. In particular:
     * <ul>
     * <li>Apps installed on external storage, which will appear to be
     * uninstalled while the the device is ejected.
     * <li>Apps with encryption unaware components, which will appear to not
     * exist while the device is locked.
     * </ul>
     *
     * @hide
     */
    public static final int FLAG_DEBUG_TRIAGED_MISSING = 0x00000100;

       public static final int FLAG_IGNORE_EPHEMERAL = 0x00000200;

       public static final int FLAG_ACTIVITY_NO_HISTORY = 0x40000000;
       public static final int FLAG_ACTIVITY_SINGLE_TOP = 0x20000000;
    /**
     * If set, this activity will become the start of a new task on this
     * history stack.  A task (from the activity that started it to the
     * next task activity) defines an atomic group of activities that the
     * user can move to.  Tasks can be moved to the foreground and background;
     * all of the activities inside of a particular task always remain in
     * the same order.  See
     * <a href="{@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html">Tasks and Back
     * Stack</a> for more information about tasks.
     *
     * <p>This flag is generally used by activities that want
     * to present a "launcher" style behavior: they give the user a list of
     * separate things that can be done, which otherwise run completely
     * independently of the activity launching them.
     *
     * <p>When using this flag, if a task is already running for the activity
     * you are now starting, then a new activity will not be started; instead,
     * the current task will simply be brought to the front of the screen with
     * the state it was last in.  See {@link #FLAG_ACTIVITY_MULTIPLE_TASK} for a flag
     * to disable this behavior.
     *
     * <p>This flag can not be used when the caller is requesting a result from
     * the activity being launched.
     */
    public static final int FLAG_ACTIVITY_NEW_TASK = 0x10000000;
    /**
     * This flag is used to create a new task and launch an activity into it.
     * This flag is always paired with either {@link #FLAG_ACTIVITY_NEW_DOCUMENT}
     * or {@link #FLAG_ACTIVITY_NEW_TASK}. In both cases these flags alone would
     * search through existing tasks for ones matching this Intent. Only if no such
     * task is found would a new task be created. When paired with
     * FLAG_ACTIVITY_MULTIPLE_TASK both of these behaviors are modified to skip
     * the search for a matching task and unconditionally start a new task.
     *
     * <strong>When used with {@link #FLAG_ACTIVITY_NEW_TASK} do not use this
     * flag unless you are implementing your own
     * top-level application launcher.</strong>  Used in conjunction with
     * {@link #FLAG_ACTIVITY_NEW_TASK} to disable the
     * behavior of bringing an existing task to the foreground.  When set,
     * a new task is <em>always</em> started to host the Activity for the
     * Intent, regardless of whether there is already an existing task running
     * the same thing.
     *
     * <p><strong>Because the default system does not include graphical task management,
     * you should not use this flag unless you provide some way for a user to
     * return back to the tasks you have launched.</strong>
     *
     * See {@link #FLAG_ACTIVITY_NEW_DOCUMENT} for details of this flag's use for
     * creating new document tasks.
     *
     * <p>This flag is ignored if one of {@link #FLAG_ACTIVITY_NEW_TASK} or
     * {@link #FLAG_ACTIVITY_NEW_DOCUMENT} is not also set.
     *
     * <p>See
     * <a href="{@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html">Tasks and Back
     * Stack</a> for more information about tasks.
     *
     * @see #FLAG_ACTIVITY_NEW_DOCUMENT
     * @see #FLAG_ACTIVITY_NEW_TASK
     */
    public static final int FLAG_ACTIVITY_MULTIPLE_TASK = 0x08000000;
    /**
     * If set, and the activity being launched is already running in the
     * current task, then instead of launching a new instance of that activity,
     * all of the other activities on top of it will be closed and this Intent
     * will be delivered to the (now on top) old activity as a new Intent.
     *
     * <p>For example, consider a task consisting of the activities: A, B, C, D.
     * If D calls startActivity() with an Intent that resolves to the component
     * of activity B, then C and D will be finished and B receive the given
     * Intent, resulting in the stack now being: A, B.
     *
     * <p>The currently running instance of activity B in the above example will
     * either receive the new intent you are starting here in its
     * onNewIntent() method, or be itself finished and restarted with the
     * new intent.  If it has declared its launch mode to be "multiple" (the
     * default) and you have not set {@link #FLAG_ACTIVITY_SINGLE_TOP} in
     * the same intent, then it will be finished and re-created; for all other
     * launch modes or if {@link #FLAG_ACTIVITY_SINGLE_TOP} is set then this
     * Intent will be delivered to the current instance's onNewIntent().
     *
     * <p>This launch mode can also be used to good effect in conjunction with
     * {@link #FLAG_ACTIVITY_NEW_TASK}: if used to start the root activity
     * of a task, it will bring any currently running instance of that task
     * to the foreground, and then clear it to its root state.  This is
     * especially useful, for example, when launching an activity from the
     * notification manager.
     *
     * <p>See
     * <a href="{@docRoot}guide/topics/fundamentals/tasks-and-back-stack.html">Tasks and Back
     * Stack</a> for more information about tasks.
     */
    
    public static final int FLAG_ACTIVITY_CLEAR_TOP = 0x04000000;
       public static final int FLAG_ACTIVITY_FORWARD_RESULT = 0x02000000;
       public static final int FLAG_ACTIVITY_PREVIOUS_IS_TOP = 0x01000000;
       public static final int FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS = 0x00800000;
       public static final int FLAG_ACTIVITY_BROUGHT_TO_FRONT = 0x00400000;
       public static final int FLAG_ACTIVITY_RESET_TASK_IF_NEEDED = 0x00200000;
       public static final int FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY = 0x00100000;
    
       public static final int FLAG_ACTIVITY_NEW_DOCUMENT = FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
       public static final int FLAG_ACTIVITY_NO_USER_ACTION = 0x00040000;
       public static final int FLAG_ACTIVITY_REORDER_TO_FRONT = 0X00020000;
       public static final int FLAG_ACTIVITY_NO_ANIMATION = 0X00010000;
       public static final int FLAG_ACTIVITY_CLEAR_TASK = 0X00008000;
       public static final int FLAG_ACTIVITY_TASK_ON_HOME = 0X00004000;
       public static final int FLAG_ACTIVITY_RETAIN_IN_RECENTS = 0x00002000;

       public static final int FLAG_ACTIVITY_LAUNCH_ADJACENT = 0x00001000;

       public static final int FLAG_RECEIVER_REGISTERED_ONLY = 0x40000000;
       public static final int FLAG_RECEIVER_REPLACE_PENDING = 0x20000000;
       public static final int FLAG_RECEIVER_FOREGROUND = 0x10000000;
       public static final int FLAG_RECEIVER_NO_ABORT = 0x08000000;
    /**
     * If set, when sending a broadcast <i>before boot has completed</i> only
     * registered receivers will be called -- no BroadcastReceiver components
     * will be launched.  Sticky intent state will be recorded properly even
     * if no receivers wind up being called.  If {@link #FLAG_RECEIVER_REGISTERED_ONLY}
     * is specified in the broadcast intent, this flag is unnecessary.
     *
     * <p>This flag is only for use by system sevices as a convenience to
     * avoid having to implement a more complex mechanism around detection
     * of boot completion.
     *
     * @hide
     */
    public static final int FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT = 0x04000000;
       public static final int FLAG_RECEIVER_BOOT_UPGRADE = 0x02000000;
       public static final int FLAG_RECEIVER_INCLUDE_BACKGROUND = 0x01000000;
       public static final int FLAG_RECEIVER_EXCLUDE_BACKGROUND = 0x00800000;
       public static final int FLAG_RECEIVER_FROM_SHELL = 0x00400000;

    /**
     * If set, the broadcast will be visible to receivers in Instant Apps. By default Instant Apps
     * will not receive broadcasts.
     *
     * <em>This flag has no effect when used by an Instant App.</em>
     */
    public static final int FLAG_RECEIVER_VISIBLE_TO_INSTANT_APPS = 0x00200000;

       public static final int IMMUTABLE_FLAGS = FLAG_GRANT_READ_URI_PERMISSION
            | FLAG_GRANT_WRITE_URI_PERMISSION | FLAG_GRANT_PERSISTABLE_URI_PERMISSION
            | FLAG_GRANT_PREFIX_URI_PERMISSION;

    // ---------------------------------------------------------------------
    // ---------------------------------------------------------------------
    // toUri() and parseUri() options.

    @Retention(RetentionPolicy.SOURCE)
    public @interface UriFlags {}

       public static final int URI_INTENT_SCHEME = 1<<0;

    /**
     * Flag for use with {@link #toUri} and {@link #parseUri}: the URI string
     * always has the "android-app:" scheme.  This is a variation of
     * {@link #URI_INTENT_SCHEME} whose format is simpler for the case of an
     * http/https URI being delivered to a specific package name.  The format
     * is:
     *
     * <pre class="prettyprint">
     * android-app://{package_id}[/{scheme}[/{host}[/{path}]]][#Intent;{...}]</pre>
     *
     * <p>In this scheme, only the <code>package_id</code> is required.  If you include a host,
     * you must also include a scheme; including a path also requires both a host and a scheme.
     * The final #Intent; fragment can be used without a scheme, host, or path.
     * Note that this can not be
     * used with intents that have a {@link #setSelector}, since the base intent
     * will always have an explicit package name.</p>
     *
     * <p>Some examples of how this scheme maps to Intent objects:</p>
     * <table border="2" width="85%" align="center" frame="hsides" rules="rows">
     *     <colgroup align="left" />
     *     <colgroup align="left" />
     *     <thead>
     *     <tr><th>URI</th> <th>Intent</th></tr>
     *     </thead>
     *
     *     <tbody>
     *     <tr><td><code>android-app://com.example.app</code></td>
     *         <td><table style="margin:0;border:0;cellpadding:0;cellspacing:0">
     *             <tr><td>Action: </td><td>{@link #ACTION_MAIN}</td></tr>
     *             <tr><td>Package: </td><td><code>com.example.app</code></td></tr>
     *         </table></td>
     *     </tr>
     *     <tr><td><code>android-app://com.example.app/http/example.com</code></td>
     *         <td><table style="margin:0;border:0;cellpadding:0;cellspacing:0">
     *             <tr><td>Action: </td><td>{@link #ACTION_VIEW}</td></tr>
     *             <tr><td>Data: </td><td><code>http://example.com/</code></td></tr>
     *             <tr><td>Package: </td><td><code>com.example.app</code></td></tr>
     *         </table></td>
     *     </tr>
     *     <tr><td><code>android-app://com.example.app/http/example.com/foo?1234</code></td>
     *         <td><table style="margin:0;border:0;cellpadding:0;cellspacing:0">
     *             <tr><td>Action: </td><td>{@link #ACTION_VIEW}</td></tr>
     *             <tr><td>Data: </td><td><code>http://example.com/foo?1234</code></td></tr>
     *             <tr><td>Package: </td><td><code>com.example.app</code></td></tr>
     *         </table></td>
     *     </tr>
     *     <tr><td><code>android-app://com.example.app/<br />#Intent;action=com.example.MY_ACTION;end</code></td>
     *         <td><table style="margin:0;border:0;cellpadding:0;cellspacing:0">
     *             <tr><td>Action: </td><td><code>com.example.MY_ACTION</code></td></tr>
     *             <tr><td>Package: </td><td><code>com.example.app</code></td></tr>
     *         </table></td>
     *     </tr>
     *     <tr><td><code>android-app://com.example.app/http/example.com/foo?1234<br />#Intent;action=com.example.MY_ACTION;end</code></td>
     *         <td><table style="margin:0;border:0;cellpadding:0;cellspacing:0">
     *             <tr><td>Action: </td><td><code>com.example.MY_ACTION</code></td></tr>
     *             <tr><td>Data: </td><td><code>http://example.com/foo?1234</code></td></tr>
     *             <tr><td>Package: </td><td><code>com.example.app</code></td></tr>
     *         </table></td>
     *     </tr>
     *     <tr><td><code>android-app://com.example.app/<br />#Intent;action=com.example.MY_ACTION;<br />i.some_int=100;S.some_str=hello;end</code></td>
     *         <td><table border="" style="margin:0" >
     *             <tr><td>Action: </td><td><code>com.example.MY_ACTION</code></td></tr>
     *             <tr><td>Package: </td><td><code>com.example.app</code></td></tr>
     *             <tr><td>Extras: </td><td><code>some_int=(int)100<br />some_str=(String)hello</code></td></tr>
     *         </table></td>
     *     </tr>
     *     </tbody>
     * </table>
     */
    public static final int URI_ANDROID_APP_SCHEME = 1<<1;

    /**
     * Flag for use with {@link #toUri} and {@link #parseUri}: allow parsing
     * of unsafe information.  In particular, the flags {@link #FLAG_GRANT_READ_URI_PERMISSION},
     * {@link #FLAG_GRANT_WRITE_URI_PERMISSION}, {@link #FLAG_GRANT_PERSISTABLE_URI_PERMISSION},
     * and {@link #FLAG_GRANT_PREFIX_URI_PERMISSION} flags can not be set, so that the
     * generated Intent can not cause unexpected data access to happen.
     *
     * <p>If you do not trust the source of the URI being parsed, you should still do further
     * processing to protect yourself from it.  In particular, when using it to start an
     * activity you should usually add in {@link #CATEGORY_BROWSABLE} to limit the activities
     * that can handle it.</p>
     */
    public static final int URI_ALLOW_UNSAFE = 1<<2;

    // ---------------------------------------------------------------------

    private String mAction;
    private String mType;
    private String mPackage;
    private ComponentName mComponent;
    private int mFlags;
    private Intent mSelector;
    private int mContentUserHint = 0;
       private String mLaunchToken;

    // ---------------------------------------------------------------------

    private static final int COPY_MODE_ALL = 0;
    private static final int COPY_MODE_FILTER = 1;
    private static final int COPY_MODE_HISTORY = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CopyMode {}


       public Intent() {
    }

       public Intent(Intent o) {
    }

    private Intent(Intent o, @CopyMode int copyMode) {
    }

    @Override
    public Object clone() {
        return null;
    }

       public Intent cloneFilter() {
           return null;
    }

    /**
     * Create an intent with a given action.  All other fields (data, type,
     * class) are null.  Note that the action <em>must</em> be in a
     * namespace because Intents are used globally in the system -- for
     * example the system VIEW action is android.intent.action.VIEW; an
     * application's custom action would be something like
     * com.google.app.myapp.CUSTOM_ACTION.
     *
     * @param action The Intent action, such as ACTION_VIEW.
     */
    public Intent(String action) {
        setAction(action);
    }

    /**
     * Create an intent with a given action and for a given data url.  Note
     * that the action <em>must</em> be in a namespace because Intents are
     * used globally in the system -- for example the system VIEW action is
     * android.intent.action.VIEW; an application's custom action would be
     * something like com.google.app.myapp.CUSTOM_ACTION.
     *
     * <p><em>Note: scheme and host name matching in the Android framework is
     * case-sensitive, unlike the formal RFC.  As a result,
     * you should always ensure that you write your Uri with these elements
     * using lower case letters, and normalize any Uris you receive from
     * outside of Android to ensure the scheme and host is lower case.</em></p>
     *
     * @param action The Intent action, such as ACTION_VIEW.
     * @param uri The Intent data URI.
     */
    public Intent(String action, Uri uri) {
    }

       public Intent(Context packageContext, Class<?> cls) {
    }

    public Intent(String action, Uri uri,
                  Context packageContext, Class<?> cls) {
    }

    /**
     * Create an intent to launch the main (root) activity of a task.  This
     * is the Intent that is started when the application's is launched from
     * Home.  For anything else that wants to launch an application in the
     * same way, it is important that they use an Intent structured the same
     * way, and can use this function to ensure this is the case.
     *
     * <p>The returned Intent has the given Activity component as its explicit
     * component, {@link #ACTION_MAIN} as its action, and includes the
     * category {@link #CATEGORY_LAUNCHER}.  This does <em>not</em> have
     * {@link #FLAG_ACTIVITY_NEW_TASK} set, though typically you will want
     * to do that through {@link #addFlags(int)} on the returned Intent.
     *
     * @param mainActivity The main activity component that this Intent will
     * launch.
     * @return Returns a newly created Intent that can be used to launch the
     * activity as a main application entry.
     *
     * @see #setClass
     * @see #setComponent
     */
    public static Intent makeMainActivity(ComponentName mainActivity) {
        return null;
    }

    /**
     * Make an Intent for the main activity of an application, without
     * specifying a specific activity to run but giving a selector to find
     * the activity.  This results in a final Intent that is structured
     * the same as when the application is launched from
     * Home.  For anything else that wants to launch an application in the
     * same way, it is important that they use an Intent structured the same
     * way, and can use this function to ensure this is the case.
     *
     * <p>The returned Intent has {@link #ACTION_MAIN} as its action, and includes the
     * category {@link #CATEGORY_LAUNCHER}.  This does <em>not</em> have
     * {@link #FLAG_ACTIVITY_NEW_TASK} set, though typically you will want
     * to do that through {@link #addFlags(int)} on the returned Intent.
     *
     * @param selectorAction The action name of the Intent's selector.
     * @param selectorCategory The name of a category to add to the Intent's
     * selector.
     * @return Returns a newly created Intent that can be used to launch the
     * activity as a main application entry.
     *
     * @see #setSelector(Intent)
     */
    public static Intent makeMainSelectorActivity(String selectorAction,
                                                  String selectorCategory) {
        return null;
    }

       public static Intent makeRestartActivityTask(ComponentName mainActivity) {
           return null;
    }

       @Deprecated
    public static Intent getIntent(String uri) throws URISyntaxException {
           return null;
    }

       public static Intent parseUri(String uri, @UriFlags int flags) throws URISyntaxException {
           return null;
    }

    public static Intent getIntentOld(String uri) throws URISyntaxException {
        return null;
    }

    private static Intent getIntentOld(String uri, int flags) throws URISyntaxException {

        return null;
    }



       public static void printIntentArgsHelp(PrintWriter pw, String prefix) {
    }

       public  String getAction() {
           return null;
    }

       public  Uri getData() {
           return null;
    }

       public  String getDataString() {
           return null;
    }

       public  String getScheme() {
           return null;
    }

       public  String getType() {
           return null;
    }

       public  String resolveType( Context context) {
           return null;
    }



       public boolean hasCategory(String category) {
        return false;
    }

       public Set<String> getCategories() {
           return null;
    }

       public Intent getSelector() {
        return null;
    }


       public int getContentUserHint() {
        return mContentUserHint;
    }

       public String getLaunchToken() {
        return mLaunchToken;
    }

       public void setLaunchToken(String launchToken) {
        mLaunchToken = launchToken;
    }

       public void setExtrasClassLoader( ClassLoader loader) {
    }

       public boolean hasExtra(String name) {
        return false;
    }

       public boolean hasFileDescriptors() {
        return false;
    }

       public void setAllowFds(boolean allowFds) {
    }

       public void setDefusable(boolean defusable) {
    }

    public Object getExtra(String name) {
        return null;
    }

       public boolean getBooleanExtra(String name, boolean defaultValue) {
        return false;
    }

       public byte getByteExtra(String name, byte defaultValue) {
        return 0;
    }

       public short getShortExtra(String name, short defaultValue) {
        return 0;
    }

       public char getCharExtra(String name, char defaultValue) {
        return 0;
    }

       public int getIntExtra(String name, int defaultValue) {
        return 0;
    }

       public long getLongExtra(String name, long defaultValue) {
        return 0;
    }

       public float getFloatExtra(String name, float defaultValue) {
        return 0;
    }

       public double getDoubleExtra(String name, double defaultValue) {
        return 0;
    }

       public String getStringExtra(String name) {
        return null;
    }

       public CharSequence getCharSequenceExtra(String name) {
           return null;
    }


       public Serializable getSerializableExtra(String name) {
           return null;
    }

       public ArrayList<Integer> getIntegerArrayListExtra(String name) {
           return null;
    }

       public ArrayList<String> getStringArrayListExtra(String name) {
           return null;
    }

       public ArrayList<CharSequence> getCharSequenceArrayListExtra(String name) {
           return null;
    }

       public boolean[] getBooleanArrayExtra(String name) {
           return null;
    }

       public byte[] getByteArrayExtra(String name) {
           return null;
    }

       public short[] getShortArrayExtra(String name) {
           return null;
    }

       public char[] getCharArrayExtra(String name) {
           return null;
    }

       public int[] getIntArrayExtra(String name) {
           return null;
    }

       public long[] getLongArrayExtra(String name) {
        return null;
    }

       public float[] getFloatArrayExtra(String name) {
        return null;
    }

       public double[] getDoubleArrayExtra(String name) {
        return null;
    }

       public String[] getStringArrayExtra(String name) {
        return null;
    }

       public CharSequence[] getCharSequenceArrayExtra(String name) {
        return null;
    }





       public void removeUnsafeExtras() {
    }

       public boolean canStripForHistory() {
        return false;
    }

       public Intent maybeStripForHistory() {
        // TODO Scan and remove possibly heavy instances like Bitmaps from unparcelled extras?

        if (!canStripForHistory()) {
            return this;
        }
        return new Intent(this, COPY_MODE_HISTORY);
    }

       public @Flags int getFlags() {
        return 0;
    }

       public boolean isExcludingStopped() {
        return (mFlags&(FLAG_EXCLUDE_STOPPED_PACKAGES|FLAG_INCLUDE_STOPPED_PACKAGES))
                == FLAG_EXCLUDE_STOPPED_PACKAGES;
    }

       public  String getPackage() {
        return null;
    }

       public  ComponentName getComponent() {
        return null;
    }




       public Intent setAction(String action) {
        mAction = action != null ? action.intern() : null;
        return this;
    }
    public Intent setData(Uri data) {
        return this;
    }

    public Intent setDataAndNormalize(Uri data) {
        return null;
    }

    /**
     * Set an explicit MIME data type.
     *
     * <p>This is used to create intents that only specify a type and not data,
     * for example to indicate the type of data to return.
     *
     * <p>This method automatically clears any data that was
     * previously set (for example by {@link #setData}).
     *
     * <p><em>Note: MIME type matching in the Android framework is
     * case-sensitive, unlike formal RFC MIME types.  As a result,
     * you should always write your MIME types with lower case letters,
     * or use {@link #normalizeMimeType} or {@link #setTypeAndNormalize}
     * to ensure that it is converted to lower case.</em>
     *
     * @param type The MIME type of the data being handled by this intent.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #getType
     * @see #setTypeAndNormalize
     * @see #setDataAndType
     * @see #normalizeMimeType
     */
    public Intent setType(String type) {
        return this;
    }

    /**
     * Normalize and set an explicit MIME data type.
     *
     * <p>This is used to create intents that only specify a type and not data,
     * for example to indicate the type of data to return.
     *
     * <p>This method automatically clears any data that was
     * previously set (for example by {@link #setData}).
     *
     * <p>The MIME type is normalized using
     * {@link #normalizeMimeType} before it is set,
     * so really this is just a convenience method for
     * <pre>
     * setType(Intent.normalizeMimeType(type))
     * </pre>
     *
     * @param type The MIME type of the data being handled by this intent.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #getType
     * @see #setData
     * @see #normalizeMimeType
     */
    public Intent setTypeAndNormalize(String type) {
        return null;
    }

    public Intent setDataAndType(Uri data, String type) {
        return this;
    }
    public Intent setDataAndTypeAndNormalize(Uri data, String type) {
        return null;
    }

    /**
     * Add a new category to the intent.  Categories provide additional detail
     * about the action the intent performs.  When resolving an intent, only
     * activities that provide <em>all</em> of the requested categories will be
     * used.
     *
     * @param category The desired category.  This can be either one of the
     *               predefined Intent categories, or a custom category in your own
     *               namespace.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #hasCategory
     * @see #removeCategory
     */
    public Intent addCategory(String category) {
        return this;
    }

       public void removeCategory(String category) {
    }

    /**
     * Set a selector for this Intent.  This is a modification to the kinds of
     * things the Intent will match.  If the selector is set, it will be used
     * when trying to find entities that can handle the Intent, instead of the
     * main contents of the Intent.  This allows you build an Intent containing
     * a generic protocol while targeting it more specifically.
     *
     * <p>An example of where this may be used is with things like
     * {@link #CATEGORY_APP_BROWSER}.  This category allows you to build an
     * Intent that will launch the Browser application.  However, the correct
     * main entry point of an application is actually {@link #ACTION_MAIN}
     * {@link #CATEGORY_LAUNCHER} with {@link #setComponent(ComponentName)}
     * used to specify the actual Activity to launch.  If you launch the browser
     * with something different, undesired behavior may happen if the user has
     * previously or later launches it the normal way, since they do not match.
     * Instead, you can build an Intent with the MAIN action (but no ComponentName
     * yet specified) and set a selector with {@link #ACTION_MAIN} and
     * {@link #CATEGORY_APP_BROWSER} to point it specifically to the browser activity.
     *
     * <p>Setting a selector does not impact the behavior of
     * {@link #filterEquals(Intent)} and {@link #filterHashCode()}.  This is part of the
     * desired behavior of a selector -- it does not impact the base meaning
     * of the Intent, just what kinds of things will be matched against it
     * when determining who can handle it.</p>
     *
     * <p>You can not use both a selector and {@link #setPackage(String)} on
     * the same base Intent.</p>
     *
     * @param selector The desired selector Intent; set to null to not use
     * a special selector.
     */
    public void setSelector( Intent selector) {
    }


       public void prepareToLeaveUser(int userId) {
    }

       public Intent putExtra(String name, boolean value) {
        return this;
    }

       public Intent putExtra(String name, byte value) {
        return this;
    }

       public Intent putExtra(String name, char value) {
        return this;
    }

       public Intent putExtra(String name, short value) {
        return this;
    }

       public Intent putExtra(String name, int value) {
        return this;
    }

       public Intent putExtra(String name, long value) {
        return this;
    }

       public Intent putExtra(String name, float value) {
        return this;
    }

       public Intent putExtra(String name, double value) {
        return this;
    }

       public Intent putExtra(String name, String value) {
        return this;
    }

       public Intent putExtra(String name, CharSequence value) {
        return this;
    }




       public Intent putIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        return this;
    }

       public Intent putStringArrayListExtra(String name, ArrayList<String> value) {
        return this;
    }

       public Intent putCharSequenceArrayListExtra(String name,
                                                   ArrayList<CharSequence> value) {
        return this;
    }

       public Intent putExtra(String name, Serializable value) {
        return this;
    }

       public Intent putExtra(String name, boolean[] value) {
        return this;
    }

       public Intent putExtra(String name, byte[] value) {
        return this;
    }

       public Intent putExtra(String name, short[] value) {
        return this;
    }

       public Intent putExtra(String name, char[] value) {
        return this;
    }

       public Intent putExtra(String name, int[] value) {
        return this;
    }

       public Intent putExtra(String name, long[] value) {
        return this;
    }

       public Intent putExtra(String name, float[] value) {
        return this;
    }

       public Intent putExtra(String name, double[] value) {
        return this;
    }

       public Intent putExtra(String name, String[] value) {
        return this;
    }

       public Intent putExtra(String name, CharSequence[] value) {
        return this;
    }



       public Intent putExtras(Intent src) {
        return this;
    }


       public Intent replaceExtras(Intent src) {
        return this;
    }


       public void removeExtra(String name) {
    }
    public Intent setFlags(@Flags int flags) {
        return this;
    }

       public Intent addFlags(@Flags int flags) {
        return this;
    }

       public void removeFlags(@Flags int flags) {
    }

       public Intent setPackage(String packageName) {
        return this;
    }

       public Intent setComponent(ComponentName component) {
        return this;
    }

       public Intent setClassName(Context packageContext,
                                  String className) {
        return this;
    }

       public Intent setClassName(String packageName, String className) {
        return this;
    }

    /**
     * Convenience for calling {@link #setComponent(ComponentName)} with the
     * name returned by a {@link Class} object.
     *
     * @param packageContext A Context of the application package implementing
     * this class.
     * @param cls The class name to set, equivalent to
     *            <code>setClassName(context, cls.getName())</code>.
     *
     * @return Returns the same Intent object, for chaining multiple calls
     * into a single statement.
     *
     * @see #setComponent
     */
    public Intent setClass(Context packageContext, Class<?> cls) {
      return null;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FillInFlags {}

       public static final int FILL_IN_ACTION = 1<<0;

       public static final int FILL_IN_DATA = 1<<1;

       public static final int FILL_IN_CATEGORIES = 1<<2;

       public static final int FILL_IN_COMPONENT = 1<<3;

       public static final int FILL_IN_PACKAGE = 1<<4;

       public static final int FILL_IN_SOURCE_BOUNDS = 1<<5;

       public static final int FILL_IN_SELECTOR = 1<<6;

       public static final int FILL_IN_CLIP_DATA = 1<<7;

    public int fillIn(Intent other, @FillInFlags int flags) {
        return 0;
    }

       public static final class FilterComparison {
        private final Intent mIntent;
        private final int mHashCode;

        public FilterComparison(Intent intent) {
            mIntent = intent;
            mHashCode = intent.filterHashCode();
        }

               public Intent getIntent() {
            return mIntent;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof FilterComparison) {
                Intent other = ((FilterComparison)obj).mIntent;
                return mIntent.filterEquals(other);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return mHashCode;
        }
    }

    /**
     * Determine if two intents are the same for the purposes of intent
     * resolution (filtering). That is, if their action, data, type,
     * class, and categories are the same.  This does <em>not</em> compare
     * any extra data included in the intents.
     *
     * @param other The other Intent to compare against.
     *
     * @return Returns true if action, data, type, class, and categories
     *         are the same.
     */
    public boolean filterEquals(Intent other) {

        return true;
    }

       public int filterHashCode() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder(128);

        b.append("Intent { ");
        toShortString(b, true, true, true, false);
        b.append(" }");

        return b.toString();
    }

       public String toInsecureString() {
        StringBuilder b = new StringBuilder(128);

        b.append("Intent { ");
        toShortString(b, false, true, true, false);
        b.append(" }");

        return b.toString();
    }

       public String toInsecureStringWithClip() {
        StringBuilder b = new StringBuilder(128);

        b.append("Intent { ");
        toShortString(b, false, true, true, true);
        b.append(" }");

        return b.toString();
    }

       public String toShortString(boolean secure, boolean comp, boolean extras, boolean clip) {
        StringBuilder b = new StringBuilder(128);
        toShortString(b, secure, comp, extras, clip);
        return b.toString();
    }

       public void toShortString(StringBuilder b, boolean secure, boolean comp, boolean extras,
                              boolean clip) {
    }

    public String toURI() {
        return toUri(0);
    }

       public String toUri( int flags) {

        return null;
    }

    private void toUriFragment(StringBuilder uri, String scheme, String defAction,
                               String defPackage, int flags) {
    }

    private void toUriInner(StringBuilder uri, String scheme, String defAction,
                            String defPackage, int flags) {
        
    }

    public int describeContents() {
        return 0;
    }

  

    
    /**
     * Normalize a MIME data type.
     *
     * <p>A normalized MIME type has white-space trimmed,
     * content-type parameters removed, and is lower-case.
     * This aligns the type with Android best practices for
     * intent filtering.
     *
     * <p>For example, "text/plain; charset=utf-8" becomes "text/plain".
     * "text/x-vCard" becomes "text/x-vcard".
     *
     * <p>All MIME types received from outside Android (such as user input,
     * or external sources like Bluetooth, NFC, or the Internet) should
     * be normalized before they are used to create an Intent.
     *
     * @param type MIME data type to normalize
     * @return normalized MIME data type, or null if the input was null
     * @see #setType
     * @see #setTypeAndNormalize
     */
    public static  String normalizeMimeType( String type) {
        return null;
    }

       public void prepareToEnterProcess() {
      
    }

       public void fixUris(int contentUserHint) {
    }

       public boolean migrateExtraStreamToClipData() {

        return false;
    }

       public boolean isDocument() {
        return (mFlags & FLAG_ACTIVITY_NEW_DOCUMENT) == FLAG_ACTIVITY_NEW_DOCUMENT;
    }
}
