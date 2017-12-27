
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class WindCorrectionAngleandTrueAirspeedView extends JPanel
{
	private JTextField tfWindSpeed;
	private JTextField tfDesiredCourse;
	private JTextField tfWindDirection;
	private JTextField tfAltitude;
	private JTextField tfIndicatedAirspeed;

	private JButton windCorCalc, trueAirspeedCalc, DtrueAirspeedCalc, DwindCorCalc;
	private JLabel lblWindCorrectionAngle, lbltrueAirspeed, DlbltrueAirspeed, DlblWindCorrectionAngle;

	

	public WindCorrectionAngleandTrueAirspeedView()

	{
		setLayout( new GridLayout(9, 2, 2, 2));

		add( new JLabel("Wind Speed (knots)"));
		tfWindSpeed = new JTextField("15");
		add( tfWindSpeed );

		add(new JLabel( "Desired Course Direction (degrees)"));
		tfDesiredCourse = new JTextField("");
		add( tfDesiredCourse );

		add( new JLabel("Wind Direction  (degrees)"));
		tfWindDirection = new JTextField("");
		add( tfWindDirection );

		add( new JLabel("Altitude  (ft)"));
		tfAltitude = new JTextField("");
		add( tfAltitude );

		add( new JLabel("Indicated Airspeed  (knots)"));
		tfIndicatedAirspeed = new JTextField("");
		add( tfIndicatedAirspeed );

		trueAirspeedCalc = new JButton( "True Airspeed");
		add( trueAirspeedCalc );
      	trueAirspeedCalc.addActionListener( new TrueAirspeedButtonHandler());

		lbltrueAirspeed = new JLabel( "unknown");
		lbltrueAirspeed.setBorder( BorderFactory.createLineBorder(Color.green));
		add (lbltrueAirspeed);


		windCorCalc = new JButton( "Wind Correction Angle");
		add( windCorCalc);
      	windCorCalc.addActionListener( new WindCorrectionAngleButtonHandler());

		lblWindCorrectionAngle = new JLabel( "unknown");
		lblWindCorrectionAngle.setBorder( BorderFactory.createLineBorder(Color.green));
		add (lblWindCorrectionAngle);

		DtrueAirspeedCalc = new JButton( "Default True Airspeed");
		add( DtrueAirspeedCalc );
      	DtrueAirspeedCalc.addActionListener( new DefaultTrueAirspeedButtonHandler());

		DlbltrueAirspeed = new JLabel( "unknown");
		DlbltrueAirspeed.setBorder( BorderFactory.createLineBorder(Color.green));
		add (DlbltrueAirspeed);


		DwindCorCalc = new JButton( "Default Wind Correction Angle");
		add( DwindCorCalc);
      	DwindCorCalc.addActionListener( new DefaultWindCorrectionAngleButtonHandler());

		DlblWindCorrectionAngle = new JLabel( "unknown");
		DlblWindCorrectionAngle.setBorder( BorderFactory.createLineBorder(Color.green));
		add (DlblWindCorrectionAngle);

		

	}// end constructor
   
   private class TrueAirspeedButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			double dc = Double.parseDouble( tfDesiredCourse.getText());
			double ws = Double.parseDouble( tfWindSpeed.getText());
			double wd = Double.parseDouble( tfWindDirection.getText());
			double ia = Double.parseDouble( tfIndicatedAirspeed.getText());
			double a  = Double.parseDouble( tfAltitude.getText());


			E6BFlightComputer e6b = new E6BFlightComputer("", 0, 0, 0,a,ia,dc,wd,ws);
        	lbltrueAirspeed.setText( Double.toString(e6b.trueAirspeed()) );

		}
	}

	private class WindCorrectionAngleButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			double dc = Double.parseDouble( tfDesiredCourse.getText());
			double ws = Double.parseDouble( tfWindSpeed.getText());
			double wd = Double.parseDouble( tfWindDirection.getText());
			double ia = Double.parseDouble( tfIndicatedAirspeed.getText());
			double a  = Double.parseDouble( tfAltitude.getText());


			E6BFlightComputer e6b = new E6BFlightComputer("", 0, 0, 0,a,ia,dc,wd,ws);
        	lblWindCorrectionAngle.setText( Double.toString(e6b.windCorrectionAngle()) );

		}
	}

	private class DefaultTrueAirspeedButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			

			E6BFlightComputer defaultCheck = new E6BFlightComputer();
			DlbltrueAirspeed.setText( Double.toString(defaultCheck.trueAirspeed()));

			

		}
	}

	private class DefaultWindCorrectionAngleButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			

			E6BFlightComputer defaultCheck = new E6BFlightComputer();
			DlblWindCorrectionAngle.setText( Double.toString(defaultCheck.windCorrectionAngle()));

			

		}
	}
}