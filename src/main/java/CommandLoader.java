import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class CommandLoader {
  public static List<Command> loadCommands(String fileName) {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Command> commands;

    try (InputStream jsonCommands = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream("resources/" + fileName)) {
      commands = objectMapper.readValue(jsonCommands, new TypeReference<>() {
      });
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }

    return commands;
  }
}
