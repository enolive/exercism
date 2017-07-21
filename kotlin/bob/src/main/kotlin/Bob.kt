object Bob {
    fun hey(statement: String): String {
        return when {
            statement.isYelling() -> "Whoa, chill out!"
            statement.isQuestion() -> "Sure."
            else -> "Whatever."
        }

    }

    private fun String.isYelling(): Boolean {
        if (this.all { !it.isLetter() }) {
            return false
        }
        
        return this == this.toUpperCase()
    }

    private fun String.isQuestion(): Boolean {
        return this.endsWith("?")
    }

}