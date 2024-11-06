package hw4_hess;

/*
 * AUthor : Phillip Hess

 * Date: 11/1/24
 * Description : Vehicle documentation program, that takes in general Vehicle specs, along truck and jet ski specific specs -
 * it is designed with a vehicle super() class and two inherited classes.
 * it is designed with error handling so that every input must be correctly provided or you will be asked to re-enter
 */

import javax.swing.JOptionPane;

import java.util.ArrayList;

//==================   CLASS HW_4    =======================//



public class HW4_HESS {
	
	static ArrayList<Truck> truckList = new ArrayList<Truck>();
	
	static ArrayList<Jetski> jetskiList = new ArrayList<Jetski>();
	
	static String input = "";
	
	//
	
	//==================   MAIN    =======================//
	

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
						truckList.add(truck);
						break;
						
					case 2 : displayAllTrucks();
					break;
						
					case 3 : truckMenuSelection = 3;
					break;
					
					default : break;
					
					} //end truck selection
					
				}//end  while truck selection
				break;
				
			case 2 : 
				while(jetskiMenuSelection != 3) {
					jetskiMenuSelection = jetskiMenu();
					switch(jetskiMenuSelection) {
				
					case 1: Jetski jetski = new Jetski();
					jetski.getVehicleInfo();
					jetski.getJetskiInfo();
					jetski.displayVehiceInfo();
					jetski.displayJetskiInfo();
					jetskiList.add(jetski);

					break;
					
					case 2 : displayAllJetskis();
					break;
					
					case 3 : jetskiMenuSelection = 3;			
					break;
					
					default : break;
				
						}//end switch jet ski
					
					}//end while jet ski menu
				break;
				
			case 3 : JOptionPane.showMessageDialog(null, "Goodbye!");
			break;
			
			default: break;
				
				}//end switch selection
			
			
			}//end while selection 
		
	
					
		

	}//end main
	
	//==================   END MAIN    =======================//
	
	
	
	//==================  MENU     =======================//
	
	public static int menu() {
		int selection;
		input = JOptionPane.showInputDialog("to process a truck select - 1" + "\n" + 
											"to process a jet ski select - 2" + "\n" + 
											"to quit program select - 3");
		selection = Integer.parseInt(input);
		return selection;
		
	}//end menu
	
	//==================   END MENU    =======================//
	
	
	
	
	//==================   TRUCK MENU    =======================//
	
	
	public static int truckMenu() {
		int truckMenuSelection;
		input = JOptionPane.showInputDialog("to add truck select - 1" + "\n" + 
											"to display a truck select - 2" + "\n" + 
											"to go back to the main menu select - 3");
		truckMenuSelection = Integer.parseInt(input);
		return truckMenuSelection;
		
	}
	
	//==================    END TRUCK MENU   =======================//
	
	//==================    DISPLAY ALL TRUCKS   =======================//
	
	public static void displayAllTrucks() {
		for(int i = 0; i < truckList.size(); i++) {
			JOptionPane.showMessageDialog(null, "VIN : " + truckList.get(i).VIN + 
												"make : " + truckList.get(i).make +
												"model : " + truckList.get(i).model +
												"engine size : " + truckList.get(i).engineSize);
			
		}
		
	}
	
	//==================   END DISPLAY ALL TRUCKS    =======================//
	
	//==================  DISPLAY ALL JET SKIS     =======================//
	
	public static void displayAllJetskis() {
		for(int i = 0; i < jetskiList.size(); i++) {
			JOptionPane.showMessageDialog(null, "VIN : " + jetskiList.get(i).VIN + 
												"make : " + jetskiList.get(i).make +
												"model : " + jetskiList.get(i).model +
												"jetski type : " + jetskiList.get(i).type + 
												"jetski hours : " + jetskiList.get(i).hours);
			
		}
		
	}
	
	//==================    END DISPLAY ALL JETSKIS   =======================//

	
	//==================    JET SKI MENU   =======================//
	
	public static int jetskiMenu() {
		int jetskiMenuSelection;
		input = JOptionPane.showInputDialog("to process a jet ski select - 1" + "\n" + 
											"to display a jetski select - 2" + "\n" + 
											"to go back to the main menu select - 3");
		jetskiMenuSelection = Integer.parseInt(input);
		return jetskiMenuSelection;
		
	}
	
	//==================    END JET SKI MENU   =======================//
	
	

}//end class HW4

//==================   END CLASS HW_4    =======================//

//==================    CLASS VEHICLE   =======================//


class Vehicle{
	
	static String input = "";
	static boolean check = false;
	
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
	
	//==================    GET VEHICLE INFO  =======================//
	
	void getVehicleInfo() {
		input = JOptionPane.showInputDialog("Please Enter VIN : "); 
		checkVIN();
		VIN = input;
		while(!checkVIN()) {
			JOptionPane.showMessageDialog(null,"incorrect 10 charcaters number and letters only !!");
			input = JOptionPane.showInputDialog("Please Enter VIN : "); 
			VIN = input;
			checkVIN();
		}//end while
		
		input = JOptionPane.showInputDialog("Please Enter make : "); 
		checkMake();
		make = input;
		while(!checkMake()) {
			JOptionPane.showMessageDialog(null,"incorrect letters only !!");
			input = JOptionPane.showInputDialog("Please Enter Make : "); 
			make = input;
			checkMake();
		}//end while
		
		input = JOptionPane.showInputDialog("Please Enter model : "); 
		checkModel();
		model = input;
		while(!checkModel()) {
			JOptionPane.showMessageDialog(null,"incorrect letters only !!");
			input = JOptionPane.showInputDialog("Please Enter Make : "); 
			model = input;
			checkModel();
		}//end while
		
		
//		input = JOptionPane.showInputDialog("Please Enter model : "); 
//		model = input;
	}
	
