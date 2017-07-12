object Sieve {
    fun primesUpTo(limit: Int): List<Int> 
            = (2..limit).filter { it.isPrime() }

    private fun Int.isPrime(): Boolean =
            (2..Math.sqrt(this.toDouble()).toInt())
                    .none { this % it == 0 }
}


