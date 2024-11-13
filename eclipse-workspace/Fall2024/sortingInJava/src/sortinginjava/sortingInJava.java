package sortinginjava;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class sortingInJava {
	
	static ArrayList <FLcity> city = new ArrayList <FLcity>();
	static String input = "";
	static int response;

	public static void main(String[] args) {
		response = JOptionPane.showConfirmDialog(null, "do you want to continue???", "confimation",JOptionPane.YES_NO_OPTION); 
		if (response == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "you have sleected yes");
			FLcity newCity = new FLcity();
			newCity.getInfo();
			newCity.displayInfo();
			city.add(newCity);
		} else if (response == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "naur");
		} else {
			JOptionPane.showMessageDialog(null, "you have closed the box, you have failed :( ");
		}
	}
}

class FLcity {
	
	static String input = "";

	String cityName;
	int valueOfIndex;
	int AQI;
	String levelOfConcern;
	
	FLcity(){
		cityName = "";
		valueOfIndex = 0;
		AQI = 0;
		levelOfConcern = "";
	}
	
	FLcity(String cityName, int valueOfIndex, int AQI, String levelOfConcern){
		this.cityName = cityName;
		this.valueOfIndex = valueOfIndex;
		this.AQI = AQI;
		this.levelOfConcern = levelOfConcern;
	}
	
	void getInfo() {
		//check city input
		input = JOptionPane.showInputDialog("Please nenter the nameof the city : ");
		checkType();
		while(!checkType()) {
			JOptionPane.showMessageDialog(null,"incorrect must be letters only");
			input = JOptionPane.showInputDialog("Please Enter city name again... : "); 
			checkType();
		}
		cityName = input;
		//check value of index
		input = JOptionPane.showInputDialog("please enter this city's value of Index : ");
		checkValue();
		while(!checkValue()) {
			JOptionPane.showMessageDialog(null,"incorrect must be numbers only");
			input = JOptionPane.showInputDialog("Please Enter value of index : "); 
			checkValue();
		}//end while
		valueOfIndex = Integer.parseInt(input);
	}//end get info 
	
	
	
	
	void displayInfo(){
		JOptionPane.showMessageDialog(null, "city name : " + cityName + "\n" + "value of index : " + valueOfIndex);
	}//end display info
	
	boolean checkType() {
		 for (int i = 0; i < input.length(); i++) {
	            if (!Character.isLetter(input.charAt(i))) {
	                return false;
	          }
	            }
	        return true;
	    }//end check type
	
	
	boolean checkValue() {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
    return true;
    }//end check value
	
	
	
	void determineAQIandLevelOfConcern() {
		/*
		 * if value of index is = 0 or <= 50 : levelOfConcern is = good : AQI = green
		 * if value of index is >= 51 or <= 510 : levelOfConcern is = moderate : AQI = yellow
		 * if value of index is >= 101 or <= 150 : levelOfConcern is = unhealthy for sensitive groups : AQI = green
		 */
	}
	
	
	
	
}
