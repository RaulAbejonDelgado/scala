package com.lightbend.akka.sample;

import java.io.IOException;

import com.lightbend.akka.sample.Greeter.Greet;
import com.lightbend.akka.sample.Greeter.WhoToGreet;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class AkkaQuickstart {
  public static void main(String[] args) {
    final ActorSystem system = ActorSystem.create("helloakka");
    try {
      //#create-actors
      final ActorRef printerActor = 
        system.actorOf(Printer.props(), "printerActor");
      final ActorRef howdyGreeter = 
        system.actorOf(Greeter.props("Actor1 dice : ", printerActor), "Actor1");
      final ActorRef helloGreeter = 
        system.actorOf(Greeter.props("Actor2 dice", printerActor), "Actor2");
      final ActorRef goodDayGreeter = 
        system.actorOf(Greeter.props("Actor3 dice", printerActor), "Actor3");
      //#create-actors

      //#main-send-messages
      howdyGreeter.tell(new WhoToGreet("Saludo 1"), ActorRef.noSender());
      howdyGreeter.tell(new Greet(), ActorRef.noSender());

      howdyGreeter.tell(new WhoToGreet("Saludo 2"), ActorRef.noSender());
      howdyGreeter.tell(new Greet(), ActorRef.noSender());

      helloGreeter.tell(new WhoToGreet("Saludo 1"), ActorRef.noSender());
      helloGreeter.tell(new Greet(), ActorRef.noSender());

      goodDayGreeter.tell(new WhoToGreet("Saludo 1"), ActorRef.noSender());
      goodDayGreeter.tell(new Greet(), ActorRef.noSender());
      //#main-send-messages

      System.out.println(">>> Press ENTER to exit <<<");
      System.in.read();
    } catch (IOException ioe) {
    } finally {
      system.terminate();
    }
  }
}
