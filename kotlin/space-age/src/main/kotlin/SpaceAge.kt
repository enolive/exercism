import Planet.*

class SpaceAge(val seconds: Long) {

    fun onEarth(): Double = on(Earth)

    fun onMercury(): Double = on(Mercury)

    fun onVenus(): Double = on(Venus)

    fun onMars(): Double = on(Mars)

    fun onJupiter(): Double = on(Jupiter)

    fun onSaturn(): Double = on(Planet.Saturn)

    private fun on(planet: Planet): Double {
        val yearsOnEarth = seconds / (365.25 * 24 * 60 * 60)
        return roundTwoDecimals(yearsOnEarth / planet.ratio)
    }

    fun onNeptune(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onUranus(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun roundTwoDecimals(value: Double) = Math.round(value * 100) / 100.0
}

