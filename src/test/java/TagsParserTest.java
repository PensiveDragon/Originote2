import org.junit.jupiter.api.Test;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

class TagsParserTest {

    @Test
    public void parses_single_tag() {
        String tag = "#blessed";
        List<String> tagsList = TagsParser.createTagsList(tag);
        assertThat(tagsList, contains("blessed"));
    }
}
