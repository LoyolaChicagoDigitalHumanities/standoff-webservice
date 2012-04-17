package edu.luc.etl.standoffmarkup
package webservice

import org.slf4j.LoggerFactory

import scala.util.Properties
import akka.config.Supervision._
import akka.actor.{Supervisor, Actor}
import Actor._
import cc.spray.{HttpService, SprayCanRootService}
import cc.spray.can.{HttpServer, ServerConfig}

object Boot extends App {

  LoggerFactory.getLogger(getClass) // initialize SLF4J early

  val host = "0.0.0.0"
  val port = Properties.envOrElse("PORT", "8080").toInt

  val mainModule = new MarkupService {
    // bake your module cake here
  }

  val httpService = actorOf(new HttpService(mainModule.controller))
  val rootService = actorOf(new SprayCanRootService(httpService))
  val sprayCanServer = actorOf(new HttpServer(new ServerConfig(host = host, port = port)))

  Supervisor(
    SupervisorConfig(
      OneForOneStrategy(List(classOf[Exception]), 3, 100),
      List(
        Supervise(httpService, Permanent),
        Supervise(rootService, Permanent),
        Supervise(sprayCanServer, Permanent)
      )
    )
  )
}