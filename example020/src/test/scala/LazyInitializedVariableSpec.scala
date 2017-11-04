
import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.matchers.MustMatchers._

class LazyVariableInitialization() {

  // Note: var variables can't be lazy.

  private lazy val initializedLater = {
    println("lazy")
    5
  }

  private val initializedEager = {
    println("eager")
    2
  }

  def sum1() : Int = {
    // Note: use the laze variable in the expression first.
    println("sum")
    initializedLater + initializedEager
  }

}

class LazyInitializedVariableSpec extends FeatureSpec with GivenWhenThen {

  info("As someone wanting to learn scala")
  info("I want to see an example which uses the lazy keyword")
  info("So I can see how it works")

  feature("Lazy variable initialization") {

    scenario("Order of initialization") {

      Given("I have capture output when the code runs")
      val capturer= new java.io.ByteArrayOutputStream()
      Console.withOut( capturer ) {

        When("I run sum1 to add two numbers")
        val exampleClass = new LazyVariableInitialization()
        exampleClass.sum1()
      }

      Then("""The output demonstrates that the eager initialization occurred
        before the late lazy intitialization""")
      val capturedOutput = capturer.toString()
      val lazyIndex  = capturedOutput.indexOf("lazy")
      val eagerIndex = capturedOutput.indexOf("eager")
      val sumIndex   = capturedOutput.indexOf("sum")
      lazyIndex must be > eagerIndex
      sumIndex must be > eagerIndex
      lazyIndex must be > sumIndex
    }

  }
}
