package com.task;

import java.util.List;

import com.task.exceptions.EmptyFileNameException;
import com.task.utils.FileUtils;

/**
 * A program that loads all words and determines the average number of vowels per word grouped by:
 * set of vowels present in a word and length of the word.
 * Result should be written to the output file.
 *
 * @Params file named INPUT.TXT
 * @Params file named OUTPUT.TXT
 * @author Teyyub Aliyev
 * @date 12/21/2022 
 */
public class App 
{
    static  String fileName;// = "/Users/teyyub392/Downloads/task/java-project/src/main/INPUT.TXT";.
     
     
    public static void main(String[] args) {
        fileName = args[0]; 
        processFile();
    } 
    private static void processFile() {
        FileUtils.writeToFile(getAverageNumberOfVowels());
    }

    private static List<WordData> getAverageNumberOfVowels() {
        return VowelCounter.getAverageVowelCounts(FileUtils.readWords(fileName));
    }       
   

}
