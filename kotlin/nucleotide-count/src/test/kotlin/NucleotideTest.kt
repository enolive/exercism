import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals

class NucleotideTest {

    @Test
    fun `empty dna string has no adenosine`() {
        val dna = DNA("")

        assertEquals(0, dna.count('A'))
    }

    @Test
    fun `empty dna string has no nucleotides`() {
        val dna = DNA("")
        val expected = mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0)

        assertEquals(expected, dna.nucleotideCounts)
    }

    @Test
    fun `repetitive cytidine gets counted`() {
        val dna = DNA("CCCCC")
        assertEquals(5, dna.count('C'))
    }

    @Test
    fun `repetitive sequence with only guanosine`() {
        val dna = DNA("GGGGGGGG")
        val expected = mapOf('A' to 0, 'C' to 0, 'G' to 8, 'T' to 0)

        assertEquals(expected, dna.nucleotideCounts)
    }

    @Ignore
    @Test
    fun countsOnlyThymidine() {
        val dna = DNA("GGGGGTAACCCGG")

        assertEquals(1, dna.count('T'))
    }

    @Ignore
    @Test
    fun countsANucleotideOnlyOnce() {
        val dna = DNA("CGATTGGG")

        dna.count('T')
        assertEquals(2, dna.count('T'))
    }

    @Ignore
    @Test
    fun dnaCountsDoNotChangeAfterCountingAdenosine() {
        val dna = DNA("GATTACA")
        val expected = mapOf('A' to 3, 'C' to 1, 'G' to 1, 'T' to 2)

        dna.count('A')
        assertEquals(expected, dna.nucleotideCounts)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun validatesNucleotides() {
        DNA("GX")
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun validatesNucleotidesCountInput() {
        DNA("GACT").count('X')
    }

    @Ignore
    @Test
    fun countsAllNucleotides() {
        val dna = DNA("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")
        val expected = mapOf('A' to 20, 'C' to 12, 'G' to 17, 'T' to 21)

        assertEquals(expected, dna.nucleotideCounts)
    }
}

