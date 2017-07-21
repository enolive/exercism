import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class WordCountTest {


    @Test
    fun `count one word`() {
        val expectedWordCount = mapOf("word" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("word"))
    }

    @Test
    fun `count one of each`() {
        val expectedWordCount = mapOf("one" to 1, "of" to 1, "each" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("one of each"))
    }

    @Test
    fun `count multiple occurences`() {
        val expectedWordCount = mapOf("one" to 1, "fish" to 4, "two" to 1, "red" to 1, "blue" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("one fish two fish red fish blue fish"))
    }

    @Test
    fun `ignore punctuation`() {
        val expectedWordCount = mapOf("car" to 1, "carpet" to 1, "as" to 1, "java" to 1, "javascript" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("car : carpet as java : javascript!!&@$%^&"))

    }

    @Test
    fun `include numbers`() {
        val expectedWordCount = mapOf("testing" to 2, "1" to 1, "2" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("testing, 1, 2 testing"))
    }

    @Ignore
    @Test
    fun normalizeCase() {
        val expectedWordCount = mapOf("go" to 3)

        assertEquals(expectedWordCount, WordCount.phrase("go Go GO"))
    }

    @Ignore
    @Test
    fun allowApostrophes() {
        val expectedWordCount = mapOf("first" to 1, "don't" to 2, "laugh" to 1, "then" to 1, "cry" to 1)

        assertEquals(expectedWordCount, WordCount.phrase("First: don't laugh. Then: don't cry."))
    }

}

