import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
  private String name;
  private String description;
  private String type;
  private int value;

  @JsonCreator
  public Item(@JsonProperty("name") String name,
      @JsonProperty("description") String description,
      @JsonProperty("type") String type,
      @JsonProperty("value") int value) {
    this.name = name;
    this.description = description;
    this.type = type;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getType() {
    return type;
  }

  public int getValue() {
    return value;
  }

  public void use(Player player) {
    switch (type.toLowerCase()) {
      case "health_serum":
        player.heal(value);
        System.out.println("You used " + name + " and healed " + value + " health points.");
        break;
      // Add more cases for different item types here
      default:
        System.out.println("This item cannot be used.");
        break;
    }
  }
}
