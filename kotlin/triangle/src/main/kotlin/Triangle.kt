class Triangle {
    private val first: Double
    private val second: Double
    private val third: Double

    constructor(first: Double, second: Double, third: Double) {
        require(first > 0.0 && second > 0.0 && third > 0.0)
        this.first = first
        this.second = second
        this.third = third
    }

    constructor(first: Int, second: Int, third: Int) 
            : this(first.toDouble(), second.toDouble(), third.toDouble())

    val isEquilateral: Boolean
        get() {
            return (first == second && first == third)
        }
    val isScalene: Boolean = false
    val isIsosceles: Boolean = true

}