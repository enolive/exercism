import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class LuhnTest {

    @Test
    fun `single digit strings cannot be valid`() {
        assertThat(Luhn.isValid("1")).isFalse()
    }

    @Test
    fun `single zero is invalid`() {
        assertThat(Luhn.isValid("0")).isFalse()
    }

    @Test
    fun `simple valid SIN that remains valid if reversed`() {
        assertThat(Luhn.isValid("059")).isTrue()
        assertThat(Luhn.isValid("950")).isTrue()
    }

    @Test
    fun `simple valid SIN that becomes invalid if reversed`() {
        assertThat(Luhn.isValid("59")).isTrue()
        assertThat(Luhn.isValid("95")).isFalse()
    }

    @Test
    fun `valid canadian SIN`() {
        assertThat(Luhn.isValid("055 444 285")).isTrue()
    }

    @Test
    fun `invalid canadian SIN`() {
        assertThat(Luhn.isValid("055 444 286")).isFalse()
    }

    @Test
    fun `invalid credit card`() {
        assertThat(Luhn.isValid("8273 1232 7352 0569")).isFalse()
    }

    @Test
    fun `valid strings with non digit included become invalid`() {
        assertThat(Luhn.isValid("055a 444 285")).isFalse()
    }

    @Test
    fun `valid strings with punctuation included become invalid`() {
        assertThat(Luhn.isValid("055-444-285")).isFalse()
    }

    @Test
    fun `valid strings with commas included become invalid`() {
        assertThat(Luhn.isValid("055,444,285")).isFalse()
    }

    @Test
    fun `valid strings with symbols included become invalid`() {
        assertThat(Luhn.isValid("055£ 444$ 285")).isFalse()
    }

    @Test
    fun `single zero with space is invalid`() {
        assertThat(Luhn.isValid(" 0")).isFalse()
    }

    @Test
    fun `more than single zero is valid`() {
        assertThat(Luhn.isValid("0000 0")).isTrue()
    }

    @Test
    fun `input digit 9 is correctly converted to output digit9`() {
        assertThat(Luhn.isValid("091")).isTrue()
    }

}

