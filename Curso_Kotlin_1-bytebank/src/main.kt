fun main() {

    println("Bem vindo ao Bytebank")
    // testaLacos()
    // testaCopiasEReferencias()

    val contaAlex = Conta(titular = "Alex", numero = 1001)
    contaAlex.deposita(1000.0)
    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    // deposita(contaAlex, 70.0) //Dessa maneira não é seguido os padrões da Orientação a Objetos
    contaAlex.deposita(70.0)
    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    contaAlex.sacar(1070.0)
    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println("Saco em excesso")
    contaAlex.sacar(50.0)
    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    contaAlex.deposita(1000.0)
    val contaFran = Conta("Fran", 1002)

    if (contaAlex.transfere(destino = contaFran, valor = 600.0))
        println("Transferência sucedida")
    else
        println("Falha na transferência")

    println("Contra Alex")
    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println("Conta Fran")
    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)


}

class Conta(
    var titular: String = "",
    val numero: Int = 0 ) { // Se houvesse apenas um construtor esse seria a melhor maneira (Contrutor Primário)

    var saldo = 0.0
        private set(valor){
           println("field: $field")
           if(valor > 0)
               field = valor
        }

//    constructor()   //(Contrutor Secundário)
//
//    constructor(titular: String, numero: Int){ //(Contrutor Secundário)
//        this.titular = titular
//        this.numero = numero
//    }

    fun deposita(valor:Double){
        println("Depositando na conta do titular: ${this.titular} o valor de $valor")
        this.saldo += valor
        println("O valor total na conta do titular: ${this.titular} é ${this.saldo}")
    }

    fun sacar(valor: Double){
        if (this.saldo >= valor){
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if(this.saldo >= valor){
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }


}

//fun deposita(conta: Conta, valor:Double){
//    println("Depositando na conta do titular: ${conta.titular} o valor de $valor")
//    conta.saldo += valor
//    println("O valor total na conta do titular: ${conta.titular} é ${conta.saldo}")
//}

fun testaCopiasEReferencias(){

    val contaAlex = Conta(numero = 1001, titular = "Alex")
    contaAlex.deposita(1000.0)
    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println(Conta().titular)
    println(Conta().numero)
    println(Conta().saldo)

    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta()
    contaJoao.titular = "João"
    val contaMaria = Conta()
    contaMaria.titular = "Maria"
    contaJoao.titular = "João"

    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")

    println(contaJoao)
    println(contaMaria)
}

fun testaLacos(){

    for (i in 1..5){

        val titular: String = "Waldyr + $i"
        val numConta: Int = 1000 + i
        var saldoConta: Double = 0.0 + i
        saldoConta += 100 + + i

        println("Titular $titular")
        println("Número da Conta $numConta")
        println("Saldo em Conta $saldoConta")

//        testaCondicoes(saldoConta)
    }

    for (i in 5 downTo 1){

        val titular: String = "Waldyr + $i"
        val numConta: Int = 1000 + i
        var saldoConta: Double = 0.0 + i
        saldoConta += 100 + + i

        println("Titular $titular")
        println("Número da Conta $numConta")
        println("Saldo em Conta $saldoConta")

//        testaCondicoes(saldoConta)
    }

    for (i in 5 downTo 1 step 2){

        val titular: String = "Waldyr + $i"
        val numConta: Int = 1000 + i
        var saldoConta: Double = 0.0 + i
        saldoConta += 100 + + i

        println("Titular $titular")
        println("Número da Conta $numConta")
        println("Saldo em Conta $saldoConta")

//        testaCondicoes(saldoConta)
    }

    var i = 0
    while(i < 5){
        val titular: String = "Waldyr + $i"
        val numConta: Int = 1000 + i
        var saldoConta: Double = 0.0 + i
        saldoConta += 100 + + i

        println("Titular $titular")
        println("Número da Conta $numConta")
        println("Saldo em Conta $saldoConta")
//        testaCondicoes(saldoConta)
        i++
    }
}

fun testaCondicoes(saldoConta: Double) {

    if (saldoConta > 0.0) {
        println("conta é positiva")
    } else if (saldoConta == 0.0) {
        println("conta é neutra")
    } else {
        println("conta é negativa")
    }

    when {
        saldoConta > 0.0 -> println("conta é positiva")
        saldoConta == 0.0 -> println("conta é neutra")
        else -> println("conta é negativa")
    }
}

