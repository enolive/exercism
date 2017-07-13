object Prime {
    fun nth(i: Int): Int {
        val primes = sequenceOf(2, 3)
        return primes.elementAt(i - 1)
    }

}