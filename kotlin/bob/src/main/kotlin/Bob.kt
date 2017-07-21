object Bob {
    private val rules = listOf(
            Silence(),
            Yelling(),
            Question(),
            AnythingElse()
    )
    
    fun hey(statement: String?): String {
        return rules.filter { it.appliesTo(statement) }.first().answer
    }
}

