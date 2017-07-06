object Scrabble {
    fun scoreWord(input: String): Int {
        return input
                .filter { !it.isWhitespace() }
                .map { Letter(it).score() }
                .sum()
    }

}

