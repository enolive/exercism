import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class `Bob Tests` {

    @Test
    fun `say something`() {
        assertThat(Bob.hey("Tom-ay-to, tom-aaaah-to.")).isEqualTo("Whatever.")
    }

    @Test
    fun shouting() {
        assertThat(Bob.hey("WATCH OUT!")).isEqualTo("Whoa, chill out!")
    }

    @Test
    fun `asking a question`() {
        assertThat(Bob.hey("Does this cryogenic chamber make me look fat?")).isEqualTo("Sure.")
    }

    @Test
    fun `asking a numeric question`() {
        assertThat(Bob.hey("You are, what, like 15?")).isEqualTo("Sure.")
    }

    @Test
    fun `talking forcefully`() {
        assertThat(Bob.hey("Let's go make out behind the gym!")).isEqualTo("Whatever.")
    }

    @Test
    fun `using acronyms in regular speech`() {
        assertThat(Bob.hey("It's OK if you don't want to go to the DMV.")).isEqualTo("Whatever.")
    }

    @Test
    fun `forceful questions`() {
        assertThat(Bob.hey("WHAT THE HELL WERE YOU THINKING?")).isEqualTo("Whoa, chill out!")
    }

    @Test
    fun `shouting numbers`() {
        assertThat(Bob.hey("1, 2, 3 GO!")).isEqualTo("Whoa, chill out!")
    }

    @Test
    fun `only numbers`() {
        assertThat(Bob.hey("1, 2, 3")).isEqualTo("Whatever.")
    }

    @Test
    fun `question with only numbers`() {
        assertThat(Bob.hey("4?")).isEqualTo("Sure.")
    }

    @Test
    fun `shouting with special characters`() {
        assertThat(Bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!")).isEqualTo("Whoa, chill out!")
    }

    @Test
    fun `shouting with umlauts`() {
        assertThat(Bob.hey("ÜMLÄÜTS!")).isEqualTo("Whoa, chill out!")
    }

    @Test
    fun `calmly speaking with umlauts`() {
        assertThat(Bob.hey("ÜMLäÜTS!")).isEqualTo("Whatever.")
    }

    @Test
    fun `shouting with no exclamation mark`() {
        assertThat(Bob.hey("I HATE YOU")).isEqualTo("Whoa, chill out!")
    }

    @Test
    fun `statement containing question mark`() {
        assertThat(Bob.hey("Ending with ? means a question.")).isEqualTo("Whatever.")
    }

    @Test
    fun `prattling on`() {
        assertThat(Bob.hey("Wait! Hang on. Are you going to be OK?")).isEqualTo("Sure.")
    }

    @Test
    fun silence() {
        assertThat(Bob.hey("")).isEqualTo("Fine. Be that way!")
    }

    @Test
    fun `prolonged silence`() {
        assertThat(Bob.hey("    ")).isEqualTo("Fine. Be that way!")
    }

    @Test
    fun `saying nothing`() {
        assertThat(Bob.hey(null)).isEqualTo("Fine. Be that way!")
    }
}

