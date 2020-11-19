package com.library.Data;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class FileReader {

    public <T> ArrayList<T> readFromFile(String searchedName) {
        BufferedReader reader;
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            reader = new BufferedReader(new java.io.FileReader("src\\main\\java\\com\\library\\Data\\SampleData.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] arr = line.split("===");
                if (arr[0].equals("book") && arr[0].equals(searchedName)) {
                    arrayList.add(((T) new Book(arr[1], arr[2], arr[3], Integer.parseInt(arr[4]))));
                } else if (arr[0].equals("newspaper") && arr[0].equals(searchedName)) {
                    arrayList.add((T) new Newspaper(arr[1], arr[2]));
                } else if (arr[0].equals("renter") && arr[0].equals(searchedName)) {
                    arrayList.add((T) new Renter(arr[1], arr[2], arr[3]));
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
