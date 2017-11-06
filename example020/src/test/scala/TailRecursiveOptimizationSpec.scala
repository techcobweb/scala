
import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.matchers.MustMatchers._

/**
  * A way of indicating that recusive function can be optimized
  */
class TailRecursiveOptimizationSpec extends FlatSpec {

  def fibonacci( nThTermToGet : Int ) : Int = {
    @annotation.tailrec
    def loop( termsLeftToCalculate : Int , term2ago : Int , term1ago : Int ) :Int = {
      if( termsLeftToCalculate <= 0 ) {
        term1ago
      } else {
        val nextTermValue = term2ago + term1ago
        loop( termsLeftToCalculate-1 , term1ago , nextTermValue )
      }
    }
    nThTermToGet match {
      case 1 => 0
      case _ => loop(nThTermToGet-2, 0, 1)
    }
  }

  "Fibonacci" must "have a 1st term of 0" in {
    fibonacci(1) must be(0)
  }
  it must "have a 2nd term of 1" in {
    fibonacci(2) must be(1)
  }
  it must "have a 3rd term of 1" in {
    fibonacci(3) must be(1)
  }
  it must "have a 4th term of 2" in {
    fibonacci(4) must be(2)
  }
  it must "have a 5th term of 3" in {
    fibonacci(5) must be(3)
  }
  it must "have a 6th term of 5" in {
    fibonacci(6) must be(5)
  }
}
