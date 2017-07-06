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
            previousIsSpace(i) -> return true
            previousIsHyphen(i) -> return true
            previousIsLowerCase(i) -> return true
            else -> return false
        }
    }

    private fun String.previousIsLowerCase(i: Int) = this[i].isUpperCase() && this[i - 1].isLowerCase()

    private fun String.previousIsHyphen(i: Int): Boolean = this[i - 1] == '-'

    private fun String.previousIsSpace(i: Int): Boolean = this[i - 1] == ' '

    private fun firstLetterInSentence(i: Int) = i == 0
}