private const val NUCLEOTIDES = "AGCT"

class DNA(private val value: String) {

    val nucleotideCounts: Map<Char, Int>

    init {
        require(value.all { it.isValid() })
        nucleotideCounts = NUCLEOTIDES
                .associate { nucleotide -> nucleotide to value.count { it == nucleotide } }
    }
    
    fun count(nucleotide: Char): Int {
        require(nucleotide.isValid())
        return nucleotideCounts.getValue(nucleotide)
    }

    private fun Char.isValid() = this in NUCLEOTIDES
}