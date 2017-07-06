object Raindrops {
    fun convert(input: Int): String {
        val rules = sequenceOf(
                Rule(3 to "Pling"),
                Rule(5 to "Plang"),
                Rule(7 to "Plong")
        )

        val result = rules
                .filter { it.appliesTo(input) }
                .map { it.result }
                .joinToString("")
        return if (result.isNotEmpty()) result else input.toString()
    }

}

class Rule(val pair: Pair<Int, String>) {
    val result = pair.second

    fun appliesTo(input: Int): Boolean {
        return input.isDivisibleBy(pair.first)
    }
    private fun Int.isDivisibleBy(denominator: Int) = this % denominator == 0
}
