package org.test

import org.nlogo.{ agent, api, nvm }
import java.util.Random
import api.Syntax._
import api.ScalaConversions._

class BuildRandomList extends api.DefaultReporter {
  val r = scala.util.Random

  override def getSyntax =
    reporterSyntax(Array(NumberType), ListType)
  def report(args: Array[api.Argument], context: api.Context): AnyRef = {
    val n = try args(0).getIntValue
    catch {
      case e: api.LogoException =>
        throw new api.ExtensionException(e.getMessage)
    }
    if (n < 0)
      throw new api.ExtensionException("input must be positive")
    (0 until n).map{_ => r.nextDouble}.toLogoList
  }
}