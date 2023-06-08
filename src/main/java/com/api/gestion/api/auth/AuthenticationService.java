package com.api.gestion.api.auth;

import com.api.gestion.api.config.JwtService;
import com.api.gestion.api.dto.RolesDto;
import com.api.gestion.api.user.*;
import com.api.gestion.api.validator.ObjectsValidator;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository useruserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;
    private final ObjectsValidator<RegisterRequest> validator;

    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        validator.validate(request);
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(
                        passwordEncoder.encode(request.getPassword())
                )
                .build();
        // set roles
        var userRole = roleRepository.findByName(RoleType.USER.name())
                .orElse(
                        Roles.builder()
                                .name(RoleType.USER.name())
                                .build()
                );
        if (userRole.getId() == null) {
            userRole = roleRepository.save(userRole);
        }
        var defaultUserRole = List.of(userRole);
        user.setRoles(defaultUserRole);
        var savedUser = useruserRepository.save(user);

        userRole.setUsers(new ArrayList<>(List.of(savedUser)));
        roleRepository.save(userRole);
        var claims = new HashMap<String, Object>();
        claims.put("role", user.getRoles());
        var jwtToken = jwtService.generateToken(savedUser, claims);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .firstname(savedUser.getFirstname())
                .lastname(savedUser.getLastname())
                .userId(savedUser.getId())
                .email(savedUser.getEmail())
                .roles(
                        savedUser.getRoles() != null ?
                                savedUser.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        final User user = useruserRepository.findUserByEmail(request.getEmail()).get();
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("fullName", user.getFirstname() + " " + user.getLastname());
        final String token = jwtService.generateToken(user, claims);
        return AuthenticationResponse.builder()
                .token(token)
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .userId(user.getId())
                .email(user.getEmail())
                .roles(
                        user.getRoles() != null ?
                                user.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    private Roles findOrCreateRole(String roleName) {
        Roles role = roleRepository.findByName(roleName)
                .orElse(null);
        if (role == null) {
            return roleRepository.save(
                    Roles.builder()
                            .name(roleName)
                            .build()
            );
        }
        return role;
    }
}
