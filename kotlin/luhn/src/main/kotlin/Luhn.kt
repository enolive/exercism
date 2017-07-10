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
                .mapIndexed(this::doubleEverySecondOne)
                .map(this::toSingleDigit)
                .sum()
                .isDivisibleBy(10)
    }

    private fun String.reversedNumberSequence() =
            reversed().map { it.parseCharacter() }

    private fun List<Int>.containsInvalidCharacters() = any { it !in 0..9 }

    private fun doubleEverySecondOne(index: Int, digit: Int) =
            if ((index + 1).isDivisibleBy(2)) digit * 2 else digit

    private fun toSingleDigit(it: Int) = if (it > 9) it - 9 else it

    private fun Int.isDivisibleBy(divisor: Int) = (this) % divisor == 0

    private fun Char.parseCharacter() = toInt() - '0'.toInt()
}