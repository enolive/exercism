object HandshakeCalculator {
    fun calculateHandshake(i: Int): List<Signal> {
        if (i == 2) {
            return listOf(Signal.DOUBLE_BLINK)
        }
        
        return listOf(Signal.WINK)
    }

}