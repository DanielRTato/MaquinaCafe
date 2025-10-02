/**
 * Representa las opciones de cafe que tendria el usuario
 */
data class OpcionCafe(val tipo: TipoCafe) {
    enum class TipoCafe {
        SOLO,
        CON_LECHE
    }
}
