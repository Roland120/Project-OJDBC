/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;

/**
 *
 * @author User
 */
public class RegionDAO implements IRegionDAO {
    
    private Connection connection;
    
    public RegionDAO (Connection connection){
        this.connection = connection;
    }
    
    @Override
    public List<Region> getAll(){
        List<Region> listRegion = new ArrayList<Region>();
        String query = "SELECT * FROM HR.REGIONS ORDER BY region_id";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Region r = new Region(resultSet.getInt(1),resultSet.getString(2));
//                r.setId(resultSet.getInt("REGION_ID"));
//                r.setName(resultSet.getString(2));
                listRegion.add(r);   
            }
        }catch(Exception e){
            e.getStackTrace();
        }
    return listRegion;
    }
    
    @Override
    public boolean insert2 (Region r){
        boolean result = false;
        String query = "INSERT INTO HR.REGIONS(region_id,region_name)VALUES(?,?)";
//? merupakan parameterize query yg berguna untuk membantu keamaan dari sql injection attactk
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, r.getId());
            preparedStatement.setString(2, r.getName());
            preparedStatement.executeQuery();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            //return false;
        }
        return result;
    }
    
    @Override
    public Region insert (Region r) {
        String query = "INSERT INTO HR.REGIONS(region_id,region_name)VALUES(?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(2, r.getName());
            ps.setInt(1, r.getId());
            ps.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return r;
    } 
    
    @Override
    public boolean update2 (Region r){
        boolean result = false;
        String query = "UPDATE HR.REGIONS SET region_name= ? WHERE region_id= ?";
        try{
            PreparedStatement update = connection.prepareStatement(query);
            update.setString(1,r.getName());
            update.setInt(2,r.getId());
            update.executeQuery();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    @Override
    public Region update(Region r) {
        String query = "UPDATE HR.REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, r.getName());
            ps.setInt(2, r.getId());
            ps.executeQuery();
//           return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return r;
    }    

    @Override
    public void delete(int id) {
         //boolean result = false;
         String query = "DELETE HR.REGIONS WHERE region_id=?";
         try{
            PreparedStatement delete = connection.prepareStatement(query);
            delete.setInt(1,id);
            delete.executeQuery();
           // result = true;
         
         }catch(Exception e){
             e.printStackTrace();
         }
    //return result;
    }

    @Override
    public List<Region> getById2(int id) {
        List<Region> listRegion = new ArrayList<Region>();
        String query = "Select * FROM HR.REGIONS WHERE region_id= ?";
        try{
            PreparedStatement getById = connection.prepareStatement(query);
            getById.setInt(1,id);
            ResultSet resultSet = getById.executeQuery();
            while (resultSet.next()){
                Region r = new Region();
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                listRegion.add(r);   
            }
        }catch(Exception e){
            e.getStackTrace();
        }
    return listRegion;
    }
    
    public Region getById(int id) {
        Region r = new Region();
        String query = "SELECT * FROM HR.REGIONS WHERE REGION_ID = ?";
        try {
            PreparedStatement getById = connection.prepareStatement(query);
            getById.setInt(1, id);
            ResultSet resultSet = getById.executeQuery();
            while (resultSet.next()){
                //Region r = new Region();
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                //listRegion.add(r);   
            }
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
       return r;
    }

    @Override
    public List<Region> search(String key) {
    List<Region> listRegion = new ArrayList<Region>();
        String query = "Select * FROM HR.REGIONS WHERE UPPER(region_name) LIKE ? ORDER BY region_id ";// LIKE '% ? %'
    try{
            PreparedStatement search = connection.prepareStatement(query);
            search.setString(1,"%"+key+"%");
            ResultSet resultSet = search.executeQuery();
            while (resultSet.next()){
                Region r = new Region();
                r.setId(resultSet.getInt(1));
                r.setName(resultSet.getString(2));
                listRegion.add(r);   
            }
        }catch(Exception e){
            e.getStackTrace();
            return null;
        }
    return listRegion;
    }
    
    
    
    



    
    
}
