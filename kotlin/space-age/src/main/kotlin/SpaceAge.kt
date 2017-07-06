import Planet.*
import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(val seconds: Long) {

    fun onEarth(): Double = on(EARTH)

    fun onMercury(): Double = on(MERCURY)

    fun onVenus(): Double = on(VENUS)

    fun onMars(): Double = on(MARS)

    fun onJupiter(): Double = on(JUPITER)

    fun onSaturn(): Double = on(SATURN)

    fun onUranus(): Double = on(URANUS)

    fun onNeptune(): Double = on(NEPTUNE)

    private fun on(planet: Planet): Double = (seconds.yearsOnEarth() / planet.ratio).round(2)

    private fun Double.round(decimals: Int) = BigDecimal(this)
            .setScale(decimals, RoundingMode.HALF_UP)
            .toDouble()

    private fun Long.yearsOnEarth() = this / (365.25 * 24 * 60 * 60)
}

