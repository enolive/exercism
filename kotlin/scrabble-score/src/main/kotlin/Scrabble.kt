object Scrabble {
    fun scoreWord(input: String): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        return input.map { Letter(it).score() }
                .sum()
        
        val letter = Letter(input[0])
        var score = letter.score()

        return score
    }

}

class Letter(private val value: Char) {
    fun score(): Int {
        return when (value) {
            'a', 'e' -> 1
            'f' -> 4
            else -> {
                throw IllegalArgumentException("invalid letter '$value'")
            }
        }
    }

}
