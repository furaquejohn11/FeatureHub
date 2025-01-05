/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author johnpatrick
 */
public class QuizAttempt implements Comparable<QuizAttempt> {
    private String username;
    private int score;
    private String timestamp;
    private int timeTaken;  // in seconds
    
    public QuizAttempt(String username, int score, String timestamp, int timeTaken) {
        this.username = username;
        this.score = score;
        this.timestamp = timestamp;
        this.timeTaken = timeTaken;
    }
    
    public String getUsername() {
        return username;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public int getTimeTaken() {
        return timeTaken;
    }
    
    // Format time taken as minutes:seconds
    public String getFormattedTime() {
        int minutes = timeTaken / 60;
        int seconds = timeTaken % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
    
    // Compare based on score first, then time taken if scores are equal
    @Override
    public int compareTo(QuizAttempt other) {
        if (this.score != other.score) {
            return other.score - this.score; // Higher score first
        }
        return this.timeTaken - other.timeTaken; // Lower time first if scores are equal
    }
}
