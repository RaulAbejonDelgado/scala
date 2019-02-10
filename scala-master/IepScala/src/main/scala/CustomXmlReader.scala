import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array

import scala.xml.XML

object CustomXmlReader {


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
