package com.example.casebe6.controller;

import com.example.casebe6.dto.UserToken;
import com.example.casebe6.models.AppUser;
import com.example.casebe6.models.Role;
import com.example.casebe6.models.Seller;
import com.example.casebe6.service.AppUserService;
import com.example.casebe6.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    AppUserService appUserService;


    @PostMapping("/login")
    public UserToken login(@RequestBody AppUser appUser) {
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPass()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);

            // Sẽ là tạo ra appUser1 vì nếu để appUser bình thường sẽ lộ password
            AppUser appUser1 = appUserService.findByUserName(appUser.getUsername());
            return new UserToken(appUser1.getId(), appUser1.getUsername(), token, appUser1.getRoles());
        } catch (Exception e) {
            return null;
        }
    }

//    @PostMapping("/registerSeller")
//    public ResponseEntity<AppUser> register(@RequestBody Seller seller) {
//        appUserService.save(seller.getAppUser());
//        sellerService.save(seller);
//        return new ResponseEntity<>(seller.getAppUser(), HttpStatus.OK);
//    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser) {
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(1L);
        roles.add(role);
        appUser.setRoles(roles);
        return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.OK);
    }
}
