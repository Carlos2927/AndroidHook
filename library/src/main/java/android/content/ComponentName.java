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


import java.io.PrintWriter;

public final class ComponentName implements  Cloneable, Comparable<ComponentName> {

    /**
     * Create a new component identifier where the class name may be specified
     * as either absolute or relative to the containing package.
     *
     * <p>Relative package names begin with a <code>'.'</code> character. For a package
     * <code>"com.example"</code> and class name <code>".app.MyActivity"</code> this method
     * will return a ComponentName with the package <code>"com.example"</code>and class name
     * <code>"com.example.app.MyActivity"</code>. Fully qualified class names are also
     * permitted.</p>
     *
     * @param pkg the name of the package the component exists in
     * @param cls the name of the class inside of <var>pkg</var> that implements
     *            the component
     * @return the new ComponentName
     */
    public static ComponentName createRelative(String pkg, String cls) {
        return null;
    }

    /**
     * Create a new component identifier where the class name may be specified
     * as either absolute or relative to the containing package.
     *
     * <p>Relative package names begin with a <code>'.'</code> character. For a package
     * <code>"com.example"</code> and class name <code>".app.MyActivity"</code> this method
     * will return a ComponentName with the package <code>"com.example"</code>and class name
     * <code>"com.example.app.MyActivity"</code>. Fully qualified class names are also
     * permitted.</p>
     *
     * @param pkg a Context for the package implementing the component
     * @param cls the name of the class inside of <var>pkg</var> that implements
     *            the component
     * @return the new ComponentName
     */
    public static ComponentName createRelative(Context pkg, String cls) {
        return null;
    }

    /**
     * Create a new component identifier.
     *
     * @param pkg The name of the package that the component exists in.  Can
     * not be null.
     * @param cls The name of the class inside of <var>pkg</var> that
     * implements the component.  Can not be null.
     */
    public ComponentName( String pkg,  String cls) {
    }

    /**
     * Create a new component identifier from a Context and class name.
     *
     * @param pkg A Context for the package implementing the component,
     * from which the actual package name will be retrieved.
     * @param cls The name of the class inside of <var>pkg</var> that
     * implements the component.
     */
    public ComponentName( Context pkg,  String cls) {
    }

    /**
     * Create a new component identifier from a Context and Class object.
     *
     * @param pkg A Context for the package implementing the component, from
     * which the actual package name will be retrieved.
     * @param cls The Class object of the desired component, from which the
     * actual class name will be retrieved.
     */
    public ComponentName( Context pkg,  Class<?> cls) {
    }

    public ComponentName clone() {
        return null;
    }

    /**
     * Return the package name of this component.
     */
    public  String getPackageName() {
        return null;
    }

    /**
     * Return the class name of this component.
     */
    public  String getClassName() {
        return null;
    }

    /**
     * Return the class name, either fully qualified or in a shortened form
     * (with a leading '.') if it is a suffix of the package.
     */
    public String getShortClassName() {
        return null;
    }

    private static void appendShortClassName(StringBuilder sb, String packageName,
                                             String className) {
    }

    private static void printShortClassName(PrintWriter pw, String packageName,
                                            String className) {
    }

    /**
     * Return a String that unambiguously describes both the package and
     * class names contained in the ComponentName.  You can later recover
     * the ComponentName from this string through
     * {@link #unflattenFromString(String)}.
     *
     * @return Returns a new String holding the package and class names.  This
     * is represented as the package name, concatenated with a '/' and then the
     * class name.
     *
     * @see #unflattenFromString(String)
     */
    public  String flattenToString() {
        return null;
    }

    /**
     * The same as {@link #flattenToString()}, but abbreviates the class
     * name if it is a suffix of the package.  The result can still be used
     * with {@link #unflattenFromString(String)}.
     *
     * @return Returns a new String holding the package and class names.  This
     * is represented as the package name, concatenated with a '/' and then the
     * class name.
     *
     * @see #unflattenFromString(String)
     */
    public  String flattenToShortString() {
        return null;
    }

    /** @hide */
    public void appendShortString(StringBuilder sb) {
    }

    /** @hide */
    public static void appendShortString(StringBuilder sb, String packageName, String className) {
    }

    /** @hide */
    public static void printShortString(PrintWriter pw, String packageName, String className) {
    }

    /**
     * Recover a ComponentName from a String that was previously created with
     * {@link #flattenToString()}.  It splits the string at the first '/',
     * taking the part before as the package name and the part after as the
     * class name.  As a special convenience (to use, for example, when
     * parsing component names on the command line), if the '/' is immediately
     * followed by a '.' then the final class name will be the concatenation
     * of the package name with the string following the '/'.  Thus
     * "com.foo/.Blah" becomes package="com.foo" class="com.foo.Blah".
     *
     * @param str The String that was returned by flattenToString().
     * @return Returns a new ComponentName containing the package and class
     * names that were encoded in <var>str</var>
     *
     * @see #flattenToString()
     */
    public static ComponentName unflattenFromString(String str) {
        return null;
    }

    /**
     * Return string representation of this class without the class's name
     * as a prefix.
     */
    public String toShortString() {
        return null;
    }

    
    public String toString() {
        return null;
    }

    
    public boolean equals(Object obj) {
        return false;
    }

    
    public int hashCode() {
        return 0;
    }

    public int compareTo(ComponentName that) {
        return 0;
    }

    public int describeContents() {
        return 0;
    }





}
