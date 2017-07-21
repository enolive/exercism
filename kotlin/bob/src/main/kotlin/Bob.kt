import rules.*

object Bob {
    private val rules = sequenceOf(
            Silence(),
            Yelling(),
            Question(),
            AnythingElse()
    )
    
    fun hey(statement: String?): String {
        return rules.filter { it.appliesTo(statement) }.first().answer
    }
}

