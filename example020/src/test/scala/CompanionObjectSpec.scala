
import org.scalatest._
import org.scalatest.matchers._
import org.scalatest.matchers.MustMatchers._

class Person( age : Int ) {
  def isAbleToVote : Boolean = {
    age >= Person.MIN_AGE_OF_ADULT // Need the Person qualifier : just using MIN_AGE_OF_ADULT doesn't work.
  }
}

/**
  * A companion object. Think the 'static' part of a java class.
  * There is only one instance of this. Its' a singleton.
  * The name being the same as the class links the class to its' companion object.
  */
object Person {
  // Note: Even if private, the class can still access things in the companion object.
  private val MIN_AGE_OF_ADULT = 18
}

class CompanionObjectSpec extends FeatureSpec with GivenWhenThen {

  info("As someone wanting to learn scala")
  info("I want to see an example which uses a companion object")
  info("So I can see how it works")

  feature("CompanionObjectSpec: Person") {

    scenario("A minor can't vote") {

      Given("The person is 16")
      val person = new Person( 16 )

      When("I ask whether the person can vote")
      val isAbleToVote = person.isAbleToVote

      Then("The result says that a minor can't vote.")
      isAbleToVote must be (false)
    }

    scenario("A late teen can vote" ) {
      Given("The person is 19" )
      val person = new Person(19)

      When("I ask whether the person can vote")
      val isAbleToVote = person.isAbleToVote

      Then("The result says that a late teen can vote")
      isAbleToVote must be (true)
    }
  }
}
