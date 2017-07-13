object HandshakeCalculator {
    fun calculateHandshake(i: Int): List<Signal> {
        if (i == 8) {
            return listOf(Signal.JUMP)
        }

        if (i == 4) {
            return listOf(Signal.CLOSE_YOUR_EYES)
        }
        
        if (i == 2) {
            return listOf(Signal.DOUBLE_BLINK)
        }
        
        return listOf(Signal.WINK)
    }

}