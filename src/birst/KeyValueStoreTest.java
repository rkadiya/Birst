package birst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KeyValueStoreTest {
	
	@Before
	public void runBeforeEachTestMethod() {
		KeyValueStore.store.clear();
    }
	
	@Test
	public void testValidInput() {
		KeyValueStore.create("birst=goodcompany");
		assertTrue(KeyValueStore.store.size() == 1);
		KeyValueStore.create("ravi=goodprogrammer");
		assertTrue(KeyValueStore.store.size() == 2);
		assertTrue(KeyValueStore.store.get("ravi").equals("goodprogrammer"));
	}
	
	@Test
	public void testInValidInput() {
		KeyValueStore.create("birst");
		assertTrue(KeyValueStore.store.size() == 0); // Since error.
	}
	
	@Test
	public void testCommonFunctionality() {
		KeyValueStore.create("birst=goodcompany");
		assertTrue(KeyValueStore.store.size() == 1);
		KeyValueStore.create("ravi=goodprogrammer");
		assertTrue(KeyValueStore.store.size() == 2);
		KeyValueStore.delete("ravi");
		assertTrue(KeyValueStore.store.size() == 1);
		KeyValueStore.update("birst=greatcompany");
		assertTrue(KeyValueStore.store.get("birst").equals("greatcompany"));
	}

}