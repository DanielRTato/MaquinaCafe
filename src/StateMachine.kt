/**
 * Maneja el estado actual y las transiciones de estado
 */
object StateMachine {
    private var currentState: MaquinaCafeEstados = MaquinaCafeEstados.Idle
    var opcionCafe: OpcionCafe = OpcionCafe(OpcionCafe.TipoCafe.CON_LECHE) // Valores posibles: SOLO, CON_LECHE

    fun setState(newState: MaquinaCafeEstados) {
        if (funcionamientoMaquina(currentState, newState)) {
            currentState = newState
            currentState.onEnter(this)
        } else {
            println("Transición inválida de ${currentState::class.simpleName} a ${newState::class.simpleName}")
            currentState = MaquinaCafeEstados.Error("Se produjo un error")
            currentState.onEnter(this)
        }
    }

    fun getState(): MaquinaCafeEstados = currentState

    /** Reinicia la máquina al estado Idle */
    fun reset() {
        println("Reiniciando máquina")
        currentState = MaquinaCafeEstados.Idle
    }

    /**
     * Controla las transiciones entre estados
     */
    fun funcionamientoMaquina(from: MaquinaCafeEstados, to: MaquinaCafeEstados): Boolean {
        return when (from) {
            MaquinaCafeEstados.Idle -> to == MaquinaCafeEstados.CalentarAgua
            MaquinaCafeEstados.CalentarAgua -> to == MaquinaCafeEstados.FiltrarCafe
            MaquinaCafeEstados.FiltrarCafe ->
                to == MaquinaCafeEstados.ServirLeche || to == MaquinaCafeEstados.ServirAzuca
            MaquinaCafeEstados.ServirLeche -> to == MaquinaCafeEstados.ServirAzuca
            MaquinaCafeEstados.ServirAzuca -> to == MaquinaCafeEstados.RetirarTaza
            MaquinaCafeEstados.RetirarTaza -> to == MaquinaCafeEstados.Idle
            is MaquinaCafeEstados.Error -> to == MaquinaCafeEstados.Idle
            else -> false
        }
    }


}