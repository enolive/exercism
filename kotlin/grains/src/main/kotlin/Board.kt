import java.math.BigInteger

object Board {
    fun getGrainCountForSquare(i: Int): BigInteger {
        return BigInteger.valueOf(2).pow(i - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}