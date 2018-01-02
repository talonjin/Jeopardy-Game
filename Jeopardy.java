/** 
 * Talon Jin
 * Mr. Patterson
 * ICS3U
 * 1/18/2015
 *
 * Declares the topics, subtopics, questions and answers.
 * 
 * Pre: Jeopardy constructor must have an instance of the StartPage created.
 * Post: Open Category.java.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Jeopardy extends JFrame {
  public static String topic1 = "Java";
  public static String[] topic1subtopics = { "Strings", "Loops", "Methods" };
  public static String[][] javaQuestions = {
    { "What will \"Talon.length()\" output?", "What will \"Talon.atChar(3)\" output?", "How to convert a String to Int?" },
    { "How many types of loops are there?", "Which looping process checks the test condition at the end of the loop?", " The statement  i++;  is equivalent to?" }, 
    { "What is the return type of a method that does not return any values?", "Which of the following is a method having same name as it’s class?", "Which method can be defined only once in a program?" } };
  public static String[][] javaAnswers = { 
    { "5", "l", "int n = Interger.parseInt()" }, 
    { "3", "do-while", "i = i + 1" },
    { "void", "constructor", "main method" } };
  
  public static String topic2 = "History";
  public static String[] topic2subtopics = { "Settlers", "Government", "Historic Figures" };
  public static String[][] hisQuestions = { 
    {"Who were the first people to step foot on Canada?", "Who was Canada's first Prime Minister?", "Who founded Quebec City?" },
    {"Canada's Prime Minister today is?", "The head of state of Canada is?", "Has Canada ever had a female Prime Minister?" },
    {"This person named after our school is an...?", "This person founded FreeTheChildren with his brother Marc.", "This person ran to raise money for Cancer research is?" } };
  public static String[][] hisAnswers = {
    {"First Nations", "John A. Macdonald", "Samuel de Champlain" },
    {"Justin Trudeau", "Queen Elizabeth", "Yes" },
    {"Artist", "Craig Kielburger", "Terry Fox" } };
  
  public static String topic3 = "Geography";
  public static String[] topic3subtopics = { "Canadian Ecozones", "Global Issues", "Land formations" };
  public static String[][] geoQuestions = { 
    {"Which ecozone has the largest area?", "How many ecozones are found in Ontario?", "Which ecozone has the largest population density?" },
    {"Are there still slaves today?", "Can we stop climate change?", "Most common Anthropogenic GreenHouseGas is?" },
    {"What is Canada's smallest province?", "How much of Canada do lakes cover?", "What is the capital of Yukon?" } };
  public static String[][] geoAnswers = {
    {"Boreal Sheild", "3", "Mixedwood Plains" },
    {"Yes", "No", "Carbon Dioxide" },
    {"Prince Edward Island", "9%", "Whitehorse" } };
  
  Boolean c1toggle = true;
  Boolean c2toggle = true;
  Boolean c3toggle = true;
  
  GridLayout mainLayout = new GridLayout(5, 1);
  GridLayout buttonLayout = new GridLayout(1, 3);
  GridLayout terminateLayout = new GridLayout(1, 3);
  
  Player player1;
  Player player2;
  
  Category c1;
  Category c2;
  Category c3;
  
  String currentPlayer;
  int timer;
  
  JLabel player1label;
  JLabel player2label;
  JLabel selectCategory;
  
  public Jeopardy(String name, String p1, String p2, int t) {
    super(name);
    this.player1 = new Player(p1, 0);
    this.player2 = new Player(p2, 0);
    this.currentPlayer = p1;
    this.timer = t;
    this.c1 = new Category(topic1, topic1subtopics, javaQuestions, javaAnswers, this.timer);
    this.c2 = new Category(topic2, topic2subtopics, hisQuestions, hisAnswers, this.timer);
    this.c3 = new Category(topic3, topic3subtopics, geoQuestions, geoAnswers, this.timer);
  }
  
  // FUNCTION TO SWITCH BETWEEN PLAYERS
  public void switchPlayer() {
    if (this.currentPlayer == player1.name) {
      this.currentPlayer = player2.name;
    } else {
      this.currentPlayer = player1.name;
    }
  }
  
  // FUNCTION TO UPDATE SCORE
  public void updateScore() {
    player1label.setText(this.player1.name + " score: " + this.player1.score);
    player2label.setText(this.player2.name + " score: " + this.player2.score);
  }
  
  // FUNCTION TO UPDATE TURN
  public void updateTurn() {
    selectCategory.setText(this.currentPlayer + ": Please select a category."); 
  }
  
  public void addComponentsToPane(Jeopardy jeopardy) {
    Container pane = jeopardy.getContentPane();
    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(mainLayout);
    this.add(mainPanel, BorderLayout.CENTER);
    
    // DISPLAYS INSTRUCTIONS
    JLabel space = new JLabel(" ");
    mainPanel.add(space);
    JLabel title = new JLabel("Jeopardy!", SwingConstants.CENTER);
    mainPanel.add(title);
    selectCategory = new JLabel(this.currentPlayer + ": Please select a category.", SwingConstants.CENTER);
    mainPanel.add(selectCategory);
    player1label = new JLabel(this.player1.name + " score: " + this.player1.score, SwingConstants.CENTER);
    mainPanel.add(player1label);
    player2label = new JLabel(this.player2.name + " score: " + this.player2.score, SwingConstants.CENTER);
    mainPanel.add(player2label);
    
    // THREE DIFFERENT TOPICS
    JPanel panel = new JPanel();
    panel.setLayout(buttonLayout);
    JButton comp = new JButton(topic1);
    panel.add(comp);
    JButton history = new JButton(topic2);
    panel.add(history);
    JButton geography = new JButton(topic3);
    panel.add(geography);
    
    // TERMINATE PANEL
    JPanel closePanel = new JPanel();
    closePanel.setLayout(terminateLayout);
    JLabel gap = new JLabel("");
    closePanel.add(gap);
    JButton endProgram = new JButton("Terminate");
    closePanel.add(endProgram);
    JLabel gap1 = new JLabel("");
    closePanel.add(gap1);
    
    pane.add(mainPanel);
    pane.add(panel);
    pane.add(closePanel);
    
    // COLORS
    Color blue = new Color(100, 174, 255);
    mainPanel.setBackground(blue);
    panel.setBackground(blue);
    closePanel.setBackground(blue);
    
    // BUTTON ACTIONLISTENER
    comp.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (c1toggle) {
          c1.addComponentsToPane(c1, jeopardy);
          c1.setSize(400, 300);
          c1toggle = false;
        } 
        c1.setVisible(true);
      }
    });
    history.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (c2toggle) {
          c2.addComponentsToPane(c2, jeopardy);
          c2.setSize(400, 300);
          c2toggle = false;
        } 
        c2.setVisible(true);
      }
    });
    geography.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (c3toggle) {
          c3.addComponentsToPane(c3, jeopardy);
          c3.setSize(400, 300);
          c3toggle = false;
        } 
        c3.setVisible(true);
      }
    });
    endProgram.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
          System.exit(0);
      }
    });
  }
}