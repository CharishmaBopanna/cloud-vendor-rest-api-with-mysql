package com.cloud_vendor_rest_api_with_mysql.rest_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                                                                             //Maps this class to a table in DB
@Table(name="cloud_vendor_info")                                                    //used to specify a table name.

public class CloudVendor {

        @Id                                                                     // Marks the primary key of the Entity
        String vendorId;
        String vendorName;
        String vendorAddress;
        int vendorPhoneNumber;


    // Assessor Methods - getters and setters
    public String getVendorName() {return vendorName;}
    public void setVendorName(String vendorName) {this.vendorName = vendorName;}

    public String getVendorId() {return vendorId;}
    public void setVendorId(String vendorId) {this.vendorId = vendorId;}

    public String getVendorAddress() {return vendorAddress;}
    public void setVendorAddress(String vendorAddress) {this.vendorAddress = vendorAddress;}

    public int getVendorPhoneNumber() {return vendorPhoneNumber;}
    public void setVendorPhoneNumber(int vendorPhoneNumber) {this.vendorPhoneNumber = vendorPhoneNumber;}


    //Default Constructor as I was getting an error when making a POST call.
    public CloudVendor() {
    }

    //Constructor
    public CloudVendor(String vendorId, String vendorName, String vendorAddress, int vendorPhoneNumber) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorPhoneNumber = vendorPhoneNumber;
    }



}
