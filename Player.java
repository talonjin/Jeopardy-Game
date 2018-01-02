/** 
 * Talon Jin
 * Mr. Patterson
 * ICS3U
 * 1/18/2015
 * 
 * This class defines Player
 * Each Player has its unique player name (p1, p2) - See StartPage.java
 * Each Player has its own unique score (player1.score, player2.score) - See Jeopardy.java
 * 
 * Pre: Player instance must be called.
 * Post: Send Player a name and a score.
 */
public class Player {
 String name;
 int score;

 public Player(String name, int score) {
  this.name = name;
  this.score = score;
 }
}