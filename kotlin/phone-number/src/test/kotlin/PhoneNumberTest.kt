import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail

class PhoneNumberTest {

    @Test
    fun `cleans number`() {
        val expectedNumber = "2234567890"
        val actualNumber = PhoneNumber("(223) 456-7890").number

        assertEquals(expectedNumber, actualNumber)
    }

    @Test
    fun `cleans number with dots`() {
        val expectedNumber = "2234567890"
        val actualNumber = PhoneNumber("223.456.7890").number

        assertEquals(expectedNumber, actualNumber)
    }

    @Test
    fun `valid when 11 digits and first is 1`() {
        val expectedNumber = "2234567890"
        val actualNumber = PhoneNumber("12234567890").number

        assertEquals(expectedNumber, actualNumber)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `invalid when 10 digits and first is 1`() {
        PhoneNumber("1234567890")

        fail("IllegalArgumentException should have been thrown")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `invalid when only 11 digits`() {
        PhoneNumber("21234567890")

        fail("IllegalArgumentException should have been thrown")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `invalid when 9 digits`() {
        PhoneNumber("223456789")

        fail("IllegalArgumentException should have been thrown")
    }

    @Test
    fun `area code`() {
        val expectedAreaCode = "223"
        val actualAreaCode = PhoneNumber("2234567890").areaCode

        assertEquals(expectedAreaCode, actualAreaCode)
    }

    @Test
    fun `area code for 11 digits`() {
        val expectedAreaCode = "223"
        val actualAreaCode = PhoneNumber("12234567890").areaCode

        assertEquals(expectedAreaCode, actualAreaCode)
    }

    @Test
    fun `to string print`() {
        val expectedtoStringNumber = "(223) 456-7890"
        val actualtoStringNumber = PhoneNumber("2234567890").toString()

        assertEquals(expectedtoStringNumber, actualtoStringNumber)
    }

    @Test
    fun `to string print with full US-Phone number`() {
        val expectedtoStringNumber = "(223) 456-7890"
        val actualtoStringNumber = PhoneNumber("12234567890").toString()

        assertEquals(expectedtoStringNumber, actualtoStringNumber)
    }

}

