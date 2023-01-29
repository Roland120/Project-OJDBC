/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.Region;


/**
 *
 * @author User
 */
public class RegionController implements IRegionController {
    private IRegionDAO irdao;
    
    public RegionController (Connection connection){
        irdao = new RegionDAO(connection);
        
    }

    @Override
    public List<Region> getAll() {
        System.out.println("Menampilkan semua data Region");
        return irdao.getAll();
    }

    @Override
    public List<Region> search(String key) {
        List<Region> region = new ArrayList<Region>();
        try {
        //data kosong
        if (key.isEmpty()) {
            System.out.println("Error");
            System.out.println("Maaf masukan anda tidak boleh kosong");
        }else if (key.length() > 25) {
            System.out.println("Error!!");
            System.out.println("Masukan tidak boleh lebih dari 25 karakter"); 
        }else {
            System.out.println("Menampilkan data Region dengan kata kunci: "+key);
            region = irdao.search(key);
        }
        } catch (NullPointerException npe) {
            System.out.println("Maaf terdapat kesalah!!");
            npe.printStackTrace();
        }
        return region;
    }

    @Override
    public void delete(String id) {
        String result = "";
        try {
            
            if (id.isEmpty()){
                System.out.println("Error");
                System.out.println("ID tidak boleh kosong");
            } 
            else if (Integer.parseInt(id) != irdao.getById(Integer.parseInt(id)).getId()) {
                System.out.println("Error");
                System.out.println("ID tidak ditemukan");
            }
            else if (Integer.parseInt(id) < 1) {
                System.out.println("Error");
                System.out.println("ID tidak boleh nol atau minus");
            } else {
                irdao.delete(Integer.parseInt(id));
                System.out.println("Data  berhasl dihapus");
            }
        } catch (Exception e){
            e.getStackTrace();
            result = "Failed!!";
        }
    }

    @Override
    public Region getById(String id) {
       Region r = new Region(0, "0");
        try {
            //data kosong
            if (id.isEmpty()) {
                System.out.println("Error");
                System.out.println("Id masukan tidak boleh kosong");
            } //data 0 atau negatif
            else if (Integer.parseInt(id) < 1) {
                System.out.println("Error");
                System.out.println("ID harus lebih besar dari 1");
            } //data tidak ada
            else if (Integer.parseInt(id) != irdao.getById(Integer.parseInt(id)).getId()) {
                System.out.println("Error");
                System.out.println("ID tidak ditemukan");
            } else {
                System.out.println("Menampilkan data Region dengan id: "+id);
                r = irdao.getById(Integer.parseInt(id));
//                
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error!!");
            System.out.println("Enter ID correctly");
        }
        return r;
    }

    @Override
    public Region update(String id, String name) {
            Region region = new Region(Integer.parseInt(id), name);
        try {
            if (name.isEmpty()) {
                System.out.println("Error");
                System.out.println("Data tidak boleh kosong");
            }else if (name.length() > 25) {
                System.out.println("Error");
                System.out.println("Nama Region tidak boleh lebih dari 25 karakter");
            }else if (name.length() < 3) {
                System.out.println("Error");
                System.out.println("Nama Region tidak boleh kurang dari 3 karakter");
            } else {
                region = irdao.update(region);
                System.out.println("Id: "+ id +"\tname: "+name);
                System.out.println("Data berhasil diubah");
            }
        } catch (NullPointerException npe) {
            System.out.println("Error!!");
            System.out.println("Enter data correctly");
            npe.printStackTrace();
        }
        return region;
        }

    @Override
    public Region insert(String id, String name) {
             Region region = new Region(Integer.parseInt(id), name);
        try {
            if (name.isEmpty()) {
                System.out.println("Error");
                System.out.println("Data tidak boleh kosong");
            }else if (name.length() > 25) {
                System.out.println("Error");
                System.out.println("Nama Region tidak boleh lebih dari 25 karakter");
            }else if (name.length() < 3) {
                System.out.println("Error");
                System.out.println("Nama Region tidak boleh kurang dari 3 karakter");
            } else {
                region = irdao.insert(region);
                System.out.println("Id: "+ id +"\tname: "+name);
                System.out.println("Data berhasil dimasukkan");
            }
        } catch (NullPointerException npe) {
            System.out.println("There is an error!!");
            npe.printStackTrace();
        }
        return region;
    }
    
}
