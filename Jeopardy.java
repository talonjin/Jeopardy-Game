import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Jeopardy extends JFrame {
  GridLayout mainLayout = new GridLayout(3,1);
  GridLayout nameLayout = new GridLayout(1,2); 

  public Jeopardy(String name) {
 super(name);
  }   
  
  public void addComponentsToPane(final Container pane) {
 pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
 
 //TOP BORDER TOP
 JPanel topPanel = new JPanel();
 topPanel.setLayout(mainLayout);
 this.add(topPanel, BorderLayout.CENTER);      
 //WELCOME TO JEOPARDY
 JLabel space = new JLabel(" ", SwingConstants.CENTER);
 JLabel space2 = new JLabel(" ", SwingConstants.CENTER);
 JLabel title = new JLabel("Welcome to Jeopardy!", SwingConstants.CENTER);
 topPanel.add(space);
 topPanel.add(title);
 topPanel.add(space2);

 //PLAYER1 SELECTION
 JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));  
 middlePanel.setLayout(nameLayout);
 //PLAYER1 NAME
 JLabel p1text = new JLabel("Please enter first player's name: ", SwingConstants.CENTER);
 middlePanel.add(p1text);
 //PLAYER1 TEXT FIELD
 JTextField player1 = new JTextField("player1");
 middlePanel.add(player1);

 //PLAYER2 SELECTION
 JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));  
 bottomPanel.setLayout(nameLayout);
 //PLAYER2 NAME
 JLabel p2text = new JLabel("Please enter second player's name: ", SwingConstants.CENTER);
 bottomPanel.add(p2text);
 //PLAYER2 TEXT FIELD
 JTextField player2 = new JTextField("player2");
 bottomPanel.add(player2);
 
 Color blue = new Color(100, 174, 255);
 topPanel.setBackground(blue);
 middlePanel.setBackground(blue);
 bottomPanel.setBackground(blue);

 pane.add(topPanel);
 pane.add(middlePanel);
 pane.add(bottomPanel);
  }


  private static void createAndShowGUI() {
 Jeopardy frame = new Jeopardy("Jeopardy");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
 frame.addComponentsToPane(frame.getContentPane());
 frame.setSize(600,300);
 frame.setVisible(true);
  }


  public static void main(String[] args) {
 javax.swing.SwingUtilities.invokeLater(new Runnable() {
   public void run() {
  createAndShowGUI();
   }
 });
  }
}