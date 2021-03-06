object PigLatin {
    val vowels = listOf("a", "e", "i", "o", "u") + listOf("yt", "xr")
    val compounds = listOf("ch", "qu", "sch", "squ", "th", "thr").sortedDescending()
    val wordDelimiter = " "

    fun translate(input: String): String {
        return input.toLowerCase()
                .split(wordDelimiter)
                .map(this::translateWord)
                .joinToString(wordDelimiter)
    }

    private fun translateWord(input: String): String {
        val swapLength = when {
            vowels.any { input.startsWith(it) } -> 0
            else -> lengthOfStartingConsonant(input)
        }
        return "${input.drop(swapLength)}${input.take(swapLength)}ay"
    }

    private fun lengthOfStartingConsonant(input: String): Int {
        return compounds
                .filter { input.startsWith(it) }
                .map { it.length }
                .firstOrNull() ?: 1
    }

}