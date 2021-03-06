import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

/*
 * version: 1.0.0
 */
class DiamondPrinterTest {

    private lateinit var diamondPrinter: DiamondPrinter

    @Before
    fun setUp() {
        diamondPrinter = DiamondPrinter()
    }

    @Test
    fun `one by one diamond`() {
        val output = diamondPrinter.printToList('A')
        assertThat(output, `is`(listOf("A")))
    }

    @Test
    fun `two by two diamond`() {
        val output = diamondPrinter.printToList('B')
        assertThat(output, `is`(listOf(
                " A ",
                "B B",
                " A ")))
    }

    @Test
    fun `three by three diamond`() {
        val output = diamondPrinter.printToList('C')
        assertThat(output, `is`(listOf(
                "  A  ",
                " B B ",
                "C   C",
                " B B ",
                "  A  ")))
    }

    @Test
    fun `five by five diamond`() {
        val output = diamondPrinter.printToList('E')
        assertThat(output, `is`(listOf(
                "    A    ",
                "   B B   ",
                "  C   C  ",
                " D     D ",
                "E       E",
                " D     D ",
                "  C   C  ",
                "   B B   ",
                "    A    ")))
    }

    @Test
    fun `full diamond`() {
        val output = diamondPrinter.printToList('Z')
        assertThat(output, `is`(listOf(
                "                         A                         ",
                "                        B B                        ",
                "                       C   C                       ",
                "                      D     D                      ",
                "                     E       E                     ",
                "                    F         F                    ",
                "                   G           G                   ",
                "                  H             H                  ",
                "                 I               I                 ",
                "                J                 J                ",
                "               K                   K               ",
                "              L                     L              ",
                "             M                       M             ",
                "            N                         N            ",
                "           O                           O           ",
                "          P                             P          ",
                "         Q                               Q         ",
                "        R                                 R        ",
                "       S                                   S       ",
                "      T                                     T      ",
                "     U                                       U     ",
                "    V                                         V    ",
                "   W                                           W   ",
                "  X                                             X  ",
                " Y                                               Y ",
                "Z                                                 Z",
                " Y                                               Y ",
                "  X                                             X  ",
                "   W                                           W   ",
                "    V                                         V    ",
                "     U                                       U     ",
                "      T                                     T      ",
                "       S                                   S       ",
                "        R                                 R        ",
                "         Q                               Q         ",
                "          P                             P          ",
                "           O                           O           ",
                "            N                         N            ",
                "             M                       M             ",
                "              L                     L              ",
                "               K                   K               ",
                "                J                 J                ",
                "                 I               I                 ",
                "                  H             H                  ",
                "                   G           G                   ",
                "                    F         F                    ",
                "                     E       E                     ",
                "                      D     D                      ",
                "                       C   C                       ",
                "                        B B                        ",
                "                         A                         ")))
    }

}
