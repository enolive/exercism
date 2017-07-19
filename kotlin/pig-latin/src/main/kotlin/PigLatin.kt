object PigLatin {
    fun translate(input: String): String {
        val treatLikeVowel = listOf("yt", "xr")
        val vowels = listOf("a", "e", "i", "o", "u") + treatLikeVowel
        val treatLikeConsonant = listOf("ch", "qu", "sch", "squ", "th", "thr")
        val consonants = ('a'..'z')
                .map { it.toString() } - vowels + treatLikeConsonant

        if (vowels.any { input.startsWith(it) }) {
            return input + "ay"
        }
        
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