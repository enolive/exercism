import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LuhnTest {

    @Test
    fun `single digit strings cannot be valid`() {
        assertFalse(Luhn.isValid("1"))
    }

    @Test
    fun `single zero is invalid`() {
        assertFalse(Luhn.isValid("0"))
    }

    @Test
    fun `simple valid SIN that remains valid if reversed`() {
        assertTrue(Luhn.isValid("059"))
        assertTrue(Luhn.isValid("950"))
    }

    @Test
    fun `simple valid SIN that becomes invalid if reversed`() {
        assertTrue(Luhn.isValid("59"))
        assertFalse(Luhn.isValid("95"))
    }

    @Test
    fun `valid canadian SIN`() {
        assertTrue(Luhn.isValid("055 444 285"))
    }

    @Test
    fun `invalid canadian SIN`() {
        assertFalse(Luhn.isValid("055 444 286"))
    }

    @Test
    fun `invalid credit card`() {
        assertFalse(Luhn.isValid("8273 1232 7352 0569"))
    }

    @Test
    fun `valid strings with non digit included become invalid`() {
        assertFalse(Luhn.isValid("055a 444 285"))
    }

    @Test
    fun `valid strings with punctuation included become invalid`() {
        assertFalse(Luhn.isValid("055-444-285"))
    }

    @Test
    fun `valid strings with commas included become invalid`() {
        assertFalse(Luhn.isValid("055,444,285"))
    }

    @Test
    fun `valid strings with symbols included become invalid`() {
        assertFalse(Luhn.isValid("055£ 444$ 285"))
    }

    @Test
    fun `single zero with space is invalid`() {
        assertFalse(Luhn.isValid(" 0"))
    }

    @Test
    fun `more than single zero is valid`() {
        assertTrue(Luhn.isValid("0000 0"))
    }

    @Test
    fun `input digit 9 is correctly converted to output digit9`() {
        assertTrue(Luhn.isValid("091"))
    }

}

