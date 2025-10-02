/**
 * Maneja el estado actual y las transiciones de estado
 */
object StateMachine {
    private var currentState: MaquinaCafeEstados = MaquinaCafeEstados.Idle
    var opcionCafe: OpcionCafe = OpcionCafe(OpcionCafe.TipoCafe.CON_LECHE) // Opcion actual de cafe. Valores posibles: SOLO, CON_LECHE

    /**
     * Cambia los estados de la máquina si la transicion es válida
     * Si no entra en el estado Error
     * @param newState estado al que se quiere pasar
     */
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

    /**
     * Devuelve el estado en el que se encuentra la máquina
     */
    fun getState(): MaquinaCafeEstados = currentState

    /**
     * Inicia la cafetera en Idle
     */
    fun start() {
        println("Encendiendo la cafetera")
        currentState.onEnter(this)
    }

    /**
     * Reinicia la máquina al estado Idle
     */
    fun reset() {
        println("Reiniciando máquina al estado Idle")
        currentState = MaquinaCafeEstados.Idle
    }

    /**
     * Define las transiciones validas entre estados
     */
    fun funcionamientoMaquina(from: MaquinaCafeEstados, to: MaquinaCafeEstados): Boolean {
        return when (from) {
            MaquinaCafeEstados.Idle -> to == MaquinaCafeEstados.CalentarAgua
            MaquinaCafeEstados.CalentarAgua -> to == MaquinaCafeEstados.FiltrarCafe
            MaquinaCafeEstados.FiltrarCafe ->
                to == MaquinaCafeEstados.ServirLeche || to == MaquinaCafeEstados.ServirAzucar
            MaquinaCafeEstados.ServirLeche -> to == MaquinaCafeEstados.ServirAzucar
            MaquinaCafeEstados.ServirAzucar -> to == MaquinaCafeEstados.RetirarTaza
            MaquinaCafeEstados.RetirarTaza -> to == MaquinaCafeEstados.Idle
            is MaquinaCafeEstados.Error -> to == MaquinaCafeEstados.Idle
            else -> false
        }
    }


}