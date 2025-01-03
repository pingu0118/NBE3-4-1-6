package com.mysite.setting_pr_1.controller;

import com.mysite.setting_pr_1.dto.AdminLoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private static final String ADMIN_PASSWORD = "admin123";

    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestBody AdminLoginDTO loginDTO) {
        if (loginDTO.getPassword().equals(ADMIN_PASSWORD)) {
            return ResponseEntity.ok("Access Granted");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Access Denied");
    }
}
