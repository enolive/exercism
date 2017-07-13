object HandshakeCalculator {
    fun calculateHandshake(i: Int): List<Signal> {
        return Signal.values()
                .filter { i and it.bitmask != 0 }
                .let { if (i and 16 != 0) it.reversed() else it }
    }
}