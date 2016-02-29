package org.test;

import org.nlogo.api.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class ComputeMean extends DefaultReporter{

    public Syntax getSyntax() {
        return Syntax.reporterSyntax(new int[]{Syntax.NumberType() | Syntax.RepeatableType()},Syntax.NumberType());
    }


    // show (my-extension:get-mean 5.0 5.0 10.0)
    public Object report(Argument args[], Context context) {//throws ExtensionException, LogoException {

        List<Double> numbers = new ArrayList<Double>(args.length);

        int nargs = args.length;
        return Double.valueOf(nargs);

       /* try {
            for (int i = 0; i < args.length; i += 1) {
                numbers.add(args[0].getDoubleValue());
            }
        } catch (LogoException e) {
            throw new ExtensionException(e.getMessage());
        }

        return calculateAverage(numbers);*/
    }
}
