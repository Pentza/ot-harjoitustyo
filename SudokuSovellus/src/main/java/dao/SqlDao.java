/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pewlahde
 */
public class SqlDao implements ScoreDao, LevelDao {

    private String url;
    private Connection conn;
    private Statement stmt;

    /**
     * SqlDao object
     */
    public SqlDao() {
        url = "jdbc:sqlite:sudoku.db";
        getConnection();
        try {
            createIfNotExist();
        } catch (SQLException ex) {
            Logger.getLogger(SqlDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Tries to get connection to database
     */
    public void getConnection() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    /**
     * Creates database if it doesn't exist
     * @throws SQLException 
     */
    public void createIfNotExist() throws SQLException {
        try {
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS score ("
                    + "Score INTEGER);");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
        try {
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS level ("
                    + "Level TEXT, "
                    + "Difficulty TEXT);");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    /**
     * Adds score to database
     * @param score score to be added
     */
    @Override
    public void add(int score) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns list of scores in database
     * @return list of scores
     */
    @Override
    public List<Integer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Gets random level from database
     * @param diff difficulty of the level
     * @return returns level string
     */
    @Override
    public String getRandomLevel(String diff) {
        String level = "";
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT Level FROM level "
                    + "WHERE Difficulty=(?) "
                    + "ORDER BY RANDOM() "
                    + "LIMIT 1;");
            stmt.setString(1, diff);
            ResultSet rs = stmt.executeQuery();
            level = rs.getString("Level");
        } catch (Exception e) {
            
        }
        return level;
    }

}
