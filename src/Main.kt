fun main() {
    println("Encendiendo cafetera!")
    //println("Elige tipo de café: 1) Solo  2) Con leche")
    //val opcion = readLine()
    //StateMachine.opcionCafe = when (opcion) {
    //"2" -> OpcionCafe(OpcionCafe.TipoCafe.CON_LECHE)
    //    else -> OpcionCafe(OpcionCafe.TipoCafe.SOLO)
    //}

    //StateMachine.setState(MaquinaCafeEstados.Idle)
    //StateMachine.setState(MaquinaCafeEstados.RetirarTaza)
    StateMachine.setState(MaquinaCafeEstados.ServirLeche)



  //  if (StateMachine.getState() is MaquinaCafeEstados.Idle) {
  //      println("Se completó un ciclo")
  //  }
}