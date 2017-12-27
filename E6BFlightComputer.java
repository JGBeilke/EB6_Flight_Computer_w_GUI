public class E6BFlightComputer
{

   
   private double pressure , temperature, altitude, indicatedAS, windDirection, 
                  windDirectionRad, desiredCourse, desiredCourseRad, trueAS, 
                  windSpeed, groundSpeed, densityAltitude = 0, airportElevation,
                  windCorrectionAngleDeg = 0, windCorrectionAngleRad = 0;
   private String name;
          
   private final double constant1 = 17.326, constant2 = 459.67, constant3 = 145442.16, //constants for density altitude equation
                        constant4 = 1, constant5 = .235;
   private final double constant6 = 1000, constant7 = .02;
   
   public E6BFlightComputer() //default constructor based on "Standard day" 
   {
      name = "defaultConstructor";
      pressure = 29.3;   //inHg
      temperature = 59;   // degrees F
      altitude = 6500;    //feet
      indicatedAS = 120;  //knots
      desiredCourse = 270;//degrees from north
      desiredCourseRad = Math.toRadians(270);
      windDirection = 360;//degrees from north
      windDirectionRad = Math.toRadians(360);
      windSpeed = 15;     //knots
      airportElevation = -50; //feet
   }
   
   public E6BFlightComputer(String n, double p, double te, double aE, double a, double i,
                            double d, double wD, double wS)//constructor  
   {
      name = n;
      pressure = p;       //inHg
      temperature = te;   // degrees F
      altitude = a;       //feet
      indicatedAS = i;    //knots
      desiredCourseRad = Math.toRadians(d);  //radians from north
      desiredCourse   = d;    // degrees from north
      windDirectionRad = Math.toRadians(wD); //radians from north
      windDirection = wD; //degrees from north
      windSpeed = wS;     //knots
      airportElevation = aE; 
   }

   
   
   
   public double densityAltitude()
   {
      double rv;
      double base = (constant1*pressure)/(constant2 + temperature);
      densityAltitude = airportElevation + constant3*(constant4 - (Math.pow(base,constant5)));
      rv = roundToHundreds(densityAltitude);
      return rv;
   }
   
   public double trueAirspeed()
   {
      
      trueAS = indicatedAS + (altitude/constant6)*constant7*indicatedAS;
      return trueAS;
   }
   
   public double windCorrectionAngle()
   {  
      
      
      
      windCorrectionAngleRad = Math.asin((windSpeed * Math.sin(windDirectionRad - desiredCourseRad)/(this.trueAirspeed())));
      windCorrectionAngleDeg = Math.toDegrees(windCorrectionAngleRad);

      return windCorrectionAngleDeg;
   }
   
   public double groundSpeed()
   {
      
      
      groundSpeed =  Math.sqrt(Math.pow(this.trueAirspeed(), 2)+Math.pow(windSpeed, 2)-2*this.trueAirspeed()
                     *windSpeed*Math.cos(desiredCourseRad-windDirectionRad+this.windCorrectionAngle()));
      
      
      
      return groundSpeed;
   }
   
   private double roundToHundreds(double a)
   {
      double rv;
      rv = ((int)a+50)/100*100;
         
      
      return rv;
   }
   
  
   
   public String toString()
   {
      String rv;
      
      String pressureS = Double.toString(pressure);
      String temperatureS = Double.toString(temperature);
      String altitudeS = Double.toString(altitude);
      String indicatedASS = Double.toString(indicatedAS);
      String desiredCourseS = Double.toString(desiredCourse);
      String windDirectionS = Double.toString(windDirection);
      String windSpeedS = Double.toString(windSpeed);
      
      rv = "Pressure= " + pressureS + "\r\n"
      + "Temperature= " + temperatureS + "\r\n"
      + "Altitude= " + altitudeS + "\r\n"
      + "Indicated Airspeed= " + indicatedASS +"\r\n"
      + "Desired Course= " + desiredCourseS +"\r\n"
      + "Wind Direction= " + windDirectionS +"\r\n"
      + "Wind Speed= " + windSpeedS +"\r\n";
      
      return rv;
   }



   public static void main(String[] args)
   {
      E6BFlightComputer testActual = new E6BFlightComputer("testActual", 29.45, 95, 4000, 8000, 100, 360, 300, 5);// given data test
      System.out.println("Given data test, object name testActual:");
      System.out.println("Density altitude (expected 6800) = " + testActual.densityAltitude()+ "ft");
      System.out.println("True airspeed (expected 116) = " + testActual.trueAirspeed() + "knots");
      System.out.println("Wind correction angle (expected -2.139272905) = " +testActual.windCorrectionAngle()+ "degrees");
      System.out.println("GroundSpeed (expected 128.250805) = " + testActual.groundSpeed() + "knots");
      System.out.println("Contents of object testActual: \r" + testActual.toString());
      
      E6BFlightComputer defaultConstructor = new E6BFlightComputer();//default constructor test
      System.out.println("Default constructor test, object name defaultConstructor:");
      System.out.println("Density altitude (expected 700) = " + defaultConstructor.densityAltitude()+ "ft");
      System.out.println("True airspeed (expected 135.6) = " + defaultConstructor.trueAirspeed() + "knots");
      System.out.println("Wind correction angle (expected 6.351026465) = " +defaultConstructor.windCorrectionAngle()+ "degrees");
      System.out.println("GroundSpeed (expected 134.7678) = " + defaultConstructor.groundSpeed() + "knots");
      System.out.println("Contents of object defaultConstructor: \r" + defaultConstructor.toString());

   }
}