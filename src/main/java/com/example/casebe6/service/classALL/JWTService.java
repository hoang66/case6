package com.example.casebe6.service.classALL;

import com.example.casebe6.service.classALL.AppUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class JWTService {
    @Autowired
    AppUserService appUserService;
    // key để mã hóa token.
    private static final String KEY_Private = "abc12345678";
    // thời gian để token sống.
    private static final long EXPIRE_TIME = 86400000000L;


    public String createToken(Authentication authentication) {
        // lấy đối tượng đang đăng nhập.
        User user = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((user.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRE_TIME * 1000))
                .signWith(SignatureAlgorithm.HS512, KEY_Private)
                .compact();
    }

    // lấy username từ token
    public String getUserNameFromJwtToken(String token) {
        String userName = Jwts.parser()
                .setSigningKey(KEY_Private)
                .parseClaimsJws(token)
                .getBody().getSubject();
        return userName;
    }
}