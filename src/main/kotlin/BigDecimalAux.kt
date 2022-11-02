import java.math.BigDecimal

class BigDecimalAux {
    fun BigDecimalArrayOf(vararg values:String):Array<BigDecimal> {
        return Array<BigDecimal>(values.size) { i ->
            values[i].toBigDecimal()
        }
    }
}