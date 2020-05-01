package subtask1

import kotlin.math.absoluteValue

class PolynomialConverter {
    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) {
            return null
        }
        return numbers.foldIndexed("") { index, string, number ->
            if (number == 0)
                return@foldIndexed string
            val stringNumber = if (number.absoluteValue == 1) "" else number.absoluteValue
            val size = numbers.size
            val delimiter = if (index == 0) "" else {if (number < 0) " - " else " + "}
            string + when (index) {
                size - 1 -> delimiter + stringNumber
                size - 2 -> "$delimiter${stringNumber}x"
                else -> "$delimiter${stringNumber}x^${size - index - 1}"
            }
        }
    }
}
