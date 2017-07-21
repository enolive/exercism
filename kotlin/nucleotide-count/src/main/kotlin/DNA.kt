class DNA(private val value: String) {

    val nucleotideCounts: Map<Char, Int>
    private val nucleotides = setOf('A', 'C', 'G', 'T')

    init {
        require(value.all { it.isValid() })
        nucleotideCounts = nucleotides
                .associate { nucleotide -> nucleotide to value.count { it == nucleotide } }
    }
    
    fun count(nucleotide: Char): Int {
        require(nucleotide.isValid())
        return nucleotideCounts.getValue(nucleotide)
    }

    private fun Char.isValid() = nucleotides.contains(this)
}