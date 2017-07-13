import java.math.BigInteger

object Board {
    fun getGrainCountForSquare(i: Int): BigInteger {
        require(i in 1..64) {
            "Only integers between 1 and 64 (inclusive) are allowed."
        }
        return BigInteger.valueOf(2).pow(i - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        return (1..64)
                .map { getGrainCountForSquare(it) }
                .reduce { sum, number -> sum + number }
    }
}