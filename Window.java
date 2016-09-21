import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Window extends JFrame {

	int width;
	int height;
	boolean fullScreen;
	int tabs;
	
	public Window() {
		width = 1000;
		height = 500;
		fullScreen = false;
		tabs = 0;
		initUI();
	}
	
	private void initUI() {
		createMenuBar();
		
		setTitle("Versatile Analysis of Body Temperature");
		setSize(width,height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void createMenuBar() {
		
		JMenuBar menuBar = new JMenuBar();
		
		//--------------------File menu--------------------
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		//Open
		ImageIcon openIcon = new ImageIcon("open.png");
		JMenuItem openMenuItem = new JMenuItem("Open...",openIcon);
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		openMenuItem.setToolTipText("Open data files");
		openMenuItem.addActionListener(new OpenFileAction());
		fileMenu.add(openMenuItem);
		
		//Print
		ImageIcon printIcon = new ImageIcon("print.png");
		JMenuItem printMenuItem = new JMenuItem("Print",printIcon);
		printMenuItem.setMnemonic(KeyEvent.VK_P);
		printMenuItem.setToolTipText("Print results");
		printMenuItem.addActionListener((ActionEvent event) -> {
			
		});
		fileMenu.add(printMenuItem);
		fileMenu.addSeparator();
		
		//Open recent
		JMenu openRecentMenu = new JMenu("Open Recent");
		fileMenu.add(openRecentMenu);
		
		//Export As
		JMenu exportAsMenu = new JMenu("Export As");
		fileMenu.add(exportAsMenu);
		fileMenu.addSeparator();
		
		//Exit
		ImageIcon exitIcon = new ImageIcon("exit.png");
		JMenuItem exitMenuItem = new JMenuItem("Exit",exitIcon);
		exitMenuItem.setMnemonic(KeyEvent.VK_E);
		exitMenuItem.setToolTipText("Exit application");
		exitMenuItem.addActionListener((ActionEvent event) -> {
			System.exit(0);
		});
		fileMenu.add(exitMenuItem);
		
		//Add file menu to menu bar
		menuBar.add(fileMenu);
		
		//--------------------Help Menu--------------------
		
		JMenu helpMenu = new JMenu("Help");
		
		//Documentation
		ImageIcon docIcon = new ImageIcon("documentation.png");
		JMenuItem docMenuItem = new JMenuItem("Documentation",docIcon);
		docMenuItem.setMnemonic(KeyEvent.VK_D);
		docMenuItem.setToolTipText("Open documentation");
		docMenuItem.addActionListener((ActionEvent event) -> {
			
		});
		helpMenu.add(docMenuItem);
		
		//Add help menu to the RIGHT side of menu bar
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(helpMenu);
		
		//---------------------------------------
		setJMenuBar(menuBar);
	}
	
	private class OpenFileAction extends AbstractAction {
		
		JPanel panel = (JPanel) getContentPane();
		
		@Override
		public void actionPerformed (ActionEvent e) {
			JFileChooser fdia = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
			fdia.addChoosableFileFilter(filter);
			
			int ret = fdia.showDialog(panel, "Open file");
			if (ret == JFileChooser.APPROVE_OPTION) {
				File file =fdia.getSelectedFile();
				processFile(file);
			}
		}
	}
	
	public void processFile(File file){
		
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(() -> {
			Window w = new Window();
			w.setVisible(true);
		});
	}
}
