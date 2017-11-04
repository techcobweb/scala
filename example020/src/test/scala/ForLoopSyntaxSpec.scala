
import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.matchers.MustMatchers._

object Looper {

  def range1() = {
    var total = 0

    for (num <- Seq(1, 2, 3, 4)) {
      total += num
    }

    total
  }

  def range2() = {
    var total = 0

    for( num <- 0 to 4 ) total += num

    total
  }



  def loopSkipping3() = {
    var total = 0

    // Should skip the number 3 as a result of the guard condition.
    // i.e Executes 0,1,2 and 4 as the loop counter.
    for( num <- 0 to 4
         if num != 3
       ) total += num

    total
  }

  def range4BracketsDifferent() = {
    var total = 0

    // Note the inside of the bracket is a unit which generates the
    // loop counter over successive calls.
    for { num <- 0 to 4 } total += num

    total
  }

  def loopsWithMultipleLoopVariables() = {
    val nums = Seq(1,2)
    val letters = Seq('a', 'b')

    val resultTuples = for {
      n <- nums
      c <- letters
    } yield (n, c)

    resultTuples
  }

}


class ForLoopSyntaxSpec extends FlatSpec {

  "Looper " must "return a total of 10 for range1" in {
    Looper.range1 must be(10)
  }

  it must "return 10 from range2" in {
    Looper.range2 must be(10)
  }

  it must "return 7 from loopSkipping3" in {
    Looper.loopSkipping3 must be (7)
  }

  it must "return 10 from range4BracketsDifferent" in {
    Looper.range4BracketsDifferent must be(10)
  }

  it must "produce all combinations from loopsWithMultipleLoopVariables" in {
    val result = Looper.loopsWithMultipleLoopVariables
    result.size must be (4)

    {
      val (a, b) = result(0)
      a must be(1)
      b must be('a')
    }

    {
      val (a, b) = result(1)
      a must be(1)
      b must be('b')
    }
  }

}
