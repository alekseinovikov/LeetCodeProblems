package me.alekseinovikov.leetcode

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class HouseRobberTest {

    @Test
    fun rob_test1() {
        val result = rob(1, 2, 3, 1)
        Assertions.assertThat(result).isEqualTo(4)
    }

    @Test
    fun rob_test2() {
        val result = rob(2, 7, 9, 3, 1)
        Assertions.assertThat(result).isEqualTo(12)
    }

    @Test
    fun rob_test3() {
        val result = rob(1, 1, 1)
        Assertions.assertThat(result).isEqualTo(2)
    }

    @Test
    fun rob_test4() {
        val result = rob(2, 1, 1, 2)
        Assertions.assertThat(result).isEqualTo(4)
    }

    @Test
    fun rob_test5() {
        val result = rob(
            183,
            219,
            57,
            193,
            94,
            233,
            202,
            154,
            65,
            240,
            97,
            234,
            100,
            249,
            186,
            66,
            90,
            238,
            168,
            128,
            177,
            235,
            50,
            81,
            185,
            165,
            217,
            207,
            88,
            80,
            112,
            78,
            135,
            62,
            228,
            247,
            211
        )
        Assertions.assertThat(result).isEqualTo(4)
    }

    private fun rob(vararg houseNumbers: Int): Int =
        HouseRobber().rob(houseNumbers)

}