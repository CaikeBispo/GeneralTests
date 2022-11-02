import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    println("Hello World!")

    val salaries: Array<BigDecimal> = BigDecimalArrayOf("1500.50", "2300.0", "5000.0", "8000.0", "10000.0")

    println("Salários cadastrados: " + salaries.contentToString())

    val aumento = "1.1".toBigDecimal()
    val salariosComAumento: Array<BigDecimal> = salaries
        .map { salarie -> calculaAumentoRelativo(salarie, aumento) }
        .toTypedArray()

    val gastoInicial = salariosComAumento.somatoria()
    val meses = "6".toBigDecimal()

    val gastoTotal = salariosComAumento.fold(gastoInicial){
        acumulador, salarie -> acumulador + (salarie * meses).setScale(2, RoundingMode.UP)
    }

    println("Gasto inicial com salários: $gastoInicial")
    println("Gasto total com salários: $gastoTotal")

    val media = salariosComAumento.sorted().takeLast(3).toTypedArray().media()

    println("Media maiores salários: $media")

    val mediaMenoresSalarios = salariosComAumento.sorted().take(3).toTypedArray().media()

    println("Media menores salários: $mediaMenoresSalarios")

}

fun BigDecimalArrayOf(vararg values:String):Array<BigDecimal> {
    return Array<BigDecimal>(values.size) { i ->
        values[i].toBigDecimal()
    }
}

fun Array<BigDecimal>.somatoria():BigDecimal = this.reduce{acumulador, valor -> acumulador + valor}

fun Array<BigDecimal>.media():BigDecimal{
    return if(this.isEmpty()){
        BigDecimal.ZERO
    } else {
        this.somatoria() / this.size.toBigDecimal()
    }
}
private fun calculaAumentoRelativo(salario: BigDecimal, aumento: BigDecimal)
        : BigDecimal {
    return if (salario < "5000".toBigDecimal()) {
        salario + "500".toBigDecimal()
    } else {
        (salario * aumento).setScale(2, RoundingMode.UP)
    }
}