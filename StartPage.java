/** 
 * Talon Jin
 * Mr. Patterson
 * ICS3U
 * 1/18/2015
 * 
 * Welcome to my game of Jeopardy!
 * This it the main page that will launch the program.
 * 
 * Pre: None.
 * Post: Open Jeopardy.java.
 * 
 * !--------------Make sure to use JDK 8.0_65--------------! 
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartPage extends JFrame {
  GridLayout mainLayout = new GridLayout(3, 1);
  GridLayout nameLayout = new GridLayout(1, 2);
  GridLayout timerLayout = new GridLayout(1, 2);
  GridLayout submitLayout = new GridLayout(1, 3);
  
  public StartPage(String name) {
    super(name);
  }
  
  public void addComponentsToPane(StartPage frame) {
    Container pane = frame.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    
    // TOP BORDER TOP
    JPanel topPanel = new JPanel();
    topPanel.setLayout(mainLayout);
    this.add(topPanel, BorderLayout.CENTER);
    // WELCOME TO Jeopardy
    JLabel space = new JLabel(" ", SwingConstants.CENTER);
    JLabel space2 = new JLabel(" ", SwingConstants.CENTER);
    JLabel title = new JLabel("Welcome to Jepordy!", SwingConstants.CENTER);
    topPanel.add(space);
    topPanel.add(title);
    topPanel.add(space2);
    
    // PLAYER1 SELECTION
    JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    middlePanel.setLayout(nameLayout);
    JLabel p1text = new JLabel("Please enter first player's name: ", SwingConstants.CENTER);
    final JTextField player1 = new JTextField("player1");
    middlePanel.add(p1text);
    middlePanel.add(player1);
    
    // PLAYER2 SELECTION
    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    bottomPanel.setLayout(nameLayout);
    JLabel p2text = new JLabel("Please enter second player's name: ", SwingConstants.CENTER);
    JTextField player2 = new JTextField("player2");
    bottomPanel.add(p2text);
    bottomPanel.add(player2);
    
    // TIMER SELECTION
    JPanel timerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    timerPanel.setLayout(timerLayout);
    JLabel timerText = new JLabel("Please enter time for each question: ", SwingConstants.CENTER);
    JTextField time = new JTextField("30");
    timerPanel.add(timerText);
    timerPanel.add(time);
    
    // SUBMIT PANEL
    JPanel submitPanel = new JPanel();
    submitPanel.setLayout(submitLayout);
    JLabel empty1 = new JLabel(" ", SwingConstants.CENTER);
    JLabel empty2 = new JLabel(" ", SwingConstants.CENTER);
    JButton submitButton = new JButton("Submit");
    submitPanel.add(empty1);
    submitPanel.add(submitButton);
    submitPanel.add(empty2);
    
    // COLORS
    Color blue = new Color(100, 174, 255);
    topPanel.setBackground(blue);
    middlePanel.setBackground(blue);
    bottomPanel.setBackground(blue);
    timerPanel.setBackground(blue);
    submitPanel.setBackground(blue);
    
    pane.add(topPanel);
    pane.add(middlePanel);
    pane.add(bottomPanel);
    pane.add(timerPanel);
    pane.add(submitPanel);
    
    // BUTTON ACTIONLISTENERS
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String p1 = player1.getText();
        String p2 = player2.getText();
        int t = Integer.parseInt(time.getText());
        Jeopardy game = new Jeopardy("CS", p1, p2, t);
        game.addComponentsToPane(game);
        game.setSize(400, 300);
        game.setVisible(true);
        frame.setVisible(false);
      }
    });
  }
  
  private static void createAndShowGUI() {
    StartPage frame = new StartPage("Jepordy");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addComponentsToPane(frame);
    frame.setSize(600, 300);
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