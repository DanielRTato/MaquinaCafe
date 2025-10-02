fun main() {

    // Probando cafe con leche
    StateMachine.opcionCafe = OpcionCafe(OpcionCafe.TipoCafe.CON_LECHE)
    StateMachine.start()

    println("---------------------------------------------------------")

    // Probando cafe solo (no sirve leche)
    StateMachine.opcionCafe = OpcionCafe(OpcionCafe.TipoCafe.SOLO)
    StateMachine.start()
    println(StateMachine.getState())
}