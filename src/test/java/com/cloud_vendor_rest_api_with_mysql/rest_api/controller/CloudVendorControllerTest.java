package com.cloud_vendor_rest_api_with_mysql.rest_api.controller;

import com.cloud_vendor_rest_api_with_mysql.rest_api.model.CloudVendor;
import com.cloud_vendor_rest_api_with_mysql.rest_api.service.CloudVendorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;   //added this manually

@WebMvcTest(CloudVendorController.class)    //for the controller layer that interacts with external web.
class CloudVendorControllerTest {

    @Autowired
    private MockMvc mockMvc; //normal Mock wnt work, but MockMvc is needed for Controller layer
    @MockitoBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendorOne;
    CloudVendor cloudVendorTwo;
    List<CloudVendor> cloudVendorList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        cloudVendorOne = new CloudVendor("20111","Amazon","Mississauga",78675);
        cloudVendorOne = new CloudVendor("20112","GCP","Toronto",78678);
        cloudVendorList.add(cloudVendorOne);
        cloudVendorList.add(cloudVendorTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetVendorDetails() throws Exception {
        when(cloudVendorService.getCloudVendor("20111")).thenReturn(cloudVendorOne);
        this.mockMvc.perform(get("/cloudVendor/id/20111")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetVendorDetailsByName() throws Exception {
        when(cloudVendorService.getCloudVendorByName("Amazon")).thenReturn(cloudVendorOne);
        this.mockMvc.perform(get("/cloudVendor/name/Amazon")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/cloudVendor")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testAddVendorDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cloudVendorOne);
        when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Created successfully!!");
        this.mockMvc.perform(post("/cloudVendor").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void testUpdateVendorDetails()throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(cloudVendorOne);
        when(cloudVendorService.updateCloudVendor(cloudVendorOne)).thenReturn("Updated successfully");
        this.mockMvc.perform(put("/cloudVendor").contentType(MediaType.APPLICATION_JSON).content(requestJson)).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteVendorDetails()throws Exception {
        when(cloudVendorService.deleteCloudVendor("11101")).thenReturn("Deleted successfully");
        this.mockMvc.perform(delete("/cloudVendor/id/11101")).andDo(print()).andExpect(status().isOk());
    }
}