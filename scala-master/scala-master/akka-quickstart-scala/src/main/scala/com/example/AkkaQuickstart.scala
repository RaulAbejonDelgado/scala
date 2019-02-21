//#full-example
package com.example

import akka.actor.{ Actor, ActorLogging, ActorRef, ActorSystem, Props }


//#greeter-companion
//#greeter-messages
object MessageController {
  //#greeter-messages
  def props(message: String, printerActor: ActorRef): Props ={
    Props(new MessageController(message, printerActor))
    //#greeter-messages

  }
  final case class ProcessMsg(who: String)
  case object PrintMsg

}
//#greeter-messages
//#greeter-companion

//#greeter-actor
class MessageController(message: String, printerActor: ActorRef) extends Actor {
  import MessageController._
  import Printer._

  var msgToPrint = ""

  def receive = {
    case ProcessMsg(who) =>
      msgToPrint = message + ", " + who
    case PrintMsg           =>
      //#greeter-send-message
      printerActor ! Printing(msgToPrint)
      //#greeter-send-message
  }
}
//#greeter-actor

//#printer-companion
//#printer-messages
object Printer {
  //#printer-messages
  def props: Props = Props[Printer]
  //#printer-messages
  final case class Printing(msgToPrint: String)
}
//#printer-messages
//#printer-companion

//#printer-actor
class Printer extends Actor with ActorLogging {
  import Printer._

  def receive = {
    case Printing(msgToPrint) =>
      log.info("Greeting received (from " + sender() + "): " + msgToPrint)
  }
}
//#printer-actor

//#main-class
object AkkaQuickstart extends App {
  import MessageController._

  // Create the 'helloAkka' actor system
  val system: ActorSystem = ActorSystem("helloAkka")

  //#create-actors
  // Create the printer actor
  val printerActor: ActorRef = system.actorOf(Printer.props, "printerActor")

  // Create the 'greeter' actors
  val actor1: ActorRef =
    system.actorOf(MessageController.props("Actor1 dice:", printerActor), "actor1")
  val actor2: ActorRef =
    system.actorOf(MessageController.props("Actor2 dice:", printerActor), "actor2")
  val Actor3: ActorRef =
    system.actorOf(MessageController.props("Actor3 dice:", printerActor), "Actor3")
  //#create-actors

  //#main-send-messages
  actor1 ! ProcessMsg("Mi primer saludo")
  actor1 ! PrintMsg

  actor1 ! ProcessMsg("Mi segundo saludo")
  actor1 ! PrintMsg

  actor2 ! ProcessMsg("Mi primer saludo")
  actor2 ! PrintMsg

  Actor3 ! ProcessMsg("Mi primer saludo")
  Actor3 ! PrintMsg
  //#main-send-messages
}
//#main-class
//#full-example
