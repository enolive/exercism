interface Rule {
    fun appliesTo(statement: String?): Boolean
    val answer: String
}