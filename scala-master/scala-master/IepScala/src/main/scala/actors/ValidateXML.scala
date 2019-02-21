import javax.xml.transform.stream.StreamSource
import javax.xml.validation.SchemaFactory
import org.xml.sax.SAXException

object ValidateXML {
  def main(args: Array[String]) {
    require(args.size >= 2, "Params: xmlFile, xsdFile")
    val result =
      if (validate(args(0), args(1)))
        "Validates!"
      else
        "Not valid."
    println(result)
  }

  def validate(xmlFile: String, xsdFile: String): Boolean = {
    try {
      val schemaLang = "http://www.w3.org/2001/XMLSchema"
      val factory = SchemaFactory.newInstance(schemaLang)
      val schema = factory.newSchema(new StreamSource(xsdFile))
      val validator = schema.newValidator()
      validator.validate(new StreamSource(xmlFile))
    } catch {
      case ex: SAXException => ex.printStackTrace(); return false
      case ex: Exception => ex.printStackTrace()
    }
    true
  }
}
