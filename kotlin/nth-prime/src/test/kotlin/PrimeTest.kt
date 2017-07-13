import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.Test

class PrimeTest {

    @Test
    fun `first prime`() {
        assertThat(Prime.nth(1)).isEqualTo(2)
    }

    @Test
    fun `second prime`() {
        assertThat(Prime.nth(2)).isEqualTo(3)
    }

    @Test
    fun `sixth prime`() {
        assertThat(Prime.nth(6)).isEqualTo(13)
    }

    @Test
    fun `big prime`() {
        assertThat(Prime.nth(10001)).isEqualTo(104743)
    }

    @Test
    fun `undefined prime`() {
        val which = IllegalArgumentException::class.java
        assertThatExceptionOfType(which).isThrownBy { Prime.nth(0) }
        assertThatExceptionOfType(which).isThrownBy { Prime.nth(-1) }
    }

}

