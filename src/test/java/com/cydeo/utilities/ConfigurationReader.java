package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1-create the object of Properties
    private static Properties properties= new Properties();

    static {
        // 2-we need to open the file  in java memory: FileInputstream
        try {
            FileInputStream file= new FileInputStream("configuration.properties");

            //3-load the properties object using FileInputStream object

            properties.load(file);

            //close the file
            file.close();
        } catch (IOException e) {
            System.out.println("File is not found in configuration properties");
        }

    }
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);

    }



/*
    //2-we need to open the file  in java memory: FileInputstream
    FileInputStream file= new FileInputStream("configuration.properties");

    //3-load the properties object using FileInputStream object
        properties.load(file);
*/

}
