
/**
  * object  ->  singleton pattern(how java static class)
  * class -> can be initializate
  */
object IepScala {

  val flag = true
  val x = 10

  /**
    * main app method -> app starter
    *
    */
  def main(args: Array[String]): Unit = {
    println("¡¡ Iep Scala !!")

    funcionCondiciones1()
    funcionCondiciones2()
    funcionCondiciones3()
    funcionCondiciones4()
    operacionesMath()

  }

  //*******************************CONDICIONALES********************************************
  /**
    * Unit =  the method wo return
    */
  def funcionCondiciones1(): Unit = {
    println("********funcionCondiciones1********\n")
    if (!flag) {
      println("bandera false")
    } else {
      println("bandera true")
    }
  }

  def funcionCondiciones2(): Unit = {
    println("********funcionCondiciones2********\n")
    if (!flag) {
      println("bandera false")
    } else if (flag) {
      println("bandera true del else if")
    } else {
      println("Si ningun else if se ejecuta termina con este else, cosa que no ocurrira")
    }
  }

  def funcionCondiciones3(): Unit = {
    println("********funcionCondiciones3********\n")
    println(if (flag) "la bandera es true " else "la bandera es false")
  }

  def funcionCondiciones4(): Unit = {
    println("********funcionCondiciones4********\n")
    println(funcionCondicionesExtends4())
  }

  /**
    *
    * @return if flag is true one msg else other msg
    */
  def funcionCondicionesExtends4(): String = if (flag) "la bandera es true ex4" else "la bandera es false ex4"

  def operacionesMath(): Unit = {
    println("********operacionesMath********\n")
    println(SimpleCalc.sumar(5,3))
    println(SimpleCalc.restar(7,4))
    println(SimpleCalc.multiplcar(5,5))
    println(SimpleCalc.dividir(10,2))
  }

}