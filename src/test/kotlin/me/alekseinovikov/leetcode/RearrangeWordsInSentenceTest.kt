package me.alekseinovikov.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RearrangeWordsInSentenceTest {

    @Test
    fun arrangeWords1() {
        val result = RearrangeWordsInSentence().arrangeWords("Keep calm and code on")

        assertThat(result)
            .isEqualTo("On and keep calm code")
    }

    @Test
    fun arrangeWords2() {
        val result = RearrangeWordsInSentence().arrangeWords("To be or not to be")

        assertThat(result)
            .isEqualTo("To be or to be not")
    }

}