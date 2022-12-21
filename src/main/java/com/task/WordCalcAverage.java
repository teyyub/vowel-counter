package com.task;

import java.util.*;

import com.task.utils.FileUtils;

public class WordCalcAverage
{
   
    String fileName; 
     
    public WordCalcAverage(String fileName){
        this.fileName = fileName;
    }

    public void run(){
        List<String> words = FileUtils.readWords(fileName);
        List<WordData> wordsAvgGroup = WordCalcAverage.calcAverage(words);
        FileUtils.writeToFile(wordsAvgGroup);     
    } 
 
     public static List<WordData> calcAverage(List<String> words) {
        List<WordData> wordsAvg = new ArrayList<>();

        for(String word : words) {        	
            final WordData wordSet = new WordData(word.length());
            int vowelsCount = 0;
            
            for(char ch : word.toCharArray()) {
                if(isVoWel(ch)) {
                    wordSet.add(ch, ++vowelsCount);
                }
            }

			if (wordsAvg.contains(wordSet)) {
				for (WordData wa : wordsAvg)
					if (wa.equals(wordSet)) {
						wa.addCount();
						wa.addTotalVowel(vowelsCount);
						break;
					}
			} else {
				wordsAvg.add(wordSet);
			}
        }
        Collections.sort(wordsAvg);
        return wordsAvg;
    }

    private static boolean isVoWel(char c){
        return  (c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u'); 
    }
}
