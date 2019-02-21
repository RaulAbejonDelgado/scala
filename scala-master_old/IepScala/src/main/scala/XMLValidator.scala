import java.io.File

import javax.xml.XMLConstants
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.{Schema, SchemaFactory, Validator}

import scala.xml.NodeBuffer

class XMLValidator {

  /**
    * @param xmlPath path of xml file
    * @param xsdPath path of xsd file
    * @return boolean true if file gets validated else false
    **/
  def validate(xmlPath: String, xsdPath: String): Boolean = {
    try {
      val factory: SchemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)

      val schema: Schema = factory.newSchema(new File(xsdPath))

      val validator: Validator = schema.newValidator()
      validator.validate(new StreamSource(new File(xmlPath)))
      //val cSource = new StreamSource(new File("main/resources/","arhivoTemporal.xml"))
      val xmlFile = new File(xmlPath)
      val cSource = new StreamSource(xmlFile)
      validator.validate(cSource)
      xmlFile.delete()

      true
    }
  }
}
