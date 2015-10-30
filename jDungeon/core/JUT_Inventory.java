package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUT_Inventory {

	@Test
	public void testAddItem() {
		Inventory i = new Inventory();
		Item it = new Item("Kohle");
		i.addItem(it);
		assertEquals(i.getSize(), 1);
		it = new Item("Falzzange");
		i.addItem(it);
		assertEquals(i.getSize(), 2);
		i.drop_item(it);
		assertEquals(i.getSize(),1);
	}
	@Test
	public void testListInventory(){
		Item it = new Item("Kohle");
		it = new Item("Falzzange");
		
	}
}
