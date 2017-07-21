class DNA(private val value: String) {
    private val nucleotides = listOf('A', 'C', 'G', 'T')

    val nucleotideCounts: Map<Char, Int> = nucleotides
            .associateBy({ it }, { nucleotide -> value.count { it == nucleotide } })
    
    fun count(nucleotide: Char): Int {
        return nucleotideCounts.getValue(nucleotide)
    }
}