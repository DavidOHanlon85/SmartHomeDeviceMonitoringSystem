package smartHomeDeviceMonitoring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRadiator {
	
	// test data
	
	String validNameLow, validNameMid, validNameHigh;
	String invalidNameLow, invalidNameHigh;
	
	String validManLow, validManMid,validManHigh;
	String invalidManLow, invalidManHigh;
	
	Room house, kitchen, bedroom, bathroom, lounge;
	
	Powerstate on, off;
	
	double validTempNowLow, validTempNowMid, validTempNowHigh;
	double invalidTempNowLow, invalidTempNowHigh;
	
	double validTargetTempNowLow, validTargetTempNowMid, validTargetTempNowHigh;
	double invalidTargetTempNowLow, invalidTargetTempNowHigh;
	
	Radiator r;

	@BeforeEach
	void setUp() throws Exception {
		
		validNameLow = "AAA";
		validNameMid = "A".repeat(12);
		validNameHigh = "A".repeat(20);
			
		invalidNameLow = "A".repeat(2);
		invalidNameHigh = "A".repeat(21);
		
		validManLow = "AAA";
		validManMid = "A".repeat(12);
		validManHigh = "A".repeat(20);
		
		invalidManLow = "A".repeat(2);
		invalidManHigh = "A".repeat(21);
		
		house = Room.HOUSE;
		kitchen = Room.KITCHEN;
		bedroom = Room.BEDROOM;
		bathroom = Room.BATHROOM;
		lounge = Room.LOUNGE;
		
		on = Powerstate.ON;
		off = Powerstate.OFF;
		
		validTempNowLow = -10;
		validTempNowMid = 10;
		validTempNowHigh = 30;
		
		invalidTempNowLow = -11; 
		invalidTempNowHigh = -31;
		
		validTargetTempNowLow = 5;
		validTargetTempNowMid = 15; 
		validTargetTempNowHigh = 26;
		
		invalidTargetTempNowLow = 4;
		invalidTargetTempNowHigh = 27;
		
		r = new Radiator(validNameLow, validManMid, bathroom, on, validTempNowLow, validTargetTempNowHigh);
				
	}

	@Test
	void testRadiatorConstructorValid() {
		assertNotNull(r);
		assertEquals(validNameLow, r.getName());
		assertEquals(validManMid, r.getManufacturer());
		assertEquals(bathroom, r.getRoom());
		assertEquals(validTempNowLow, r.getTempNow());
		assertEquals(validTargetTempNowHigh, r.getTempTarget());
	}

	@Test
	void testRadiatorConstructorInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			r = new Radiator(invalidNameLow, validManMid, bathroom, on, validTempNowLow, validTargetTempNowHigh);
		});
		
		assertEquals("NAME LENGTH INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r = new Radiator(null, validManMid, bathroom, on, validTempNowLow, validTargetTempNowHigh);
		});
		
		assertEquals("NAME IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r = new Radiator(validNameLow, null, bathroom, on, validTempNowLow, validTargetTempNowHigh);
		});
		
		assertEquals("MANUFACTURER IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r = new Radiator(validNameLow, invalidManHigh, bathroom, on, validTempNowLow, validTargetTempNowHigh);
		});
		
		assertEquals("NAME MANUFACTURER INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r = new Radiator(validNameLow, validManMid, null, on, validTempNowLow, validTargetTempNowHigh);
		});
		
		assertEquals("ROOM IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r = new Radiator(validNameLow, validManMid, bathroom, null, validTempNowLow, validTargetTempNowHigh);
		});
		
		assertEquals("POWERSTATE IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r = new Radiator(validNameLow, validManMid, bathroom, on, invalidTempNowLow, validTargetTempNowHigh);
		});
		
		assertEquals("INVALID TEMPNOW", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r = new Radiator(validNameLow, validManMid, bathroom, on, validTempNowLow, invalidTargetTempNowHigh);
		});
		
		assertEquals("INVALID TEMP TARGET", exp.getMessage());
		
	}

	@Test
	void testSetGetTempNowValid() {
		r.setTempNow(validTempNowLow);
		assertEquals(validTempNowLow, r.getTempNow());
		
		r.setTempNow(validTempNowMid);
		assertEquals(validTempNowMid, r.getTempNow());
		
		r.setTempNow(validTempNowHigh);
		assertEquals(validTempNowHigh, r.getTempNow());
	}

	@Test
	void testSetGetTempNowInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setTempNow(invalidTempNowLow);
		});
		
		assertEquals("INVALID TEMPNOW", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setTempNow(invalidTempNowHigh);
		});
		
		assertEquals("INVALID TEMPNOW", exp.getMessage());
	}
	
	@Test
	void testSetGetTempTargetValid() {
		r.setTempTarget(validTargetTempNowLow);
		assertEquals(validTargetTempNowLow, r.getTempTarget());
		
		r.setTempTarget(validTargetTempNowMid);
		assertEquals(validTargetTempNowMid, r.getTempTarget());
		
		r.setTempTarget(validTargetTempNowHigh);
		assertEquals(validTargetTempNowHigh, r.getTempTarget());
		
	}
	
	@Test
	void testSetGetTempTargetInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setTempTarget(invalidTargetTempNowHigh);
		});
		
		assertEquals("INVALID TEMP TARGET", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setTempTarget(invalidTargetTempNowLow);
		});
		
		assertEquals("INVALID TEMP TARGET", exp.getMessage());
	
		
	}

	@Test
	void testGetSetNameValid() {
		r.setName(validNameLow);
		assertEquals(validNameLow, r.getName());
		
		r.setName(validNameMid);
		assertEquals(validNameMid, r.getName());
		
		r.setName(validNameHigh);
		assertEquals(validNameHigh, r.getName());
	}
	
	@Test
	void testGetSetNameInvalid() {
		
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setName(invalidNameLow);
		});
		
		assertEquals("NAME LENGTH INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setName(invalidNameHigh);
		});
		
		assertEquals("NAME LENGTH INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setName(null);
		});
		
		assertEquals("NAME IS NULL", exp.getMessage());
		
	}


	@Test
	void testGetSetManufacturerValid() {
		r.setManufacturer(validManLow);;
		assertEquals(validManLow, r.getManufacturer());
		
		r.setManufacturer(validManMid);;
		assertEquals(validManMid, r.getManufacturer());
		
		r.setManufacturer(validManHigh);;
		assertEquals(validManHigh, r.getManufacturer());
		
	}
	
	@Test
	void testGetSetManufacturerInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setManufacturer(null);
		});
		
		assertEquals("MANUFACTURER IS NULL", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setManufacturer(invalidManLow);
		});
		
		assertEquals("NAME MANUFACTURER INVALID", exp.getMessage());
		
		exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setManufacturer(invalidManHigh);
		});
		
		assertEquals("NAME MANUFACTURER INVALID", exp.getMessage());
		
	}

	@Test
	void testGetSetRoomValid() {
		r.setRoom(house);
		assertEquals(Room.HOUSE, r.getRoom());
		
		r.setRoom(bathroom);
		assertEquals(Room.BATHROOM, r.getRoom());
		
		r.setRoom(bedroom);
		assertEquals(Room.BEDROOM, r.getRoom());
		
		r.setRoom(kitchen);
		assertEquals(Room.KITCHEN, r.getRoom());
		
		r.setRoom(lounge);
		assertEquals(Room.LOUNGE, r.getRoom());
		
	}
	
	@Test
	void testGetSetRoomInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setRoom(null);
		});
		
		assertEquals("ROOM IS NULL", exp.getMessage());
		
	}

	@Test
	void testGetSetPowerstateValid() {
		r.setPowerstate(on);
		assertEquals(Powerstate.ON, r.getPowerstate());
		
		r.setPowerstate(off);
		assertEquals(Powerstate.OFF, r.getPowerstate());
	}

	@Test
	void testGetSetPowerstateInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, () -> {
			r.setPowerstate(null);
		});
		
		assertEquals("POWERSTATE IS NULL", exp.getMessage());
	}
	
	@Test
	void testStatus() {
		
		Radiator r1 = new Radiator("Radiatorstat", validManLow, bedroom, on, 18.7, 21.5);
		
		String result = r1.status();
		
		assertTrue(result.substring(0, 2).equals("SR"));
		assertTrue(result.contains("RADIATORSTAT"));
		assertFalse(result.contains(" "));
		assertTrue("SR-RADIATORSTAT-BEDROOM-NOW:18.7-TARGET:21.5-ON".equals(result));
		
	}

}
