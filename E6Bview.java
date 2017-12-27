import java.awt.*;
import javax.swing.*;

public class E6Bview extends JFrame
{
	public E6Bview()
	{
		super( "E6B" );
		JTabbedPane e6bTab = new JTabbedPane();

		//add tabs to e6bTab
		e6bTab.addTab( "Density Altitude", null, new DensityAltView(), "");
        e6bTab.addTab( "Ground Speed", null, new GroundSpeedView(), "");
		e6bTab.addTab( "Wind Correction Angle and True Airspeed", null, new WindCorrectionAngleandTrueAirspeedView(), "");
        add( e6bTab );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);
		setVisible(true);

	}

	public static void main(String[] args)
	{
		E6Bview e6bv = new E6Bview();
	}
}