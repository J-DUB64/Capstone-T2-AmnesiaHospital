package com.tlglearning.amnesiahospital.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {
  private String name;
  private String coordinate;
  private String description;
  private List<String> items;
  private Map<String, String> exits;



  @JsonCreator
  public Room(@JsonProperty("name") String name,
    @JsonProperty("coordinate") String coordinate,
    @JsonProperty("description")String description,
    @JsonProperty("items")List<String> items,
    @JsonProperty("exits")Map<String, String> exits) {
    this.name = name;
    this.coordinate = coordinate;
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

  public Map<String, String> getExits() {
    return exits;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setItems(List<String> items) {
    this.items = items;
  }

  public void setExits(Map<String, String> exits) {
    this.exits = exits;
  }

  public String getCoordinate() {
    return coordinate;
  }

  public void setCoordinate(String coordinate) {
    this.coordinate = coordinate;
  }

//  public void removeItem(String itemToRemove){
//    for(String item : items){
//      if(item.equals(itemToRemove)){
//        items.remove(itemToRemove);
//      }
//    }
//  }

}
