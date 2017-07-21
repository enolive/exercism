import rules.AnythingElse
import rules.Question
import rules.Silence
import rules.Yelling

object Bob {
    private val rules = sequenceOf(
            Silence(),
            Yelling(),
            Question(),
            AnythingElse()
    )

    fun hey(statement: String?): String =
            rules.filter { it.appliesTo(statement) }
                    .first().answer
}

