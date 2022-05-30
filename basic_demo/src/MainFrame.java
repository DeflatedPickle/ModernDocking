import docking.DockedSimplePanel;
import docking.Docking;
import docking.DockingPanel;
import docking.RootDockingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.util.Random;

public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Test Docking Framework");

		setSize(800, 600);

		long eventMask = AWTEvent.MOUSE_MOTION_EVENT_MASK + AWTEvent.MOUSE_EVENT_MASK;

//		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
//			public void eventDispatched(AWTEvent e) {
//				int id = e.getID();
//
//				switch (id) {
//					case 501 -> System.out.println("MOUSE_DOWN");
//					case 502 -> System.out.println("MOUSE_UP");
//					case 503 -> System.out.println("MOUSE_MOVE");
//					case 504 -> System.out.println("MOUSE_ENTER");
//					case 505 -> System.out.println("MOUSE_EXIT");
//					case 506 -> System.out.println("MOUSE_DRAG");
//					default -> System.out.println(id);
//				}
//			}
//		}, eventMask);

		SimplePanel one = new SimplePanel("one", "one");
		SimplePanel two = new SimplePanel("two", "two");
		SimplePanel three = new SimplePanel("three", "three");
		SimplePanel four = new SimplePanel("four", "four");
		SimplePanel five = new SimplePanel("five", "five");

		JToolBar toolBar = new JToolBar();
		toolBar.add(new JButton("Test1"));
		toolBar.add(new JButton("Test2"));
		toolBar.add(new JButton("Test3"));

		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;

		add(toolBar, gbc);

		gbc.gridy++;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;

		RootDockingPanel dockingPanel = new RootDockingPanel();
		Docking.registerDockingPanel(dockingPanel, this);
		Random rand = new Random();
		dockingPanel.setBackground(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));

		add(dockingPanel, gbc);

		Docking.dock(this, one);
		Docking.dock(this, two);
		Docking.dock(this, three);
		Docking.dock(this, four);
		Docking.dock(this, five);
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		SwingUtilities.invokeLater(() -> {
			MainFrame mainFrame = new MainFrame();
			mainFrame.setVisible(true);
		});
	}
}