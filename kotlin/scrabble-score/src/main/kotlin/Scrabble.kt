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
            'a', 'e', 'i', 'r', 's', 't', 'u' -> 1
            'f', 'y' -> 4
            'k' -> 5
            'q' -> 10
            else -> {
                throw IllegalArgumentException("invalid letter '$value'")
            }
        }
    }

}
