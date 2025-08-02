package com.cloud_vendor_rest_api_with_mysql.rest_api.repository;

import com.cloud_vendor_rest_api_with_mysql.rest_api.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest                                //to let Spring boot know that it needs to use the embedded in memory H2 DB.
public class CloudVendorRepositoryTest {
    //given-when-then
    @Autowired  //to inject a class/Object into to this
    private CloudVendorRepository cloudVendorRepository;  //Class
    CloudVendor cloudVendor;                             //Object

    //we need to generate some values for 'given' - meaning CloudVendor details, this should always go in setUp().
    //Right click-->generate-->setUp()
    @BeforeEach
    void setUp() {
    cloudVendor = new CloudVendor("1101","cloudvendorSample","Mississauga",1124567788);
    cloudVendorRepository.save(cloudVendor);  //saving above data in embedded DB
    }
    //After the test, anything thats there in pipeline must just all be cleared, for that use tearDown()
    @AfterEach
    void tearDown() {
        cloudVendor = null;
        cloudVendorRepository.deleteAll();
    }

    //Test case for success
    @Test
    void testFindByVendorName_Fount (){
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("cloudvendorSample");  // In embedded DB find the vendorName
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());     // check if the data coming from DB is the same as the data given above.
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }
    @Test
    void testFindByVendorName_NotFount (){
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");   //This data is not in the DB, so result from DB should be null.
        assertThat(cloudVendorList.isEmpty()).isTrue();

    }

}
