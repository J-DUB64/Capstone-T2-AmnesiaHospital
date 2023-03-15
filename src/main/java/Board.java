import com.amnesiaHospital.gson.Gson;
import com.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
  private Room startingRoom;

  public Board() {
    try {
      Gson gson = new Gson();
      Type roomListType = new TypeToken<List<Room>>() {}.getType();
      List<Room> rooms = gson.fromJson(new FileReader("game_data.json"), roomListType);

      // Create a map of room names to Room objects
      Map<String, Room> roomMap = new HashMap<>();
      for (Room room : rooms) {
        roomMap.put(room.getName(), room);
      }

      // Connect the exits to the actual room objects
      for (Room room : rooms) {
        for (Exit exit : room.getExits()) {
          exit.setRoom(roomMap.get(exit.getRoom().getName()));
        }
      }

      // Set the starting room
      startingRoom = rooms.get(0);

    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  public Room getStartingRoom() {
    return startingRoom;
  }
}