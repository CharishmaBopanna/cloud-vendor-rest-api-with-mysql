package com.cloud_vendor_rest_api_with_mysql.rest_api.repository;

import com.cloud_vendor_rest_api_with_mysql.rest_api.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
}
