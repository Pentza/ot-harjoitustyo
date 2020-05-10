/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dao.*;

/**
 *
 * @author pewlahde
 */
public class DaoTest {
    private ScoreDao scoredao;
    private LevelDao leveldao;
    private SqlDao sqldao;
    
    public DaoTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        scoredao = new SqlDao();
        leveldao = new SqlDao();
        sqldao = new SqlDao();
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void getRandomLevelLengthTest() {
        assertEquals(81, leveldao.getRandomLevel("easy").length());
    }
}
