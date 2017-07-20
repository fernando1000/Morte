package br.com.matadouro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela {

	public static void main(String[] args) {
		
		criaFrame();
	}
	
	private static void criaFrame(){
		
		JFrame jFrame = new JFrame();
		jFrame.getContentPane().add(BorderLayout.NORTH, new JLabel("Bem vindo"));	
        jFrame.getContentPane().add(BorderLayout.SOUTH, new JButton("Entrar"));
	   
	    JPanel jPanel = new JPanel();
	    jPanel.setLayout(new GridBagLayout());
	    jPanel.setBackground(Color.green);
        jPanel.setBorder(BorderFactory.createEmptyBorder(20, 5, 10, 5));
        
        GridBagConstraints left = new GridBagConstraints();
        				   left.anchor = GridBagConstraints.EAST;
        				   
        GridBagConstraints right = new GridBagConstraints();
        				   right.weightx = 2.0;
        				   right.fill = GridBagConstraints.HORIZONTAL;
        				   right.gridwidth = GridBagConstraints.REMAINDER;

        jPanel.add(new JLabel("Usuario: "), left);
        jPanel.add(new JTextField(20), right);
        jPanel.add(new JLabel("Senha: "), left);
        jPanel.add(new JTextField(20), right);
        
        jFrame.getContentPane().add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
	    
	}
	
}
