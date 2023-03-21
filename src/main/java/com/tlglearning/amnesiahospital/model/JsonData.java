package com.tlglearning.amnesiahospital.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    try(Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("room_data.json"))){
      roomData = objectMapper.readValue(reader, new TypeReference<List<Room>>() {});
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
    try(Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("item_data.json"))){
      itemData = objectMapper.readValue(reader, new TypeReference<List<Item>>(){});
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
    try(Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("game_data.json"))){
      gameData = objectMapper.readValue(reader, new TypeReference<GameData>() {});

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