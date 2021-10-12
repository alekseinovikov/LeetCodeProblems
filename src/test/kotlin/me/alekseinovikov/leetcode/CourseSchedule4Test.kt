package me.alekseinovikov.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CourseSchedule4Test {

    @Test
    fun checkIfPrerequisite() {
        val result = CourseSchedule4().checkIfPrerequisite(
            3, arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 0),
                intArrayOf(2, 0)
            ), arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 2)
            )
        )

        assertThat(result)
            .containsExactly(true, true)
    }

    @Test
    fun checkIfPrerequisite2() {
        val result = CourseSchedule4().checkIfPrerequisite(
            2, arrayOf(
                intArrayOf(1, 0)
            ), arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 0)
            )
        )

        assertThat(result)
            .containsExactly(false, true)
    }

    @Test
    fun checkIfPrerequisite3() {
        val result = CourseSchedule4().checkIfPrerequisite(
            2, arrayOf(
            ), arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 0)
            )
        )

        assertThat(result)
            .containsExactly(false, false)
    }

}