package smartHomeDeviceMonitoring;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Radiator r1 = new Radiator();
		
		r1.setTempTarget(26);
		r1.setTempNow(23);
		
		Radiator r2 = new Radiator("Radiator Stat", "Philips", Room.BEDROOM, Powerstate.ON, 14, 16);
//		r2.setTempTarget(21.5);
//		r2.setTempNow(18.7);
		r2.ShowAll();
		
		
		
		System.out.println(r2.status());
		

	}

}
