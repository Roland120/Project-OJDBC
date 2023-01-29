/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author User
 */
public interface IRegionController {
    
    public List<Region> getAll();
    
    public List<Region> search(String key);

    public void delete(String id);
    
    public Region getById(String id);
    
    public Region update(String id, String name);
    
    public Region insert (String id, String name);
}
