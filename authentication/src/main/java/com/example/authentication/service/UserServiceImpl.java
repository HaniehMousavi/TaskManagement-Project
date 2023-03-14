package com.example.authentication.service;

import com.example.authentication.config.JwtTokenUtil;
import com.example.authentication.dao.UserDao;
import com.example.authentication.domain.AuthenticationRequest;
import com.example.authentication.domain.AuthenticationResponse;
import com.example.authentication.base.exception.CustomException;
import com.example.authentication.base.response.ResourceResponse;
import com.example.authentication.base.util.Print;
import com.example.authentication.config.JwtService;
import com.example.authentication.domain.Role;
import com.example.authentication.domain.User;
import com.example.authentication.dto.ReqUserUpdateDTO;
import com.example.authentication.dto.ResUserGetListDTO;
import com.example.authentication.repository.RoleRepository;
import com.example.authentication.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository entityRepository;
    private final RoleRepository roleRepository;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil  jwtTokenUtil;
    private final UserDao userDao;

    @Override
    public ResourceResponse<User> createUser(String role, User user) throws CustomException {

        Optional<User> existing = entityRepository.findByUsername(user.getUsername());
        existing.ifPresent(it -> {
            throw new IllegalArgumentException("user already exists: " + it.getUsername());
        });

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setSystemCreationDate(new Date());
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        Role role1 = roleRepository.findByName(role).orElseThrow(() -> new CustomException("role not found"));
        Print.print("role", role1);
        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        user.setRoles(roles);

        user = entityRepository.save(user);
        Print.print("user created", user);

        return new ResourceResponse<>(user);
    }


    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) throws CustomException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = entityRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new CustomException("No user found with username.. "));
        Print.print("user",user);
        UserDetails userDetails = null;
//        String jwtToken = jwtService.generateTokenB(user,userDetails);
        String jwtToken = jwtTokenUtil.generateToken(user,userDetails);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

        @Override
    public Boolean update(String userId, ReqUserUpdateDTO entity) {
        return userDao.update(userId, entity);
    }

    @Override
    public List<User> getList() throws CustomException {
        return userDao.getList();
    }

}

