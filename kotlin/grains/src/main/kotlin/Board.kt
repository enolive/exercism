import java.math.BigInteger

object Board {
    fun getGrainCountForSquare(i: Int): BigInteger {
        return BigInteger.valueOf(2 power i)
    }

    fun getTotalGrainCount(): BigInteger {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private infix fun Int.power(power: Int) = Math.pow(toDouble(), power.toDouble() - 1).toLong()

}