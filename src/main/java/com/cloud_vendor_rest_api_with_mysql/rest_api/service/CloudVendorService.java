package com.cloud_vendor_rest_api_with_mysql.rest_api.service;

import com.cloud_vendor_rest_api_with_mysql.rest_api.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendorByName(String cloudVendorName);
    public List<CloudVendor> getAllCloudVendors();
}
