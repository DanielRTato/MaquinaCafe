import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class MaquinaCafeEstadosTest {

    @Test
    fun prearar_cafe_solo() {
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
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.CalentarAgua, MaquinaCafeEstados.filtrarCafe))
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.filtrarCafe, MaquinaCafeEstados.ServirLeche))
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.ServirLeche, MaquinaCafeEstados.ServirAzuca))
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.ServirAzuca, MaquinaCafeEstados.RetirarTaza))
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.RetirarTaza, MaquinaCafeEstados.Idle))
        assertTrue(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.Error, MaquinaCafeEstados.Idle))
    }

    @Test
    fun cambios_de_estados_invalidos() {
        assertFalse(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.Idle, MaquinaCafeEstados.ServirLeche))
        assertFalse(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.CalentarAgua, MaquinaCafeEstados.ServirAzuca))
        assertFalse(StateMachine.funcionamientoMaquina(MaquinaCafeEstados.filtrarCafe, MaquinaCafeEstados.RetirarTaza))
    }




}
