import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.matchers.MustMatchers._

import scala.util.{Failure, Success, Try}


class FlatMapSpec extends FlatSpec {

  // Function which fails to demonstrate the flatmap.
  def functionWhichFails( arg : String ) : Try[String] = {
    Failure( new Exception("simulated failure") )
  }

  // Function which passes to demonstrate the flatmap.
  def functionWhichPasses( arg : String ) : Try[String] = {
    Success( arg.reverse )
  }

  "Flatmap" must "allow a passing function to execute something on success" in {
    val v = functionWhichPasses("hi").flatMap { message => Success(message) }
    v.get must be ( "ih" )
  }

  it must "allow a failing function to fail before executing something else" in {
    val v = functionWhichFails("hi").flatMap {
      // Never gets this far.
      message => Success( message)
    }
    v.isFailure must be ( true )
  }

}
