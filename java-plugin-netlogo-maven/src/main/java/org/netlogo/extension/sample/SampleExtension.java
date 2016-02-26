
package org.netlogo.extension.sample;

import org.nlogo.api.DefaultClassManager;
import org.nlogo.api.PrimitiveManager;

public class SampleExtension extends DefaultClassManager {
  public void load (PrimitiveManager primitiveManager) {
        primitiveManager.addPrimitive("build-a-random-list", new BuildRandomList());
        //manager.addPrimitive("multiply-by-random", new MultiplyByRandom)
  }

}
