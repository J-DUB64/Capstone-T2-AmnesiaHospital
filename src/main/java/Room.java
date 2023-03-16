import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

public class Room {
  private String name;
  private String description;
  private List<String> items;
  private List<Exit> exits;

  public Room(String name, String description, List<String> items, List<Exit> exits) {
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

  public List<Exit> getExits() {
    return exits;
  }

  public void setExit(Direction direction, Room room) {
    for (Exit exit : exits) {
      if (exit.getDirection() == direction) {
        exit.setRoom(room);
        return;
      }
    }
  }

  public List<Room> getRoom() {
    return getRoom();
  }
}
