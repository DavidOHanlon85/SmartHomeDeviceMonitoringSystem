package smartHomeDeviceMonitoring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDeviceSearch {

	// test Data

	ArrayList<AllDevices> devices;

	AllDevices r1, r2, r3, r4, r5;

	ArrayList<Radiator> radiators;

	Radiator rr1, rr2, rr3, rr4, rr5;

	DeviceSearch ds;

	@BeforeEach
	void setUp() throws Exception {
		devices = new ArrayList<AllDevices>();

		r1 = new Radiator("name1", "man1", Room.HOUSE, Powerstate.ON, 21.0, 23.0);
		r2 = new Radiator("name1", "man1", Room.KITCHEN, Powerstate.OFF, 23.0, 24.0);
		r3 = new Radiator("name1", "man1", Room.KITCHEN, Powerstate.ON, 19.0, 26.0);
		r4 = new Radiator("name1", "man1", Room.BEDROOM, Powerstate.OFF, 28.0, 26.0);
		r5 = new Radiator("name1", "man1", Room.BEDROOM, Powerstate.ON, 17.0, 23.0);

		devices.add(r1);
		devices.add(r2);
		devices.add(r3);
		devices.add(r4);
		devices.add(r5);

		radiators = new ArrayList<Radiator>();

		rr1 = new Radiator("name1", "man1", Room.HOUSE, Powerstate.ON, 21.0, 23.0);
		rr2 = new Radiator("name1", "man1", Room.HOUSE, Powerstate.OFF, 23.0, 24.0);
		rr3 = new Radiator("name1", "man1", Room.HOUSE, Powerstate.ON, 19.0, 26.0);
		rr4 = new Radiator("name1", "man1", Room.HOUSE, Powerstate.OFF, 28.0, 26.0);
		rr5 = new Radiator("name1", "man1", Room.HOUSE, Powerstate.ON, 17.0, 23.0);

		radiators.add(rr1);
		radiators.add(rr2);
		radiators.add(rr3);
		radiators.add(rr4);
		radiators.add(rr5);

		ds = new DeviceSearch();

	}

	@Test
	void testSearchByRoomValid() {
		ArrayList<AllDevices> results = ds.searchByRoom(devices, Room.KITCHEN);

		assertTrue(results.size() == 2);
		assertTrue(results.contains(r2));
		assertTrue(results.contains(r3));

		results = ds.searchByRoom(devices, Room.BEDROOM);

		assertTrue(results.size() == 2);
		assertTrue(results.contains(r4));
		assertTrue(results.contains(r5));

	}
	
	@Test
	void testSearchByRoomInvalidNull() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			ds.searchByRoom(null, Room.BEDROOM);
		});
		
		assertEquals("AL IS NULL", exp.getMessage());

	}
	
	@Test
	void testSearchByRoomInvalidALEmpty() {
		
		devices.clear();
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			ds.searchByRoom(devices, Room.BEDROOM);
		});
		
		assertEquals("AL IS EMPTY", exp.getMessage());

	}
	
	@Test
	void testSearchByRoomInvalidRoomNull() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			ds.searchByRoom(devices, null);
		});
		
		assertEquals("ROOM IS NULL", exp.getMessage());

	}

	@Test
	void testSearchByTempValid() {
		ArrayList<Radiator> results = ds.searchByTemp(radiators, 16, 22);

		assertTrue(results.size() == 3);
		assertTrue(results.contains(rr1));
		assertTrue(results.contains(rr3));
		assertTrue(results.contains(rr5));
		
		results = ds.searchByTemp(radiators, 23, 28);

		assertTrue(results.size() == 2);
		assertTrue(results.contains(rr2));
		assertTrue(results.contains(rr4));

	}
	
	@Test
	void testSearchByTempInvalidALNull() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			ds.searchByTemp(null, 16, 22);
		});
		
		assertEquals("AL IS NULL", exp.getMessage());

	}
	
	@Test
	void testSearchByTempInvalidALEmpty() {
		
		radiators.clear();

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			ds.searchByTemp(radiators, 16, 22);
		});
		
		assertEquals("AL IS EMPTY", exp.getMessage());

	}
	
	@Test
	void testSearchByTempInvalidInvalidInput() {

		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			ds.searchByTemp(radiators, 22, 16);
		});
		
		assertEquals("INPUT ERROR", exp.getMessage());

	}

}
