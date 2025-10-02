/**
 * Opciones que tiene el usuario
 */
data class OpcionCafe(val tipo: TipoCafe) {
    enum class TipoCafe {
        SOLO,
        CON_LECHE
    }
}
