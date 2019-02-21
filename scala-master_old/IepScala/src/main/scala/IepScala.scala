import actors.{CustomActor1Example, SimpleMain}
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import scala.collection.{immutable, mutable}
import scala.io.Source
import scala.util.{Failure, Success, Try}
import scala.util.control.NonFatal
import scala.xml.{Elem, XML}

/**
  * object  ->  singleton pattern(how java static class)
  * class -> can be initializate
  */
object IepScala {

  val flag = true
  val x = 10
  val mes = 1
  val lista1 = List(1, 2, 3)
  val lista2 = List(4, 5, 6)
  val lista3 = List(7, 8, 9)
  val mapa = Map(0 -> "Yo el burro por delante", 1 -> "Asier", 2 -> "Borja", 3 -> "Adrian", 4 -> "Raul")
  val mapaMutable = mutable.Map(1 -> "SpringBoot", 2 -> "Spring batch", 3 -> "Spring data")


  /**
    * main app method -> app starter
    *
    */
  def main(args: Array[String]): Unit = {
//    println("¡¡ Iep Scala !!")
//
//    funcionCondiciones1()
//    funcionCondiciones2()
//    funcionCondiciones3()
//    funcionCondiciones4()
//    operacionesMath()
//    funcionaesMatch(mes)
//    whileScala()
//    doWhileScala()
//    funcionesColecciones()
//    funcionSets()
//    funcionSetsMutalbles()
//    funcionHasMap()
//    funcionHasMap2()
//    funcionHasMapMutable()
//    operacionFor()
//    xmlOperationReadFromFile()
//    xmlOperationWriteToFile()
      //probandoActores()
//    validateXml()
//    validateScenarioXml()

    actorExample()

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
    println(SimpleCalc.sumar(5, 3))
    println(SimpleCalc.restar(7, 4))
    println(SimpleCalc.multiplcar(5, 5))
    println(SimpleCalc.dividir(10, 2))
  }

  def funcionaesMatch(nMes: Int): Unit = {
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

    while (i < 10) {
      println(s"Iterando en while ciclo ${i + 1}")
      i += 1
    }
  }

  def doWhileScala(): Unit = {
    println("********doWhileScala********\n")
    var i = 0

    do {
      println(s"Iterando en while ciclo ${i + 1}")
      i += 1
    } while (i < 10)
  }


  /**
    * CAPITULO 16 FUNCIONES BASICAS DE UNA COLECCION
    * Array ES DE TIPO INDEXED SEQ
    * metodo apply espcial ya que luego podemos utilizarlo sin tener que escribirñp
    */
  def funcionesColecciones(): Unit = {
    println("********funcionesColecciones********\n")
    //Array de String
    val juegos = Array("Fornite", "Lineage2", "COD3")
    //Array de Any al detectar diferentes tipos de datos
    val deto = Array(1, "prueba")
    //Array de tipo AnyVal
    val datoMix = Array(true, 5)

    //prueba llamando al elemento sin apply antes de haberlo definido
    println("Antes de llamar a la posicion de elemento sin apply")
    println(juegos(1))
    println(deto(1))
    println(datoMix(1))

    //accedemos al elemento del array por su posicion
    println("Llamando a la posicion del elemento con apply")
    println(juegos.apply(0))
    println(deto.apply(1))
    println(datoMix.apply(0))

    //prueba llamando al elemento sin apply despues de haberlo definido
    println("Despues de llamar a la posicion de elemento sin apply")
    println(juegos(2))
    println(deto(0))
    println(datoMix(1))

    //longitud de un array
    println(s"La longitud del array juegos contiene ${juegos.length} elementos")

    //Comprobar si esta vacio
    println(s"El array juegos esta vacio ?  ${juegos.isEmpty}")

    //Comprobar si no esta vacio ?
    println(s"El array juegos no esta vacio ?  ${juegos.nonEmpty}")
    println(s"El array juegos no esta vacio ?  ${!juegos.isEmpty}")
    println("***************************************************")
    println("Busqueda por elementos en un array por su valor")
    println("Si el valor coincide con algun elemento nos devuelve la posicion de su array")
    println("Si el valor no coincide con algun elemento nos devuelve -1")
    //sacar indice por valor
    print("Buscamos el elemento Fornite del array juegos, tiene posicion ")
    println(juegos.indexOf("Fornite"))

    //sacar indice por valor no existente
    print("Buscamos el elemento fornite NO EXISTENTE del array juegos, tiene posicion ")
    println(juegos.indexOf("fornite"))


    //programacion funcional
    println("***Mapas juegos.map(e => println(e)) ***")
    println("es una funcion (Lambda) nos permite iterar sobre un array y hacer operaciones mas sofisticadas")
    juegos.map(e => println(e))

    funcionMap()
    funcionFlatten()
    funcionFlatMap()
  }

