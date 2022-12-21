package com.task;

import org.junit.Assert;
import org.junit.Test;

import com.task.utils.FileUtils;

import java.util.*;

public class AppTest
{
    @Test
    public void test1(){
        List<String> words = FileUtils.readWords(getClass().getClassLoader().getResource("input1.txt").getPath());
        List<WordData> wordsAvg =  WordCalcAverage.calcAverage(words);

        WordData ws1 = new WordData(6);
        Set<Character> ch1 = new HashSet<Character>();
        ch1.add('a');
        ch1.add('o');
        ws1.setCharSet(ch1);
        ws1.addCount();
        ws1.addCount();
        ws1.addTotalVowel(5);

        WordData ws2 = new WordData(4);
        Set<Character> ch2 = new HashSet<Character>();
        ch2.add('a');
        ch2.add('e');
        ws2.setCharSet(ch2);
        ws2.addCount();
        ws2.addTotalVowel(2);

        WordData ws3 = new WordData(5);
        Set<Character> ch3 = new HashSet<Character>();
        ch3.add('a');
        ch3.add('o');
        ws3.setCharSet(ch3);
        ws3.addCount();
        ws3.addTotalVowel(2);

        Assert.assertTrue(wordsAvg.contains(ws1));
        Assert.assertTrue(wordsAvg.contains(ws2));
        Assert.assertTrue(wordsAvg.contains(ws3));
        Assert.assertEquals(words.size(), 4);
        Assert.assertEquals(wordsAvg.size(), 3);
    }

    @Test
    public void test2(){
        List<String> words = FileUtils.readWords(getClass().getClassLoader().getResource("input2.txt").getPath());
        List<WordData> wordsAvg = WordCalcAverage.calcAverage(words);

        WordData ws1 = new WordData(6);
        Set<Character> ch1 = new HashSet<Character>();
        ch1.add('e');
        ws1.setCharSet(ch1);
        ws1.addCount();
        ws1.addTotalVowel(2);

        ch1.add('u');
        ws1.setCharSet(ch1);
        ws1.addCount();
        ws1.addTotalVowel(2);

        Assert.assertTrue(wordsAvg.contains(ws1));
        Assert.assertEquals(words.size(), 1);
        Assert.assertEquals(wordsAvg.size(), 1);
    }
 

    @Test
    public void test3(){
        List<String> words = FileUtils.readWords(getClass().getClassLoader().getResource("input3.txt").getPath());
        Assert.assertTrue(words.isEmpty());
        List<WordData> wordsAvg = WordCalcAverage.calcAverage(words);
        Assert.assertTrue(wordsAvg.isEmpty());
    }
}
