/**
 * 
 */
package smartHomeDeviceMonitoring;

import java.util.Objects;

/**
 * David O'Hanlon - 15621049
 */
public abstract class AllDevices {

	// Constants

	private static final int MIN_NAME_LENGTH = 3;
	private static final int MAX_NAME_LENGTH = 20;

	private static final int MIN_MANUFACTURER_LENGTH = 3;
	private static final int MAX_MANUFACTURER_LENGTH = 20;

	// Instance variables

	private String name;
	private String manufacturer;
	private Room room;
	private Powerstate powerstate;

	// Constructors

	/**
	 * This is the AllDevices default constructor
	 */
	public AllDevices() {

	}

	/**
	 * AllDevices constructor with args
	 * 
	 * @param name
	 * @param manufacturer
	 * @param room
	 * @param powerstate
	 */
	public AllDevices(String name, String manufacturer, Room room, Powerstate powerstate) {
		this.setName(name);
		this.setManufacturer(manufacturer);
		this.setRoom(room);
		this.setPowerstate(powerstate);
	}

	// Getters and setters

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This setter sets the name according to the business rules that name must be
	 * between 3 and 20 characters inclusive. If null or outside this range and
	 * IllegalArgumentException will be thrown with appropriate messages
	 * 
	 * @param name
	 * @throws IllegalArgumentException
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("NAME IS NULL");
		}

		if (name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("NAME LENGTH INVALID");
		}

	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * This setter sets the manufacturer according to the business rules that
	 * manufacturer must be between 3 and 20 characters inclusive. If null or
	 * outside this range and IllegalArgumentException will be thrown with
	 * appropriate messages
	 * 
	 * @param manufacturer
	 * @throws IllegalArgumentException
	 */
	public void setManufacturer(String manufacturer) throws IllegalArgumentException {
		if (manufacturer == null) {
			throw new IllegalArgumentException("MANUFACTURER IS NULL");
		}

		if (manufacturer.length() >= MIN_MANUFACTURER_LENGTH && manufacturer.length() <= MAX_MANUFACTURER_LENGTH) {
			this.manufacturer = manufacturer;
		} else {
			throw new IllegalArgumentException("NAME MANUFACTURER INVALID");
		}

	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * Sets the ROOM. If input is null IllegalArugementException is thrown with
	 * appropriate error message.
	 * 
	 * @param room
	 * @throws IllegalArgumentException
	 */
	public void setRoom(Room room) throws IllegalArgumentException {
		if (room == null) {
			throw new IllegalArgumentException("ROOM IS NULL");
		} else {
			this.room = room;
		}

	}

	/**
	 * @return the powerstate
	 */
	public Powerstate getPowerstate() {
		return powerstate;
	}

	/**
	 * Sets the POWERSTATE. If input is null IllegalArugementException is thrown with
	 * appropriate error message.
	 * @param powerstate
	 * @throws IllegalArgumentException
	 */
	public void setPowerstate(Powerstate powerstate) throws IllegalArgumentException {
		if (powerstate == null) {
			throw new IllegalArgumentException("POWERSTATE IS NULL");
		} else {
			this.powerstate = powerstate;
		}
	} 
	
	//toString

	@Override
	public String toString() {
		return "AllDevices [name=" + name + ", manufacturer=" + manufacturer + ", room=" + room + ", powerstate="
				+ powerstate + "]";
	} 
	
	//hashCode and equals

	@Override
	public int hashCode() {
		return Objects.hash(manufacturer, name, powerstate, room);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllDevices other = (AllDevices) obj;
		return Objects.equals(manufacturer, other.manufacturer) && Objects.equals(name, other.name)
				&& powerstate == other.powerstate && room == other.room;
	}
	
	// Show all method
	
	public abstract void ShowAll();
	
	// Status method
	
	public abstract String status();

}
