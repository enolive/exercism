object WordCount {
    fun phrase(phrase: String): Map<String, Int> {
        val words = phrase
                .filter { it.isWhitespace() || it.isLetterOrDigit() }
                .split(' ')
                .filter { !it.isBlank() }
        return words.groupBy { it }
                .map { it.key to it.value.size }
                .toMap()
    }

}