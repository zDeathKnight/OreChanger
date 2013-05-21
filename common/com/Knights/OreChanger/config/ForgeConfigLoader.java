/**
* File: ConfigLoader.java
* created: 14.04.2013 - 17:57:31
* by: RoboMat
*/

package com.Knights.OreChanger.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.Knights.OreChanger.OreChanger;

public class ForgeConfigLoader
{
final private String MOD_NAME; // Name of the mod
final private String FILE_PATH; // Path of the config file
final private String CONFIG_ID; // Use if you want multiple property files
final private File CONFIG_FILE; // The config file
final private FileOutputStream OUT; // The outputstream to the config file
final private SortedProperties properties; // The properties to be sorted and stored / read

/* true if new file was created, false if there already is one */
private boolean newFileCreated = false;

/**
* Creates a new unique config file.
*
* @param modName
* @param filePath
*/
public ForgeConfigLoader(String modName, String id) 
{
	MOD_NAME = modName;
	CONFIG_ID = id;

	if (id.isEmpty()) {
		FILE_PATH = "/config/" + MOD_NAME + ".cfg";
	} else {
		FILE_PATH = "/config/" + MOD_NAME + "_" + CONFIG_ID + ".cfg";
	}

CONFIG_FILE = new File(OreChanger.porxy.getMinecraftDir() + FILE_PATH);
OUT = createPropertyFile();
properties = new SortedProperties();
}

/**
* Tests if there already is a config file with the exact path determined in
* the constructor. If there is none, it creates a new file sets the flag
* {@code newFileCreated} and opens an output stream to that file.
*
* @return Outputstream to the newly created config file.
*/
private FileOutputStream createPropertyFile() {
FileOutputStream out = null;
try {
newFileCreated = CONFIG_FILE.createNewFile();

/* Try to create file && update field */
if (newFileCreated) {
out = new FileOutputStream(CONFIG_FILE);
System.out.println("> " + MOD_NAME + " - Creating new Config-file at " + FILE_PATH + ".");
} else {
System.out.println("> " + MOD_NAME + " - Config-File found at " + FILE_PATH + ".");
}
} catch (IOException e) {
e.printStackTrace();
}
return out;
}

/* ---------------------- WRITING METHODS --------------------------------- */
/**
* Writes a single property to the config file determined in the
* constructor.
*
* @param key - The name of the property to set in the file.
* @param value - The value of the property to set in the file.
* @param comment - The comment to write in the config file.
*/
public void put(String key, Object obj) {
if (newFileCreated) {
properties.put(key, obj);
System.out.println("> " + MOD_NAME + " - Wrote property \"" + key + "\" value of " + obj + ".");
}
}

/* ---------------------- READING SINGLE VALUES --------------------------- */
/**
* Reads a single property from the property file.
*
* @param key - The name of the property to read from the file.
* @return Read property.
*/
public char readChar(String key) {
FileInputStream in = null;
String temp;
char result = 0;

try {
in = new FileInputStream(CONFIG_FILE);
properties.load(in);
temp = properties.getProperty(key).trim(); // read String from property file
result = temp.charAt(0); // get first char ... if the user inputs more it is his fault :P
System.out.println("> " + MOD_NAME + " - Read property \"" + key + "\" value of " + result + ".");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
in.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return result;
}

/**
* Reads a single property from the property file.
*
* @param key - The name of the property to read from the file.
* @return Read property.
*/
public String readString(String key) {
FileInputStream in = null;
String result = null;

try {
in = new FileInputStream(CONFIG_FILE);
properties.load(in);
result = properties.getProperty(key).trim(); // read String from property file
System.out.println("> " + MOD_NAME + " - Read property \"" + key + "\" value of " + result + ".");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
in.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return result;
}

/**
* Reads a single property from the property file.
*
* @param key - The name of the property to read from the file.
* @return Read property.
*/
public byte readByte(String key) {
FileInputStream in = null;
byte result = 0;

try {
in = new FileInputStream(CONFIG_FILE);
properties.load(in);
result = Byte.valueOf(properties.getProperty(key).trim()); // read String from property file
System.out.println("> " + MOD_NAME + " - Read property \"" + key + "\" value of " + result + ".");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
in.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return result;
}

/**
* Reads a single property from the property file.
*
* @param key - The name of the property to read from the file.
* @return Read property.
*/
public short readShort(String key) {
FileInputStream in = null;
short result = 0;

try {
in = new FileInputStream(CONFIG_FILE);
properties.load(in);
result = Short.valueOf(properties.getProperty(key).trim()); // read String from property file
System.out.println("> " + MOD_NAME + " - Read property \"" + key + "\" value of " + result + ".");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
in.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return result;
}

/**
* Reads a single property from the property file.
*
* @param key - The name of the property to read from the file.
* @return Read property.
*/
public int readInt(String key) {
FileInputStream in = null;
int result = 0;

try {
in = new FileInputStream(CONFIG_FILE);
properties.load(in);
result = Integer.valueOf(properties.getProperty(key).trim()); // read String from property file
System.out.println("> " + MOD_NAME + " - Read property \"" + key + "\" value of " + result + ".");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
in.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return result;
}

/**
* Reads a single property from the property file.
*
* @param key - The name of the property to read from the file.
* @return Read property.
*/
public long readLong(String key) {
FileInputStream in = null;
long result = 0;

try {
in = new FileInputStream(CONFIG_FILE);
properties.load(in);
result = Long.valueOf(properties.getProperty(key).trim()); // read String from property file
System.out.println("> " + MOD_NAME + " - Read property \"" + key + "\" value of " + result + ".");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
in.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return result;
}

/**
* Reads a single property from the property file.
*
* @param key - The name of the property to read from the file.
* @return Read property.
*/
public float readFloat(String key) {
FileInputStream in = null;
float result = 0;

try {
in = new FileInputStream(CONFIG_FILE);
properties.load(in);
result = Float.valueOf(properties.getProperty(key).trim()); // read String from property file
System.out.println("> " + MOD_NAME + " - Read property \"" + key + "\" value of " + result + ".");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
in.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return result;
}

/**
* Reads a single property from the property file.
*
* @param key - The name of the property to read from the file.
* @return Read property.
*/
public double readDouble(String key) {
FileInputStream in = null;
double result = 0;

try {
in = new FileInputStream(CONFIG_FILE);
properties.load(in);
result = Double.valueOf(properties.getProperty(key).trim()); // read String from property file
System.out.println("> " + MOD_NAME + " - Read property \"" + key + "\" value of " + result + ".");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
in.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return result;
}

/**
* Reads a single property from the property file.
*
* @param key - The name of the property to read from the file.
* @return Read property.
*/
public boolean readBoolean(String key) {
FileInputStream in = null;
boolean result = false;

try {
in = new FileInputStream(CONFIG_FILE);
properties.load(in);
result = Boolean.valueOf(properties.getProperty(key).trim()); // read String from property file
System.out.println("> " + MOD_NAME + " - Read property \"" + key + "\" value of " + result + ".");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
in.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return result;
}

/* ---------------------- CREATING ARRAYS FROM STRINGS -------------------- */
/**
* Trims a String and breaks it up using the given regex.
*
* @param key - The property to load from the config file.
* @param regex - The regex with which to break up the String.
* @return An String[] containing the single era names.
*/
private String[] breakUpString(String key, String regex) {
String strToBreak = null;
FileInputStream in = null;

try {
in = new FileInputStream(CONFIG_FILE);
properties.load(in);
strToBreak = properties.getProperty(key).trim();
System.out.println("> " + MOD_NAME + " - Read property \"" + key + "\" value of " + strToBreak + ".");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
in.close();
} catch (IOException e) {
e.printStackTrace();
}
}
return strToBreak.split(regex);
}

/**
* Reads and trims a String. Then breaks it up into a char array.
*
* @param key - The property to load from the config.
* @param regex - The regex with which to break up the String.
* @return char[].
*/
public char[] readStringAsCharArray(String key, String regex) {
String[] temp = breakUpString(key, regex);
char[] result = new char[temp.length];

for (int i = 0; i < result.length; i++) {
result[i] = temp[i].trim().charAt(0);
}
return result;
}

/**
* Reads and trims a String. Then breaks it up into an array.
*
* @param key - The property to load from the config.
* @param regex - The regex with which to break up the String.
* @return String[].
*/
public String[] readStringAsArray(String key, String regex) {
String[] result = breakUpString(key, regex);
return result;
}

/**
* Reads and trims a String. Then breaks it up into a byte[].
*
* @param key - The String to be edited.
* @param regex - The regex with which to break up the String.
* @return byte[].
*/
public byte[] readStringAsByteArray(String key, String regex) {
String[] temp = breakUpString(key, regex);
byte[] result = new byte[temp.length];

for (int i = 0; i < result.length; i++) {
result[i] = Byte.valueOf(temp[i].trim());
}
return result;
}

/**
* Reads and trims a String. Then breaks it up into a short[].
*
* @param key - The String to be edited.
* @param regex - The regex with which to break up the String.
* @return short[].
*/
public short[] readStringAsShortArray(String key, String regex) {
String[] temp = breakUpString(key, regex);
short[] result = new short[temp.length];

for (int i = 0; i < result.length; i++) {
result[i] = Short.valueOf(temp[i].trim());
}
return result;
}

/**
* Reads and trims a String. Then breaks it up into an int[].
*
* @param key - The String to be edited.
* @param regex - The regex with which to break up the String.
* @return short[].
*/
public int[] readStringAsIntArray(String key, String regex) {
String[] temp = breakUpString(key, regex);
int[] result = new int[temp.length];

for (int i = 0; i < result.length; i++) {
result[i] = Integer.valueOf(temp[i].trim());
}
return result;
}

/**
* Reads and trims a String. Then breaks it up into an long[].
*
* @param key - The String to be edited.
* @param regex - The regex with which to break up the String.
* @return short[].
*/
public long[] readStringAsLongArray(String key, String regex) {
String[] temp = breakUpString(key, regex);
long[] result = new long[temp.length];

for (int i = 0; i < result.length; i++) {
result[i] = Long.valueOf(temp[i].trim());
}
return result;
}

/**
* Reads and trims a String. Then breaks it up into an float[].
*
* @param key - The String to be edited.
* @param regex - The regex with which to break up the String.
* @return short[].
*/
public float[] readStringAsFloatArray(String key, String regex) {
String[] temp = breakUpString(key, regex);
float[] result = new float[temp.length];

for (int i = 0; i < result.length; i++) {
result[i] = Float.valueOf(temp[i].trim());
}
return result;
}

/**
* Reads and trims a String. Then breaks it up into an double[].
*
* @param key - The String to be edited.
* @param regex - The regex with which to break up the String.
* @return short[].
*/
public double[] readStringAsDoubleArray(String key, String regex) {
String[] temp = breakUpString(key, regex);
double[] result = new double[temp.length];

for (int i = 0; i < result.length; i++) {
result[i] = Double.valueOf(temp[i].trim());
}
return result;
}

/**
* Reads and trims a String. Then breaks it up into an long[].
*
* @param key - The String to be edited.
* @param regex - The regex with which to break up the String.
* @return short[].
*/
public boolean[] readStringAsBooleanArray(String key, String regex) {
String[] temp = breakUpString(key, regex);
boolean[] result = new boolean[temp.length];

for (int i = 0; i < result.length; i++) {
result[i] = Boolean.valueOf(temp[i].trim());
}
return result;
}

/* ------------------------------------------------------------------------ */
/**
* Closes output stream after all properties have been written.
*/
private void closeStream() {
if (OUT != null) {
try {
OUT.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}

/**
* Stores the set properties to the config file and closes the stream.
*/
public void store() {
try {
if (newFileCreated) {
properties.store(OUT, "Created with ConfigLoader by RoboMat: " + MOD_NAME);
}
} catch (IOException e) {
e.printStackTrace();
} finally {
closeStream();
}
}

}