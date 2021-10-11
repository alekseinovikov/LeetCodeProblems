package me.alekseinovikov.leetcode

//https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
class PrefixSearch {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        sentence.split(" ").forEachIndexed { indx, word ->
            if(word.startsWith(searchWord)) {
                return indx + 1
            }
        }

        return -1
    }
}