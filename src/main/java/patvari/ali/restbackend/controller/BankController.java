package patvari.ali.restbackend.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import patvari.ali.restbackend.domain.UserInfo;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BankController {

    public List<UserInfo> users = new ArrayList<>(List.of(
            UserInfo.builder().firstName("Ali").lastName("Ali").build(),
            UserInfo.builder().firstName("Aaron").lastName("Aaron").build(),
            UserInfo.builder().firstName("Sindy").lastName("Sindy").build()
    ));


    @PostMapping("user/post")
    @ApiOperation("Add new user")
    public ResponseEntity<UserInfo> postNewUser(@RequestBody UserInfo userInfo) {
        if (userInfo != null) {
            users.add(userInfo);
            return new ResponseEntity<>(userInfo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("user/getAll")
    @ApiOperation("Get all users")
    public List<UserInfo> getAllUsersInfo() {
        return users;
    }

    @GetMapping("user/get")
    @ApiOperation("Get all users")
    public ResponseEntity<UserInfo> getUserInfoByName(@RequestParam String name) {
        UserInfo user = users.stream()
                .filter(u -> u.getFirstName().equals(name))
                .findFirst()
                .orElse(null);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
