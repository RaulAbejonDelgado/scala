import org.scalatest.FunSuite

/**
  * Clase de test para hacer una primera prueba
  * extends FunSuitenos permite usar la funcionalidad de la clase FunSuite de ScalaTest, como la testfunción
  *
  */
class CubeCalculatorTest extends FunSuite {

  val a = 2;

  //test es una función que proviene de la biblioteca FunSuite que recopila resultados de aserciones dentro del cuerpo de la función.
  //testName "CubeCalculator.cube"Es un nombre para la prueba. Puede llamarlo de cualquier manera, pero una convención es "ClassName.methodName".
  test("CubeCalculator.cube") {
    //assert
    assert(CubeCalculator.cube(3) === 27)

    //assertResults
    assertResult(64) {
     CubeCalculator.cube(4)
    }

    assertResult(4) {
      CubeCalculator.sumar(a,a)
    }



  }
}