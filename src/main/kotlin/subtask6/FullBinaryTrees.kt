package subtask6

class FullBinaryTrees {
    fun stringForNodeCount(count: Int): String {
        if (count % 2 == 0) {
            return "[]"
        }
        if (count == 1) {
            return "[[0]]"
        }
        if (count == 3) {
            return "[[0, 0, 0]]"
        }

        val root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        var left = root.left
        var right = root.right
        var lastKey = 3
        val trees = mutableListOf<Node>()

        var remainder = count - 3
        while (remainder > 0) {
            if (remainder == 2) {

            }
            addNodes(lastKey, left)
            lastKey += 2
            remainder -= 2
            left = left?.left
        }
        return ""
    }
}

fun addNodes(lastKey: Int, root: Node?) {
    root?.left = Node(lastKey + 1)
    root?.right = Node(lastKey + 2)
}

data class Node(val key: Int, var left: Node? = null, var right: Node? = null)

