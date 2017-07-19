object PigLatin {
    fun translate(input: String): String {
        val consonants = listOf("p", "k", "x", "y")
        
        if (consonants.any { input.startsWith(it) }) {
            return input.drop(1) + input.take(1) + "ay"
        }
        
        return input + "ay"
    }

}