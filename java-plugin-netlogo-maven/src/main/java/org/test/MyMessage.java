package org.test;

import org.nlogo.api.*;

public class MyMessage extends DefaultReporter {

    public Syntax getSyntax() {
        return Syntax.reporterSyntax(Syntax.StringType());
    }

    public Object report(Argument args[], Context context)  {
        return "hello world";
    }
}
