package tlglearning_tests.amnesiahopital_tests.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.tlglearning.amnesiahospital.model.Item;
import com.tlglearning.amnesiahospital.model.Player;
import com.tlglearning.amnesiahospital.model.Room;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerTest {

  private Player player;
  private Room startingRoom;

  @BeforeEach
  public void setUp() {
    startingRoom = Mockito.mock(Room.class);
    player = new Player("TestPlayer", startingRoom);
  }

  @Test
  public void testMoveToValidRoom() {
    Room targetRoom = Mockito.mock(Room.class);
    List<Room> rooms = new ArrayList<>();
    rooms.add(targetRoom);

    Map<String, String> exits = new HashMap<>();
    exits.put("north", "north1");
    when(startingRoom.getExits()).thenReturn(exits);
    when(targetRoom.getCoordinate()).thenReturn("north1");

    player.move("north", rooms);
    assertEquals(targetRoom, player.getCurrentRoom());
  }

  @Test
  public void testMoveToInvalidRoom() {
    Map<String, String> exits = new HashMap<>();
    when(startingRoom.getExits()).thenReturn(exits);

    player.move("north", new ArrayList<>());
    assertEquals(startingRoom, player.getCurrentRoom());
  }

  @Test
  public void testPickUpItem() {
    List<Item> items = new ArrayList<>();
    Item item = new Item("scalpel", "A small little knife", 4, 10, null, 4);
    items.add(item);

    when(startingRoom.getItems()).thenReturn(new ArrayList<>());
    startingRoom.getItems().add("scalpel");

    player.pickUpItem("scalpel", items);
    assertEquals(1, player.getInventory().size());
  }

}