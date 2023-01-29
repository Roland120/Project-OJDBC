/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author User
 */
public interface IRegionDAO {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
   
    public List<Region> getAll();
   
    public List<Region> search(String key);
    
    public void delete(int id);
    
    public Region getById(int id);
    
    public Region update(Region r);
    
    public Region insert (Region r);
    
    public boolean insert2(Region r);
    
    public boolean update2(Region r);
    
    public List<Region> getById2(int id);
    
}
