import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.matchers.MustMatchers._

class CurrySpec extends FlatSpec {

  def curry[A,B,C] (f: (A,B) => C ) : A => ( B => C ) = {
    x => y => f(x, y)
  }

  def diadic(a: String, b: String): String = a + b
  def monadic(a:String)(b:String) : String = a + b

  "Curry" must "be able to convert a diadic function into a monadic one" in {
    curry[String,String,String](diadic)("hi")(" there") must be( "hi there" )

    val f2 = curry[String,String,String](diadic)("hi")
    f2(" matey!") must be("hi matey!")
  }

  def uncurry[A,B,C] ( f: A =>B =>C) : ( A , B ) => C = {
    (a,b) => f(a)(b)
  }

  "UnCurry" must "be able to convery a moniadic into a diadic function" in {
    val uncurried = uncurry[String,String,String](monadic)
    uncurried("hi" ," there") must be ("hi there")
  }

  "PartiallyAppliedFunction" must "allow some parameters to be supplied later" in {
    val monadicResult = monadic("hi")(_)
    monadicResult(" there") must be ("hi there")
  }

  def compose[A,B,C]( f:B=>C , g:A=>B ) : A=>C = {
    a => f( g(a) )
  }

  "Compose" must "be able to ... " in {
    def rev( a : String ) = a.reverse
    def upper( a : String ) = a.toUpperCase

    val mutate = compose( rev , upper )
    mutate( "ab" ) must be("BA")
  }

}
