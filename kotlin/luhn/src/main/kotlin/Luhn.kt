object Luhn {
    fun isValid(numberCode: String): Boolean {
        val filteredCode = numberCode.filter { !it.isWhitespace() }
        if (filteredCode.length < 2) {
            return false
        }

        val numberSequence = filteredCode.reversedNumberSequence()
        if (numberSequence.containsInvalidCharacters()) {
            return false
        }

        return numberSequence
                .mapIndexed { index, digit -> doubleEverySecond(index + 1, digit) }
                .map { subtractWhenDoubleDigit(it) }
                .sum()
                .isDivisibleBy(10)
    }

    private fun String.reversedNumberSequence() =
            reversed().map { it.parseCharacter() }

    private fun List<Int>.containsInvalidCharacters() = any { it !in 0..9 }

    private fun doubleEverySecond(index: Int, digit: Int) =
            if (index.isDivisibleBy(2)) digit * 2 else digit

    private fun Int.isDivisibleBy(divisor: Int) = (this) % divisor == 0

    private fun subtractWhenDoubleDigit(it: Int) =
            if (it > 9) it - 9 else it

    private fun Char.parseCharacter() = toInt() - '0'.toInt()
}