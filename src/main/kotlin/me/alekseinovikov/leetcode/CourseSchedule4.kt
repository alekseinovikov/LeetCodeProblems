package me.alekseinovikov.leetcode

class CourseSchedule4 {

    data class Course(
        val id: Int,
        val post: MutableMap<Int, Course> = mutableMapOf()
    )

    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val allNodes = mutableMapOf<Int, Course>()

        prerequisites.forEach { cur ->
            val postCurId = cur[1]
            val preCurId = cur[0]

            val pre = allNodes.computeIfAbsent(preCurId) { Course(it) }
            val post = allNodes.computeIfAbsent(postCurId) { Course(it) }
            pre.post[postCurId] = post
        }

        val preMatrix = Array(numCourses) {
            Array(numCourses) { false }
        }

        traverse(preMatrix, allNodes)
        val result = mutableListOf<Boolean>()
        queries.forEach { q ->
            val pre = q[0]
            val toFind = q[1]

            result.add(preMatrix[pre][toFind])
        }

        return result
    }

    private fun traverse(matrix: Array<Array<Boolean>>, nodes: Map<Int, Course>) {
        nodes.forEach { (key, value) ->
            traverse(key, matrix, value.post)
        }
    }

    private fun traverse(nodeId: Int, matrix: Array<Array<Boolean>>, nodes: Map<Int, Course>) {
        nodes.forEach { (key, value) ->
            matrix[nodeId][key] = true
            traverse(nodeId, matrix, value.post)
            traverse(key, matrix, value.post)
        }
    }

}