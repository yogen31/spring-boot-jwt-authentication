package com.saptasoch.ecommerce.controller.userController;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    @ApiImplicitParam(name = "Authorization", value = "Token", required = true, allowEmptyValue = false, paramType = "header",
            dataTypeClass = String.class, example = "Bearer")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
  @ApiImplicitParam(name = "Authorization", value = "Token", required = true, allowEmptyValue = false, paramType = "header",
            dataTypeClass = String.class, example = "Bearer")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/ven")
    @ApiImplicitParam(name = "Authorization", value = "Token", required = true, allowEmptyValue = false, paramType = "header",
            dataTypeClass = String.class, example = "Bearer")
    @PreAuthorize("hasRole('VENDOR')")
    public String vendorAccess() {
        return "Vendor Board.";
    }

    @GetMapping("/admin")
    @ApiImplicitParam(name = "Authorization", value = "Token", required = true, allowEmptyValue = false, paramType = "header",
            dataTypeClass = String.class, example = "Bearer")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}