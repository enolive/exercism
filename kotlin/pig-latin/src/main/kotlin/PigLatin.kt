object PigLatin {
    fun translate(input: String): String {
        if (input.startsWith("p")) {
            return input.drop(1) + input.take(1) + "ay"
        }
        
        return input + "ay"
    }

}