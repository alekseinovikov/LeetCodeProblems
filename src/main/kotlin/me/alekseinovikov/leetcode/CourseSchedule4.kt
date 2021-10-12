package me.alekseinovikov.leetcode

class CourseSchedule4 {

    data class Course(
        val id: Int,
        val post: MutableMap<Int, Course> = mutableMapOf()
    )

    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val allNodes = mutableMapOf<Int, Course>()

        prerequisites.forEach { cur ->
            val curId = cur[1]
            val preCurId = cur[0]

            val preCur = allNodes.computeIfAbsent(preCurId) { Course(it) }
            val postCur = allNodes.computeIfAbsent(curId) { Course(it) }

            preCur.post[curId] = postCur
        }

        val result = mutableListOf<Boolean>()
        queries.forEach { q ->
            val pre = q[0]
            val toFind = q[1]

            val preNode = allNodes[pre]
            if (preNode == null) {
                result.add(false)
            } else {
                result.add(traverse(preNode, toFind))
            }
        }

        return result
    }

    private fun traverse(currNode: Course, toFind: Int): Boolean {
        if (currNode.post.containsKey(toFind)) {
            return true
        }

        return currNode.post.any { traverse(it.value, toFind) }
    }

}