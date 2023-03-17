import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventory extends ArrayList<Item> {

  private List<Item> inventory;

  public Inventory() {
  }

  public Inventory(List<Item> inventory) {
    this.inventory = inventory;
  }

  public List<Item> getInventory() {
    return inventory;
  }

  public void setInventory(List<Item> inventory) {
    this.inventory = inventory;
  }

}
