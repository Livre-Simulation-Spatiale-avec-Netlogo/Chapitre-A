package org.test;

import org.nlogo.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class ComputeMean extends DefaultReporter{

    /** way 1 using repeatableType
    public Syntax getSyntax() {
        return Syntax.reporterSyntax(new int[]{Syntax.NumberType() | Syntax.RepeatableType()},Syntax.NumberType());
    } */

    /** way 1 Corresponding call in netlogo : show (my-extension:get-mean 5.0 5.0 10.0)
     public Object report(Argument args[], Context context) throws ExtensionException, LogoException {

     ArrayList<Double> numbers = new ArrayList<Double>();

     try {

     for (int i = 0; i < args.length; i += 1) {
     numbers.add(args[i].getDoubleValue());
     }
     } catch (LogoException e) {
     throw new ExtensionException(e.getMessage());
     }

     return average(numbers);

     }*/

    /** way 2 using listType **/
    public Syntax getSyntax() {
        return Syntax.reporterSyntax(new int[]{Syntax.ListType()},Syntax.NumberType());
    }

    public double average(ArrayList<Double> numbers)
    {
        double average = 0.0;

        for (Double d : numbers) {
          average += d;
        }

        return average/numbers.size();
    }

    /* Utility method to safely cast LogoList into ArrayList<Double> */
    private LogoList getListOrNull(Argument args[]) throws ExtensionException, LogoException  {
        try {
            return args[0].getList();
        } catch (LogoException e) {
            return null;
        }
    }

    /* Way 2 : Corresponding call in netlogo : print my-extension:get-mean [5.0 5.0 10.0] **/
    public Object report(Argument args[], Context context) throws ExtensionException, LogoException   {

        final LogoList logoListNumbers = getListOrNull(args);

        // LogoList return an array of Object, so we need to cast to ArrayList[Double]
        Double[] logoDouble = null;
        try {
            Object[] objectArray = logoListNumbers.toArray();
            logoDouble = Arrays.copyOf(objectArray, objectArray.length, Double[].class);
        }catch (ClassCastException e){
            System.out.println("Cast Error, only numbers are supported here");
        }

        ArrayList<Double> numbers = new ArrayList<Double>(Arrays.asList(logoDouble));

        return average(numbers);

    }
}
