import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MainWindow extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	
	JButton b1=new JButton("");
	JButton b2=new JButton("");
	JButton b3=new JButton("");
	JButton b4=new JButton("");
	JButton b5=new JButton("");
	JButton b6=new JButton("");
	JButton b7=new JButton("");
	JButton b8=new JButton("");
	JButton b9=new JButton("");
	JButton ng=new JButton("New Game");
	
	Logic GameLogic=new Logic();
	
	public MainWindow()
	{
		super("TIC TAC TOE GAME");
		setSize(300,340);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		b1.setSize(90,90);
		b1.setActionCommand("1");
		b1.addActionListener(this);
		b2.setSize(90,90);
		b2.setActionCommand("2");
		b2.addActionListener(this);
		b3.setSize(90,90);
		b3.setActionCommand("3");
		b3.addActionListener(this);
		b4.setSize(90,90);
		b4.setActionCommand("4");
		b4.addActionListener(this);
		b5.setSize(90,90);
		b5.setActionCommand("5");
		b5.addActionListener(this);
		b6.setSize(90,90);
		b6.setActionCommand("6");
		b6.addActionListener(this);
		b7.setSize(90,90);
		b7.setActionCommand("7");
		b7.addActionListener(this);
		b8.setSize(90,90);
		b8.setActionCommand("8");
		b8.addActionListener(this);
		b9.setSize(90,90);
		b9.setActionCommand("9");
		b9.addActionListener(this);
		ng.setActionCommand("NewGame");
		ng.addActionListener(this);
		JSplitPane splitPane=new JSplitPane();	//makes two Halves of Window
		JPanel bottomPanel=new JPanel();
		JPanel upperPanel=new JPanel();
		add(splitPane);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(40);
		splitPane.setEnabled(false);
		splitPane.setTopComponent(upperPanel);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(bottomPanel);
        GridLayout gridLayout = new GridLayout(3,3);
        bottomPanel.setLayout(gridLayout);	//To arrange Components inside the Window
	    bottomPanel.add(b1);
	    bottomPanel.add(b2);
	    bottomPanel.add(b3);
	    bottomPanel.add(b4);
	    bottomPanel.add(b5);
	    bottomPanel.add(b6);
	    bottomPanel.add(b7);
	    bottomPanel.add(b8);
	    bottomPanel.add(b9);
	    upperPanel.add(ng);
	}
	
	private void clearButtons()
	{
		b1.setEnabled(true);
		b1.setText("");
		b2.setEnabled(true);
		b2.setText("");
		b3.setEnabled(true);
		b3.setText("");
		b4.setEnabled(true);
		b4.setText("");
		b5.setEnabled(true);
		b5.setText("");
		b6.setEnabled(true);
		b6.setText("");
		b7.setEnabled(true);
		b7.setText("");
		b8.setEnabled(true);
		b8.setText("");
		b9.setEnabled(true);
		b9.setText("");
	}
	
	private void disableButtons()
	{
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
		b8.setEnabled(false);
		b9.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton Btn=(JButton)e.getSource();
		if(e.getActionCommand()!="NewGame")
		{
			Btn.setEnabled(false);	
		}
		switch(Btn.getActionCommand())
		{
		case "1":
			Btn.setText(GameLogic.gameTurn(0, 0));break;
		case "2":
			Btn.setText(GameLogic.gameTurn(1, 0));break;
		case "3":
			Btn.setText(GameLogic.gameTurn(2, 0));break;
		case "4":
			Btn.setText(GameLogic.gameTurn(0, 1));break;
		case "5":
			Btn.setText(GameLogic.gameTurn(1, 1));break;
		case "6":
			Btn.setText(GameLogic.gameTurn(2, 1));break;
		case "7":
			Btn.setText(GameLogic.gameTurn(0, 2));break;
		case "8":
			Btn.setText(GameLogic.gameTurn(1, 2));break;
		case "9":
			Btn.setText(GameLogic.gameTurn(2, 2));break;
		case "NewGame":
			GameLogic.ResetGame(); clearButtons();break;
		}
		if(GameLogic.GameEnd)
		{
			disableButtons();
		}
	}

}
