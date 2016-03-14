package org.test

import org.nlogo.api
import org.nlogo.api._

class MyMessage extends api.DefaultReporter {
  override def getSyntax: Syntax = {
    return Syntax.reporterSyntax(Syntax.StringType)
  }

  def report(args: Array[api.Argument], context: api.Context):AnyRef = {
    return "hello world"
  }
}
