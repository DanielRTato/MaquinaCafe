# Práctica: Maquina de cafe (estados)

La cafetera va pasando por los estados de manera automática. Comienza siempre en **Idle** y pasa a **CalentarAgua**, **FiltrarCafe** y ahí decide:
- Si es un café con leche → pasa a **ServirLeche** y luego a **ServirAzucar**.
- Si es un café solo → pasa directamente a **ServirAzucar**.

Después llega a **RetirarTaza**, y mediante `stateMachine.reset()` vuelve a poner la máquina en **Idle**.  
Si ocurre algún error durante el proceso, saltará la `data class Error`, que también usa `reset()` para reiniciar la máquina.
-------

##  Diagrama de estados

```mermaid
stateDiagram-v2
    Idle 
    Idle --> CalentarAgua
    CalentarAgua --> FiltrarCafe
    FiltrarCafe --> ServirLeche : Café con leche
    FiltrarCafe --> ServirAzuca : Café solo
    ServirLeche --> ServirAzuca
    ServirAzucar --> RetirarTaza
    RetirarTaza --> Idle
    Error --> Idle
    
    
````
----

##  Tests

- **preparar_cafe_con_leche()** → verifica que se puede preparar café con leche.
- **preparar_cafe_solo()** → verifica que se puede preparar café solo.
- **cambios_de_estados_validos()** → comprueba que las transiciones válidas funcionan.
- **cambios_de_estados_invalidos()** → asegura que no se permiten transiciones incorrectas.
- **reset_reinicia_estado()** → confirma que la máquina vuelve a Idle.
- **start_vuelve_a_idle_al_finalizar()** → valida que al terminar el ciclo completo siempre se reinicia a Idle.  
 