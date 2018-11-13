/*
Group Anagrams: 
Write a method to sort an array of strings so that all the anagrams are next to each other.
*/

import java.util.*;

class Solution {
    void sortAnagrams(String[] words) {
        List<WordHolder> wordsList = new ArrayList<>(words.length);
        for (String word : words) {
            wordsList.add(new WordHolder(word));
        }

        Collections.sort(wordsList);

        for (int i = 0; i < words.length; i++) {
            words[i] = wordsList.get(i).word;
        }
    }

    void sortAnagrams2(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String sorted = getSortedString(word);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(word);
        }

        int index = 0;
        for (List<String> anagrams : map.values()) {
            for (String word : anagrams) {
                words[index] = word;
                index++;
            }
        }
    }

    private String getSortedString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

class WordHolder implements Comparable<WordHolder> {
    String word;
    String sorted;

    WordHolder(String word) {
        this.word = word;
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        this.sorted = new String(chars);
    }

    @Override
    public int compareTo(WordHolder otherWord) {
        return this.sorted.compareTo(otherWord.sorted);
    }
}
