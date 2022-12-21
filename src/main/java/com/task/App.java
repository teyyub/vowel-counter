package com.task;

import java.util.List;

import com.task.exceptions.EmptyFileNameException;
import com.task.utils.FileUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String s = "/Users/teyyub392/Downloads/task/java-project/src/main/INPUT.TXT";
        
        if(s.equals("")) {
            throw new EmptyFileNameException("Empty file name");
        } 
       List<String> words = FileUtils.readWords(s);
        
       List<WordData> wordsAvgGroup = WordCalcAverage.calcAverage(words);
       FileUtils.writeToFile(wordsAvgGroup); 
    }
}
