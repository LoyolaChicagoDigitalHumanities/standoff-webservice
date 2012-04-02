package edu.luc.etl.standoffmarkup.parser

import com.thaiopensource.xml.dtd.om._
import com.thaiopensource.xml.em.ExternalId

class TopLevelVisitorAdapter extends TopLevelVisitor {
  override def attlistDecl(nameSpec: NameSpec, attributeGroup: AttributeGroup) { }
  override def attributeDefaultDef(name: String, ad: AttributeDefault) { }
  override def attributeGroupDef(name: String, attributeGroup: AttributeGroup) { }
  override def comment(value: String) { }
  override def datatypeDef(name: String, datatype: Datatype) { }
  override def elementDecl(nameSpec: NameSpec, modelGroup: ModelGroup) { }
  override def enumGroupDef(name: String, enumGroup: EnumGroup) { }
  override def externalEntityDecl(name: String, externalId: ExternalId) { }
  override def externalIdDef(name: String, externalId: ExternalId) { }
  override def externalIdRef(name: String, externalId: ExternalId, uri: String, encoding: String, contents: Array[TopLevel]) { }
  override def flagDef(name: String, flag: Flag) { }
  override def ignoredSection(flag: Flag, contents: String) { }
  override def includedSection(flag: Flag, contents: Array[TopLevel]) { }
  override def internalEntityDecl(name: String, value: String) { }
  override def modelGroupDef(name: String, modelGroup: ModelGroup) { }
  override def nameSpecDef(name: String, nameSpec: NameSpec) { }
  override def notationDecl(name: String, externalId: ExternalId) { }
  override def overriddenDef(dfn: Def, isDuplicate: Boolean) { }
  override def paramDef(name: String, value: String) { }
  override def processingInstruction(target: String, value: String) { }
}

class ModelGroupVisitorAdapter extends ModelGroupVisitor {
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

class AttributeGroupVisitorAdapter extends AttributeGroupVisitor {
  override def attribute(nameSpec: NameSpec, datatype: Datatype, attributeDefault: AttributeDefault) { }
  override def attributeGroupRef(name: String, attributeGroup: AttributeGroup) { }
}

class DatatypeVisitorAdapter extends DatatypeVisitor {
  override def cdataDatatype() { }
  override def datatypeRef(name: String, datatype: Datatype) { }
  override def enumDatatype(enumGroup: EnumGroup) { }
  override def notationDatatype(enumGroup: EnumGroup) { }
  override def tokenizedDatatype(typeName: String) { }
}

class EnumGroupVisitorAdapter extends EnumGroupVisitor {
  override def enumGroupRef(name: String, enumGroup: EnumGroup) { }
  override def enumValue(value: String) { }
}

class FlagVisitorAdapter extends FlagVisitor {
  override def flagRef(name: String, flag: Flag) { }
  override def ignore() { }
  override def include() { }
}

class NameSpecVisitorAdapter extends NameSpecVisitor {
  override def name(value: String) { }
  override def nameSpecRef(name: String, nameSpec: NameSpec) { }
}

class AttributeDefaultVisitorAdapter extends AttributeDefaultVisitor {
  override def attributeDefaultRef(name: String, ad: AttributeDefault) { }
  override def defaultValue(value: String) { }
  override def fixedValue(value: String) { }
  override def impliedValue() { }
  override def requiredValue() { }
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
