class Triangle(private val first: Double, private val second: Double, private val third: Double) {
    constructor(first: Int, second: Int, third: Int) 
            : this(first.toDouble(), second.toDouble(), third.toDouble())

    val isEquilateral: Boolean
        get() {
            return (first == second && first == third)
        }
    val isScalene: Boolean = false
    val isIsosceles: Boolean = false

}