object Prime {
    fun nth(i: Int): Int {
        require(i > 0)
        return primes().elementAt(i - 1)
    }

    private fun primes(): Sequence<Int> {
        return generateSequence(2) { it + 1 }
                .filter { it.isPrime() }
    }
}

private fun Int.isPrime() = (2..upperLimit()).all { !divisibleBy(it) }

private fun Int.upperLimit() = Math.sqrt(this.toDouble()).toInt()

private infix fun Int.divisibleBy(divisor: Int) = this % divisor == 0
