object Acronym {
    fun generate(phrase: String): String {
        return phrase.indices
                .filter { i -> phrase.wordStartsAt(i) }
                .map { i -> phrase[i].toUpperCase() }
                .joinToString("")
    }

    private fun String.wordStartsAt(i: Int) = i == 0 || this[i - 1] == ' '
}