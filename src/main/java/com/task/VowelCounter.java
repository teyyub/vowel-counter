package com.task;

import java.util.*;
 

public class VowelCounter
{
    private static List<WordData> wordsAvg = new ArrayList<>();
    
    public static List<WordData> getAverageVowelCounts(List<String> words) {
        for(String word : words) {        	
            final WordData wordData = new WordData(word.length());
        int vowelsCount = 0;
        
        for(char ch : word.toCharArray()) {
            if(isVoWel(ch)) {
                wordData.add(ch, ++vowelsCount);
            }
        }

        if (wordsAvg.contains(wordData)) {
        	for (WordData wa : wordsAvg)
        		if (wa.equals(wordData)) {
        			wa.addCount();
        			wa.addTotalVowel(vowelsCount);
        			break;
        		}
        } else {
        	wordsAvg.add(wordData);
        }
        }
        Collections.sort(wordsAvg);
        return wordsAvg;
    }

    private static void processWordSet(String word) {
        final WordData wordData = new WordData(word.length());
        int vowelsCount = 0;
        
        for(char ch : word.toCharArray()) {
            if(isVoWel(ch)) {
                wordData.add(ch, ++vowelsCount);
            }
        }

        if (wordsAvg.contains(wordData)) {
        	for (WordData wa : wordsAvg)
        		if (wa.equals(wordData)) {
        			wa.addCount();
        			wa.addTotalVowel(vowelsCount);
        			break;
        		}
        } else {
        	wordsAvg.add(wordData);
        }
    }

    private static boolean isVoWel(char c){
        return  (c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u'); 
    }
}
