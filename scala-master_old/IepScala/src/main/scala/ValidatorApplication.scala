

object ValidatorApplication extends App {


  def checkvalidate(xmlPath : String, xsdPath : String): Unit ={
    val xmlValidator = new XMLValidator
    if (xmlValidator.validate(xmlPath, xsdPath)) {
      println("successfully validated")
    } else {
      println("invalid file")
    }
  }

}
