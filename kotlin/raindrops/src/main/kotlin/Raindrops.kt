object Raindrops {
    fun convert(input: Int): String {
        val rules = sequenceOf(
                3 to "Pling",
                5 to "Plang"
        )

        val result = rules
                .filter { (denominator, _) -> input.isDivisibleBy(denominator) }
                .map { (_, result) -> result }
                .joinToString("")
        return if (result.isNotEmpty()) result else input.toString()
    }

    private fun Int.isDivisibleBy(denominator: Int) = this % denominator == 0

}