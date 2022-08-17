/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsmanagement.upgrade;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author phong
 */
public class UpFile {
    public static Object readObj(String path) throws IOException, ClassNotFoundException {
        try (
            FileInputStream fileInPutStream = new FileInputStream(path);
            ObjectInputStream objectInPutStream = new ObjectInputStream(fileInPutStream);
            ) {
            
            Object obj = objectInPutStream.readObject();
            return obj;
        }
    }
    
    public static void writeObject(String path, Object object) throws IOException {
        try (FileOutputStream fileOutPutStream = new FileOutputStream(path);
            ObjectOutputStream objectOutPutStream = new ObjectOutputStream(fileOutPutStream);)
        {
           objectOutPutStream.writeObject(object);
        }
    }
}
