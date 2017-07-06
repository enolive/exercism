import Planet.*

class SpaceAge(val seconds: Long) {

    private val yearRatio = hashMapOf(
            Mercury to 0.2408467,
            Venus to 0.61519726,
            Earth to 1.0,
            Mars to 1.8808158,
            Jupiter to 11.862615,
            Saturn to 29.447498
    )

    fun onEarth(): Double = on(Earth)

    fun onMercury(): Double = on(Mercury)

    fun onVenus(): Double = on(Venus)

    fun onMars(): Double = on(Mars)

    fun onJupiter(): Double = on(Jupiter)

    fun onSaturn(): Double = on(Planet.Saturn)

    private fun on(planet: Planet): Double {
        val ratio = yearRatio.getValue(planet)
        val yearsOnEarth = seconds / (365.25 * 24 * 60 * 60)
        return roundTwoDecimals(yearsOnEarth / ratio)
    }

    fun onNeptune(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun onUranus(): Double {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun roundTwoDecimals(value: Double) = Math.round(value * 100) / 100.0
}

