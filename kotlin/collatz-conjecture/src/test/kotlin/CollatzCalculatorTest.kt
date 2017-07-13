import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.test.assertEquals

/*
 * version: 1.1.0
 */
class CollatzCalculatorTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun `zero steps required when starting from`() {
        assertEquals(0, CollatzCalculator.computeStepCount(1))
    }

    @Test
    fun `correct number of steps when all steps are divisions`() {
        assertEquals(4, CollatzCalculator.computeStepCount(16))
    }

    @Test
    fun `correct number of steps when both step types are needed`() {
        assertEquals(9, CollatzCalculator.computeStepCount(12))
    }

    @Test
    fun `a very large input`() {
        assertEquals(152, CollatzCalculator.computeStepCount(1000000))
    }

    @Test
    fun `zero is considered invalid input`() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Only natural numbers are allowed")

        CollatzCalculator.computeStepCount(0)
    }

    @Test
    fun `negative integer is considered invalid input`() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Only natural numbers are allowed")

        CollatzCalculator.computeStepCount(-15)
    }

}


