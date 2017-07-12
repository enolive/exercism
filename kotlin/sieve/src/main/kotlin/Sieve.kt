object Sieve {
    fun primesUpTo(limit: Int): List<Int> {
        val candidates = (2..limit)
                .map { it to Candidate(it) }
                .toMap()
        candidates.keys.forEach { first ->
            (first * 2 until limit + 1 step first)
                    .map { candidates.getValue(it) }
                    .forEach { it.markAsNotPrime() }
        }
        
        return candidates.values
                .filter { it.isPrime }
                .map { it.number }
    }

}

