package org.luc.etl.standoffmarkup.webservice

import akka.config.Supervision._
import akka.actor.Supervisor
import akka.actor.Actor._
import cc.spray._

class Boot {

  val mainModule = new MarkupService {
    // bake your module cake here
  }

  val httpService = actorOf(new HttpService(mainModule.markupService))
  val rootService = actorOf(new RootService(httpService))

  Supervisor(
    SupervisorConfig(
      OneForOneStrategy(List(classOf[Exception]), 3, 100),
      List(
        Supervise(httpService, Permanent),
        Supervise(rootService, Permanent)
      )
    )
  )
}