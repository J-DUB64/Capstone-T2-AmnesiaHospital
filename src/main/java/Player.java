import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class Player {
  private String name;
  private int health;
  private Room currentRoom;
  private Weapon equippedWeapon;
  private Map<String, Item> inventory;

  public Player(String name, Room startingRoom) {
    this.name = name;
    this.health = 100;
    this.currentRoom = startingRoom;
    this.equippedWeapon = null;
    this.inventory = new HashMap<>();
  }

  public void move(Direction direction) {
    Room nextRoom = currentRoom.getAdjacentRoom(direction);
    if (nextRoom != null) {
      currentRoom = nextRoom;
      System.out.println("You have moved to " + currentRoom.getDescription());
    } else {
      System.out.println("You can't go that way, there's nothing there.");
    }
  }

  public void equipWeapon(Weapon weapon) {
    if (inventory.containsKey(weapon.getName())) {
      equippedWeapon = weapon;
      System.out.println("You have equipped " + weapon.getName());
    } else {
      System.out.println("You don't have that weapon in your inventory.");
    }
  }

  public void useItem(String itemName) {
    Item item = inventory.get(itemName);
    if (item != null) {
      item.use(this);
      System.out.println("You used " + itemName);
    } else {
      System.out.println("You don't have that item in your inventory.");
    }
  }

  public void addItem(Item item) {
    inventory.put(item.getName(), item);
  }

  public void removeItem(String itemName) {
    inventory.remove(itemName);
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

  public void interact(Interactable interactable) {
    interactable.interact(this);
  }

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

  public Map<String, Item> getInventory() {
    return inventory;
  }
}



