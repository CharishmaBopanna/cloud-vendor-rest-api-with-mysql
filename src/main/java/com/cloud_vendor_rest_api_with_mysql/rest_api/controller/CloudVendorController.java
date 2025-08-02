package com.cloud_vendor_rest_api_with_mysql.rest_api.controller;



import com.cloud_vendor_rest_api_with_mysql.rest_api.model.CloudVendor;
import com.cloud_vendor_rest_api_with_mysql.rest_api.response.ResponseHandler;
import com.cloud_vendor_rest_api_with_mysql.rest_api.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //for Spring to know that this is the controller class
@RequestMapping("/cloudVendor")  //since in the REST API , I want a path called /cloudVendor

public class CloudVendorController {

    CloudVendorService cloudVendorService;      // as we need to map Service layer here, create an instance of that.

    public CloudVendorController(CloudVendorService cloudVendorService) {       //constructor for the above instance.
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("/id/{vendorId}")    //For SpringBoot to extract the value of vendorId to pass to this method
    public ResponseEntity<Object> getVendorDetails (@PathVariable("vendorId") String vendorId){     //@PathVariable is added to extract the vendorId from url and pass it to 'String vendorId'
       return ResponseHandler.responseBuilder("Requested CloudVendor details are ", HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId) );
    }

    @GetMapping("/name/{vendorName}")    //For SpringBoot to extract the value of vendorId to pass to this method
    public ResponseEntity<Object> getVendorDetailsByName (@PathVariable("vendorName") String vendorName){     //@PathVariable is added to extract the vendorId from url and pass it to 'String vendorId'
        return ResponseHandler.responseBuilder("Requested CloudVendor details are ", HttpStatus.OK,cloudVendorService.getCloudVendorByName(vendorName) );
    }

    @GetMapping
    public List<CloudVendor> getAllVendorDetails (){
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping()
    public String addVendorDetails (@RequestBody CloudVendor cloudVendor ){     //we are trying to get the cloudVendor details from the requestBody of API
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Created successfully!!";
    }

    @PutMapping
    public String updateVendorDetails (@RequestBody CloudVendor cloudVendor ){     //we are trying to get the cloudVendor details from the requestBody of API
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteVendorDetails (@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Deleted successfully";
    }






}
