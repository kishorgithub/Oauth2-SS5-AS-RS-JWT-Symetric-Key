package com.example.rs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: R K Rahu
 */
@RestController
public class ResourceController {

    @GetMapping(value = "private")
    String getPrivateMessage() {
        return "Saving Private Ryan";
    }
}
