package demo.springaop.spec;

import com.google.common.base.Strings;
import demo.springaop.service.IDigestService;
import demo.springaop.service.messages.DigestRequest;
import demo.springaop.service.messages.DigestResponse;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Component
public class DigestSteps {
    @Autowired
    private IDigestService digestService;
    private String plainString;
    private DigestResponse response;

    @Given("a plain string: $plainString")
    public void givenPlainString(String plainString) {
        this.plainString = plainString;
    }

    @When("the User hash the plain string using $hashAlgorithm algorithm")
    public void whenTheUserHashThePlainString(String hashAlgorithm) {
        // Do something
        response = digestService.digest(new DigestRequest(plainString, hashAlgorithm));
    }

    @Then("the plain string should be digested")
    public void thenThePlainStringShouldBeDigested() {
        assertThat(response, notNullValue());
        assertThat(Strings.isNullOrEmpty(response.getResult()), is(false));
        assertThat(response.getResult(), not(equalTo(plainString)));
    }
}