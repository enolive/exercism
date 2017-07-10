object Luhn {
    fun isValid(numberCode: String): Boolean {
        val withoutWhitespaces = numberCode.filter { !it.isWhitespace() }
        if (withoutWhitespaces.hasLexicalErrors()) {
            return false
        }

        return checkSumOf(withoutWhitespaces) isDivisibleBy 10
    }

    private fun String.hasLexicalErrors()
            = length < 2 || any { it !in '0'..'9' }

    private fun checkSumOf(code: String): Int
            = code.reversedNumberSequence()
            .mapIndexed { index, digit ->
                when {
                    (index + 1) isDivisibleBy 2 -> doubleWithRollover(digit)
                    else -> digit
                }
            }
            .sum()

    private fun doubleWithRollover(digit: Int): Int {
        val doubled = digit * 2
        return if (doubled > 9) doubled - 9 else doubled
    }

    private fun String.reversedNumberSequence() =
            reversed().map { "$it".toInt() }

    private infix fun Int.isDivisibleBy(divisor: Int) = (this) % divisor == 0

}