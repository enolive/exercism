import org.junit.Test
import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import kotlin.test.assertEquals

@RunWith(Parameterized::class)
class ScrabbleScoreTest(val input: String, val expectedOutput: Int) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "{index}: scoreWord({0})={1}")
        fun data() = listOf(
                arrayOf("", 0),
                arrayOf(" \t\n", 0),
                arrayOf("a", 1),
                arrayOf("f", 4),
                arrayOf("major", 14),
                arrayOf("danger", 8),
                arrayOf("street", 6),
                arrayOf("quirky", 22),
                arrayOf("OXYPHENBUTAZONE", 41),
                arrayOf("alacrity", 13),
                arrayOf("preview", 15)
        )
    }


    @Test
    fun test() {
        assertEquals(expectedOutput, Scrabble.scoreWord(input))
    }
}

