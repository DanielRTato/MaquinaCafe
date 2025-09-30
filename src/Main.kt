fun main() {

    println("Encendiendo cafetera!")
    StateMachine.setState(MaquinaCafeEstados.Idle)

    if (StateMachine.getState() is MaquinaCafeEstados.Idle) {
        println("Se completó un ciclo")
    }
}