package alt.components.version5_colorchooser;

import java.awt.GridLayout;

import javax.swing.JFrame;

import alt.components.version5_colorchooser.models.Model;
import alt.components.version5_colorchooser.panels.ButtonPanel;
import alt.components.version5_colorchooser.panels.ComboControlPanel;
import alt.components.version5_colorchooser.panels.ListPanel;
import alt.components.version5_colorchooser.panels.PaintPanel;
import alt.components.version5_colorchooser.panels.ProgressBarPanel;
import alt.components.version5_colorchooser.panels.SliderPanel;
import alt.components.version5_colorchooser.panels.TabbedPanel;
import alt.components.version5_colorchooser.panels.TablePanel;
import alt.components.version5_colorchooser.panels.TextControllerPanel;

/**
 * In dieser Klasse werden alle nötigen Panels erstellt und als Observer dem Model (Observable)
 * zugeordnet. Außerdem werden die Panels natürlich auch dem Frame hinzugefügt.
 * 
 * @author LGerhard
 *
 */
public class MainFrame extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Model m;

  public MainFrame( Model m ) {
    super( "CoolorChooser-Frame" );
    this.m = m;
    this.setResizable( true );
    this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    this.setLayout( new GridLayout( 0, 3, 20, 20 ) );

    PaintPanel pp = new PaintPanel( m );
    this.add( pp );
    m.addObserver( pp );

    // Das ButtonPanel ist kein Observer!!!
    ButtonPanel bp = new ButtonPanel( m );
    this.add( bp );

    TextControllerPanel tcp = new TextControllerPanel( m );
    this.add( tcp );

    ListPanel lp = new ListPanel(); // Hier muss das Model durch einen Trick nicht weitergereicht
                                    // werden - s. Code!
    this.add( lp );
    m.addObserver( lp );

    SliderPanel sp = new SliderPanel( m );
    this.add( sp );
    m.addObserver( sp );

    ProgressBarPanel pbp = new ProgressBarPanel( m );
    this.add( pbp );
    m.addObserver( pbp );

    ComboControlPanel ccp = new ComboControlPanel( m );
    this.add( ccp );
    m.addObserver( ccp );

    TabbedPanel tp = new TabbedPanel( m );
    this.add( tp );
    m.addObserver( tp );

    TablePanel tablePanel = new TablePanel( m );
    this.add( tablePanel );
    m.addObserver( tablePanel );
    
    this.pack();
    this.setVisible( true );
  }

  public Model getModel() {
    return m;
  }

}
