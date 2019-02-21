import java.io.StringReader

import javax.xml.XMLConstants
import javax.xml.transform.Source
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.{Schema, SchemaFactory, Validator}

import scala.util.{Failure, Success, Try}

object XmlValidationUtils {


  /**
    *
    * @param xml
    * @param xsd
    * @return
    */
  def validateXml(xml: String, xsd: String): Try[Unit] = {

    val xmlSource: Source = new StreamSource(new StringReader(xml))
    val xsdSource: Source = new StreamSource(new StringReader(xsd))

    validateXml(xmlSource, xsdSource)
  }

  def validateXml(xml: String, xsdSource: Source): Try[Unit] = {

    val xmlSource: Source = new StreamSource(new StringReader(xml))

    validateXml(xmlSource, xsdSource)
  }

  def validateXml(xml: Source, xsdSource: Source): Try[Unit] = {
    try {
      val factory: SchemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)

      val schema: Schema = factory.newSchema(xsdSource)

      val validator: Validator = schema.newValidator()

      try {
        validator.validate(xml)
        Success()
      } catch {
        case e => Failure(e)
      }

    }
  }

}
