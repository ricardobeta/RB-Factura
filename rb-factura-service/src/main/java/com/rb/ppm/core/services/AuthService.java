package com.rb.ppm.core.services;

import com.rb.ppm.core.repository.OfficerRepository;
import com.rb.ppm.application.dto.AuthRq;
import com.rb.ppm.application.dto.AuthRs;
import com.rb.ppm.core.domain.OfficerEntity;
import com.rb.ppm.core.mappers.OfficerMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.Collections;
import java.util.Date;
import java.util.function.Function;

@Service
public class AuthService {

    private final String SECRET_KEY = "b3ad4910785a7e53b2e1c13c70526303518f725f558a11b196064207091a27ad";
    private final long EXPIRATION_TIME = 86400000;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private OfficerRepository officerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public AuthRs authenticate(AuthRq authRq) throws AuthenticationException {
        OfficerEntity officer = officerRepository.findByUserName(authRq.getUserName())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!passwordEncoder.matches(authRq.getPassword(), officer.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        AuthRs authRs = new AuthRs();
        authRs.setAuthorizer(generateToken(officer.getUserName()));
        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(officer.getUserName(), null, Collections.singletonList(authority));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return authRs;
    }

    @Transactional
    public Boolean createOfficer(AuthRq authRq){
        OfficerEntity officerEntity = OfficerMapper.INSTANCE.toEntity(authRq);
        officerEntity.setPassword(passwordEncoder.encode(officerEntity.getPassword()));
        officerRepository.save(officerEntity);
        return true;
    }

    private String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }


}