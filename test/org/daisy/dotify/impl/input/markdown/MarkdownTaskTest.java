package org.daisy.dotify.impl.input.markdown;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.daisy.dotify.api.tasks.InternalTaskException;
import org.junit.Test;

public class MarkdownTaskTest {

	@Test
	public void test_01() throws IOException, InternalTaskException, URISyntaxException {
		MarkdownTask mt = new MarkdownTask(Collections.emptyMap());
		File out = File.createTempFile("test", ".tmp");
		out.deleteOnExit();
		mt.execute(new File(this.getClass().getResource("resource-files/input.md").toURI()), out);
		List<String> actual = Files.readAllLines(out.toPath());
		List<String> expected = Files.readAllLines(
						Paths.get(this.getClass().getResource("resource-files/expected.html").toURI()));
		assertEquals(expected, actual);
	}
}