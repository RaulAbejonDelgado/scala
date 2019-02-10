package com.raul.scala.api


import org.scalatra._

class ControlerDemo extends ScalatraServlet {

  import org.apache.log4j.PropertyConfigurator

  val log4jConfPath = "/path/to/log4j.properties"
  PropertyConfigurator.configure(log4jConfPath)
  get("/test"){

    "Hi there!"
  }

}
