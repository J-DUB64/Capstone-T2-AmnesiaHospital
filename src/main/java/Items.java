import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;

public class Items {
  List<Item> items;

  public Items() {
    items = generateItems();
  }

  public List<Item> getItems() {
    return items;
  }

  private List<Item> generateItems() {
    ObjectMapper objectMapper = new ObjectMapper();

    try (InputStream jsonItems = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("resources/item_data.json")) {
      items = objectMapper.readValue(jsonItems, new TypeReference<>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    return items;
  }

}
