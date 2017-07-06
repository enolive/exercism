object Acronym {
    fun generate(phrase: String): String {
        return phrase.indices
                .filter { i -> phrase.wordStartsAt(i) }
                .map { i -> phrase[i].toUpperCase() }
                .joinToString("")
    }

    private fun String.wordStartsAt(i: Int): Boolean {
        if (i == 0) {
            return true
        }
        if (this[i - 1] == ' ') {
            return true
        }
        if (this[i].isUpperCase() && this[i - 1].isLowerCase()) {
            return true
        }
        
        return false
    }
}