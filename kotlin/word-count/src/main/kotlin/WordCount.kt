object WordCount {
    fun phrase(phrase: String): Map<String, Int> {
        val words = phrase
                .toLowerCase()
                .filter { it.isRelevant() }
                .split(' ')
                .filter { !it.isBlank() }
        return words.groupBy { it }
                .map { it.key to it.value.size }
                .toMap()
    }

    private fun Char.isRelevant() = isWhitespace() || isLetterOrDigit() || this == '\''

}