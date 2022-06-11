package me.alekseinovikov.leetcode

class RearrangeWordsInSentence {
    fun arrangeWords(text: String): String {
        if(text.isBlank()) return text

        return text
            .split(" ")
            .map { it.lowercase() }
            .sortedBy { it.length }
            .joinToString(" ")
            .replaceFirstChar { it.uppercase() }
    }
}