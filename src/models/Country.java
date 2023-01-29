/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author User
 */
public class Country {
    private String id;
    private String name;
    private int idr;

    public Country(){
    }
    
    public Country(String id, String name, int idr) {
        this.id = id;
        this.name = name;
        this.idr = idr;
    }
    
    public Country (int i,String s){
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int rid) {
        this.idr = idr;
    }
    
   public void display(){
       System.out.println("Id: "+ id +"\tCountry: "+name+"   IdRegion: "+ idr);
   }
   
//   public String toString() {
//        return "id =" + id + "\t " + ", name =" + name + "IdRegion: "+idr; 
//    }
    
    

}