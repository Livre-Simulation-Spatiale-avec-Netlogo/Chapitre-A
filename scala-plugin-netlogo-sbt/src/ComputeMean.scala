package org.test

import org.nlogo.api

import api.Syntax._
import api.ScalaConversions._
import org.nlogo.api._


class ComputeMean extends api.DefaultReporter {
  override def getSyntax = reporterSyntax(Array(Syntax.ListType), NumberType)

  def average(numbers: Vector[Double]): Double = numbers.sum / numbers.length

  def report(args: Array[api.Argument], context: api.Context):AnyRef = {

    val logoListNumbers:LogoList = try args(0).getList

    val logoListCasted:Vector[Double] = logoListNumbers.toVector.map {
      case d: java.lang.Double => d: Double
      case _ => throw new ExtensionException("The list can only contain numbers")
    }

    average(logoListCasted).toLogoObject
  }
}