package com.cloud_vendor_rest_api_with_mysql.rest_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice                                                     // As its responsible to handle multiple exceptions.
public class CloudVendorExceptionHandler {

    @ExceptionHandler(value = {CloudVendorNotFoundException.class})   // to tell this method what all exception should handle.Use , after class if another needs to be added.
    public ResponseEntity<Object> handleCloudVendorNotFoundException(CloudVendorNotFoundException cloudVendorNotFoundException){

        CloudVendorException cloudVendorException = new CloudVendorException(
                cloudVendorNotFoundException.getMessage(), cloudVendorNotFoundException.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }


}
