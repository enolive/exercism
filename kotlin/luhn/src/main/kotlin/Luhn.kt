object Luhn {
    fun isValid(numberCode: String): Boolean {
        if (numberCode.length < 2) {
            return false
        }

        return numberCode
                .reversedNumberSequence()
                .mapIndexed { index, digit -> doubleEverySecond(index + 1, digit) }
                .map { subtractWhenDoubleDigit(it) }
                .sum()
                .isDivisibleBy(10)
    }

    private fun String.reversedNumberSequence() =
            reversed().map { it.parseCharacter() }

    private fun doubleEverySecond(index: Int, digit: Int) =
            if (index.isDivisibleBy(2)) digit * 2 else digit

    private fun Int.isDivisibleBy(divisor: Int) = (this) % divisor == 0

    private fun subtractWhenDoubleDigit(it: Int) = 
            if (it > 9) it - 9 else it

    private fun Char.parseCharacter() = toInt() - '0'.toInt()
}