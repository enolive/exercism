import Planet.*

class SpaceAge(val seconds: Long) {

    fun onEarth(): Double = on(Earth)

    fun onMercury(): Double = on(Mercury)

    fun onVenus(): Double = on(Venus)

    fun onMars(): Double = on(Mars)

    fun onJupiter(): Double = on(Jupiter)

    fun onSaturn(): Double = on(Saturn)

    fun onUranus(): Double = on(Uranus)

    fun onNeptune(): Double = on(Planet.Neptune)

    private fun on(planet: Planet): Double = roundTwoDecimals(yearsOnEarth(seconds) / planet.ratio)

    private fun yearsOnEarth(seconds: Long) = seconds / (365.25 * 24 * 60 * 60)

    private fun roundTwoDecimals(value: Double) = Math.round(value * 100) / 100.0
}

