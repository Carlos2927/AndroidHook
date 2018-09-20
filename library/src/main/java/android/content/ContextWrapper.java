package android.content;

import android.graphics.drawable.Drawable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class ContextWrapper extends Context {

    public ContextWrapper(Context base) {

    }

    /**
     * Set the base context for this ContextWrapper.  All calls will then be
     * delegated to the base context.  Throws
     * IllegalStateException if a base context has already been set.
     *
     * @param base The new base context for this wrapper.
     */
    protected void attachBaseContext(Context base) {
    }

    /**
     * @return the base context as set by the constructor or setBaseContext
     */
    public Context getBaseContext() {
        return null;
    }


    public Context getApplicationContext() {
        return null;
    }




    public ClassLoader getClassLoader() {
        return null;
    }

    public String getPackageName() {
        return null;
    }




    public FileInputStream openFileInput(String name)
            throws FileNotFoundException {
        return null;
    }

    public FileOutputStream openFileOutput(String name, int mode)
            throws FileNotFoundException {
        return null;
    }


    public boolean deleteFile(String name) {
        return false;
    }


    public File getFileStreamPath(String name) {
        return null;
    }



    public String[] fileList() {
        return null;
    }


    public File getDataDir() {
        return null;
    }

    public File getFilesDir() {
        return null;
    }


    public File getNoBackupFilesDir() {
        return null;
    }


    public File getExternalFilesDir(String type) {
        return null;
    }


    public File[] getExternalFilesDirs(String type) {
        return null;
    }


    public File getObbDir() {
        return null;
    }


    public File[] getObbDirs() {
        return null;
    }


    public File getCacheDir() {
        return null;
    }


    public File getCodeCacheDir() {
        return null;
    }


    public File getExternalCacheDir() {
        return null;
    }


    public File[] getExternalCacheDirs() {
        return null;
    }


    public File[] getExternalMediaDirs() {
        return null;
    }


    public File getDir(String name, int mode) {
        return null;
    }



    public File getPreloadsFileCache() {
        return null;
    }



    public boolean moveDatabaseFrom(Context sourceContext, String name) {
        return false;
    }


    public boolean deleteDatabase(String name) {
        return false;
    }


    public File getDatabasePath(String name) {
        return null;
    }


    public String[] databaseList() {
        return null;
    }

    public Drawable getWallpaper() {
        return null;
    }

    public Drawable peekWallpaper() {
        return null;
    }

    public int getWallpaperDesiredMinimumWidth() {
        return 0;
    }

    public int getWallpaperDesiredMinimumHeight() {
        return 0;
    }



    public void setWallpaper(InputStream data) throws IOException {
    }


    public void clearWallpaper() throws IOException {

    }


    public void startActivity(Intent intent) {

    }







    public void startActivities(Intent[] intents) {

    }





    public void sendBroadcast(Intent intent) {

    }


    public void sendBroadcast(Intent intent, String receiverPermission) {

    }


    public void sendOrderedBroadcast(Intent intent,
                                     String receiverPermission) {
    }




    public void sendStickyBroadcast(Intent intent) {
    }


    public void removeStickyBroadcast(Intent intent) {
    }



    public void unregisterReceiver(BroadcastReceiver receiver) {
    }


}
