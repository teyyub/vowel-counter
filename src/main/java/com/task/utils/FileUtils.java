package com.task.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.task.WordData;
import com.task.exceptions.EmptyFileNameException;

public class FileUtils { 

    static String SPLIT_PATTERN ="[^a-zA-Z0-9\\-\'\\_]";
    static String MATCH_PATTERN ="^[a-zA-Z0-9\\-'\\_]{1,}$";
    public static List<String> readWords(String fileName) {
 
        validateFileName(fileName);
        List<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();         
            while (line != null) {
                String[] parts = line.split(SPLIT_PATTERN);
                for (String w : parts) {
                    if(w.matches(MATCH_PATTERN)) {
                        words.add(w.toLowerCase());
                    }
                }
                line = br.readLine();
            }
        } 
        catch (IOException e) { 
            e.printStackTrace();
        }
        return words;
    }
 
    public static void writeToFile(List<WordData> words){
        try(PrintWriter writer = new PrintWriter("OUTPUT.txt", "UTF-8")) {
            for(WordData wd : words){
                writer.println(wd);
            }
        }
         catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void validateFileName(String fileName) {
        if (fileName.equals("")) {
            throw new EmptyFileNameException();
        }
    }
}
