package com.cloud_vendor_rest_api_with_mysql.rest_api.service.impl;

import com.cloud_vendor_rest_api_with_mysql.rest_api.model.CloudVendor;
import com.cloud_vendor_rest_api_with_mysql.rest_api.repository.CloudVendorRepository;
import com.cloud_vendor_rest_api_with_mysql.rest_api.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class CloudVendorServiceImplTest {
    //As you need everything here for testing, use @Mock for the below

    @Mock
    private CloudVendorRepository cloudVendorRepository; //Always mock Repository first and then rest(I got an error)
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendor;
    AutoCloseable autoCloseable;  //to ensure that all resources get closed after Test execution.

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);        // This denotes that we are opening/initializing the object in @Mock.
        cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("11101","GCP","Toronto",965439);
    }

    @AfterEach
    void tearDown() throws Exception { //any time you call close(), the compiler expects you to either handle or declare a possible Exception.
        autoCloseable.close();
        // This denotes that objects in @Mock needs to be released/closed.

    }

    @Test
    void createCloudVendor() {
        mock(CloudVendor.class);  //look at the actual method in the service, it is using CloudVendorRepository to save CloudVendor in DB. So mock both
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        //when the mocked method in ServiceImpl is called, then return the cloudVendor object.
        assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success");
    }

    @Test
    void updateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
        assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Successfully updated");
    }

    @Test
    void getCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findById("11101")).thenReturn(Optional.ofNullable(cloudVendor));
        assertThat(cloudVendorService.getCloudVendor("11101").getVendorName()).isEqualTo(cloudVendor.getVendorName());
    }
    @Test
    void getCloudVendorByName() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findByVendorName("GCP")).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
        assertThat(cloudVendorService.getCloudVendorByName("GCP").getVendorId()).isEqualTo(cloudVendor.getVendorId());
    }

    @Test
    void getAllCloudVendors() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);
        when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));
        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).isEqualTo(cloudVendor.getVendorPhoneNumber());

    }

    @Test
    void deleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS); //when deleteByID is called it returns a void from DB op, when ever void is returned, this Mockito thing needs to be used.

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository).deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("11101")).isEqualTo("Deleted Successfully");

    }

}