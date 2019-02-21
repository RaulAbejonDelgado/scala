package com.raul.scala.api

object App {

  val a = "2"
  val b = "5"


  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {

    println( "Hello World!" )
    println("concat arguments = " + foo(Array(a,b)))
  }

}
