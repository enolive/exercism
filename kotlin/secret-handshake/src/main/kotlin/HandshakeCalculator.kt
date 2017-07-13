object HandshakeCalculator {
    fun calculateHandshake(i: Int): List<Signal> {
        val list = mutableListOf<Signal>()
        if (i.and(1) != 0) {
            list.add(Signal.WINK)
        }
        
        if (i.and(2) != 0) {
            list.add(Signal.DOUBLE_BLINK)
        }
        
        if (i.and(4) != 0) {
            list.add(Signal.CLOSE_YOUR_EYES)
        }

        if (i.and(8) != 0) {
            list.add(Signal.JUMP)
        }
        
        return list
    }

}