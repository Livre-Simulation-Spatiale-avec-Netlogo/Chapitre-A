package org.test

import org.nlogo.{ agent, api, nvm }
import api.Syntax._
import api.ScalaConversions._  // implicits

class MyExtension extends api.DefaultClassManager {


  def load(manager: api.PrimitiveManager) {
    manager.addPrimitive("print-message", MyMessage)
    manager.addPrimitive("get-first-character", CountCharacter)
    manager.addPrimitive("build-a-random-list", BuildRandomList)
  }

}

object BuildRandomList extends api.DefaultReporter {
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