	//==================    END GET VEHICLE INFO  =======================//

	
	//==================   DISPLAY VEHICLE INFO   =======================//

	
	void displayVehiceInfo() {
		JOptionPane.showMessageDialog(null, "VIN :" + VIN + "\n" + 
											"make :" + make + "\n" + 
											"model :" + model);
		
		
	}//end display truck 
	
	//==================   END DISPLAY VEHICLE INFO   =======================//

	
	//==================  CHECK MAKE    =======================//

	
	boolean checkMake() {
		  for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
           }
            }
        return true;
    }//end chackMake
	
	//==================   END CHECK MAKE   =======================//

	
	//==================   CHECK VIN   =======================//

	
	boolean checkVIN() {
		if (input.length() != 10) {
            return false;
	} else {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i)) && !Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
    }
    return true;
	}//end checkVIN
	
	//==================   END CHECK VIN   =======================//

	//==================   CHECK MODEL   =======================//

	
	boolean checkModel() {
	     for (int i = 0; i < input.length(); i++) {
	           if (!Character.isLetter(input.charAt(i)) && !Character.isDigit(input.charAt(i))) {
	               return false;
	           }
	       }
	     return true;
	   }
	
	//==================   END CHECK MODEL   =======================//

	
	
}//end class Vehicle

//==================    END CLASS VEHICLE   =======================//


//==================  CLASS TRUCK     =======================//



class Truck extends Vehicle{
	
	double engineSize;
	String input = "";
	
	Truck(){
		super();
		double engineSize = 0;
		
	}//end without arguments
	
	Truck(String VIN, String make, String model,double engineSize){
		super(VIN,make,model);
		this.engineSize = engineSize;
	}
	//end with arguments

	//==================    GET TRUCK INFO  =======================//

	
	void getTruckInfo() {
		input = JOptionPane.showInputDialog("Please Enter Engine Size : "); 
		checkSize();
		while(!checkSize()) {
			JOptionPane.showMessageDialog(null,"incorrect must be ##.# format!");
			input = JOptionPane.showInputDialog("Please Enter Engine Size : "); 
			checkSize();
		}//end while
		engineSize = Double.parseDouble(input);
	}//end get info
	
	//==================   END GET TRUCK INFO   =======================//

	
	//==================   DISPLAY TRUCK INFO   =======================//

	
	void displayTruckInfo() {
		JOptionPane.showMessageDialog(null, "Truck EngineSize :" + engineSize );
	}//end display truck 
	
	//==================   END DISPLAY TRUCK INFO   =======================//

	
	
	//==================   CHECK SIZE   =======================//

	
	boolean checkSize() {
    	if(input.length() != 4) {
    		return false;
    	}
    	if(!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(1))) {
    			return false;
    	}
    	if (input.charAt(2) != '.') {
    		return false;
    	}
    	if(!Character.isDigit(input.charAt(3))) {
			return false;
	}
    	return true;
    }//end check size
	
	//==================   END CHECK SIZE   =======================//

    
    
   
	
	
}//end sub class truck

//==================   END CLASS TRUCK    =======================//


//==================    CLASS JET SKI   =======================//



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
	
	//==================      =======================//

	
	void getJetskiInfo() {
		
		input = JOptionPane.showInputDialog("Please Enter jetSki type  : "); 
		checkType();
		while(!checkType()) {
			JOptionPane.showMessageDialog(null,"incorrect must be letter only");
			input = JOptionPane.showInputDialog("Please Enter jetSki type  : "); 
			checkType();
		}//end while
		type = input;
		
		
		input = JOptionPane.showInputDialog("please enter how many hours are on the engine : "); 
		checkHours();
		while(!checkHours()) {
			JOptionPane.showMessageDialog(null,"incorrect must be numbers only");
			input = JOptionPane.showInputDialog("Please Enter how many hours are on engine : "); 
			checkHours();
		}//end while
		hours = Integer.parseInt(input);
		
		
		
		
	}//end get info
	
	//==================   DISPLAY JET SKI INFO   =======================//

	
	void displayJetskiInfo() {
		JOptionPane.showMessageDialog(null, "Jet Ski Type : " + type + "\n" + 
											"JetSKi hours :" + hours );
	}//end display jetski
	
	//==================   END DISPLAY JET SKI INFO   =======================//

	//==================   CHECK TYPE   =======================//

	
	 boolean checkType() {
		 for (int i = 0; i < input.length(); i++) {
	            if (!Character.isLetter(input.charAt(i))) {
	                return false;
	           }
	            }
	        return true;
	    }
	 
		//==================   END CHECK TYPE   =======================//

	 
		//==================   CHECK HOURS   =======================//

	    
	    boolean checkHours() {
	        for (int i = 0; i < input.length(); i++) {
	            if (!Character.isDigit(input.charAt(i))) {
	                return false;
	            }
	        }
	    return true;
	    }
	    
		//==================   END CHECK HOURS   =======================//

	
}//end sub class jet ski

//==================    END CLASS JET SKI   =======================//



