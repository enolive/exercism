object HandshakeCalculator {
    fun calculateHandshake(i: Int): List<Signal> {
        val signals = Signal.values()
                .filter { i.and(it.bitmask) != 0 }
        
        if (i.and(16) != 0) {
            return signals.reversed()
        }
        
        return signals
    }

}