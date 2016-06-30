package com.day2;
import  java.awt.*;
import javax.swing.*;

public class Example1 {
	public void CreateJFrame(String title){
		JFrame jf=new JFrame(title);
		Container container=jf.getContentPane();
		JLabel jLabel=new JLabel("this is lable");
		jf.setSize(200, 150);
		jf.setVisible(true);
		container.add(jLabel);
	}
	public static void main(String[] args) {
		Example1 example1=new Example1();
		example1.CreateJFrame("myfirstframe");
	}
}
