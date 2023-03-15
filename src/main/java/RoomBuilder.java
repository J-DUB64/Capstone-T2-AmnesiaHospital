
import java.util.ArrayList;
import java.util.List;

  public class RoomBuilder {
    private String name;
    private String description;
    private List<String> items;
    private List<Exit> exits;

    public RoomBuilder(String name, String description) {
      this.name = name;
      this.description = description;
      this.items = new ArrayList<String>();
      this.exits = new ArrayList<Exit>();
    }

    public RoomBuilder addItem(String item) {
      this.items.add(item);
      return this;
    }

    public RoomBuilder addExit(Direction direction, Room room) {
      this.exits.add(new Exit(direction, room));
      return this;
    }

    public Room build() {
      return new Room(name, description, items, exits);
    }
  }