package edu.luc.etl.standoffmarkup.parser

import com.thaiopensource.xml.dtd.om._
import com.thaiopensource.xml.em.ExternalId
import scala.xml.dtd.DTD

object Main {
  def main(args: Array[String]) = {
    val uem = new com.thaiopensource.xml.em.UriEntityManager
    val uriXHTML = com.thaiopensource.util.UriOrFile.toUri("etc/dtds/xhtml1/xhtml1-transitional.dtd")
    val uriMathML = com.thaiopensource.util.UriOrFile.toUri("etc/dtds/mathml3/mathml3.dtd")
    val dtdXHTML = new com.thaiopensource.xml.dtd.parse.DtdParserImpl().parse(uriXHTML, uem)
    val dtdMathML = new com.thaiopensource.xml.dtd.parse.DtdParserImpl().parse(uriMathML, uem)
    println(dtdMathML.getAllTopLevel.apply(0).asInstanceOf[Comment].getValue)
    val d = new scala.xml.dtd.DTD { }
    val v = new TopLevelVisitorAdapter {
      override def elementDecl(nameSpec: NameSpec, modelGroup: ModelGroup) {
    	println("element decl " + nameSpec.getValue + " " + modelGroup.toString)
      }
    }
    dtdXHTML.accept(v)
    dtdMathML.accept(v)
  }
}
