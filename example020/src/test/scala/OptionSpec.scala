
import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.matchers.MustMatchers._

/**
  * Option is a way of avoiding usinbg null, and makes it harder to get null pointer exceptions.
  */
class OptionSpec extends FlatSpec {

  "Option" must "Be assignable with None" in {
    val a : Option[String] = None
  }

  it must "be undefined if its' None" in {
    val a : Option[String] = None
    a.isDefined must be(false)
  }

  it must "match a none in a match block" in {
    val a : Option[String] = None
    a match {
      case Some( theString ) => fail("not expected")
      case None => {} // Passed
    }
  }

  "Option" must "be assignable with Some" in {
    val a : Option[String] = Some("hello")
  }

  it must "be defined if it is Some" in {
    val a : Option[String] = Some("hello")
    a.isDefined must be (true)
  }

  it must "match a Some in a match block" in {
    val a : Option[String] = Some("hello")
    a match {
      case None => fail("Not expected")
      case Some(value) => {} // Passed
    }
  }


}
