package com.bachelor.bachelor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@CommonsLog
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/admin")
    public String hello() {
        return "Asdasd";

    }
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public void maxSizeExceeded() {
        throw new ResponseStatusException(HttpStatus.PRECONDITION_REQUIRED);
    }


}
