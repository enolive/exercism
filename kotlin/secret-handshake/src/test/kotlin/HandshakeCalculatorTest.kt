import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/*
 * version: 1.1.0
 */
class `Calculate Handshake` {

    @Test
    fun `input 1 yields a wink`() {
        assertThat(HandshakeCalculator.calculateHandshake(1)).isEqualTo(listOf(Signal.WINK))
    }

    @Test
    fun `input 2 yields a double blink`() {
        assertThat(HandshakeCalculator.calculateHandshake(2)).isEqualTo(listOf(Signal.DOUBLE_BLINK))
    }

    @Test
    fun `input 4 yields a close your eyes`() {
        assertThat(HandshakeCalculator.calculateHandshake(4)).isEqualTo(listOf(Signal.CLOSE_YOUR_EYES))
    }

    @Test
    fun `input 8 yields a jump`() {
        assertThat(HandshakeCalculator.calculateHandshake(8)).isEqualTo(listOf(Signal.JUMP))
    }

    @Test
    fun `input that yields two actions`() {
        assertThat(HandshakeCalculator.calculateHandshake(3)).isEqualTo(listOf(Signal.WINK, Signal.DOUBLE_BLINK))
    }

    @Test
    fun `input that yields two reversed actions`() {
        assertThat(HandshakeCalculator.calculateHandshake(19)).isEqualTo(listOf(Signal.DOUBLE_BLINK, Signal.WINK))
    }

    @Test
    fun `a single action yields the same action`() {
        assertThat(HandshakeCalculator.calculateHandshake(24)).isEqualTo(listOf(Signal.JUMP))
    }

    @Test
    fun `reversing no actions yields no actions`() {
        assertThat(HandshakeCalculator.calculateHandshake(16)).isEmpty()
    }

    @Test
    fun `input that yields all actions`() {
        assertThat(HandshakeCalculator.calculateHandshake(15)).
                isEqualTo(listOf(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP))
    }

    @Test
    fun `input that yields all actions reversed`() {
        assertThat(HandshakeCalculator.calculateHandshake(31))
                .isEqualTo(listOf(Signal.JUMP, Signal.CLOSE_YOUR_EYES, Signal.DOUBLE_BLINK, Signal.WINK))
    }

    @Test
    fun `input 0 yields no actions`() {
        assertThat(HandshakeCalculator.calculateHandshake(0)).isEmpty()
    }

    @Test
    fun `input with lower 5 bits not set yields no actions`() {
        assertThat(HandshakeCalculator.calculateHandshake(32)).isEmpty()
    }

}

