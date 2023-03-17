import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonData {

  public JsonData() {
  }


  public List<Room> getBoard() {
    return generateRooms();
  }

  private List<Room> generateRooms(){
    ObjectMapper objectMapper = new ObjectMapper();
    List<Room> roomData;

    try{
      roomData = objectMapper.readValue(new File("src/main/resources/room_data.json"), new TypeReference<List<Room>>(){});
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    return roomData;
  }

  public List<Item> getItems() {
    return generateItems();
  }
  private List<Item> generateItems() {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Item> itemData;
    try {
      itemData = objectMapper.readValue(new File("src/main/resources/item_data.json"), new TypeReference<List<Item>>(){});
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    return itemData;
  }

  public GameData getDialogue(){
    return generateDialogue();
  }
  private GameData generateDialogue() {
    ObjectMapper objectMapper = new ObjectMapper();
    GameData gameData = null;
    try {
      gameData = objectMapper.readValue(new File("src/main/resources/game_data.json"),
          GameData.class);

    } catch (
        JsonParseException e) {
      System.out.println("Error parsing JSON: " + e.getMessage());
    } catch (
        JsonMappingException e) {
      System.out.println("Error mapping JSON to object: " + e.getMessage());
    } catch (
        IOException e) {
      System.out.println("Error reading file: " + e.getMessage());
    }
    return gameData;
  }
}