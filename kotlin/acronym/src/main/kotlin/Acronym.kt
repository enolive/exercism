object Acronym {
    fun generate(phrase: String): String {
        return phrase.indices
                .filter { i -> phrase.wordStartsAt(i) }
                .map { i -> phrase[i].toUpperCase() }
                .joinToString("")
    }

    private fun String.wordStartsAt(i: Int): Boolean {
        when {
            firstLetterInSentence(i) -> return true
            previousIsBlank(i) -> return true
            previousIsLowerCase(i) -> return true
            else -> return false
        }

    }

    private fun String.previousIsLowerCase(i: Int) = this[i].isUpperCase() && this[i - 1].isLowerCase()

    private fun String.previousIsBlank(i: Int) = this[i - 1] in arrayOf(' ', '-')

    private fun firstLetterInSentence(i: Int) = i == 0
}