package edu.luc.etl.standoffmarkup
package parser

import util.parsing.json.JSON.parseFull
import io.Source.fromFile

object MainJson {

  type SMap = Map[String, Any]

  def main(args: Array[String]) = {
    val xhtml1 = dtdFromFile("etc/json/xhtml1-transitional.dtd.json")
    val mathml3 = dtdFromFile("etc/json/mathml3.dtd.json")
    // element names
    Seq(xhtml1, mathml3) foreach { dtd =>
      println(dtd("@system-id") + " has elements " + elements(dtd))
    }
    // names of elements with attributes
    Seq(xhtml1, mathml3) foreach { dtd =>
      println(dtd("@system-id") + " has elements with attributes " + dtd("attlist").asInstanceOf[List[SMap]].map(_("@name")))
    }
    // attributes of a specific element
    Seq("br", "h1", "p") foreach { n =>
      println(n + " has attributes " + attributes(xhtml1, n))
    }
  }

  def dtdFromFile(fileName: String) = parseFull(fromFile(fileName) mkString).get.asInstanceOf[SMap]("dtd").asInstanceOf[SMap]

  def elements(dtd: SMap) = dtd("element").asInstanceOf[List[Map[String, Any]]].map(_("@name"))

  def attributes(dtd: SMap, elementName: String) = dtd("attlist").asInstanceOf[List[SMap]].find(_("@name") == elementName).get.asInstanceOf[SMap]("attribute").asInstanceOf[List[SMap]].map(_("@name"))
}

