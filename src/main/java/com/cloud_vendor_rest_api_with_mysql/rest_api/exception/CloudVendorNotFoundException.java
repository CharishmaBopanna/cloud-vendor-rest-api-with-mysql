package com.cloud_vendor_rest_api_with_mysql.rest_api.exception;

public class CloudVendorNotFoundException extends RuntimeException {


    public CloudVendorNotFoundException(String message) {
        super(message);
    }

    public CloudVendorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