  def funcionMap(): Unit = {

    val listaEjempl = List(3, 5, 7, 8, 9)

    println("Funciones map conbinada con otras funciones ")
    //funciona lambda o anonima
    listaEjempl.map(e => println(por2(e)))

    println("Usando _ como elemento generico de los elementos List(1,2,3) ")
    listaEjempl.map(println(_))

  }

  /**
    *
    * @param x entero proviniente actualmente de funcionMap
    * @return el numero entrante x 2
    */
  def por2(x: Int): Int = x * 2

  /**
    * Lista de listas
    * flatten nos permite anexar en una unica lista el contenido de varias listas
    *
    */
  def funcionFlatten(): Unit = {
    val lista = List(lista1, lista2, lista3)


    println(lista1)
    println(lista2)
    println(lista3)

    println(s"Imprimimos la lista de listas $lista")
    println("Imprimimos la lista de listas procesada con .flatten ")
    println(lista.flatten)
    //Iteramos sobre cada lista y sobre cada lista itereda iteramos sobre sus elementos
    println("Iteramos sobre cada lista y sobre cada lista itereda iteramos sobre sus elementos")
    println("Y sobre cada numero lo pasamos a la funcion por2()")
    println("Y lo usamos flatten donde creamos una lista unica con los valores x 2 de los elementos en una Lista ")
    print(lista.map { (x: List[Int]) => x.map { l => por2(l) } }.flatten)
    println()

  }

  /**
    * conbinacion entre flattern y map
    * e.j -> para cuando tenemos listas de listas
    * e.j2 -> No tiene porque ser una lista de listas
    */
  def funcionFlatMap(): Unit = {

    val deportes = List("Futbol", "Basket", "Natacion", "Escalada")
    println("")
    println(deportes.flatMap(d => d.toUpperCase()))
    println("")
    println(deportes.flatMap(d => d.toUpperCase()).distinct)

  }

  /**
    * Sets
    * Una serie de elementos donde no puede haber duplicados y no ordenados
    * permite funciones map
    * set(nIndice) true si encuentra algo false si no encuentra algo equivalente al contains
    * Se pueden eliminar elementos del set con set - valor
    */
  def funcionSets(): Unit = {

    val set = Set(1, 2, 3, 4)

    println("funcionSets ")
    println("Pueden contener funciones map  ")
    println(set)
    println(set(5))
    println(set - 2)
    println(set -- Set(1, 2, 3, 4))
    println(set)
    println(set intersect Set(2))
    println(set union Set(7, 8, 9))
    println(set diff Set(2))

  }

