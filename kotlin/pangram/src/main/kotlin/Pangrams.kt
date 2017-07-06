object Pangrams {
    fun isPangram(sentence: String): Boolean {
        val alphabet = 'a'..'z'
        return sentence
                .toLowerCase()
                .filter { it in alphabet }
                .toSet()
                .count() == alphabet.count()
    }
}