object Sieve {
    fun primesUpTo(limit: Int): List<Int> {
        val candidates = (2..limit).map { Candidate(it) }
        candidates.forEach { first ->
            (first.number.times(2) until limit + 1 step first.number)
                    .map { number -> candidates.single { number == it.number } }
                    .forEach { it.notPrime() }
        }
        
        return candidates.filter { it.isPrime }
                .map { it.number }
    }

}

class Candidate(val number: Int) {

    private var _isPrime = true
    var isPrime: Boolean
        get() = _isPrime
        private set(value) {
            _isPrime = value
        }

    fun notPrime() {
        isPrime = false
    }

}
