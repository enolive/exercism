
import org.junit.Test
import org.junit.Ignore

class SeriesInvalidInputTest {


    @Test(expected = IllegalArgumentException::class)
    fun `non digit characters`() {
        Series("1234a5")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `negative span`() {
        Series("12345").getLargestProduct(-1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `span larger than string size`() {
        Series("123").getLargestProduct(4)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `span larger than string size using empty string`() {
        Series("").getLargestProduct(1)
    }
}
