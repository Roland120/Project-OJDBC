/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Country;

/**
 *
 * @author User
 */
public interface ICountryDAO {
 
    public List<Country> getAll();
    
    public List<Country> search(String key);

    public void delete(String id);
    
    public Country getById(String id);
    
    public Country update(Country c);
    
    public Country insert (Country c);
}
