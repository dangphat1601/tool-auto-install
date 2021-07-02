package shopify;

import com.github.javafaker.Faker;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println(faker.name().fullName());
    }
//        File folder = new File("C:\\Attachments\\img");
//
//        //Implementing FilenameFilter to retrieve only txt files
//
//        FilenameFilter txtFileFilter = new FilenameFilter()
//        {
//            @Override
//            public boolean accept(File dir, String name)
//            {
//                if(name.endsWith(".jpg") || name.endsWith(".jpeg"))
//                {
//                    return true;
//                }
//                else
//                {
//                    return false;
//                }
//            }
//        };
//
//        //Passing txtFileFilter to listFiles() method to retrieve only txt files
//
//        File[] files = folder.listFiles(txtFileFilter);
//
//        for (File file : files)
//        {
//            System.out.println(file.getName());
//        }
//    }
}

