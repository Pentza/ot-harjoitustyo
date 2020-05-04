/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pewlahde
 */
public class SqlDao implements ScoreDao {

    private String url;
    private Connection conn;
    private Statement stmt;

    public SqlDao() {
        url = "jdbc:sqlite:score.db";
        getConnection();
        try {
            createIfNotExist();
        } catch (SQLException ex) {
            Logger.getLogger(SqlDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    public void getConnection() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    public void createIfNotExist() throws SQLException {
        try {
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTs score ("
                    + "Score INTEGER);");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    @Override
    public int add(int score) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Integer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
