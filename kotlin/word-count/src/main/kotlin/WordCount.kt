object WordCount {
    fun phrase(phrase: String): Map<String, Int> {
        val words = phrase.filter { it.isWhitespace() || it.isLetter() }.split(' ')
        return words.groupBy { it }
                .map { it.key to it.value.size }
                .toMap()
    }

}