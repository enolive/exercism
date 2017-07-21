package rules

class Question : Rule {
    override val answer: String
        get() = "Sure."

    override fun appliesTo(statement: String?): Boolean {
        return statement.isQuestion()
    }

    private fun String?.isQuestion(): Boolean {
        return this != null && this.endsWith("?")
    }

}