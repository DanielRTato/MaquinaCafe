sealed class MaquinaCafeEstados: IMaquinaCafeEstados {

    object Idle : MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            stateMachine.setState()
        }
    }

    object calentarAgua: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            TODO("Not yet implemented")
        }
    }

    object filtrarCafe: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            TODO("Not yet implemented")
        }
    }

    object servirLeche: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            TODO("Not yet implemented")
        }
    }

    object servirAzuca: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            TODO("Not yet implemented")
        }
    }

    object retirarTaza: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            TODO("Not yet implemented")
        }
    }

    object Error: MaquinaCafeEstados() {
        override fun onEnter(stateMachine: StateMachine) {
            println("Estado: " + StateMachine.getState())
            println("Error inesperado, reiciciando")
        }
    }



}