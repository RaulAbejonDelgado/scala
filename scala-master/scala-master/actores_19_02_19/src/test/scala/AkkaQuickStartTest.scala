import MessageController.{PrintMsg, ProcessMsg}
import Printer.Printing
import akka.actor.ActorSystem
import akka.testkit.{TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

class AkkaQuickStartTest(_system : ActorSystem) extends TestKit(_system ) with Matchers with WordSpecLike with BeforeAndAfterAll{

  def this() = this(ActorSystem("AkkaQuickStartTest"))

  override protected def afterAll(): Unit = {
    shutdown(system)
  }

  "A Greeter Actor" should {
    "pass on a greeting message when instructed to" in {
      //#specification-example
      val testProbe = TestProbe()
      val helloGreetingMessage = "hello"
      val helloGreeter = system.actorOf(MessageController.props(helloGreetingMessage, testProbe.ref))
      val greetPerson = "Akka"
      helloGreeter ! ProcessMsg(greetPerson)
      helloGreeter ! PrintMsg
      testProbe.expectMsg(Printing(helloGreetingMessage + ", " + greetPerson))
    }
  }

  "A MessageController Actor" should{
    "pass on a greeting message when instructed to" in {
      val testProbe = TestProbe();
      val msgToSendMessageController = "Im doing my first actor test2"
      val messageController = system.actorOf(MessageController.props(msgToSendMessageController,testProbe.ref))
      val actorName = "Actor1 dice:"
      val expectedMessage = "Actor1 dice"

      messageController ! ProcessMsg(actorName)
      messageController ! PrintMsg
      Printing(msgToSendMessageController + ", " + actorName)
      testProbe.expectMsg( Printing(msgToSendMessageController + ", " + actorName))
      //testProbe.expectMsg( "Im doing my first actor test2, Actor1 dice")

    }
  }
}
