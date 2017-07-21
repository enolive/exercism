import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class `Bob Tests` {


    @Test
    fun `say something`() {
        assertEquals("Whatever.", Bob.hey("Tom-ay-to, tom-aaaah-to."))
    }

    @Test
    fun shouting() {
        assertEquals("Whoa, chill out!", Bob.hey("WATCH OUT!"))
    }

    @Test
    fun `asking a question`() {
        assertEquals("Sure.", Bob.hey("Does this cryogenic chamber make me look fat?"))
    }

    @Test
    fun `asking a numeric question`() {
        assertEquals("Sure.", Bob.hey("You are, what, like 15?"))
    }

    @Test
    fun `talking forcefully`() {
        assertEquals("Whatever.", Bob.hey("Let's go make out behind the gym!"))
    }

    @Test
    fun `using acronyms in regular speech`() {
        assertEquals("Whatever.", Bob.hey("It's OK if you don't want to go to the DMV."))
    }

    @Test
    fun `forceful questions`() {
        assertEquals("Whoa, chill out!", Bob.hey("WHAT THE HELL WERE YOU THINKING?"))
    }

    @Test
    fun `shouting numbers`() {
        assertEquals("Whoa, chill out!", Bob.hey("1, 2, 3 GO!"))
    }

    @Test
    fun `only numbers`() {
        assertEquals("Whatever.", Bob.hey("1, 2, 3"))
    }

    @Ignore
    @Test
    fun questionWithOnlyNumbers() {
        assertEquals("Sure.", Bob.hey("4?"))
    }

    @Ignore
    @Test
    fun shoutingWithSpecialCharacters() {
        assertEquals("Whoa, chill out!", Bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"))
    }

    @Ignore
    @Test
    fun shoutingWithUmlauts() {
        assertEquals("Whoa, chill out!", Bob.hey("\u00dcML\u00c4\u00dcTS!"))
    }

    @Ignore
    @Test
    fun calmlySpeakingWithUmlauts() {
        assertEquals("Whatever.", Bob.hey("\u00dcML\u00e4\u00dcTS!"))
    }

    @Ignore
    @Test
    fun shoutingWithNoExclamationMark() {
        assertEquals("Whoa, chill out!", Bob.hey("I HATE YOU"))
    }

    @Ignore
    @Test
    fun statementContainingQuestionMark() {
        assertEquals("Whatever.", Bob.hey("Ending with ? means a question."))
    }

    @Ignore
    @Test
    fun prattlingOn() {
        assertEquals("Sure.", Bob.hey("Wait! Hang on. Are you going to be OK?"))
    }

    @Ignore
    @Test
    fun silence() {
        assertEquals("Fine. Be that way!", Bob.hey(""))
    }

    @Ignore
    @Test
    fun prolongedSilence() {
        assertEquals("Fine. Be that way!", Bob.hey("    "))
    }
}

