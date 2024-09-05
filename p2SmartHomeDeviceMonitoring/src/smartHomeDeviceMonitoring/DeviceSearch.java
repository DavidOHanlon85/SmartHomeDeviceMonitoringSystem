/**
 * 
 */
package smartHomeDeviceMonitoring;

import java.util.ArrayList;

/**
 * David O'Hanlon - 15621049
 */
public class DeviceSearch {
	
	/**
	 * This methods searches and AL and returns an AL of those devices which match the input room.
	 * 
	 * IllegalArgumentExceptions are thrown with appropriate comments for AL null, Al empty and Room null
	 * @param devices
	 * @param room
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<AllDevices> searchByRoom (ArrayList<AllDevices> devices, Room room) throws IllegalArgumentException {
		
		ArrayList<AllDevices> results = new ArrayList<AllDevices>();
		
		if (devices == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}
		
		if (devices.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}
		
		if (room == null) {
			throw new IllegalArgumentException("ROOM IS NULL");
		}
		
		for (AllDevices a : devices) {
			if(a.getRoom() == room) {
				results.add(a);
			}
		}
		
		return results;
	}
	
	/**
	 * This methods searches and AL and returns an AL of those devices which fall within the minTemp and MaxTemp inclusive
	 * 
	 * IllegalArgumentExceptions are thrown with appropriate comments for AL null, Al empty and Input Errors
	 * @param radiators
	 * @param minTemp
	 * @param MaxTemp
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static ArrayList<Radiator> searchByTemp (ArrayList<Radiator> radiators, double minTemp, double MaxTemp) throws IllegalArgumentException {
		
		ArrayList<Radiator> results = new ArrayList<Radiator>();
		
		if (radiators == null) {
			throw new IllegalArgumentException("AL IS NULL");
		}
		
		if (radiators.size() == 0) {
			throw new IllegalArgumentException("AL IS EMPTY");
		}
		
		if (minTemp > MaxTemp) {
			throw new IllegalArgumentException("INPUT ERROR");
		}
		
		for (Radiator r : radiators) {
			if(r.getTempNow() >= minTemp && r.getTempNow() <= MaxTemp) {
				results.add(r);
			}
		}
		
		return results;
	}
}
