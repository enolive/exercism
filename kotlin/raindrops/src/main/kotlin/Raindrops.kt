object Raindrops {
    private val rules = sequenceOf(
            Rule(3 to "Pling"),
            Rule(5 to "Plang"),
            Rule(7 to "Plong")
    )

    fun convert(input: Int): String {
        return rules
                .filter { it.appliesTo(input) }
                .map { it.result }
                .joinToString("")
                .ifBlank { input.toString() }
    }

    private fun String.ifBlank(alternative: () -> String) = if (isNotEmpty()) this else alternative()
}

