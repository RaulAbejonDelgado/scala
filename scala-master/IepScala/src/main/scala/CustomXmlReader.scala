import xml._

object CustomXmlReader {

  def main(args: Array[String]): Unit = {
    xmlOperationReadFromFile()
  }
  def xmlOperationReadFromFile() = {
//    /home/drohne/scala_projects/scala-master/IepScala/src/main/resources/test.xml
    val xmlData = XML.load("main/resources/test.xml")
    println(xmlData)

    //nodo
    val nombre = (xmlData \ "nombre").text
    println(nombre)

    //atributo
    val mobil = (xmlData \\ "@tipo").text
    println(mobil)

    //etiqueta
    val r = (xmlData \\"telefono").text
    println(r)


  }

  def xmlOperationWriteToFile(): Unit = {


  }
}
