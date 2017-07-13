import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

/*
 * version: 1.1.0
 */
class HandshakeCalculatorTest {

    @Test
    fun `input 1 yields a wink`() {
        assertEquals(
            listOf(Signal.WINK),
            HandshakeCalculator.calculateHandshake(1))
    }

    @Test
    fun `input 2 yields a double blink`() {
        assertEquals(
            listOf(Signal.DOUBLE_BLINK),
            HandshakeCalculator.calculateHandshake(2))
    }

    @Test
    fun `input 4 yields a close your eyes`() {
        assertEquals(
            listOf(Signal.CLOSE_YOUR_EYES),
            HandshakeCalculator.calculateHandshake(4))
    }

    @Test
    fun `input 8 yields a jump`() {
        assertEquals(
            listOf(Signal.JUMP),
            HandshakeCalculator.calculateHandshake(8))
    }

    @Test
    fun `input that yields two actions`() {
        assertEquals(
            listOf(Signal.WINK, Signal.DOUBLE_BLINK),
            HandshakeCalculator.calculateHandshake(3))
    }

    @Test
    fun `input that yields two reversed actions`() {
        assertEquals(
            listOf(Signal.DOUBLE_BLINK, Signal.WINK),
            HandshakeCalculator.calculateHandshake(19))
    }

    @Test
    fun `a single action yields the same action`() {
        assertEquals(
            listOf(Signal.JUMP),
            HandshakeCalculator.calculateHandshake(24))
    }

    @Test
    fun `reversing no actions yields no actions`() {
        assertEquals(
            emptyList(),
            HandshakeCalculator.calculateHandshake(16))
    }

    @Test
    fun `input that yields all actions`() {
        assertEquals(
            listOf(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP),
            HandshakeCalculator.calculateHandshake(15))
    }

    @Ignore
    @Test
    fun testInputThatYieldsAllActionsReversed() {
        assertEquals(
            listOf(Signal.JUMP, Signal.CLOSE_YOUR_EYES, Signal.DOUBLE_BLINK, Signal.WINK),
            HandshakeCalculator.calculateHandshake(31))
    }

    @Ignore
    @Test
    fun testThatInput0YieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator.calculateHandshake(0))
    }

    @Ignore
    @Test
    fun testThatInputWithLower5BitsNotSetYieldsNoActions() {
        assertEquals(
            emptyList(),
            HandshakeCalculator.calculateHandshake(32))
    }

}

