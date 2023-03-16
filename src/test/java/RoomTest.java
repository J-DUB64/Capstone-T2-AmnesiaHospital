import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class RoomTest {
  private Room room;

  @BeforeEach
  public void setUp() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    File file = new File("room_data.json");
    Room roomList = mapper.readValue(file, Room.class);
    List<Room> rooms = roomList.getRoom();
    room = rooms.get(0);
  }

  @Test
  public void testGetName() {
    Assertions.assertEquals("ICU Room #109", room.getName());
  }

  @Test
  public void testGetDescription() {
    String expectedDescription = "You wake up on a hospital bed in a dimly lit lobby. The only thing you can hear is the sound of your own heartbeat. The room looks empty, but you see the flicker of a light down the hall.";
    Assertions.assertEquals(expectedDescription, room.getDescription());
  }

  @Test
  public void testGetItems() {
    List<String> expectedItems = List.of();
    Assertions.assertEquals(expectedItems, room.getItems());
  }

  @Test
  public void testGetExits() {
    List<Exit> expectedExits = List.of(new Exit(Direction.EAST, "ICU Hallway South 5"));
    Assertions.assertEquals(expectedExits, room.getExits());
  }

  @Test
  public void testSetExit() {
    Room newRoom = new Room("New Room", "This is a new room", List.of(), List.of());
    room.setExit(Direction.EAST, newRoom);
    Exit expectedExit = new Exit(Direction.EAST, newRoom);
    Assertions.assertEquals(expectedExit, room.getExits().get(0));
  }
}