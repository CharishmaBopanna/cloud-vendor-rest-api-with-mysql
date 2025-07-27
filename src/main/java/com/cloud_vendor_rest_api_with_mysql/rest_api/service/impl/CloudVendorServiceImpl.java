package com.cloud_vendor_rest_api_with_mysql.rest_api.service.impl;

import com.cloud_vendor_rest_api_with_mysql.rest_api.model.CloudVendor;
import com.cloud_vendor_rest_api_with_mysql.rest_api.repository.CloudVendorRepository;
import com.cloud_vendor_rest_api_with_mysql.rest_api.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service                                                                      //Marks a class as a service (business logic)                                                                              /
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        //If more business logic is required, it should be written here
        cloudVendorRepository.save(cloudVendor);
        return "Successfully created!";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        //If more business logic is required, it should be written here
        cloudVendorRepository.save(cloudVendor);
        return "Successfully updated";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        //If more business logic is required, it should be written here
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Deleted Successfully";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        //If more business logic is required, it should be written here
        return cloudVendorRepository.findById(cloudVendorId).get();
        //first findById() & then get() to get the value as this method is supposed to return the value of the object, retun the whole thing.
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        //If more business logic is required, it should be written here
        return cloudVendorRepository.findAll();
    }
}
