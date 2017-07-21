package rules

class Silence : Rule {
    override val answer: String
        get() = "Fine. Be that way!"
    
    override fun appliesTo(statement: String?): Boolean {
        return statement.saysNothing()
    }

    private fun String?.saysNothing() = isNullOrBlank()

}