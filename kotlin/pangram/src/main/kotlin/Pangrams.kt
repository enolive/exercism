object Pangrams {
    fun isPangram(sentence: String): Boolean {
        val allCharacters = 'a'..'z'
        return allCharacters.all { c -> sentence.contains(c, false) }
    }

}