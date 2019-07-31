package selenium;

import org.testng.annotations.Test;

public class JenkinsIntegrationTest extends browser{

	@Test
	public void test() {
		initiatebrowser();
		System.out.println("Maven project running");
	}
}
