/**
 * Posibles estados de la máquina de café
 */
sealed class MaquinaCafeEstados: IMaquinaCafeEstados {

    object Idle : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            stateMachine.setState(CalentarAgua)
        }
    }

    object CalentarAgua: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            println("Calentando agua")
            stateMachine.setState(FiltrarCafe)
        }
    }

    object FiltrarCafe: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            println("Filtrando el café")
            if (stateMachine.opcionCafe.tipo == OpcionCafe.TipoCafe.CON_LECHE) {
                stateMachine.setState(ServirLeche)
            } else {
                stateMachine.setState(ServirAzuca)
            }
        }
    }

    object ServirLeche: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            println("Sirviendo leche")
            stateMachine.setState(ServirAzuca)
        }
    }

    object ServirAzuca: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            stateMachine.setState(RetirarTaza)
        }
    }

    object RetirarTaza: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            println("Café listo, retira la taza")
            Thread.sleep(2000)
            stateMachine.reset() // Cuando acaba toodo el proceso pone la maquina en el estado Idle
        }
    }

    data class Error(val msg: String) : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: Error $msg" )
            stateMachine.reset() // Cuando algo falla vuelve al estado Idle
        }
    }
}