
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class GroundSpeedView extends JPanel
{
	private JTextField tfIndicatedAirSpeed, tfWindSpeed;
	private JTextField tfAltitude;
	private JTextField tfDesiredCourse;
	private JTextField tfWindDirection;

	private JButton DgrndSpdCalc;
    private JButton grndSpdCalc;
	private JLabel DlblGroundSpeed;
    private JLabel lblGroundSpeed;

	public GroundSpeedView()

	{
		setLayout( new GridLayout(6, 2, 2, 2));

		add( new JLabel("Indicated Airspeed (knots)"));
		tfIndicatedAirSpeed = new JTextField("");
		add( tfIndicatedAirSpeed );

		add( new JLabel("Altitude (ft)"));
		tfAltitude = new JTextField("");
		add( tfAltitude );

		add( new JLabel("Wind Speed (knots)"));
		tfWindSpeed = new JTextField("");
		add( tfWindSpeed );

		add(new JLabel( "Desired Course Direction (degrees)"));
		tfDesiredCourse = new JTextField("");
		add( tfDesiredCourse );

		add( new JLabel("Wind Direction  (degrees)"));
		tfWindDirection = new JTextField("");
		add( tfWindDirection );



		


		grndSpdCalc = new JButton( "Ground Speed");
		add( grndSpdCalc);
		grndSpdCalc.addActionListener( new GroundSpeedButtonHandler());


		lblGroundSpeed = new JLabel( "unknown");
		lblGroundSpeed.setBorder( BorderFactory.createLineBorder(Color.green));
		add(lblGroundSpeed);
//Default Button for testing purposes. Remove comment delimeters for a quick button test based on the e6b default constructor
		/*DgrndSpdCalc = new JButton( "Default Ground Speed");
		add( DgrndSpdCalc);
		DgrndSpdCalc.addActionListener( new DGroundSpeedButtonHandler());


		DlblGroundSpeed = new JLabel( "unknown");
		DlblGroundSpeed.setBorder( BorderFactory.createLineBorder(Color.blue));
		add(DlblGroundSpeed);*/		

	}// end constructor

	private class GroundSpeedButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			double dc = Double.parseDouble( tfDesiredCourse.getText());
			double ws = Double.parseDouble( tfWindSpeed.getText());
			double wd = Double.parseDouble( tfWindDirection.getText());
			double ia = Double.parseDouble( tfIndicatedAirSpeed.getText());
			double a  = Double.parseDouble( tfAltitude.getText());


			E6BFlightComputer e6b = new E6BFlightComputer("", 0, 0, 0,a,ia,dc,wd,ws);
        	lblGroundSpeed.setText( Double.toString(e6b.groundSpeed()) );

		}
	}

//Default Button for testing purposes. Remove comment delimeters for a quick button test based on the e6b default constructor
	/*private class DGroundSpeedButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			

			E6BFlightComputer defaultCheck = new E6BFlightComputer();
			DlblGroundSpeed.setText( Double.toString(defaultCheck.groundSpeed()));

			

		}
	}*/
}