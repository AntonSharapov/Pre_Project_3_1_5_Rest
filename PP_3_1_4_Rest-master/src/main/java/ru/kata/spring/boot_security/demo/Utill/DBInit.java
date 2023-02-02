package ru.kata.spring.boot_security.demo.Utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.service.RoleServiceImp;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBInit {
    private final UserService userService;
    private final RoleServiceImp roleService;

    @Autowired
    public DBInit(UserService userService, RoleServiceImp roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void dataBaseInit() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();

        roleService.add(roleAdmin);
        roleService.add(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);

        User user1 = new User("Dima", "Mubrov", 29, "44@44", "200", userSet);
        User user2 = new User("Anton", "Sharapov", 26, "55@55", "100", adminSet);

        userService.add(user1);
        userService.add(user2);
    }
}
