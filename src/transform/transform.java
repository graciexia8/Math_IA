/*Program Name:Escher :(
 *Programmer Name:Gracie Xia
 *Program Description: A program that aids in the creation of my MathIA. Converts 3d 
 *points interchangeably from WeierStrass/Poincare model
 *Also Gives options for appropriate transformations
 *Date of Creation: February 4, 2017 
 * */

package transform;

//import libraries
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class transform {
	
	static String Indicator;//Holds the completed action of the user
	static float x,y,z,p,q;
	static float radius;
	public static void main(String[] args)throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		CoordinateEnter();
		pqask();
		
		String continueLoop = "yes";
		
		while (!continueLoop.equals("no")){
		menuPrint();
		prompt();
		
		System.out.println("\nWould you like to continue?(Yes/no): ");
		continueLoop = input.readLine();
		}
	}//end of Main Method
	
	public static void CoordinateEnter () throws IOException{
		//User Input Reader
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("What is the diameter of your circle (cm): ");
		radius = Float.parseFloat(input.readLine());
		System.out.println("Enter your x co-ordinate:");
		x = Float.parseFloat(input.readLine())/radius;
		System.out.println("Enter your y co-ordinate:");
		y = Float.parseFloat(input.readLine())/radius;
		System.out.println("Your Z co-o		rdinate is 0");
		z = 0;	//User Input Reader
		
		
	}//end of CoordinateEnter
	
	public static void pqask () throws IOException {
		//User Input Reader
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("What is the p value?: ");
		p = Float.parseFloat(input.readLine());
		System.out.println("What is the q value?: ");
		q = Float.parseFloat(input.readLine());
		
				
	}//end of pqask
	public static void menuPrint () throws IOException{
		
		
			//User Input Reader
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
		//User prompt to choose option
		System.out.println("----------------------------------------------------");
		System.out.println("type the number corresponding to the option you want");
		System.out.println("----------------------------------------------------");
		
		System.out.println("1.Poincare to Weierstrass?\n2.Weierstrass to Poincare?\n3.ReflectP\n4.ReflectQ\n5.Reflect2\n6.radius converter\n7.show coordinates\n8.ReflectY");
		String PWOption = input.readLine();
		
		while (!PWOption.equals("1") && !PWOption.equals("2") && !PWOption.equals("3") && !PWOption.equals("4") && !PWOption.equals("5")&& !PWOption.equals("6")&& !PWOption.equals("7") && !PWOption.equals("8")){
			System.out.println("1.Poincare to Weierstrass?\n2.Weierstrass to Poincare?\n3.ReflectP\n4.ReflectQ\n5.Reflect2\n6.radius converter\n7.show coordinates\n8.Reflect Y");
			PWOption = input.readLine();
		}//END WHILE
		
		if (PWOption.equals("1")){
			poincareToWeierstrass();
		}//end if 
		else if (PWOption.equals("2")){
			WeierstrassTopoincare();
		}//end else if
		else if (PWOption.equals("3")){
			reflectP();
		}
		else if (PWOption.equals("4")){
			reflectQ();
		}
		else if (PWOption.equals("5")){
			reflecttwo();
		}
		else if (PWOption.equals("6")){
			radiusconverter();
		}
		else if (PWOption.equals("7")){
			showCoordinates();
		}
		else if (PWOption.equals("8")){
			ReflectY();
		}
	}//END OF MENUPRINT
	
	public static void poincareToWeierstrass(){
		Indicator = "Poincare to Weierstrass ";
		
		float xinitial = (float) ((1/(1-Math.pow(x,2)-Math.pow(y,2)))*2*x);
		float yinitial = (float) ((1/(1-Math.pow(x,2)-Math.pow(y,2)))*2*y);
		float zinitial = (float) ((1/(1-Math.pow(x,2)-Math.pow(y,2)))*(1+Math.pow(x,2)+Math.pow(y,2)));
		
		x = xinitial;
		y = yinitial;
		z = zinitial;
		
	}//END poincareToWeierstrass
	
	public static void WeierstrassTopoincare(){
		Indicator = "Weierstrass to Poincare";
		
		float xinitial = ((1/(1+z))*x);
		float yinitial = ((1/(1+z))*y);
		float zinitial = 0;
		
		x = xinitial;
		y = yinitial;
		z = zinitial;
		
	}//END WeierstrassTopoincare
	public static void reflectP(){
		Indicator = "Reflect P";
		/*
		float sinhtwoB = (float) Math.sqrt(Math.pow((2*Math.pow(Math.cos(Math.PI/q)/Math.sin(Math.PI/p), 2))-1,2)-1);
		float coshtwoB = (float) ((2*(Math.pow(Math.cos(Math.PI/q)/Math.sin(Math.PI/p), 2)))-1);
		float reflectPx = (float) ((-1*x*coshtwoB)+(z*sinhtwoB));
		float reflectPy = y;
		float reflectPz = (float) ((-1*x*sinhtwoB)+(z*coshtwoB));*/
		
		/*double reflectPx = ((x*-2.414213569)+(z*2.197368234));
		double reflectPy = y;
		double reflectPz = (x*-2.197368234)+(z*2.414213569);*/
		/*
		double reflectPx = (x*-3)+(z*Math.sqrt(2)*2);
		double reflectPy = y;
		double reflectPz = (x*-1*Math.sqrt(2)*2)+(z*3);*/

		float reflectPx = (float) ((x*-1*((2*Math.pow(Math.cos(Math.PI/q)/Math.sin(Math.PI/p), 2))-1))+(z*Math.sqrt((Math.pow(((2*Math.pow(Math.cos(Math.PI/q)/Math.sin(Math.PI/p), 2))-1), 2)-1)))); 
		float reflectPy = y;
		float reflectPz = (float) ((z*((2*Math.pow(Math.cos(Math.PI/q)/Math.sin(Math.PI/p), 2))-1))+(-1*x*Math.sqrt((Math.pow(((2*Math.pow(Math.cos(Math.PI/q)/Math.sin(Math.PI/p), 2))-1), 2)-1))));

		x = reflectPx;
		y = reflectPy;
		z = reflectPz;
		
	}//END ReflectP
	public static void reflectQ(){
		Indicator = "Reflect Q";
		
		float reflectQx = x;
		float reflectQy = -y;
		float reflectQz = z;
		
		x = reflectQx;
		y = reflectQy;
		z = reflectQz;
	}//END ReflectQ
	public static void reflecttwo(){
		Indicator = "Reflect 2";
		
		float reflectTwox = (float) ((x*Math.cos((2*Math.PI)/p))+(y*Math.sin((2*Math.PI)/p)));
		float reflectTwoy = (float) ((x*Math.sin((2*Math.PI)/p))+(-1*y*Math.cos((2*Math.PI)/p)));
		float reflectTwoz = z;
		
		x = reflectTwox;
		y = reflectTwoy;
		z = reflectTwoz;
		
	}//END Reflecttwo
	
	public static void prompt(){
		System.out.println("\n=================================================");
		System.out.println("You have just performed the function: "+Indicator);
		System.out.println("your x-coordinates are now: "+x);
		System.out.println("your y-coordinates are now: "+y);
		System.out.println("your z-coordinates are now: "+z);
		System.out.println("=================================================");
		
	}//END PROMPT
	
	public static void radiusconverter(){
		Indicator = "radius converter";
		x = x*radius;
		y = y*radius;
		z = z*radius;
	}
	
	public static void ReflectY (){
Indicator = "Reflect Y";
		
		float reflectQx = -x;
		float reflectQy = y;
		float reflectQz = z;
		
		x = reflectQx;
		y = reflectQy;
		z = reflectQz;
	}
	
	public static void showCoordinates(){
		Indicator = "show Coordinates";
		System.out.println("x:"+x);
		System.out.println("y:"+y);
		System.out.println("z:"+z);
	}
	
}
