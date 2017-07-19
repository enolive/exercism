object PigLatin {
    fun translate(input: String): String {
        val vowels = listOf("a", "e", "i", "o", "u")
        val specialConsonants = listOf("ch", "qu", "sch", "squ", "th", "thr")
        val consonants = ('a'..'z')
                .map { it.toString() }
                .minus(vowels)
                .plus(specialConsonants)

        val startingConsonant = consonants
                .filter { input.startsWith(it) }
                .sortedBy { it.length }
                .reversed()
                .firstOrNull()
        if (startingConsonant != null) {
            return input.drop(startingConsonant.length) + input.take(startingConsonant.length) + "ay"
        }

        return input + "ay"
    }

}