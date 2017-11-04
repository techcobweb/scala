
import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.matchers.MustMatchers._

class HelloWorldSpec extends FeatureSpec with GivenWhenThen {

  info("As someone wanting to learn scala")
  info("I want to be able to run a hello world program")
  info("So I can see how it works")

  feature("Hello world program") {
    
    scenario("Outputs a message") {

      Given("I capture console output")
      val capturedOutput = new java.io.ByteArrayOutputStream()
      Console.withOut( capturedOutput ) {

        When("I run the hello main function")
        HelloWorld.main( Array("arg1","arg2"))
      }

      Then("the program prints Hello World")
      capturedOutput.toString() must be( "Hello World!\n" )
    }

  }
}
