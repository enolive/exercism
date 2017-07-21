object WordCount {
    fun phrase(phrase: String): Map<String, Int> {
        val words = phrase
                .toLowerCase()
                .filter { it.isRelevant() }
                .split(Regex(" +"))
        return words.groupingBy { it }.eachCount()
    }

    private fun Char.isRelevant() = isWhitespace() || isLetterOrDigit() || this == '\''

}