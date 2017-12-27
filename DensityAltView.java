import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DensityAltView extends JPanel
{
	private JTextField tfStationPressure;
	private JTextField tfStationTempF;
	private JTextField tfAirfieldAlt;
	private JButton bCalc, bDefault;
	private JLabel lblDensityAlt, lblDefault;

	public DensityAltView()

	{
		setLayout( new GridLayout(4, 2, 2, 2));

		add( new JLabel("Station Pressure (inHg)"));
		tfStationPressure = new JTextField("29.95");
		add( tfStationPressure );

		add( new JLabel("Station Temperature (F)"));
		tfStationTempF = new JTextField("59");
		add( tfStationTempF );

		add(new JLabel( "Airport Elevation (ft)"));
		tfAirfieldAlt = new JTextField("0");
		add( tfAirfieldAlt );

		bCalc = new JButton( "Density Altitude");
		add( bCalc);
      	bCalc.addActionListener( new ButtonHandler());
      
		lblDensityAlt = new JLabel( "unknown");
		lblDensityAlt.setBorder( BorderFactory.createLineBorder(Color.green));
		add (lblDensityAlt);

//default button for testing
		/*bDefault = new JButton( "Default Constructor");
		add( bDefault);
      	bDefault.addActionListener( new ButtonHandler2());
      
		lblDefault = new JLabel( "unknown");
		lblDefault.setBorder( BorderFactory.createLineBorder(Color.green));
		add (lblDefault);*/




	}// end constructor

	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			double sp = Double.parseDouble( tfStationPressure.getText());
			double st = Double.parseDouble( tfStationTempF.getText());
			double aa = Double.parseDouble( tfAirfieldAlt.getText());

			

			E6BFlightComputer e6b = new E6BFlightComputer("", sp, st, 0,0,0,0,0,aa);
         	lblDensityAlt.setText( Double.toString(e6b.densityAltitude()) );

		}
	}
//default button for testing
/*	private class ButtonHandler2 implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			

			E6BFlightComputer defaultCheck = new E6BFlightComputer();
			lblDefault.setText( Double.toString(defaultCheck.densityAltitude()));

			

		}
	}*/
}