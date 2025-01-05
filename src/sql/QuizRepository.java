/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.QuizAttempt;
import java.util.List;

/**
 *
 * @author johnpatrick
 */
public class QuizRepository 
{
    private final String connectionString = "jdbc:sqlite:src/sql/featurehubdb.sqlite3";
    
    
    public void setScore(QuizAttempt quizAttempt) {
        String sql = "INSERT INTO QuizAttempts (username, score, timestamp, timeTaken) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(connectionString);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            // Set the values in the PreparedStatement
            pstmt.setString(1, quizAttempt.getUsername());
            pstmt.setInt(2, quizAttempt.getScore());
            pstmt.setString(3, quizAttempt.getTimestamp());
            pstmt.setInt(4, quizAttempt.getTimeTaken());

            // Execute the insert operation
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error saving quiz attempt: " + e.getMessage());
        }
    }
    public List<QuizAttempt> getScoreLeaderboard() {
        List<QuizAttempt> leaderboard = new ArrayList<>();
        String sql = "SELECT username, score, timestamp, timeTaken FROM QuizAttempts "
                + "ORDER BY score DESC, timeTaken ASC LIMIT 10";

        try (Connection conn = DriverManager.getConnection(connectionString);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            // Iterate through the result set and populate the leaderboard list
            while (rs.next()) {
                String username = rs.getString("username");
                int score = rs.getInt("score");
                String timestamp = rs.getString("timestamp");
                int timeTaken = rs.getInt("timeTaken");
                
                leaderboard.add(new QuizAttempt(username, score, timestamp, timeTaken));
            }
            
        } catch (SQLException e) {
            System.out.println("Error retrieving leaderboard: " + e.getMessage());
        }

        return leaderboard;
    }
}
