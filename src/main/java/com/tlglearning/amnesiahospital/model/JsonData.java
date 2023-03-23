package com.tlglearning.amnesiahospital.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
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

    //noinspection ConstantConditions
    try (Reader reader = new InputStreamReader(
        getClass().getClassLoader().getResourceAsStream("room_data.json"))) {
      roomData = objectMapper.readValue(reader, new TypeReference<List<Room>>() {
      });
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
    //noinspection ConstantConditions
    try (Reader reader = new InputStreamReader(
        getClass().getClassLoader().getResourceAsStream("item_data.json"))) {
      itemData = objectMapper.readValue(reader, new TypeReference<List<Item>>() {
      });
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
    //noinspection ConstantConditions
    try (Reader reader = new InputStreamReader(
        getClass().getClassLoader().getResourceAsStream("game_data.json"))) {
      gameData = objectMapper.readValue(reader, new TypeReference<GameData>() {
      });

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


  public List<Npc> getNPC() {
    return generateNPC();
  }

 private List<Npc> generateNPC() {

  private List<Npc> fromJsonFile(String jsonFilePath) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File(jsonFilePath),
          new TypeReference<List<Npc>>() {
          });
    } catch (IOException e) {
      throw new RuntimeException("Failed to read JSON file: " + jsonFilePath,
          e);
    }
  }

      try (Reader reader = new InputStreamReader(
        getClass().getClassLoader().getResourceAsStream("npc_data.json"))) {
      npcData = objectMapper.readValue(reader, new TypeReference<List<Npc>>() {
      });



  public static List<Command> generateHelp() {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Npc> npcData;


    try(Reader reader = new InputStreamReader(JsonData.class.getClassLoader().getResourceAsStream("command_data.json"))){
      helpData = objectMapper.readValue(reader, new TypeReference<List<Command>>(){});

    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    return npcData;
  }

  public List<Zombie> getZombies() {
    return generateZombies();
  }

  private List<Zombie> generateZombies(){
    ObjectMapper objectMapper = new ObjectMapper();
    List<Zombie> zombieData;

    //noinspection ConstantConditions
    try(Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("zombie_data.json"))){
      zombieData = objectMapper.readValue(reader, new TypeReference<List<Zombie>>() {});
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    return zombieData;
  }

}
