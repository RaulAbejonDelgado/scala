package actors

import akka.actor.{Actor, ActorSystem, Props}

object CustomActor1Example extends App {

  class CustomActor extends Actor {
    override def receive: Receive = {
      case s:String => println(s"String: $s")
      case i:Int => println(s"Number: $i")
    }

    def foo = println("Normal method")
  }

  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props[CustomActor],"CustomActor")

  println("before messages")
  actor ! "Que pasa bro"
  println("after String")
  println("before int")
  actor ! 42
  println("after int")
}
