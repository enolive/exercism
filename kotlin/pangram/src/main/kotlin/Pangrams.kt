object Pangrams {
    fun isPangram(sentence: String): Boolean {
        val alphabet = 'a'..'z'
        return alphabet.all { c -> sentence.contains(c, ignoreCase = true) }
    }

}