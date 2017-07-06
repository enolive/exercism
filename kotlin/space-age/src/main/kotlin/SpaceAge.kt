import Planet.*
import java.math.BigDecimal
import java.math.RoundingMode

class SpaceAge(val seconds: Long) {

    fun onEarth(): Double = on(Earth)

    fun onMercury(): Double = on(Mercury)

    fun onVenus(): Double = on(Venus)

    fun onMars(): Double = on(Mars)

    fun onJupiter(): Double = on(Jupiter)

    fun onSaturn(): Double = on(Saturn)

    fun onUranus(): Double = on(Uranus)

    fun onNeptune(): Double = on(Planet.Neptune)

    private fun on(planet: Planet): Double = (seconds.yearsOnEarth() / planet.ratio).round(2)

    private fun Double.round(decimals: Int) = BigDecimal(this)
            .setScale(decimals, RoundingMode.HALF_UP)
            .toDouble()

    private fun Long.yearsOnEarth() = this / (365.25 * 24 * 60 * 60)
}

