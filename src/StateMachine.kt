object StateMachine {
    private var currentState: MaquinaCafeEstados = MaquinaCafeEstados.Idle
    var opcionCafe: OpcionCafe = OpcionCafe(OpcionCafe.TipoCafe.SOLO)

    fun setState(newState: MaquinaCafeEstados) {
        if (funcionamientoMaquina(currentState, newState)) {
            currentState = newState
            currentState.onEnter(this)
        } else {
            println("Transición inválida de ${currentState::class.simpleName} a ${newState::class.simpleName}")
            currentState = MaquinaCafeEstados.Error
            currentState.onEnter(this)
        }
    }

    fun getState(): MaquinaCafeEstados = currentState


    fun funcionamientoMaquina(from: MaquinaCafeEstados, to: MaquinaCafeEstados): Boolean {
        return when (from) {
            MaquinaCafeEstados.Idle -> to == MaquinaCafeEstados.CalentarAgua
            MaquinaCafeEstados.CalentarAgua -> to == MaquinaCafeEstados.FiltrarCafe
            MaquinaCafeEstados.FiltrarCafe ->
                to == MaquinaCafeEstados.ServirLeche || to == MaquinaCafeEstados.ServirAzuca
            MaquinaCafeEstados.ServirLeche -> to == MaquinaCafeEstados.ServirAzuca
            MaquinaCafeEstados.ServirAzuca -> to == MaquinaCafeEstados.RetirarTaza
            MaquinaCafeEstados.RetirarTaza -> to == MaquinaCafeEstados.Idle
            MaquinaCafeEstados.Error -> to == MaquinaCafeEstados.Idle
            else -> false
        }
    }


}