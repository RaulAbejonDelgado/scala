package raul.bilbomatica.scalasbt

/**
  * En scala las clases empiezan por object
  */
object Main extends App {
  // val serian como constantes
  // var serian como variables
  val ages = Seq(42, 61, 29, 64)
  println(s"The oldest person is ${ages.max}")
}
