package org.luc.etl.standoffmarkup.webservice

import cc.spray._

trait MarkupService extends Directives {

  val markupService = get {

    pathPrefix("languages") {
      path("") { _.complete("xhtml mathml") } ~
      pathPrefix("\\w+".r) { lang =>
        path("") { _.complete("/languages/" + lang + " is a cool language") } ~
        pathPrefix("elements") {
          path("") { _.complete("a img h1") } ~
          pathPrefix("\\w+".r) { elem =>
            path("") {
              _.complete("/languages/" + lang + "/elements/" + elem + " is a useful element")
            } ~
            path("content") {
              _.complete("/languages/" + lang + "/elements/" + elem + " has content #PCDATA")
            } ~
            pathPrefix("attributes") {
              path("") {
                _.complete("/languages/" + lang + "/elements/" + elem + " has attributes a b c")
              } ~
              pathPrefix("\\w+".r) { attr =>
                path("") {
                  _.complete("/languages/" + lang + "/elements/" + elem + "/attributes/" + attr + " is a useful attribute")
                } ~
                path("type") {
                  _.complete("/languages/" + lang + "/elements/" + elem + "/attributes/" + attr + " has type CDATA")
                } ~
                path("default") {
                  _.complete("/languages/" + lang + "/elements/" + elem + "/attributes/" + attr + " has default #IMPLIED")
                }
              }
            }
          }
        }
      }
    } ~
	pathPrefix("search") {
	  parameter('element) { elem =>
	    _.complete("found element matching " + elem + " in xhtml mathml")
	  }
	}
  }

}