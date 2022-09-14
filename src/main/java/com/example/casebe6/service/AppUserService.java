package com.example.casebe6.service;

import com.example.casebe6.models.AppUser;
import com.example.casebe6.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAppUserRepo iAppUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepo.findByUsername(username);
        return new User(appUser.getUsername(), appUser.getPass(),appUser.getRoles());
    }

    public List<AppUser> getAll() {
        return (List<AppUser>) iAppUserRepo.findAll();
    }

    public AppUser findByUserName(String username){
        AppUser appUser = iAppUserRepo.findByUsername(username);
        return appUser;
    }

    public AppUser save(AppUser appUser){
        return iAppUserRepo.save(appUser);
    }

    public List<String> getAllEmails() {
        List<String> emails = new ArrayList<>();
        for (AppUser e: getAll()) {
            emails.add(e.getUsername());
        }
        return emails;
    }

    public List<AppUser> getAppUserAsSeller(){
        return iAppUserRepo.getAppUserAsSeller();
    }

    public void delete(Long id) {
        iAppUserRepo.deleteById(id);
    }
}
