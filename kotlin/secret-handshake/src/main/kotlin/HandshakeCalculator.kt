object HandshakeCalculator {
    fun calculateHandshake(i: Int): List<Signal> {
        return Signal.values()
                .filter { i.and(it.bitmask) != 0 }

    }

}