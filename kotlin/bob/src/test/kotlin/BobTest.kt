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

    @Test
    fun `question with only numbers`() {
        assertEquals("Sure.", Bob.hey("4?"))
    }

    @Test
    fun `shouting with special characters`() {
        assertEquals("Whoa, chill out!", Bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"))
    }

    @Test
    fun `shouting with umlauts`() {
        assertEquals("Whoa, chill out!", Bob.hey("ÜMLÄÜTS!"))
    }

    @Test
    fun `calmly speaking with umlauts`() {
        assertEquals("Whatever.", Bob.hey("ÜMLäÜTS!"))
    }

    @Test
    fun `shouting with no exclamation mark`() {
        assertEquals("Whoa, chill out!", Bob.hey("I HATE YOU"))
    }

    @Test
    fun `statement containing question mark`() {
        assertEquals("Whatever.", Bob.hey("Ending with ? means a question."))
    }

    @Test
    fun `prattling on`() {
        assertEquals("Sure.", Bob.hey("Wait! Hang on. Are you going to be OK?"))
    }

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

