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

    private fun on(planet: Planet): Double = round(seconds.yearsOnEarth() / planet.ratio)

    private fun round(value: Double) = Math.round(value * 100) / 100.0

    private fun Long.yearsOnEarth() = this / (365.25 * 24 * 60 * 60)
}

