package gui.demo;


import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Nodepad extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2928827064671388423L;
	JTextArea jTextArea;
	JMenu jMenu;
	JMenuBar jMenuBar;
	JMenuItem open;
	JMenuItem save;
	
	public static void main(String[] args) {
		Nodepad mynotepad=new Nodepad();
	}
	public Nodepad() {
		// TODO Auto-generated constructor stub
		jTextArea=new JTextArea();
		jMenu=new JMenu("нд╪Ч");
		jMenu.setMnemonic('f');
		jMenuBar=new JMenuBar();
		open=new JMenuItem("open");
		save=new JMenuItem("save");
		this.add(jTextArea);
		this.setJMenuBar(jMenuBar);
		jMenuBar.add(jMenu);
		jMenu.add(open);
		jMenu.add(save);
		open.addActionListener(this);
		open.setActionCommand("open");
		save.addActionListener(this);
		save.setActionCommand("save");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("open")) {
			JFileChooser jFileChooser=new JFileChooser();
			jFileChooser.setDialogTitle("open");
			jFileChooser.showOpenDialog(null);
			jFileChooser.setVisible(true);
			String file=jFileChooser.getSelectedFile().getAbsolutePath();
			try {
				BufferedReader bReader=new BufferedReader(new FileReader(file));
				String line="";
				String content="";
				try {
					while ((line=bReader.readLine())!=null) {
						content=content+line+"\r\n";
					}
					jTextArea.setText(content);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getActionCommand().equals("save")) {
			JFileChooser jFileChooser=new JFileChooser();
			jFileChooser.setDialogTitle("open");
			jFileChooser.showSaveDialog(null);
			jFileChooser.setVisible(true);
			String file=jFileChooser.getSelectedFile().getAbsolutePath();
			
				BufferedWriter bWriter=null;
				try {
					bWriter = new BufferedWriter(new FileWriter(file));
					bWriter.write(jTextArea.getText());
					bWriter.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
		}
	}
}
