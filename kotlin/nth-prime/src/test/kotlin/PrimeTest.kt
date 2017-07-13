import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals
import kotlin.test.fail

class PrimeTest {


    @Test
    fun `first prime`() {
        assertEquals(2, Prime.nth(1))
    }

    @Test
    fun `second prime`() {
        assertEquals(3, Prime.nth(2))
    }

    @Test
    fun `sixth prime`() {
        assertEquals(13, Prime.nth(6))
    }

    @Test
    fun `big prime`() {
        assertEquals(104743, Prime.nth(10001))
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun undefinedPrime() {
        Prime.nth(0)
    }

}

