object PigLatin {
    val treatLikeVowel = listOf("yt", "xr")
    val vowels = listOf("a", "e", "i", "o", "u") + treatLikeVowel
    val treatLikeConsonant = listOf("ch", "qu", "sch", "squ", "th", "thr")
    val consonants = ('a'..'z')
            .map { it.toString() } - vowels + treatLikeConsonant

    fun translate(input: String): String {
        val space = " "
        return input.toLowerCase()
                .split(space)
                .map(this::translateWord)
                .joinToString(space)
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