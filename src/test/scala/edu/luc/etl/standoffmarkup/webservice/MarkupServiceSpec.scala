package edu.luc.etl.standoffmarkup.webservice

import org.specs2.mutable._
import cc.spray._
import test._
import http._
import HttpMethods._
import StatusCodes._

class MarkupServiceSpec extends Specification with SprayTest with MarkupService {

  "The standoff markup webservice" should {
    "return a greeting for GET requests to the root path" in {
      testService(HttpRequest(GET, "/")) {
        markupService
      }.response.content.as[String] mustEqual Right("welcome to the standoff markup webservice")
    }
    "reject GET requests to other paths" in {
      testService(HttpRequest(GET, "/kermit")) {
        markupService
      }.handled must beFalse
    }
    "return a MethodNotAllowed error for POST requests to the root path" in {
      testService(HttpRequest(POST, "/")) {
        markupService
      }.response mustEqual HttpResponse(MethodNotAllowed, "HTTP method not allowed, supported methods: GET")
    }
  }

}