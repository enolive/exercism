import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import java.math.BigInteger
import kotlin.test.assertEquals

/*
 * version: 1.0.0
 */
class BoardTest {

    @Rule
    @JvmField
    var expectedException: ExpectedException = ExpectedException.none()

    @Test
    fun `square 1 contains correct number of grains`() {
        assertEquals(BigInteger.ONE, Board.getGrainCountForSquare(1))
    }

    @Test
    fun `square 2 contains correct number of grains`() {
        assertEquals(BigInteger.valueOf(2), Board.getGrainCountForSquare(2))
    }

    @Test
    fun `square 3 contains correct number of grains`() {
        assertEquals(BigInteger.valueOf(4), Board.getGrainCountForSquare(3))
    }

    @Ignore
    @Test
    fun testSquare4ContainsCorrectNumberOfGrains() {
        assertEquals(BigInteger.valueOf(8), Board.getGrainCountForSquare(4))
    }

    @Ignore
    @Test
    fun testSquare16ContainsCorrectNumberOfGrains() {
        assertEquals(BigInteger.valueOf(32768), Board.getGrainCountForSquare(16))
    }

    @Ignore
    @Test
    fun testSquare32ContainsCorrectNumberOfGrains() {
        assertEquals(BigInteger.valueOf(2147483648), Board.getGrainCountForSquare(32))
    }

    @Ignore
    @Test
    fun testSquare64ContainsCorrectNumberOfGrains() {
        assertEquals(BigInteger("9223372036854775808"), Board.getGrainCountForSquare(64))
    }

    @Ignore
    @Test
    fun testSquare0IsInvalid() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Only integers between 1 and 64 (inclusive) are allowed")

        Board.getGrainCountForSquare(0)
    }

    @Ignore
    @Test
    fun testNegativeSquareIsInvalid() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Only integers between 1 and 64 (inclusive) are allowed")

        Board.getGrainCountForSquare(-1)
    }

    @Ignore
    @Test
    fun testSquareGreaterThan64IsInvalid() {
        expectedException.expect(IllegalArgumentException::class.java)
        expectedException.expectMessage("Only integers between 1 and 64 (inclusive) are allowed")

        Board.getGrainCountForSquare(65)
    }

    @Ignore
    @Test
    fun testBoardContainsCorrectNumberOfGrains() {
        assertEquals(BigInteger("18446744073709551615"), Board.getTotalGrainCount())
    }

}

