package org.test;

import org.nlogo.api.DefaultClassManager;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.PrimitiveManager;

public class MyExtension extends DefaultClassManager {
  public void load (PrimitiveManager primitiveManager) throws ExtensionException {
      primitiveManager.addPrimitive("print-message", new MyMessage());
      primitiveManager.addPrimitive("get-mean", new ComputeMean());
      primitiveManager.addPrimitive("build-a-random-list", new BuildRandomList());
  }

}
