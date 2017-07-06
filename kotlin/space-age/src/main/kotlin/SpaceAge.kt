class SpaceAge(val seconds: Long) {
    private val earthYears = seconds / (365.25 * 24 * 60 * 60)

    fun onEarth(): Double = roundTwoDecimals(earthYears)

    fun onMercury(): Double = roundTwoDecimals(earthYears / 0.2408467)

    fun onVenus(): Double = roundTwoDecimals(earthYears / 0.61519726)

    fun onMars(): Double = roundTwoDecimals(earthYears / 1.8808158)

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
