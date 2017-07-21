object Bob {
    fun hey(statement: String): String {
        if (statement.isYelling()) {
            return "Whoa, chill out!"
        }

        if (statement.isQuestion()) {
            return "Sure."
        }

        return "Whatever."
    }

    private fun String.isYelling() = this == "WATCH OUT!"

    private fun String.isQuestion(): Boolean {
        return this.endsWith("?")
    }

}