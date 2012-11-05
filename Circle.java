package Projects;

import java.io.*;
public class Circle
{
	public static void CalculateTheCenter( double x1, double y1, double x2, double y2, double radius )
	{
		double center_a, center_b;
		System.out.println( );
		System.out.println( "EQUATION 1" );
		System.out.println( "(a - " + x1 + ")^2 + (b - " + y1 + ")^2 = " + radius + "^2" );
		System.out.println( );
		System.out.println( "EQUATION 2" );
		System.out.println( "(a - " + x2 + ")^2 + (b - " + y2 + ")^2 = " + radius + "^2" );
		System.out.println( );
		System.out.println( "******************************************************************" );
		System.out.println( );
		double twoabx1 = -2 * x1;
		double twoaby1 = -2 * y1;
		double twoabx2 = -2 * x2;
		double twoaby2 = -2 * y2;
		double x1square = x1 * x1;
		double y1square = y1 * y1;
		double x2square = x2 * x2;
		double y2square = y2 * y2;
		double radiussquare = radius * radius;
		System.out.println( "EXPANDING TWO EQUATION" );
		System.out.println( "a^2 " + twoabx1 + "a + " + x1square + " + b^2 " + twoaby1 + "b + " + y1square + " = " + radiussquare );
		System.out.println( );		
		System.out.println( "a^2 " + twoabx2 + "a + " + x2square + " + b^2 " + twoaby2 + "b + " + y2square + " = " + radiussquare );
		System.out.println( "--------------------------------------------------------------" );
		System.out.println( );
		double x1_twoab_x2 = twoabx1 + (-1 * twoabx2);
		double y1_twoab_y2 = twoaby1 + (-1 * twoaby2);
		double x1_square_x2 = x1square + (-1 * x2square);
		double y1_square_y2 = y1square + (-1 * y2square);
		System.out.println( "" + x1_twoab_x2 + "a +(" + x1_square_x2 + ") + " + y1_twoab_y2 + "b +(" + y1_square_y2 +") = 0" );
		System.out.println( );
		System.out.println( "--------------------------------------------------------------" );
		System.out.println( );
		double a_square;
		double a;
		double constant;
		double b_square_coefficient = ( y1_twoab_y2 * y1_twoab_y2 );
		double temp;
		//double rounded_off_centera;
		if( y1_twoab_y2 < 0 )
		{
			System.out.println( "b = ( " + x1_twoab_x2 + "a " + ( x1_square_x2 + y1_square_y2 ) + " ) / " + ( -1 * y1_twoab_y2 ) );
			System.out.println( );
			System.out.println( "FORMING QUADRATIC EQUATION!!!!!!!" );
			a_square = ( b_square_coefficient ) + ( x1_twoab_x2 * x1_twoab_x2 );			
			temp = ( x1_square_x2 + y1_square_y2 ) - ( y1 * -1 * y1_twoab_y2 );			
			a = ( b_square_coefficient * twoabx1 ) + ( 2 * x1_twoab_x2 * temp );			
			constant = ( b_square_coefficient * x1square ) - ( b_square_coefficient * radiussquare ) + ( temp * temp );
			
			System.out.println( "" + a_square + "a^2 + (" + a + "a) + (" + constant + ") = 0" );
			//(b+sqrt(b^2 - 4ac))/2a
			center_a = ( ( -1 * a ) + Math.sqrt( ( a * a ) - ( 4 * a_square * constant ) ) ) / ( 2 * a_square );
			center_b = ( ( x1_twoab_x2 * center_a ) + ( x1_square_x2 + y1_square_y2 ) ) / ( -1 * y1_twoab_y2 );
			System.out.println( );
			System.out.println( );			
			System.out.println( "Center( " + center_a + ", " + center_b + " )");
			//(b-sqrt(b^2 - 4ac))/2a
			center_a = ( ( -1 * a ) - Math.sqrt( ( a * a ) - ( 4 * a_square * constant ) ) ) / ( 2 * a_square );
			center_b = ( ( x1_twoab_x2 * center_a ) + ( x1_square_x2 + y1_square_y2 ) ) / ( -1 * y1_twoab_y2 );
			System.out.println( "Center( " + center_a + ", " + center_b + " )");
		}
		else
		{
			System.out.println( "b = ( " + ( -1 * x1_twoab_x2 ) + "a +" + ( -1 * ( x1_square_x2 + y1_square_y2 ) ) + " ) / " + y1_twoab_y2 );
			System.out.println( );
			System.out.println( "FORMING QUADRATIC EQUATION!!!!!!!" );
			a_square = ( b_square_coefficient ) + ( x1_twoab_x2 * x1_twoab_x2 );
			temp = ( -1 * ( x1_square_x2 + y1_square_y2 )) - ( y1 * y1_twoab_y2 );
			a = ( b_square_coefficient * twoabx1 ) + ( 2 * -1 * x1_twoab_x2 * temp );
			constant = ( b_square_coefficient * x1square ) - ( b_square_coefficient * radiussquare ) + ( temp * temp );
			
			System.out.println( "" + a_square + "a^2 + (" + a + "a) + (" + constant + ") = 0" );
			//(b+sqrt(b^2 - 4ac))/2a
			center_a = ( ( -1 * a ) + Math.sqrt( ( a * a ) - ( 4 * a_square * constant ) ) ) / ( 2 * a_square );
			center_b = ( ( -1 * ( x1_square_x2 + y1_square_y2 ) ) + ( -1 * x1_twoab_x2 * center_a ) ) / ( y1_twoab_y2 );
			System.out.println( );
			System.out.println( );			
			System.out.println( "Center( " + center_a + ", " + center_b + " )");
			//(b-sqrt(b^2 - 4ac))/2a
			center_a = ( ( -1 * a ) - Math.sqrt( ( a * a ) - ( 4 * a_square * constant ) ) ) / ( 2 * a_square );
			center_b = ( ( -1 * ( x1_square_x2 + y1_square_y2 ) ) + ( -1 * x1_twoab_x2 * center_a ) ) / ( y1_twoab_y2 );
			System.out.println( "Center( " + center_a + ", " + center_b + " )");
		}
		System.out.println( "******************************************************************" );
		System.out.println( );
		
	}
	public static void main( String [] arguments )
	{
		System.out.println( );
		System.out.println( "Author	:	SARAVANAN SIVAJI" );
		System.out.println( "Date	:	24-09-2007" );
		System.out.println( "E-mail	:	pcs_saravanan@yahoo.co.in or jetsarwan@yahoo.co.in" );
		System.out.println( );
		if( arguments.length != 5 )
		{
			System.out.println( );
			System.out.println( "USUAGE: java <filename> x1 y1 x2 y2 radius" );
			System.out.println( "INPUT : (x1,y1), (x2,y2) & radius )" );
			System.out.println( "Program Terminates!!!!" );
			System.exit( 0 );
		}
		else
		{
			double x1 = Double.parseDouble( arguments[0] );
			double y1 = Double.parseDouble( arguments[1] );
			double x2 = Double.parseDouble( arguments[2] );
			double y2 = Double.parseDouble( arguments[3] );
			double radius = Double.parseDouble( arguments[4] );
			System.out.println( "GIVEN 2 POINTS AND RADIUS OF THE CIRCLE........" );
			System.out.println( "x1 = " + x1 + ", y1 = " + y1 );
			System.out.println( "x2 = " + x2 + ", y2 = " + y2 );
			System.out.println( "radius = " + radius );
			CalculateTheCenter( x1, y1, x2, y2, radius ); 	
		}
	}
}