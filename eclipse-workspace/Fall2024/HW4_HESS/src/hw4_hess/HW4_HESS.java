package hw4_hess;

/*
 * AUthor : Phillip Hess
 * Date: 11/1/24
 * Description : Homework 4
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class HW4_HESS {
	
	static ArrayList<Truck> truckList = new ArrayList<Truck>();
	
	static ArrayList<Jetski> jetskiList = new ArrayList<Jetski>();
	
	static String input = "";
	

	public static void main(String[] args) {
		
		int selection = 0;
		int truckMenuSelection = 0;
		int jetskiMenuSelection = 0;
		
		JOptionPane.showMessageDialog(null, "hello world");
		while (selection != 3){
			selection = menu();
			switch(selection) {
			case 1 :
				while(truckMenuSelection != 3) {
					truckMenuSelection = truckMenu();
					switch(truckMenuSelection) {
					case 1 : 
						Truck truck = new Truck();
						truck.getVehicleInfo();
						truck.getTruckInfo();
						truck.displayVehiceInfo();
						truck.displayTruckInfo();
						break;
					case 2 :
						break;
					default : break;
					} //end truck selection
					
				}//end  while truck selection
				
			case 2 : 
			Jetski jetski = new Jetski();
			jetski.getVehicleInfo();
			jetski.getJetskiInfo();
			jetski.displayVehiceInfo();
			jetski.displayJetskiInfo();
			break;
			case 3 : JOptionPane.showMessageDialog(null, "goodbye!!"); 
			break;
			}//end selection
		}//end while

	}//end main
	
	
	
	public static int menu() {
		int selection;
		input = JOptionPane.showInputDialog("to process a truck select - 1" + "\n" + 
											"to process a jet ski select - 2" + "\n" + 
											"to quit program select - 3");
		selection = Integer.parseInt(input);
		return selection;
		
	}//end menu
	
	
	
	public static int truckMenu() {
		int truckMenuSelection;
		input = JOptionPane.showInputDialog("to add truck select - 1" + "\n" + 
											"to display a truck select - 2" + "\n" + 
											"to go back to the main menu select - 3");
		truckMenuSelection = Integer.parseInt(input);
		return truckMenuSelection;
		
	}
	
	
	
	public static int jetskiMenu() {
		int jetskiMenuSelection;
		input = JOptionPane.showInputDialog("to process a truck select - 1" + "\n" + 
											"to process a jet ski select - 2" + "\n" + 
											"to quit program select - 3");
		jetskiMenuSelection = Integer.parseInt(input);
		return jetskiMenuSelection;
		
	}
	
	

}//end class HW4

class Vehicle{
	
	static String input = "";
	
	String VIN;
	String make;
	String model;
	
	Vehicle(){
		VIN = "";
		make = "";
		model = "";
		
	}//end without arguments
	
	Vehicle(String VIN, String make, String model){
		this.VIN = VIN;
		this.make = make;
		this.model = model;
		
	}
	
	void getVehicleInfo() {
		input = JOptionPane.showInputDialog("Please Enter VIN : "); 
		VIN = input;
		input = JOptionPane.showInputDialog("Please Enter make : "); 
		make = input;
		input = JOptionPane.showInputDialog("Please Enter model : "); 
		model = input;
	}
	
	void displayVehiceInfo() {
		JOptionPane.showMessageDialog(null, "VIN :" + VIN + "\n" + 
											"make :" + model + "\n" + 
											"model :" + make);
	}//end display truck 
	
	
}//end class Vehicle




class Truck extends Vehicle{
	
	int engineSize;
	String input = "";
	
	Truck(){
		super();
		int engineSize = 0;
		
	}//end without arguments
	
	Truck(String VIN, String make, String model,int engineSize){
		super(VIN,make,model);
		this.engineSize = engineSize;
	}
	//end with arguments
	
	void getTruckInfo() {
		input = JOptionPane.showInputDialog("Please Enter Engine Size : "); 
		engineSize = Integer.parseInt(input);
	}//end get info
	
	void displayTruckInfo() {
		JOptionPane.showMessageDialog(null, "Truck EngineSize :" + engineSize );
	}//end display truck 
	
	
}//end sub class truck




class Jetski extends Vehicle{
	
	String type;
	int hours;
	
	Jetski(){
		super();
		type = "";
		hours = 0;
	}//end without arguments
	
	Jetski(String VIN, String make, String model, String type, int hours){
		super(VIN,make,model);
		this.type = type;
		this.hours = hours;
	}
	
	void getJetskiInfo() {
		input = JOptionPane.showInputDialog("Please jet-ski type : "); 
		type = input;
		input = JOptionPane.showInputDialog("Please enter hours on engine: "); 
		hours = Integer.parseInt(input);
	}//end get info
	
	void displayJetskiInfo() {
		JOptionPane.showMessageDialog(null, "Jet Ski Type : " + type + "\n" + 
											"JetSKi hours :" + hours );
	}//end display truck 
	
}//end sub class jet ski


