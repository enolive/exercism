class DNA(private val value: String) {
    private val nucleotides = listOf('A', 'C', 'G', 'T')

    init {
        require(value.all { it.isValid() })
    }

    val nucleotideCounts: Map<Char, Int> = nucleotides
            .associateBy({ it }, { nucleotide -> value.count { it == nucleotide } })

    fun count(nucleotide: Char): Int {
        require(nucleotide.isValid())
        return nucleotideCounts.getValue(nucleotide)
    }

    private fun Char.isValid() = nucleotides.contains(this)
}