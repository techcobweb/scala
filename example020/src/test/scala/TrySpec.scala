
import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.matchers.MustMatchers._

import scala.util.{Failure, Success, Try}


class TrySpec extends FlatSpec {

  "Try" must "be able to convey success if it worked" in {

    val result : Try[String] = Try { "it worked!" }
    result match {
      case Success( theString ) => {
        theString must be("it worked!")
      }
      case Failure( ex ) => fail( ex ) // Not expected.
    }
  }

  it must "be able to convey a failure if it failed" in {
    val result : Try[String] = Try { throw new Exception("simulated failure message") }
    result match {
      case Success( theString ) => fail("expected a failure, got a success!")
      case Failure(ex) => {
        ex.isInstanceOf[Exception] must be(true)
        ex.getMessage() must be ("simulated failure message")
      }
    }
  }

  it must "be possible to return a success explicitly" in {
    val result : Try[String] = { Success("it worked") }
    result match {
      case Success( theString ) => theString.equals("it worked")
      case Failure(ex) => fail("should have worked!")
    }
  }

  it must "be possible to return a failure explicitly" in {
    val result : Try[String] = { Failure( new Exception("simulated failure") )}
    result match {
      case Success( theString ) => fail("Should have been a failure")
      case Failure(ex) => ex.getMessage() must be("simulated failure")
    }
  }

}
