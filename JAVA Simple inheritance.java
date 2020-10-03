//inheritance is code reusability, one of the main pillars of OOP paradigm

class Bike {
	public int gears;
	public int speed;
	
	public Bike(int gears, int speed) {
		this.gears = gears;
		this.speed = speed;
	}
	
	public void applyBrakes(int decrement) {
		this.speed -= decrement;
	}
	
	public void applySpeed(int increment) {
		this.speed += increment;
	}
	
	@Override
	public String toString() {
		return "This bike has " + this.gears + " gears and its speed is: " + this.speed + "!";
	}
}

//single inheritance, super class(base class) is the Bike class, subclass or extending class is the MountainBike
//mountainbike reuses of bike's attributes/methods for free. 
class MountainBike extends Bike {
	public int seatHeight;
	
	//super() class the parents class(super class) constructor
	public MountainBike(int gears, int speed, int seatHeight) {
		super(gears, speed);
		this.seatHeight = seatHeight;
	}
	
	public void setHeight(int newHeight) {
		this.seatHeight += newHeight;
	}
	
	@Override
	public String toString() {
		return super.toString() + " and has a seat height of: " + this.seatHeight + " inches.";
	}
}

public class NQueens {
	public static void main(String[] args) {
		
		MountainBike mb1 = new MountainBike(3, 45, 28);
		System.out.println(mb1.toString());
		
	}
}