  /**
    * leccion 20-21
    */
  def funcionSetsMutalbles(): Unit = {
    val mset = mutable.Set(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val sset = immutable.SortedSet(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println("funcionSetsMutalbles")
    mset += 10

    println(mset)

    mset -= 10

    println(mset)
    println("retain -- Modifica la coleccion")
    mset.retain(n => n % 2 == 0)
    println(mset)

    println("filter -- no Modifica la coleccion")
    mset.filter(n => n % 2 == 0)
    println(mset)

    println("Leccion 21 sortedSet")
    println(sset)

    val menosMas = Ordering.fromLessThan[Int](_ > _)
    println("Invertimos el orden")
    val sortedSetInverso = immutable.SortedSet.empty(menosMas) ++ sset
    println(sortedSetInverso)
  }

  /**
    * HasMap, map
    * Python : Diccionarios
    * Ruby: Hashes
    * Clave:Valor -> la clave no puede repetirse
    * leccion 22
    */
  def funcionHasMap(): Unit = {
    println("*********Leccion 22 funcionHasMap*******\n")
    println("El manejo del indice en los mapas a diferencia de los arrays lo marca el primer elemento del diccionario")
    println(s"mapa -> $mapa")
    println(s"mapa.keyset -> ${mapa.keySet}")
    println(s"mapa.values -> ${mapa.values}")
    println("Si al invocar por el `indice` del elemento obtenemos coincidencia nos devuelve un tipo some, si no tipo none")
    println(s"mapa.get(1) -> ${mapa.get(1)}")
    println(s"mapa.get(0) -> ${mapa.get(0)}")
    println(s"mapa.get(11) -> ${mapa.get(11)}")
    println("Tambien podemos buscar el indice sin get ")
    println(s"mapa(0) -> ${mapa(0)}")
    println(s"mapa(11) -> si usamos el indice en el map de la siguiente manera, debemos estar seguros")
    println("De que el elemento exista porque de no ser asi provocaremos java.util.NoSuchElementException: key not found.\n")
    println("getOrElse nos permite devolver una respuesta en casa de que la primer match no resulte ok")
    println(s"mapa.getOrElse(12,'No existe') -> ${mapa.getOrElse(12, "No existe")}")
    println(s"mapa.getOrElse(3,'No existe') -> ${mapa.getOrElse(3, "No existe")}")
    println("Podemos usar contains para evaluar su contenido mediante un valor booleano")
    println(s"mapa.contains(3) -> ${mapa.contains(3)}")
    println(s"mapa.contains(11) -> ${mapa.contains(11)}")

  }

  /**
    * Leccion 23
    * Manipulacion de mapas
    */
  def funcionHasMap2(): Unit = {

    println("******************funcionHasMap2*********")
    println("insertar en un mapa nuevo ya que este es inmutable")
    println("En la creacion del nuevo mapa podemos aprovechar para añadir nuevos elementos")
    println("e.j -> val mapaPlus =mapa + (12 -> \"Alberto\", 13 -> \"Jaime\")")
    val mapaPlus = mapa + (12 -> "Alberto", 13 -> "Jaime")
    println(s"mapaPlus -> ${mapaPlus}")
    println("Eliminar elementos ? (No eran inmutables ?)")
    println("Si !!! Por eso debemos guardar el resultado de dicha operacion en nuevo mapa)")
    println(" val mapaLess = mapaPlus - 4")
    val mapaLess = mapaPlus - 4
    println(s"mapaLess -> ${mapaLess}")
    println("Juntar 2 o mas mapas en un nuevo mapa")
    println("Operacion de juntar 2 diccionarios en un nuevo no me sale\n")
    println("Si por un casual los indices de algun elemento de ambos diccionarios coincide se sobre-escribiran")
    val mapaTest1 = Map(1 -> "python", 2 -> "scala", 3 -> "java")
    val mapaTest2 = Map(4 -> "ECMA6", 5 -> "PHP")
    val mergedMap = mapaTest1 ++ mapaTest2
    println(s"val mergedMap = mapaTest1 ++ mapaTest2 -> ${mergedMap}")

  }

  def funcionHasMapMutable(): Unit = {
    println("******************funcionHasMapMutable*********")
    println(s"mapaMutable -> $mapaMutable")
    println("Para sustituir o añadir un elemento del mapa mutable por otro elemento usaremos mapaMutable.+=( 3 -> \"Modificado ><\")")
    println("Si nos coincide el valor del indice sera remplazado, si no sera añadido")
    mapaMutable.+=(3 -> "Modificado ><")
    println(mapaMutable)
    println("Formas de hacer lo mismo: ")
    println("e.j - mapaMutable.put(3, \"Nuevo elemento\")")
    println("e.j - mapaMutable(indice) = \"Nuevo Elemento\"")
    println("e.j - mapaMutable ++= Map(6 -> \"Nuevo Elemento\")")
    println("Eliminar elementos")
    println("e.j - mapaMutable -= 2 (donde 2 seria el numero del indice)")
    mapaMutable -= 2
    println(mapaMutable)
    println("Limpiar diccionarios e.j  mapaMutable.clear")
    mapaMutable.clear()
    println(mapaMutable)

  }

  /**
    * leccion 24
    * cliclos for
    */
  def operacionFor(): Unit = {
    println("*********Leccion 24 operacionFor*********\n")
    //println("foreach -> lenguajes.foreach( e =>println(s"$e es un lenguaje de programacion") ))
    val lenguajes = Seq("java", "scala", "python", "js", "c")
    val meses = Seq("enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre")
    val dias = Seq.range(1, 30)
    println("lenguajes.foreach( e =>println(e)")
    lenguajes.foreach(e => println(s"$e es un lenguaje de programacion"))

    println("***('clasico') for  (e <- lenguajes)\n")
    for (e <- lenguajes) {
      println(s"$e es un lenguaje de programacion")
    }

    println("****OPERACIONES CARTESIANAS*****")
    for (l <- meses; f <- dias) {
      println(s"$f de $l")
    }
  }

  def xmlOperationReadFromFile() = {

    val xmlData = XML.load("main/resources/test.xml")
    println(xmlData)
    val nombre = (xmlData \ "nombre").text
    println(nombre)

  }

  def xmlOperationWriteToFile(): Unit = {


  }

//  def probandoActores(): Unit = {
//    object CustomActor1Example extends App {
//
//      class CustomActor extends Actor {
//        override def receive: Receive = {
//          case s: String => println(s"String: $s")
//          case i: Int => println(s"Number: $i")
//        }
//
//        def foo = println("Normal method")
//      }
//
//      val system = ActorSystem("SimpleSystem")
//      val actor = system.actorOf(Props[CustomActor], "CustomActor")
//
//      println("before messages")
//      actor ! "Que pasa bro"
//      println("after String")
//      println("before int")
//      actor ! 42
//      println("after int")
//    }

//  }

//  def validateXml(): Unit = {
//
//    val xmlEs = Source.fromInputStream(getClass.getResourceAsStream("/BOOKMARK_ES.xml"))
//    val xsdEs = Source.fromInputStream(getClass.getResourceAsStream("/BOOKMARK_ES.xsd")).mkString
//
//    //val isValidXml:Try[Unit] = XmlValidationUtils.validateXml(xmlEs, xsdEs)
//
//    isValidXml match {
//      case Success(_) => System.out.println("El xml es valido")
//      case Failure(e) => System.out.println("El xml no es valido", e)
//    }

//
//    val MOCK_XML = getXML()
//
//    scala.xml.XML.save("main/resources/tmpXML.xml", MOCK_XML, "UTF-8")
//
//    var resul = false
//
//    val xsdPath = "main/resources/BOOKMARK_ES.xsd"
//    val xmlPath = "main/resources/tmpXML.xml"
//
//    val xmlValidator = new XMLValidator
//    try {
//      resul = xmlValidator.validate(xmlPath, xsdPath)
//    } catch {
//      case NonFatal(ex) =>
//        println("XML not validates")
//        val error = ex.getMessage()
//        println(error)
//    }
//    if (resul) {
//      println("successfully validated, process can continue")
//    } else {
//      println("invalid file")
//    }

 // }

//  def getXML(): Elem ={
//    val MOCK_XML = <Bookmarks country="ES"><Category><name>Abstract</name><values><value>Primera Página</value><z></z></values></Category><Category><name>Amendments</name><values><value>Adiciones</value><value>Modificaciones</value></values></Category><Category><name>Bibliography</name><values><value>Primera Página</value><value>Biblio./Description</value></values></Category><Category><name>Claims</name><values><value>Reivindicaciones</value><value>Claims</value><value>Claim</value></values></Category><Category><name>Description</name><values><value>Descripción</value><value>Description</value></values></Category><Category><name>Drawings</name><values><value>Dibujos</value><value>Drawing</value></values></Category><Category><name>Search report</name><values><value>IET</value><value>Search Report</value></values></Category><Category><name>DNA sequence</name><values></values></Category><Category><name>Applicant citations</name><values></values></Category></Bookmarks>

//    val MOCK_XML =
//      "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
//        "<Bookmarks country=\"ES\">"+
//        "<Category>"+
//        "<name>Abstract</name>"+
//        "<values>"+
//        "<value>Primera Página</value>"+
//        "</values>"+
//        "</Category>"+
//        "<Category>"+
//        "<name>Amendments</name>"+
//        "<values>"+
//        "<value>Adiciones</value>"+
//        "<value>Modificaciones</value>"+
//        "</values>"+
//        "</Category>"+
//        "<Category>"+
//        "<name>Bibliography</name>"+
//        "<values>"+
//        "<value>Primera Página</value>"+
//        "<value>Biblio./Description</value>"+
//        "</values>"+
//        "</Category>"+
//        "<Category>"+
//        "<name>Claims</name>"+
//        "<values>"+
//        "<value>Reivindicaciones</value>"+
//        "<value>Claims</value>"+
//        "<value>Claim</value>"+
//        "</values>"+
//        "</Category>"+
//        "<Category>"+
//        "<name>Description</name>"+
//        "<values>"+
//        "<value>Descripción</value>"+
//        "<value>Description</value>"+
//        "</values>"+
//        "</Category>"+
//        "<Category>"+
//        "<name>Drawings</name>"+
//        "<values>"+
//        "<value>Dibujos</value>"+
//        "<value>Drawing</value>"+
//        "</values>"+
//        "</Category>"+
//        "<Category>"+
//        "<name>Search report</name>"+
//        "<values>"+
//        "<value>IET</value>"+
//        "<value>Search Report</value>"+
//        "</values>"+
//        "</Category>"+
//        "<Category>"+
//        "<name>DNA sequence</name>"+
//        "<values>"+
//        "</values>"+
//        "</Category>"+
//        "<Category>"+
//        "<name>Applicant citations</name>"+
//        "<values>"+
//        "</values>"+
//        "</Category>"+
//        "</Bookmarks>"

//    MOCK_XML

  def actorExample(): Unit = {
    // Create the 'helloAkka' actor system
    val system: ActorSystem = ActorSystem("helloAkka")
    val howdyGreeter: ActorRef =
      system.actorOf(SimpleMain.props("Howdy", printer), "howdyGreeter")
  }


}