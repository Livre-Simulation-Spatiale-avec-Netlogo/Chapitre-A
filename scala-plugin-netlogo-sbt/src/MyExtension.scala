package org.test

import org.nlogo.{ agent, api, nvm }
import api.Syntax._
import api.ScalaConversions._  // implicits

class MyExtension extends api.DefaultClassManager {

  def load(manager: api.PrimitiveManager) {
    manager.addPrimitive("print-message", new MyMessage())
    manager.addPrimitive("get-first-character", new ComputeMean())
    manager.addPrimitive("build-a-random-list", new BuildRandomList())
  }

}




