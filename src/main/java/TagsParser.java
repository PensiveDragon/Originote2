import java.util.ArrayList;
import java.util.List;

public class TagsParser {
    public static List<String> createTagsList(String raw_string) {

        List<String> results = new ArrayList<>();
        String[] tags = raw_string.split("#");
        for (int i = 0; i < tags.length; i++) {
            String tag = tags[i].trim();
            //System.out.println(tags[i]);
            if (!tag.isEmpty()) {
                results.add(tag);
            }
        }
        //System.out.println(tags.length);
        return results;
    }
}
