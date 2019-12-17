package co.com.pagesearch.demo.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PageTest {

	private String content = "test #ContentMatcher page";

	@InjectMocks
	private Page page = new Page("", content);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getMatcherOkTest() {
		String pattern = "#";

		List<String> result = this.page.getMatcher(pattern);

		assertThat(result).isNotEmpty();
	}

	@Test
	public void getMatcherNotFoundTest() {
		String pattern = "@";

		List<String> result = this.page.getMatcher(pattern);

		assertThat(result).isEmpty();
	}
}
