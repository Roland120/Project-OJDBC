/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.CountryController;
import controllers.RegionController;
import daos.CountryDAO;
import daos.RegionDAO;
import java.util.List;
import java.util.Scanner;
import models.Country;
import models.Region;

/**
 *
 * @author User
 */
public class OJDBC {
    
    
    
    public static void main (String []args){
        DBConnection connection = new DBConnection();
        System.out.println(connection.getConnection());
        
//        Region region = new Region();
//        region.setId(0);
//        region.setName("region");
//        System.out.println(region.getId() +" "+region.getName());
//        Region r = new Region(1,"Region New");
//        System.out.println(r.getId()+" "+r.getName());
        
        RegionDAO rdao = new RegionDAO(connection.getConnection());
        RegionController rcon = new RegionController(connection.getConnection()); 
        CountryDAO cdao = new CountryDAO (connection.getConnection());
        CountryController ccon = new CountryController(connection.getConnection());
        
        //Get ALL        
//        List<Region> regs = rdao.getAll();
//        for (Region reg : regs){
//            System.out.println(reg);
//        }
        
        //Insert
        
//        Region region = new Region(12,"Antartika");
//        System.out.println(rdao.insert(region));
        
        //Update
//        Region region = new Region(19,"ASIA");
//        boolean bol = rdao.update2(region);
//        System.out.println(bol); 

//        Region region = new Region(12,"ASIA-Antartika");
//        System.out.println(rdao.update(region));
        
        
        //Delete
//        rdao.delete(19);
//        System.out.println(true); 
        
        //Get by Id
//        List<Region> regs = rdao.getById2(19); 
//        for (Region reg : regs){
//            System.out.println(reg);
//        }

//        List<Region> regs = rdao.getById2(6);
//        for (Region reg : regs){
//            System.out.println(reg);
//        }

//        Region coba = rdao.getById(120);
//        System.out.println(coba);
        

        //Search
//        List<Region> regs = rdao.search("Asia"); 
//        for (Region reg : regs){
//            System.out.println(reg);
//        }

        boolean start = true;
    
    while(start){
            System.out.println("=== SELAMAT DATANG ===\n"+
                    "Silahankan pilih menu yang anda ingin jalankan\n"+
                    "1. Melihat semua data Region\n"+
                    "2. Menambahkan data Region\n"+
                    "3. Mengubah data Region\n"+
                    "4. Mencari data Region\n"+
                    "5. Mencari data berdasarkan ID Region\n"+
                    "6. Menghapus data Region\n"+
                    "7. Melihat semua data Country\n"+
                    "8. Menambahkan data Country\n"+
                    "9. Mengubah data Country\n"+
                    "10. Mencari data Country\n"+
                    "11. Mencari data berdasarkan ID Country\n"+
                    "12. Menghapus data Country\n"+
                    "13. Keluar\n");
            System.out.print("Masukkan pilihan anda:");        
            
        Scanner scrint = new Scanner(System.in);
        Scanner scrstr = new Scanner(System.in);
        int pilihan=scrint.nextInt();
        System.out.println("\t");
        switch(pilihan){
        case 1:
            List<Region> regs = rcon.getAll();
            for (Region reg : regs){
                //System.out.println(reg);
                reg.display();
            }
            System.out.println("\n==============================================\n\n");
            break;
        case 2:
            System.out.printf("Masukkan ID baru dalam bentuk angka: ");
            String id2 = scrstr.nextLine();           
            System.out.printf("Masukkan nama Region baru: ");
            String name2 = scrstr.nextLine();
            //Region region = new Region(12,"Antartika");
            rcon.insert(id2, name2);
           
            System.out.println("\n==============================================\n\n");   
                break;
        case 3:
            System.out.printf("Masukkan ID Region yang ingin diubah dalam bentuk angka: ");
            String id3 = scrstr.nextLine();            
            System.out.printf("Masukkan nama Region baru: ");
            String name3 = scrstr.nextLine();
            Region region = new Region(12,"ASIA-Antartika");
            rcon.update(id3,name3);            
            System.out.println("\n==============================================\n\n");                
//            Country c = new Country("ID", "Indo", 3); 
//            System.out.println(cdao.update(c));
            break;
        case 4:
            System.out.printf("Masukkan kata kunci yang ingin anda cari: ");
            String name4 = scrstr.nextLine();
            List<Region> regss = rcon.search(name4.toUpperCase()); 
            for (Region reg : regss){
                reg.display();
            }
//            List<Country> count = cdao.search("Indo"); 
//            for (Country cou : count){
//                cou.display();
//            }
            System.out.println("\n==============================================\n\n");
            break;
        case 5:
            System.out.printf("Masukkan ID Region yang ingin anda cari: ");
            String id5= scrstr.nextLine();
            Region coba = rcon.getById(id5);
            coba.display();
        
            System.out.println("\n==============================================\n\n");
            break;
        case 6:
            System.out.printf("Masukkan ID Region yang ingin anda hapus: ");
            String id6= scrstr.nextLine();
            rcon.delete(id6);
            System.out.println("\n==============================================\n\n");
            break;
        case 7:
            List<Country> coun = ccon.getAll();
            for (Country  cou : coun){
                cou.display();
            }
            System.out.println("\n==============================================\n\n");
            break;
        case 8:
            System.out.printf("Masukkan ID baru terdiri dari 2 huruf: ");
            String id8 = scrstr.nextLine();
            System.out.printf("Masukkan nama Country baru: ");
            String name8 = scrstr.nextLine();
            System.out.printf("Masukkan ID Region: ");
            String idr8 = scrstr.nextLine();
//            CountryDAO crd = new CountryDAO(connection.getConnection());
//            Country cr = new Country("ID", "Indonesia", 3);
            ccon.insert(id8,name8,idr8);
            
//            System.out.println(crd.insert(cr));
            //crd.insert.(cr.display());
            
            System.out.println("\n==============================================\n\n");
            
            break;
        case 9:// kalau update id yg gak ada berhasil
            System.out.printf("Masukkan ID Country yang ingin di update terdiri dari 2 huruf: ");
            String id9 = scrstr.nextLine();
            System.out.printf("Masukkan nama Country baru: ");
            String name9 = scrstr.nextLine();
            System.out.printf("Masukkan ID Region: ");
            String idr9 = scrstr.nextLine();
//            CountryDAO crd = new CountryDAO(connection.getConnection());
//            Country cr = new Country("ID", "Indonesia", 3);
            ccon.update(id9,name9,idr9);
            System.out.println("\n==============================================\n\n");
            break;
        case 10:
            System.out.printf("Masukkan kata kunci yang ingin anda cari: ");
            String name10 = scrstr.nextLine();
            List<Country> coun10 = cdao.search(name10.toUpperCase()); 
            for (Country cou : coun10){
                cou.display();
            }
            System.out.println("\n==============================================\n\n");
            break;
        case 11:
            System.out.printf("Masukkan ID Country yang ingin anda cari: ");
            String id11= scrstr.nextLine();
            Country coun11 = cdao.getById(id11);
            coun11.display();
//            System.out.println(coun11);
//            Country coba = cdao.getById("AR");
//            coba.display();
            System.out.println("\n==============================================\n\n");
            break;
        case 12:
            System.out.printf("Masukkan ID Country yang ingin anda hapus: ");
            String id12= scrstr.nextLine();
            ccon.delete(id12);
            System.out.println("\n==============================================\n\n");
            break;
        
        
        case 13:
            start = false;
            break;
            
                    
    }
    }
        
    }
}
