/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author James
 */
public class NumberConversionModel {
    public String getGreetingsMessage(String name){
        return "Hello "+name+".\n"
                + "Greetings from the top\n"
                + " Java developerclass in town";
    }
    public double getMilesFromKilometers(double km){
        double miles = km/1.609344;
        return miles;
    }
    
    public double getKilometersFromMiles(double miles){
        double km = miles*1.609344;
        return km;
        
    }
    
}
