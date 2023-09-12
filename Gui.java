package inl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui {
	private SudokuSolver s;
	private JPanel panel;
	private JButton solve;

	/**
	* Skapar guin
	* @param s
	*/	
public Gui(SudokuSolver s) {
	SwingUtilities.invokeLater(() -> createWindow(s));
	}
	public void createWindow(SudokuSolver s){
		this.s = s;
		JFrame frame = new JFrame("Sudoku");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground( Color.GRAY);
	
		Container pane = frame.getContentPane();
		
		panel = new JPanel();
		panel.setLayout(new GridLayout (9,9));
		panel.setPreferredSize(new Dimension(500,500));
		
		int c = 0;
		for(int i = 0; i < 9; i++) {
			c++;

			if(c < 4 || c > 6) {
				for(int j = 0; j < 3; j++) {
					red(panel);
				}
				for(int j = 0; j < 3; j++) {
					white(panel);
				}
				for(int j = 0; j < 3; j++) {
					red(panel);
				}
			}
			else {
				for(int j = 0; j < 3; j++) {
					white(panel);
				}
				for(int j = 0; j < 3; j++) {
					red(panel);
				}
				for(int j = 0; j < 3; j++) {
					white(panel);
				}
			}
			
		}

		pane.add(panel, BorderLayout.CENTER);
		JPanel bottomPanel = new JPanel();
		solve = new JButton("Solve");
		bottomPanel.add(solve);
		JButton clear = new JButton("Clear");
		bottomPanel.add(clear);
		
		pane.add(bottomPanel, BorderLayout.SOUTH);
		
		clear.addActionListener(e -> this.clearSudoku());
		
		 solve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(!PanelToBoard())
					return;
				
				if(!s.solve()) {
					JOptionPane.showMessageDialog(panel ,"Sudoku not solvable");
				}else {
					BoardToPanels();

				}
               
			}});
		
		frame.pack();
		frame.setVisible(true);	
}
	/**
	* Skapar en röd textruta
	* @param panel
	*/
private void red(JPanel panel) {
	JTextField temp = new JTextField();
	temp.setHorizontalAlignment(JTextField.CENTER);
	panel.add(temp);
	temp.setBackground(Color.RED);
}
/**
* Skapar en vit textruta
* @param panel
*/
private void white(JPanel panel) {
	JTextField temp = new JTextField();
	temp.setHorizontalAlignment(JTextField.CENTER);
	temp.setBackground(Color.WHITE);
	panel.add(temp);
}
//Tar bort alla värden i gui sudokut.
public void clearSudoku() {
	for(Component comp : panel.getComponents()) {
		if(comp instanceof JTextField) {
			JTextField textf = (JTextField)comp;
			textf.setText("");
		}
	}
}

//Sätter in det lösta sudokut i gui
public void BoardToPanels() {
	int col = 0;
	int row = 0;
	//går igenom var komponent i panelen
	for(Component comp : panel.getComponents()) {
		//kollar om komponent är JTextField
		if(comp instanceof JTextField) {
			
			JTextField textf = (JTextField)comp;
			//kollar så att komponent placeras rätt inom planen
			if(col % 9 == 0 && col != 0) {
				row++;
				col = 0;
			}
			if(row % 9 == 0 && col != 0) {
				row = 0;
			}
			//sätter in komponent i JTextField
			textf.setText(Integer.toString(s.getCell(row, col)));

			col++;
		}
	}
	
}
//Tar värdena från gui och plaserar de i sudokut
public boolean PanelToBoard() {
	
	int col= 0;
	int row = 0;

	for(Component comp : panel.getComponents()) {
		if(comp instanceof JTextField) {
			
			JTextField textf = (JTextField)comp;
			if(col % 9 == 0 && col != 0) {
				row++;
				col = 0;
			}
			if(row % 9 == 0 && row != 0) {
				row = 0;
			}

			int val = 0; //när inget värde finns
				
			try {
				val = Integer.parseInt(textf.getText());
				if(val > 9 || val < 1) {
					JOptionPane.showMessageDialog(panel, "invalid values!");
					return false;
					
				}
			} catch(Exception e) {
				if(!textf.getText().isBlank()) {
					JOptionPane.showMessageDialog(panel, " invalid values!");
					return false;
				}
			}
			
			s.setCell(row, col, val);
			col++;
		}
	}

	return true;
}

public static void main(String[] args) {
Sudoku s = new Sudoku();
Gui g =new Gui(s);
}
}