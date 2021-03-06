import org.junit.Test
import org.junit.Ignore
import kotlin.test.assertEquals

class FlattenerTest {


    @Test
    fun `flattens a nested list`() {
        val nestedList = listOf<Any>(emptyList<Any>())
        assertEquals(emptyList<Any>(), Flattener.flatten(nestedList))
    }

    @Test
    fun `flattens 2 level nested list`() {
        val nestedList = listOf(1, listOf(2, 3, 4), 5)
        assertEquals(listOf(1, 2, 3, 4, 5), Flattener.flatten(nestedList))
    }

    @Test
    fun `flattens 3 level nested list`() {
        val nestedList = listOf(1, listOf(2, 3, 4), 5, listOf(6, listOf(7, 8)))
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8), Flattener.flatten(nestedList))
    }

    @Test
    fun `flattens 5 level nested list`() {
        val nestedList = listOf(0, 2, listOf(listOf(2, 3), 8, 100, 4, listOf(listOf(listOf(50))), -2))
        assertEquals(listOf(0, 2, 2, 3, 8, 100, 4, 50, -2), Flattener.flatten(nestedList))
    }

    @Test
    fun `flattens 6 level nested list`() {
        val nestedList = listOf(1, listOf(2, listOf(listOf(3)), listOf(4, listOf(listOf(5))), 6, 7), 8)
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8), Flattener.flatten(nestedList))
    }

    @Test
    fun `flattens 6 level nested list with nulls`() {
        val nestedList = listOf(1, listOf(2, null, listOf(listOf(3), null), listOf(4, listOf(listOf(5))), 6, 7, listOf(listOf(null))), 8, null)
        assertEquals(listOf(1, 2, 3, 4, 5, 6, 7, 8), Flattener.flatten(nestedList))
    }

    @Test
    fun `all null nested list returns empty list`() {
        val nestedList = listOf(null, listOf(null, listOf(null), listOf(listOf(listOf(null)))), null)
        assertEquals(emptyList<Any>(), Flattener.flatten(nestedList))
    }
}

