package tlglearning_tests.amnesiahopital_tests.model;

import com.tlglearning.amnesiahospital.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

  private Item item;

  @BeforeEach
  public void setUp() {
    item = new Item("scalpel", "A small little knife", 4, 10, null, 4);
  }

  @Test
  public void testGetName() {
    assertEquals("scalpel", item.getName());
  }

  @Test
  public void testGetDescription() {
    assertEquals("A small little knife", item.getDescription());
  }

  @Test
  public void testGetType() {
    assertEquals(4, item.getType());
  }

  @Test
  public void testGetValue() {
    assertEquals(10, item.getValue());
  }

  @Test
  public void testGetDurability() {
    assertEquals(4, item.getDurability());
  }

  @Test
  public void testSetDurability() {
    item.setDurability(2);
    assertEquals(2, item.getDurability());
  }

  @Test
  public void testGetMapArt() {
    String[] mapArt = {"Line 1", "Line 2"};
    item = new Item("map", "A map of the hospital", 3, 0, mapArt, 0);
    assertEquals(mapArt, item.getMapArt());
  }
}

