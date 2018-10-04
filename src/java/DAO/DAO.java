/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author MGU
 */
public interface DAO<T> {
    
    public void create(T obj);
    
    public T find(int id);
    
    public void update(T obj);
    
    public void delete(T obj);
    
    public List<T> findAll();
    
}
