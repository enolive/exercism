import Planet.*

class SpaceAge(val seconds: Long) {

    private val planetRatio = hashMapOf(
        Mercury to 0.2408467,
        Venus to 0.61519726,
        Earth to 1.0,
        Mars to 1.8808158
    )
            
    fun onEarth(): Double = on(Earth)

    fun onMercury(): Double = on(Mercury)

    fun onVenus(): Double = on(Venus)

    fun onMars(): Double = on(Mars)

    private fun on(planet: Planet): Double {
        val ratio = planetRatio.getValue(planet)
        val yearsOnEarth = seconds / (365.25 * 24 * 60 * 60)
        return roundTwoDecimals(yearsOnEarth / ratio)
    }

    fun onNeptune(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onUranus(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onSaturn(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onJupiter(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun roundTwoDecimals(value: Double) = Math.round(value * 100) / 100.0
}

