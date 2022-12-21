package com.task;

import org.junit.Assert;
import org.junit.Test;

import com.task.exceptions.EmptyFileNameException;
import com.task.utils.FileUtils;

import java.util.*;

public class AppTest
{

    @Test(expected = EmptyFileNameException.class) 
    public void shouldThrowEmptyFileNameException(){
       FileUtils.readWords(""); 
    }

    @Test
    public void shouldPrintAverageVowelCount1(){
        List<String> words = initFile("input1.txt");
        List<WordData> wordsAvg =  VowelCounter.getAverageVowelCounts(words);

        WordData wordData1 = new WordData(6);
        Set<Character> vowelSet1 = new HashSet<Character>();
        vowelSet1.add('a');
        vowelSet1.add('o');
        wordData1.setCharSet(vowelSet1);
        wordData1.addCount();
        wordData1.addCount();
        wordData1.addTotalVowel(5);

        WordData wordData2 = new WordData(4);
        Set<Character> vowelSet2 = new HashSet<Character>();
        vowelSet2.add('a');
        vowelSet2.add('e');
        wordData2.setCharSet(vowelSet2);
        wordData2.addCount();
        wordData2.addTotalVowel(2);

        WordData wordData3 = new WordData(5);
        Set<Character> vowelSet3 = new HashSet<Character>();
        vowelSet3.add('a');
        vowelSet3.add('o');
        wordData3.setCharSet(vowelSet3);
        wordData3.addCount();
        wordData3.addTotalVowel(2);

        Assert.assertTrue(wordsAvg.contains(wordData1));
        Assert.assertTrue(wordsAvg.contains(wordData2));
        Assert.assertTrue(wordsAvg.contains(wordData3));
        Assert.assertEquals(words.size(), 4);
        Assert.assertEquals(wordsAvg.size(), 3);
    }

    @Test
    public void shouldPrintAverageVowelCount2(){
        List<String> words = initFile("input2.txt");
        List<WordData> wordsAvg = VowelCounter.getAverageVowelCounts(words);

        WordData wordData1 = new WordData(4);
        Set<Character> vowelSet1 = new HashSet<Character>();
        vowelSet1.add('e');
        wordData1.setCharSet(vowelSet1);
        wordData1.addCount();
        wordData1.addTotalVowel(1);
 
        Assert.assertTrue(wordsAvg.contains(wordData1));
        Assert.assertEquals(words.size(), 1);
        Assert.assertEquals(wordsAvg.size(), 1);
    }
 

    @Test
    public void shouldPrintAverageVowelCount3(){
        List<String> words = initFile("input3.txt");
        Assert.assertTrue(words.isEmpty());
        List<WordData> wordsAvg = VowelCounter.getAverageVowelCounts(words);
        Assert.assertTrue(wordsAvg.isEmpty());
    }


    private List<String> initFile(String fileName){
        return FileUtils.readWords(getClass().getClassLoader().getResource(fileName).getPath());
    }
}
