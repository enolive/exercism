object Bob {
    fun hey(statement: String): String {
        return when {
            statement.isBlank() -> "Fine. Be that way!"
            statement.isYelling() -> "Whoa, chill out!"
            statement.isQuestion() -> "Sure."
            else -> "Whatever."
        }

    }

    private fun String.isYelling(): Boolean {
        return this.any { it.isLetter() } && this == this.toUpperCase()
    }

    private fun String.isQuestion(): Boolean {
        return this.endsWith("?")
    }

}