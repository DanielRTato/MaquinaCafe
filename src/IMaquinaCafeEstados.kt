/**
 * Interfaz que implementan todos los estados
 * Sirve para definir lo que hacen al entrar
 */
interface IMaquinaCafeEstados {
    fun onEnter(stateMachine: StateMachine)
}