/** 
 * Talon Jin
 * Mr. Patterson
 * ICS3U
 * 1/18/2015
 * 
 * This code will lauch the GUI that displays the question.
 * 
 * Pre: Question constructor must have an instance of the Category created.
 * Post: Sends points to currentPlayer.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Question extends JFrame {
 GridLayout subtopicLayout = new GridLayout(1, 1);
 GridLayout subtopicQuestionLayout = new GridLayout(1, 1);
 GridLayout timerLayout = new GridLayout(1, 2);
 GridLayout subtopicAnswerLayout = new GridLayout(1, 1);
 GridLayout submitAnswerLayout = new GridLayout(1, 1);

 String subtopic;
 String subtopicQuestion;
 String subtopicAnswer;
 int value;
 Timer questionTimer;
 int timer;

 public Question(String subtopic, String subtopicQuestion, String subtopicAnswer, int value, int timer) {
  this.subtopic = subtopic;
  this.subtopicQuestion = subtopicQuestion;
  this.subtopicAnswer = subtopicAnswer;
  this.value = value;
  this.timer = timer;
 }

 public void addComponentsToPane(Question question, Jeopardy jeopardy, Category category) {
  Container pane = question.getContentPane();
  pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

  // TOPIC DISPLAY
  JPanel subtopicPanel = new JPanel();
  subtopicPanel.setLayout(subtopicLayout);
  this.add(subtopicPanel, BorderLayout.CENTER);
  JLabel subtopicLabel = new JLabel(this.subtopic, SwingConstants.CENTER);
  subtopicPanel.add(subtopicLabel);

  // QUESTION DISPLAY
  JPanel questionPanel = new JPanel();
  questionPanel.setLayout(subtopicQuestionLayout);
  JLabel subtopicQuestionLabel = new JLabel(subtopicQuestion, SwingConstants.CENTER);
  questionPanel.add(subtopicQuestionLabel);
  
  // TIMER DISPLAY
  JPanel timerPanel = new JPanel();
  timerPanel.setLayout(timerLayout);
  JLabel timerText = new JLabel("Time remaining: ", SwingConstants.RIGHT);
  JLabel timerLabel = new JLabel();
  timerPanel.add(timerText);
  timerPanel.add(timerLabel);

  // ANSWER INPUT
  JPanel answerPanel = new JPanel();
  answerPanel.setLayout(subtopicAnswerLayout);
  JTextField subtopicAnswerTextField = new JTextField("");
  answerPanel.add(subtopicAnswerTextField);
  
  // SUBMIT PANEL
  JPanel submitPanel = new JPanel();
  submitPanel.setLayout(submitAnswerLayout);
  JButton submitButton = new JButton("Submit");
  submitPanel.add(submitButton);

  pane.add(subtopicPanel);
  pane.add(questionPanel);
  pane.add(timerPanel);
  pane.add(answerPanel);
  pane.add(submitPanel);

  // COLORS
  Color blue = new Color(100, 174, 255);
  subtopicPanel.setBackground(blue);
  questionPanel.setBackground(blue);
  timerPanel.setBackground(blue);
  answerPanel.setBackground(blue);
  submitPanel.setBackground(blue);

  // TIMER
  questionTimer = new Timer(1000, new ActionListener() {
     @Override
      public void actionPerformed(ActionEvent e) {
        timerLabel.setText(String.valueOf(timer));
        timer--;
        if(timer < 0) {
          questionTimer.stop();
        }
      }
    });
    questionTimer.start(); 
  
  // SUBMIT BUTTON ACTIONLISTENER (Processes answers to see if correct/incorrect)
  submitButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    String playerAnswer = subtopicAnswerTextField.getText();
    System.out.println(playerAnswer.equals(subtopicAnswer));
    if (playerAnswer.equals(subtopicAnswer) && timer > 0) {
     System.out.println("correct");
     if (jeopardy.player1.name == jeopardy.currentPlayer) {
      jeopardy.player1.score += value;
     } else {
      jeopardy.player2.score += value;
     }
     jeopardy.updateScore();
    } else {
     if (jeopardy.player1.name == jeopardy.currentPlayer) {
      jeopardy.player1.score -= value;
     } else {
      jeopardy.player2.score -= value;
     }
     jeopardy.updateScore();
     jeopardy.switchPlayer();
     jeopardy.updateTurn();
     category.updateLabel(jeopardy.currentPlayer);
    }
    question.setVisible(false);
   }
  });

 }
}