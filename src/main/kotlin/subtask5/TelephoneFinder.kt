package subtask5

class TelephoneFinder {
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.contains('-')) {
            return null
        }
        val numbers = mutableListOf<String>()
        val neighbors = mapOf(
            '1' to listOf('2', '4'),
            '2' to listOf('1', '5', '3'),
            '3' to listOf('2', '6'),
            '4' to listOf('1', '5', '7'),
            '5' to listOf('2', '4', '6', '8'),
            '6' to listOf('3', '5', '9'),
            '7' to listOf('4', '8'),
            '8' to listOf('0', '5', '7', '9'),
            '9' to listOf('6', '8'),
            '0' to listOf('8'))

        number.forEachIndexed {index, char ->
            neighbors[char]?.forEach {neighbor ->
                val numList = number.toMutableList()
                numList[index] = neighbor
                numbers.add(numList.joinToString(""))
            }
        }
        return numbers.toTypedArray()
    }
}
