import java.math.BigInteger
import java.math.BigInteger.valueOf

object Board {
    fun getGrainCountForSquare(i: Int): BigInteger {
        require(i in 1..64) {
            "Only integers between 1 and 64 (inclusive) are allowed."
        }
        return valueOf(2).pow(i - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        return geometricSum(2, 64)
    }

    private fun geometricSum(exponent: Long, count: Int) =
            (valueOf(exponent).pow(count) - valueOf(1)) /
                    (valueOf(exponent) - valueOf(1))
}