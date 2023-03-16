import java.util.List;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Player {
  private String name;
  private int health;
  private Room currentRoom;
  private Weapon equippedWeapon;
  private Inventory inventory;

  public Player(String name, Room startingRoom) {
    this.name = name;
    this.health = 100;
    this.currentRoom = startingRoom;
    this.equippedWeapon = null;
    this.inventory = new Inventory();
  }

  public Room move(Direction direction, Room currentRoom) {
    List<Room> rooms = Board.getBoard();
    String nextRoomName = currentRoom.getExits().get(direction);
    for(Room room: rooms){
      if(room.getName().equals(nextRoomName)){
        return room;
      }
    }
    return currentRoom;
  }

//  public void equipWeapon(Weapon weapon) {
//    if (inventory.containsKey(weapon.getName())) {
//      equippedWeapon = weapon;
//      System.out.println("You have equipped " + weapon.getName());
//    } else {
//      System.out.println("You don't have that weapon in your inventory.");
//    }
//  }

  public void useItem(Item item) {
    if (inventory.contains(item)) {
//      Item item = inventory.get(item);
      item.use(this);
    } else {
      System.out.println("You don't have that item!");
    }
  }


  public void addItem(Item item) {
    inventory.add(item);
  }

  public void removeItem(Item item) {
    inventory.remove(item);
  }

  public void takeDamage(int damage) {
    health -= damage;
    if (health <= 0) {
      System.out.println("You have died!...what a shame");
    } else {
      System.out.println("You took " + damage + " damage. Health: " + health);
    }
  }

  public void heal(int healthPoints) {
    health += healthPoints;
    System.out.println("You healed " + healthPoints + " health points. Health: " + health);
  }

//  public void interact(Interactable interactable) {
//    interactable.interact(this);
//  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  public Inventory getInventory() {
    return inventory;
  }
}



