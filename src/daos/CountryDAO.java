/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import idaos.ICountryDAO;


/**
 *
 * @author User
 */
public class CountryDAO implements ICountryDAO {
    
    private Connection connection;
    
    public CountryDAO (Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Country> getAll() {
        List<Country> listcoun = new ArrayList<Country>();
        String query = "Select * FROM HR.COUNTRIES ORDER BY country_name";
        try{
            PreparedStatement getAll = connection.prepareStatement(query);
            ResultSet resultSet = getAll.executeQuery();
            while (resultSet.next()){
                Country r = new Country (resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3));
                listcoun.add(r);   
            }
        }catch(Exception e){
            e.getStackTrace();
        }
        return listcoun;
    }

    @Override
    public List<Country> search(String key) {
        List<Country> listcoun = new ArrayList<Country>();
        String query = "Select * FROM HR.COUNTRIES WHERE Upper(COUNTRY_NAME) LIKE ? Order by country_name ";// LIKE '% ? %'
        try {
            PreparedStatement search = connection.prepareStatement(query);
            search.setString(1, "%" + key + "%");
            ResultSet resultSet = search.executeQuery();
            while (resultSet.next()) {
                Country r = new Country();
                r.setId(resultSet.getString(1));
                r.setName(resultSet.getString(2));
                r.setIdr(resultSet.getInt(3));
                listcoun.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
        return listcoun;
        
    }

    @Override
    public void delete(String id) {
        String query = "DELETE HR.COUNTRIES WHERE country_id=?";
        try{
            PreparedStatement delete = connection.prepareStatement(query);
            delete.setString(1,id);
            delete.executeQuery();
         
         }catch(Exception e){
             e.printStackTrace();
         }
    }

    @Override
    public Country getById(String id) {
     Country coun = new Country();
        String query = "SELECT * FROM HR.COUNTRIES WHERE COUNTRY_ID = ?";
        try {
            PreparedStatement getById = connection.prepareStatement(query);
            getById.setString(1, id);
            
            ResultSet resultSet = getById.executeQuery();
            if (resultSet.next()) {
                
                coun.setId(resultSet.getString(1));
                coun.setName(resultSet.getString(2));
                coun.setIdr(resultSet.getInt(3));              
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
       return coun;
    }

    @Override
    public Country update(Country c) {
        String query = "UPDATE HR.COUNTRIES SET COUNTRY_NAME = ?,REGION_ID=?  WHERE COUNTRY_ID = upper(?)";
        try {
            PreparedStatement update = connection.prepareStatement(query);
            update.setString(1, c.getName());
            update.setInt(2, c.getIdr());
            update.setString(3, c.getId());
            update.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return c;
    
    }

    @Override
    public Country insert(Country c) {
      
        String query = "INSERT INTO HR.COUNTRIES(country_id, country_name, region_id)VALUES(?,?,?)";
        
        try {
            PreparedStatement insert = connection.prepareStatement(query);
            insert.setString(1, c.getId());
            insert.setString(2, c.getName());
            insert.setInt(3, c.getIdr());
            insert.executeQuery();
        } catch (Exception e) {
            return null;
        }
        return c;
    
    }
    
    
    
}
