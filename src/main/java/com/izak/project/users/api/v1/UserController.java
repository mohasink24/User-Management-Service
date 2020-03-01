package com.izak.project.users.api.v1;

import com.izak.project.users.entities.User;
import com.izak.project.users.repositories.UserRepository;
import com.izak.project.users.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User related operations endpoint definitions
 *
 * @author Mohasin Kazi
 * @since 1st Match 20202
 */
@RestController
// TODO [MK] allow this only if necessary
@CrossOrigin(allowedHeaders = "*",
        methods = {RequestMethod.DELETE,
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.OPTIONS,
                RequestMethod.PUT})
public class UserController {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private UserRepository userRepository;


    // TODO [MK] following is a test code to test db connections, please remove
    @GetMapping(value = "save-dummy")
    public void saveDummyUser() {

        try {
            User user = new User();
            user.setUuid("uuid3");
            user.setFirstName("Value");
            user.setMiddleName("Value");
            user.setLastName("Value");
            user.setEmail("Value");
            user.setMobileNo("Value");
            user.setCountryCode("Value");
            user.setAddress("Value");
            userRepository.save(user);
            databaseService.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
