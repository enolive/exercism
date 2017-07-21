class DNA(private val value: String) {
    fun count(nucleotide: Char): Int {
        return value.count { it == nucleotide }
    }

    val nucleotideCounts: Map<Char, Int> = mapOf(
            'A' to 0,
            'C' to 0,
            'G' to count('G'),
            'T' to 0
    )

}