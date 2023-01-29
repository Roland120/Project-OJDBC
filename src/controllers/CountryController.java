/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import icontrollers.ICountryController;
import idaos.ICountryDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Country;

/**
 *
 * @author User
 */
public class CountryController implements ICountryController{
    private ICountryDAO icdao;
    
    public CountryController (Connection connection){
        icdao = new CountryDAO(connection);
    }

    @Override
    public List<Country> getAll() {
        System.out.println("Menampilkan semua data Country");
        return icdao.getAll();
    }

    @Override
    public Country getById(String id) {
       Country coun = new Country("0", "0",0);
        try{
            if(id.isEmpty()){
                System.out.println("Error");
                System.out.println("Id masukan tidak boleh kosong");
            }else if (id.length() > 2) {
                System.out.println("Error");
                System.out.println("ID hanya terdiri dari 2 huruf");
            }else if (!icdao.getById(id).getId().equals(id)) {
                System.out.println("Error");
                System.out.println("ID tidak ditemukan");
            }else {
                coun = icdao.getById(id);
//                System.out.println("id: " + coun.getId() + "," +
//                                   "name: " + coun.getName() + 
//                        ", id region: " + coun.getIdr()) ;
            } 
        } catch (NumberFormatException nfe){
            System.out.println("Failed");
        } return coun; 
    }

    @Override
    public List<Country> search(String key) {
        List<Country> coun = new ArrayList<Country>();
        try {
        //data kosong
        if (key.isEmpty()) {
            System.out.println("Error");
            System.out.println("Maaf masukan anda tidak boleh kosong");
        }else if (key.length() > 25) {
            System.out.println("Error!!");
            System.out.println("Masukan tidak boleh lebih dari 25 karakter"); 
        } else {
            coun = icdao.search(key);
        }
        } catch (NullPointerException npe) {
            System.out.println("There is an error!!");
            npe.printStackTrace();
        }
        return coun;
    }

    @Override
    public Country insert(String id, String name, String idr) {
        Country coun = new Country(id, name, Integer.parseInt(idr));
        try {
            if (name.isEmpty()) {
                System.out.println("Error");
                System.out.println("Data tidak boleh kosong");
            }  
            else if (name.length() > 25) {
                System.out.println("Error");
                System.out.println("Nama Country tidak boleh lebih dari 25 karakter");
            } else if (name.length() < 3) {
                System.out.println("Error");
                System.out.println("Nama Country tidak boleh kurang dari 3 karakter");
            }else if (id.equals(icdao.getById(id).getId())) {
                 System.out.println("Error");
                System.out.println("ID tidak ditemukan");
            }else {
                System.out.println("Id: "+ id +"\tname: "+name+"   IdRegion: "+idr);
                coun = icdao.insert(coun);
                System.out.println("Data berhasil dimasukkan");
            }
        } catch (NullPointerException npe) {
            System.out.println("There is an error!!");
            npe.printStackTrace();
        }
        return coun;
    }

    @Override
    public Country update(String id, String name, String idr) {
        Country coun = new Country(id , name, Integer.parseInt(idr));
        try {
            if (name.isEmpty()) {
                System.out.println("Error");
                System.out.println("Data tidak boleh kosong");
            }else if (name.length() > 25) {
                System.out.println("Error");
                System.out.println("Nama Country tidak boleh lebih dari 25 karakter");
            } 
            else if (!id.equals(icdao.getById(id).getId())) {
                 System.out.println("Error");
                System.out.println("ID tidak ditemukan");
            }
            else if (name.length() < 3) {
                System.out.println("Error");
                System.out.println("Nama Country tidak boleh kurang dari 3 karakter");
            } else {
                coun = icdao.update(coun);
                System.out.println("Data berhasil diupdate");
            }
        } catch (NullPointerException npe) {
            System.out.println("There is an error!!");
            npe.printStackTrace();
        }
        return coun;
    }

    @Override
    public void delete(String id) {
        String result = "";
        try {
            if (id.isEmpty()){
                System.out.println("Error");
                System.out.println("ID tidak boleh kosong");
            } 
            else if (!id.equals(icdao.getById(id).getId())) {
                 System.out.println("Error");
                System.out.println("ID tidak ditemukan");
            }else {
                icdao.delete(id);
                System.out.println("Data berhasil dihapus");
            }
        } catch (Exception e){
            e.getStackTrace();
            result = "Failed!!";
        }
    }
    
}
