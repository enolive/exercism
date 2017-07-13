object Prime {
    fun nth(i: Int): Int {
        return primes().elementAt(i - 1)
    }

    private fun primes(): Sequence<Int> {
        return generateSequence(2) { it + 1 }
                .filter { it.isPrime() }
    }

}

private fun Int.isPrime(): Boolean {
    return (2..upperLimit()).all { this % it != 0 }
}

private fun Int.upperLimit() = Math.sqrt(this.toDouble()).toInt()
