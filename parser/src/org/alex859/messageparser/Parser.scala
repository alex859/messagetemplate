package org.alex859.messageparser

import scala.util.parsing.combinator.{RegexParsers, _}

// #{variable:parser:[args]}
class Parser extends RegexParsers {
  def temp: Parser[String]   = """#{\w:\w:\[[\w,]*\]""".r ^^ { case v => v.substring(1, v.length - 1)}
}

object Parser extends Parser {
  def main(args: Array[String]) = {
    parse(temp, "#{var1:test:[dsds]}") match {
      case Success(matched,_) => println(matched)
      case Failure(msg,_) => println("FAILURE: " + msg)
      case Error(msg,_) => println("ERROR: " + msg)
    }
  }
}

case class Message(variable: String, formatter: String, args: List[String])
