class Triangle(private val first: Double, private val second: Double, private val third: Double) {

    constructor(first: Int, second: Int, third: Int)
            : this(first.toDouble(), second.toDouble(), third.toDouble())

    init {
        require(validSideLengths())
        require(triangularInequality())
    }

    private fun validSideLengths() 
            = first > 0.0 && second > 0.0 && third > 0.0

    private fun triangularInequality() 
            = first + second >= third && second + third >= first && first + third >= second
    
    val isEquilateral: Boolean
        get() = (first == second && first == third)
    
    val isScalene: Boolean = !isIsosceles

    val isIsosceles: Boolean
        get() = !(first != second && first != third && second != third)

}