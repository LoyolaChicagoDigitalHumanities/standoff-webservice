package edu.luc.etl.standoffmarkup
package parser

object MainJson {
  def main(args: Array[String]) = {
    val xhtml1 = util.parsing.json.JSON.parseFull(io.Source.fromFile("etc/json/xhtml1-transitional.dtd.json") mkString)
    val mathml3 = util.parsing.json.JSON.parseFull(io.Source.fromFile("etc/json/mathml3.dtd.json") mkString)
    Seq(xhtml1, mathml3) foreach { json =>
      println(json.get.asInstanceOf[Map[String, Any]]("dtd").asInstanceOf[Map[String, Any]]("element").asInstanceOf[List[Map[String, Any]]].map(_.asInstanceOf[Map[String, Any]]("@name")))
    }
  }
}
