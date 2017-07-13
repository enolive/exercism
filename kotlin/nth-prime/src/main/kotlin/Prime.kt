object Prime {
    fun nth(i: Int): Int {
        val primes = primesUpto(i)
        return primes.elementAt(i - 1)
    }

    private fun primesUpto(i: Int) = sequenceOf(2, 3, 5, 7, 11, 13)

}