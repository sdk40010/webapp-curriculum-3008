import akka.actor.{Actor, ActorSystem, Props}

class CountActor extends Actor {
  var count = 0

  def receive = {
    case _ => {
      count += 1
      println(count)
    }
  }
}

object MessageCountActorApp extends App {
  val system = ActorSystem("messageCountActorApp")

  val countActor = system.actorOf(Props[CountActor], "countActor")

  for (i <- 1 to 10000) {
    countActor ! "test"
  }

  Thread.currentThread().join()
}
