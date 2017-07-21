package rules

class AnythingElse : Rule {
    override val answer: String
        get() = "Whatever."

    override fun appliesTo(statement: String?): Boolean {
        return true
    }

}