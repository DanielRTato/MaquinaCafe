import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaquinaCafeEstadosTest {

    @Test
    fun preparar_cafe_solo() {
        StateMachine.opcionCafe = OpcionCafe(OpcionCafe.TipoCafe.SOLO)
        assertEquals(OpcionCafe.TipoCafe.SOLO, StateMachine.opcionCafe.tipo)
    }

    @Test
    fun preparar_cafe_con_leche() {
        StateMachine.opcionCafe = OpcionCafe(OpcionCafe.TipoCafe.CON_LECHE)
        assertEquals(OpcionCafe.TipoCafe.CON_LECHE, StateMachine.opcionCafe.tipo)
    }

    @Test
    fun cambios_de_estados_validos() {
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.Idle, MaquinaCafeEstados.CalentarAgua))
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.CalentarAgua, MaquinaCafeEstados.FiltrarCafe))
        // Ahora FiltrarCafe puede ir a ambos
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.FiltrarCafe, MaquinaCafeEstados.ServirLeche))
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.FiltrarCafe, MaquinaCafeEstados.ServirAzucar))
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.ServirLeche, MaquinaCafeEstados.ServirAzucar))
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.ServirAzucar, MaquinaCafeEstados.RetirarTaza))
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.RetirarTaza, MaquinaCafeEstados.Idle))
           }

    @Test
    fun cambios_de_estados_invalidos() {
        assertFalse(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.Idle, MaquinaCafeEstados.ServirLeche))
        assertFalse(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.CalentarAgua, MaquinaCafeEstados.ServirAzucar))
        assertFalse(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.FiltrarCafe, MaquinaCafeEstados.RetirarTaza))
    }
    @Test
    fun reset_reinicia_estado() {
        StateMachine.reset()
        assertEquals(MaquinaCafeEstados.Idle, StateMachine.getState())
    }

    @Test
    fun start_vuelve_a_idle_al_finalizar() {
        StateMachine.opcionCafe = OpcionCafe(OpcionCafe.TipoCafe.SOLO)
        StateMachine.start()
        assertTrue(StateMachine.getState() is MaquinaCafeEstados.Idle)
    }
}