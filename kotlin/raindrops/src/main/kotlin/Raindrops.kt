object Raindrops {
    private val rules = sequenceOf(
            Rule(3 to "Pling"),
            Rule(5 to "Plang"),
            Rule(7 to "Plong")
    )

    fun convert(input: Int): String {
        val result = rules
                .filter { it.appliesTo(input) }
                .map { it.result }
                .joinToString("")
        return if (result.isNotEmpty()) result else input.toString()
    }

}

