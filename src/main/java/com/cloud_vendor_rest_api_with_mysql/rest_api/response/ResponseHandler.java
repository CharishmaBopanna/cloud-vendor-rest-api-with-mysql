package com.cloud_vendor_rest_api_with_mysql.rest_api.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder (String message, HttpStatus httpStatus, Object responseObject){       //Method

            Map <String,Object> response = new HashMap<>();
                    response.put("message", message);
                    response.put("httpStatus", httpStatus);
                    response.put("data",responseObject );         //As we want the response to be inside 'data'

                    return new ResponseEntity<>(response,httpStatus);     //response must hold all the above as a single thing + httpCode
    }

}
