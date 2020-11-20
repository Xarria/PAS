package com.library.Data;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class FileReaderWriter {

    public <T> ArrayList<T> readFromFile(String searchedName) {
        BufferedReader reader;
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader("src\\main\\java\\com\\library\\Data\\SampleData.txt"));
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

    public <T> void writeToFile(ArrayList<T> arrayToBeWritten, String str) {
        BufferedWriter writer;
        ArrayList<Book> books;
        ArrayList<Newspaper> newspapers;
        ArrayList<Renter> renters;

        // getting the old values
        books = readFromFile("book");
        newspapers = readFromFile("newspaper");
        renters = readFromFile("renters");

        // updating chosen values
        if (str.equals("book")) {
            books = (ArrayList<Book>) arrayToBeWritten;
        } else if (str.equals("newspaper")) {
            newspapers = (ArrayList<Newspaper>) arrayToBeWritten;
        } else {
            renters = (ArrayList<Renter>) arrayToBeWritten;
        }

        try {
            writer = new BufferedWriter(new FileWriter("src\\main\\java\\com\\library\\Data\\SampleData.txt"));
            writer.flush();
            for (Book book : books) {
                writer.append("book" + "===").append(book.getName()).append("===").append(book.getGenre()).append("===").append(book.getAuthor()).append("===").append(String.valueOf(book.getPages()));
                writer.newLine();
            }
            for (Newspaper newspaper : newspapers) {
                writer.append("newspaper" + "===").append(newspaper.getName()).append("===").append(newspaper.getGenre());
                writer.newLine();
            }
            for (Renter renter : renters) {
                writer.append("renter" + "===").append(renter.getName()).append("===").append(renter.getSurname()).append("===").append(renter.getLogin());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
