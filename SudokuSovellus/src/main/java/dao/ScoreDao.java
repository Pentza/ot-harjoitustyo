/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author pewlahde
 */
public interface ScoreDao {
    int add(int score);
    List<Integer> getAll();
}
