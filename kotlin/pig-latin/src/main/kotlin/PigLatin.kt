object PigLatin {
    fun translate(input: String): String {
        val consonants = listOf("ch", "p", "qu", "k", "x", "y")

        val any = consonants.firstOrNull { input.startsWith(it) }
        if (any != null) {
            return input.drop(any.length) + input.take(any.length) + "ay"
        }
        
        return input + "ay"
    }

}