object HandshakeCalculator {
    fun calculateHandshake(i: Int): List<Signal> {
        val signals = Signal.values()
                .filter { i.and(it.bitmask) != 0 }
                .let { if (i.and(16) != 0) it.reversed() else it }
        return signals
    }
}