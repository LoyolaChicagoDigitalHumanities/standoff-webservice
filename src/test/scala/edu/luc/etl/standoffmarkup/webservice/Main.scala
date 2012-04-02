package edu.luc.etl.standoffmarkup.webservice

import com.thaiopensource.xml.dtd.om._
import com.thaiopensource.xml.em.ExternalId

object Main {
  def main(args: Array[String]) = {
    val uem = new com.thaiopensource.xml.em.UriEntityManager
    val uriXHTML = com.thaiopensource.util.UriOrFile.toUri("config/dtds/xhtml1/DTD/xhtml1-transitional.dtd")
    val uriMathML = com.thaiopensource.util.UriOrFile.toUri("config/dtds/mathml3/mathml3.dtd")
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
  }
}

class DTD extends scala.xml.dtd.DTD

class TopLevelVisitorAdapter extends TopLevelVisitor {
  def attlistDecl(nameSpec: NameSpec, attributeGroup: AttributeGroup) { }
  def attributeDefaultDef(name: String, ad: AttributeDefault) { }
  def attributeGroupDef(name: String, attributeGroup: AttributeGroup) { }
  def comment(value: String) { }
  def datatypeDef(name: String, datatype: Datatype) { }
  def elementDecl(nameSpec: NameSpec, modelGroup: ModelGroup) { }
  def enumGroupDef(name: String, enumGroup: EnumGroup) { }
  def externalEntityDecl(name: String, externalId: ExternalId) { }
  def externalIdDef(name: String, externalId: ExternalId) { }
  def externalIdRef(name: String, externalId: ExternalId, uri: String, encoding: String, contents: Array[TopLevel]) { }
  def flagDef(name: String, flag: Flag) { }
  def ignoredSection(flag: Flag, contents: String) { }
  def includedSection(flag: Flag, contents: Array[TopLevel]) { }
  def internalEntityDecl(name: String, value: String) { }
  def modelGroupDef(name: String, modelGroup: ModelGroup) { }
  def nameSpecDef(name: String, nameSpec: NameSpec) { }
  def notationDecl(name: String, externalId: ExternalId) { }
  def overriddenDef(dfn: Def, isDuplicate: Boolean) { }
  def paramDef(name: String, value: String) { }
  def processingInstruction(target: String, value: String) { }
}

class ModelGroupVisitorAdapter extends ModelGroupVisitor {
  def any() { }
  def choice(members: Array[ModelGroup]) { }
  def elementRef(name: NameSpec) { }
  def modelGroupRef(name: String, modelGroup: ModelGroup) { }
  def oneOrMore(member: ModelGroup) { }
  def optional(member: ModelGroup) { }
  def pcdata() { }
  def sequence(members: Array[ModelGroup]) { }
  def zeroOrMore(member: ModelGroup) { }
}

class AttributeGroupVisitorAdapter extends AttributeGroupVisitor {
  def attribute(nameSpec: NameSpec, datatype: Datatype, attributeDefault: AttributeDefault) { }
  def attributeGroupRef(name: String, attributeGroup: AttributeGroup) { }
}

class DatatypeVisitorAdapter extends DatatypeVisitor {
  def cdataDatatype() { }
  def datatypeRef(name: String, datatype: Datatype) { }
  def enumDatatype(enumGroup: EnumGroup) { }
  def notationDatatype(enumGroup: EnumGroup) { }
  def tokenizedDatatype(typeName: String) { }
}

class EnumGroupVisitorAdapter extends EnumGroupVisitor {
  def enumGroupRef(name: String, enumGroup: EnumGroup) { }
  def enumValue(value: String) { }
}

class FlagVisitorAdapter extends FlagVisitor {
  def flagRef(name: String, flag: Flag) { }
  def ignore() { }
  def include() { }
}

class NameSpecVisitorAdapter extends NameSpecVisitor {
  def name(value: String) { }
  def nameSpecRef(name: String, nameSpec: NameSpec) { }
}

class AttributeDefaultVisitorAdapter extends AttributeDefaultVisitor {
  def attributeDefaultRef(name: String, ad: AttributeDefault) { }
  def defaultValue(value: String) { }
  def fixedValue(value: String) { }
  def impliedValue() { }
  def requiredValue() { }
}

class ModelGroupConverter() extends ModelGroupVisitorAdapter {
  override def any() { }
  override def choice(members: Array[ModelGroup]) { }
  override def elementRef(name: NameSpec) { }
  override def modelGroupRef(name: String, modelGroup: ModelGroup) { }
  override def oneOrMore(member: ModelGroup) { }
  override def optional(member: ModelGroup) { }
  override def pcdata() { }
  override def sequence(members: Array[ModelGroup]) { }
  override def zeroOrMore(member: ModelGroup) { }
}
