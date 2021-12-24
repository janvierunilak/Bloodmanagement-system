/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Used_pages;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Kwizera
 */
public class Donationreq {
   
        
        private SimpleStringProperty date;
        private SimpleStringProperty status;
        private  SimpleStringProperty username;
        private SimpleIntegerProperty userId;
        private SimpleStringProperty location;


        public Donationreq(int donorId, String date, String status,String location) {
          
            this.date = new SimpleStringProperty(date);
            this.status = new SimpleStringProperty(status);
            this.userId=new SimpleIntegerProperty(donorId);
            this.location=new SimpleStringProperty(location);
        }
     public int getDonorId() {
            return userId.get();
        }

        public void setDonorId(int id) {
            userId.set(id);
        }
  
 public String getLocation() {
            return location.get();
        }

        public void setLocation(String location) {
          this.location.set(location);
        }

        


        public String getDate() {
            return date.get();
        }

        public void setDate(String date) {
            this.date.set(date);
        }

        public String getStatus() {
            return status.get();
        }

        public void setStatus(String status) {
            this.status.set(status);
        }

        public String getUsername() {
            return username.get();
        }

        public void setUsername(String username) {
            this.username.set(username);
        }
}