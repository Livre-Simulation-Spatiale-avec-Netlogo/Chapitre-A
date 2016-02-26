package org.netlogo.extension.sample;

import org.nlogo.api.*;

public class BuildRandomList extends DefaultReporter {
    public Syntax getSyntax() {
        return Syntax.reporterSyntax(new int[]{Syntax.NumberType()},Syntax.ListType());
    }

    public Object report(Argument args[], Context context) throws ExtensionException, LogoException {
        LogoListBuilder list = new LogoListBuilder();

        int n;
        try {
            n = args[0].getIntValue();
        } catch (LogoException e) {
            throw new ExtensionException(e.getMessage());
        }

        for (int i = 0; i < n; i++) {
            list.add(Double.valueOf(i));
        }

        return list.toLogoList();

    }

}