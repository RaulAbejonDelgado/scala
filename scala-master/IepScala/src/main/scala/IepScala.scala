import scala.collection.mutable
/**
  * object  ->  singleton pattern(how java static class)
  * class -> can be initializate
  */
object IepScala {

  val flag = true
  val x = 10
  val mes = 1

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
    funcionaesMatch(mes)
    whileScala()
    doWhileScala()

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

  def funcionaesMatch(nMes:Int): Unit = {
    println("********funcionaesMatch********\n")

    println(nMes match {
      case 1 => "Enero"
      case 2 => "Feberero"
      case 3 => "Marzo"
      case 4 => "Abril"
      case 5 => "Mayo"
      case 6 => "Junio"
      case 7 => "Julio"
      case 8 => "Agosto"
      case 9 => "Septiembre"
      case 10 => "Octubre"
      case 11 => "Noviembre"
      case 12 => "Diciembre"
      case _ => "No disponible(default)"
    })
  }

  //*******************************Bucles********************************************
  /**
    * ciclo while
    * println(s"Iterando en while ciclo $i") =>
    * añadiendo  el caracter s le indicamos que va a ser una cadena interpolada
    * Permitiendo integrar la variable en la propia cadena de texto
    */
  def whileScala(): Unit = {
    println("********whileScala********\n")

    var i = 0

    while(i < 10){
      println(s"Iterando en while ciclo ${i +1}")
      i = i + 1
    }
  }

  def doWhileScala() : Unit = {
    println("********doWhileScala********\n")
    var i = 0

    do {
      println(s"Iterando en while ciclo ${i +1}")
      i = i + 1
    }while(i < 10)
  }

  /**
    * tipos de datos
    * AnyVal: Int,Long,Double,Float,Byte,Short,Char,Boolean,Unit
    * AnyRef: Objetos de java, instancias , Listas, Colecciones
    * Any: Lo que vendria a ser la clase Object de java
    * Null: AnyRef sin valor
    * Nothing: es de todos los tipos de forma simultanea, donde no podremos instanciarlo
    * Option: Para tratar con valores que aveces pueden ser null o aveces no
    */

  /**
    * For para iterar sobre colecciones
    * Tipos de colecciones mutables e inmutables
    * //Inmutable
    * val k = 5
    * val inmut = java.util.ArrayList
    * esto significa que podemos hacer las operaciones sobre el arraylist tipicas que nos ofrece el propio tipo de dato ArrayList
    * pero no podremos volver a definir e.j val inmut = java.util.List
    * //Mutable
    * var x = 6
    * x = 8
    * colecciones de scala inmutables
    * scala.collection.inmutable -> colecciones inmutables (TreeSet, Queques. etc)
    * colecciones de scala mutables
    * scala.collection.mutable -> coleccions mutables
    * TIPOS DE COLECCIONES
    * Tienen un trait algo parecido a las interfaces , la interfaz root se llama Traversable
    * Elementos de iterable :
    * Set(Colecciones donde no puede haber elementos duplicados)
    * Map(clave:valor) no pueden repetirse las claves
    * Seq(Listas, vectores, rangos ) {
    * IndexedSeq -> nos permite trabajar con secuancias donde los elementos estan posicionados(obtener posicion de un elemento , cantidad de elementos, etc)
    * LinearSeq -> secuancias lineares, sabemos que tienen una posicion, en el caso de la listas(cabeza y cola), pilas, colas
    * }
    *
    * Trasversable
    *       |
    *   Iterable
    * ---------------------
    * Set     Map     Seq
    *                  |
    *                ----------------------
    *                IndexedSeq     LinearSeq
    */
}