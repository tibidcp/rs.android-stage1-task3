package subtask3

import kotlin.math.absoluteValue

class ArrayCalculator {
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val list = itemsFromArray.filterIsInstance<Int>().sortedByDescending { it.absoluteValue }
        if (list.isEmpty()) {
            return 0
        }
        if (list.size <= numberOfItems) {
            return list.reduce(Int::times)
        }
        return comb(list.size, numberOfItems)
            .map { indexList -> list.filterIndexed { index, _ -> index in indexList }
                .reduce(Int::times) }.max()!!
    }

    private fun comb(n: Int, k: Int) : List<List<Int>> {
        val listOfComb = mutableListOf<List<Int>>()
        val list = (0 until k).toMutableList()
        listOfComb.add(list.toList())
        while (true) {
            var i = k - 1
            while (i >= 0 && list[i] + k - i + 1 > n) {
                i--
            }
            if (i < 0) {
                break
            }
            list[i] += 1
            for (j in (i + 1) until k) {
                list[j] = list[j - 1] + 1
            }
            listOfComb.add(list.toList())
        }
        return listOfComb
    }
}
