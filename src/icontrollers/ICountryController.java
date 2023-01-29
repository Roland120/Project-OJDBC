/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Country;

/**
 *
 * @author User
 */
public interface ICountryController {
    public List<Country> getAll();
    
    public Country getById(String id);
    
    public List<Country> search(String keyword);
    
    public Country insert(String id, String name, String idr);
    
    public Country update(String id, String name, String idr);
    
    public void delete(String id);
    
    
    
    
}
