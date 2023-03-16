import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Board {
  List<Room> Board;

  public Board(){
      Board = generateRooms();
  }

  public List<Room> getBoard() {
    return Board;
  }

  private List<Room> generateRooms(){
    ObjectMapper objectMapper = new ObjectMapper();

    try (InputStream jsonRooms = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("resources/room_data.json")) {
      Board = objectMapper.readValue(jsonRooms, new TypeReference<>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    return Board;
  }

}