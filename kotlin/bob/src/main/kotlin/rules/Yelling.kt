package rules

class Yelling : Rule {
    override val answer: String
        get() = "Whoa, chill out!"

    override fun appliesTo(statement: String?): Boolean {
        return statement.isYelling()
    }

    private fun String?.isYelling(): Boolean {
        return this != null && this.any { it.isLetter() } && this == this.toUpperCase()
    }
}