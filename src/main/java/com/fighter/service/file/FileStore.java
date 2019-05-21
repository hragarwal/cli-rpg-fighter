package com.fighter.service.file;

import com.fighter.model.Activity;

import java.io.*;

public class FileStore {

    public static String FILE_NAME = "data.ser";

    public Boolean serialize(Activity activity) {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(activity);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public Activity deserialize() {
        Activity activity = null;
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            activity = (Activity) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return activity;
    }
}
