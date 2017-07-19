object PigLatin {
    fun translate(input: String): String {
        val vowels = listOf("a", "e", "i", "o", "u")
        val specialConsonants = listOf("ch", "qu", "squ", "th")
        val consonants = ('a'..'z').map { it.toString() }.minus(vowels).plus(specialConsonants)

        val foundConsonant = consonants
                .filter { input.startsWith(it) }
                .sortedBy { it.length }
                .reversed()
                .firstOrNull()
        if (foundConsonant != null) {
            return input.drop(foundConsonant.length) + input.take(foundConsonant.length) + "ay"
        }

        return input + "ay"
    }

}