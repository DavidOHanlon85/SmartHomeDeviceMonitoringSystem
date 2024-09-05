/**
 * 
 */
package smartHomeDeviceMonitoring;

import java.util.Objects;

/**
 * David O'Hanlon - 15621049
 */
public class Radiator extends AllDevices {

	// Constants

	private static final int MIN_TEMPNOW = -10;
	private static final int MAX_TEMPNOW = 30;

	private static final int MIN_TARGETTEMP = 5;
	private static final int MAX_TARGETTEMP = 26;

	// Instance Variables

	private double tempNow;
	private double tempTarget;

	/**
	 * Default radiator constructot
	 */
	public Radiator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Radiator constructor with args
	 * 
	 * @param name
	 * @param manufacturer
	 * @param room
	 * @param powerstate
	 * @param tempNow
	 * @param tempTarget
	 */
	public Radiator(String name, String manufacturer, Room room, Powerstate powerstate, double tempNow,
			double tempTarget) {
		super(name, manufacturer, room, powerstate);
		this.setTempTarget(tempTarget);
		this.setTempNow(tempNow);
		
		
		
	}

	// Getters and setters

	/**
	 * @return the tempNow
	 */
	public double getTempNow() {
		return tempNow;
	}

	/**
	 * This sets tempNow according to the business rules that it must be between -10
	 * and 30 (inclusive) and throws and IllegalArgumentException with appropriate
	 * message if outside this range
	 * 
	 * @param tempNow
	 * @throws IllegalArgumentException
	 */
	public void setTempNow(double tempNow) throws IllegalArgumentException {
		if (tempNow >= MIN_TEMPNOW && tempNow <= MAX_TEMPNOW && tempNow < getTempTarget()) {
			setPowerstate(Powerstate.ON);
			this.tempNow = tempNow;
		} else if (tempNow >= MIN_TEMPNOW && tempNow <= MAX_TEMPNOW && tempNow > getTempTarget()) {
			setPowerstate(Powerstate.OFF);
			this.tempNow = tempNow;
		} else {
			throw new IllegalArgumentException("INVALID TEMPNOW");
		}

	}

	/**
	 * @return the tempTarget
	 */
	public double getTempTarget() {
		return tempTarget;
	}

	/**
	 * @param tempTarget the tempTarget to set
	 */
	public void setTempTarget(double tempTarget) {
		if (tempTarget >= MIN_TARGETTEMP && tempTarget <= MAX_TARGETTEMP) {
			this.tempTarget = tempTarget;
			
		} else if (tempTarget >= MIN_TARGETTEMP && tempTarget <= MAX_TARGETTEMP) {
			this.tempTarget = tempTarget;
			
		} else {
			throw new IllegalArgumentException("INVALID TEMP TARGET");
		}

	}

	@Override
	public void ShowAll() {
		System.out.println("NAME\t\t: " + getName());
		System.out.println("MANUFACTURER\t: " + getManufacturer());
		System.out.println("ROOM\t\t: " + getRoom());
		System.out.println("POWERSTATE\t: " + getPowerstate());
		System.out.printf("TEMPNOW\t\t: %.1f Degrees %n", getTempNow());
		System.out.printf("TEMPTARGET\t: %.1f  Degrees %n", getTempTarget());
	}

	@Override
	public String status() {

		String radRef;
		
		String SRRef = "SR";
		
		String refName = getName();
		refName = refName.toUpperCase().replace(" ", "");

		radRef = SRRef + "-" + refName + "-" + getRoom() + "-NOW:" + String.format("%.1f", getTempNow())
				+ "-TARGET:" + String.format("%.1f", getTempTarget()) + "-" + getPowerstate();

		return radRef;
	} 
	
	//hashCode and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(tempNow, tempTarget);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Radiator other = (Radiator) obj;
		return Double.doubleToLongBits(tempNow) == Double.doubleToLongBits(other.tempNow)
				&& Double.doubleToLongBits(tempTarget) == Double.doubleToLongBits(other.tempTarget);
	}
	
	

}
