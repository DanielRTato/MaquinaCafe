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
            stateMachine.setState(filtrarCafe)
        }
    }

    object filtrarCafe: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            println("Filtrando el café")
            stateMachine.setState(ServirLeche)
        }
    }

    object ServirLeche: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            if (stateMachine.opcionCafe.tipo == OpcionCafe.TipoCafe.CON_LECHE) {
                println("Sirviendo leche")
            } else {
                println("Café solo, no se sirve leche")
            }
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
            stateMachine.setState(Idle)
        }
    }

    object Error: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            println("Error inesperado, reiciciando")
            stateMachine.setState(Idle)
        }
    }



}