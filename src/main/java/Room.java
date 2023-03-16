import java.util.List;
import java.util.Map;

public class Room {
  private String name;
  private String description;
  private List<String> items;
  private Map<String, String> exits;

  public Room(String name, String description, List<String> items, Map<String, String> exits) {
    this.name = name;
    this.description = description;
    this.items = items;
    this.exits = exits;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public List<String> getItems() {
    return items;
  }

  public Map<String, String> getExits() {
    return exits;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }

  public void setExits(Map<String, String> exits) {
    this.exits = exits;
  }

  public void removeItem(String itemToRemove){
    for(String item : items){
      if(item.equals(itemToRemove)){
        items.remove(itemToRemove);
      }
    }
  }

}