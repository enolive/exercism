object PigLatin {
    fun translate(input: String): String {
        val consonants = listOf("ch", "p", "qu", "squ", "th", "k", "x", "y")

        val foundConsonant = consonants.firstOrNull { input.startsWith(it) }
        if (foundConsonant != null) {
            return input.drop(foundConsonant.length) + input.take(foundConsonant.length) + "ay"
        }
        
        return input + "ay"
    }

}