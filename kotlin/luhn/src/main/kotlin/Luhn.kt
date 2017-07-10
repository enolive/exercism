object Luhn {
    fun isValid(numberCode: String): Boolean {
        val withoutWhitespaces = numberCode.filter { !it.isWhitespace() }
        if (withoutWhitespaces.hasLexicalErrors()) {
            return false
        }
        
        return checkSumOf(withoutWhitespaces).isDivisibleBy(10)
    }

    private fun String.hasLexicalErrors()
            = length < 2 || any { it !in '0'..'9' }

    private fun checkSumOf(code: String): Int 
            = code.reversedNumberSequence()
            .mapIndexed(this::doubleEverySecondOne)
            .map(this::toSingleDigit)
            .sum()

    private fun String.reversedNumberSequence() =
            reversed().map { "$it".toInt() }

    private fun doubleEverySecondOne(index: Int, digit: Int) =
            if ((index + 1).isDivisibleBy(2)) digit * 2 else digit

    private fun toSingleDigit(it: Int) = if (it > 9) it - 9 else it

    private fun Int.isDivisibleBy(divisor: Int) = (this) % divisor == 0

}