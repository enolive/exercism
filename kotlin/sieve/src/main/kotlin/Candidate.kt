class Candidate(val number: Int) {

    private var _isPrime = true
    var isPrime: Boolean
        get() = _isPrime
        private set(value) {
            _isPrime = value
        }

    fun markAsNotPrime() {
        isPrime = false
    }

}