object StateMachine {
    private var currentState: MaquinaCafeEstados = MaquinaCafeEstados.Idle

    fun setState(newState: MaquinaCafeEstados) {
        currentState = newState
        currentState.onEnter(this)
    }

    fun getState(): MaquinaCafeEstados = currentState
}