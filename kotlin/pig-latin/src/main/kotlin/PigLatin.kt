object PigLatin {
    val treatLikeVowel = listOf("yt", "xr")
    val vowels = listOf("a", "e", "i", "o", "u") + treatLikeVowel
    val treatLikeConsonant = listOf("ch", "qu", "sch", "squ", "th", "thr")
    val consonants = ('a'..'z')
            .map { it.toString() } - vowels + treatLikeConsonant
    val wordDelimiter = " "

    fun translate(input: String): String {
        return input.toLowerCase()
                .split(wordDelimiter)
                .map(this::translateWord)
                .joinToString(wordDelimiter)
    }

    private fun translateWord(input: String): String {
        val howMany = howManyCharactersToSwap(input)
        return "${input.drop(howMany)}${input.take(howMany)}ay"
    }

    private fun howManyCharactersToSwap(input: String): Int {
        return when {
            vowels.any { input.startsWith(it) } -> 0
            else -> lengthOfStartingConsonant(input)
        }
    }

    private fun lengthOfStartingConsonant(input: String): Int {
        return consonants
                .filter { input.startsWith(it) }
                .map { it.length }
                .sorted()
                .reversed()
                .first()
    }

}