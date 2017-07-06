object Scrabble {
    fun scoreWord(input: String): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        return input
                .map { Letter(it).score() }
                .sum()
    }

}

class Letter(private val value: Char) {
    fun score(): Int {
        return when (value) {
            'a', 'e', 'r', 's', 't' -> 1
            'f' -> 4
            else -> {
                throw IllegalArgumentException("invalid letter '$value'")
            }
        }
    }

}
