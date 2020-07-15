package vn.thanhlong.controller;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.thanhlong.common.dto.UserDTO;
import vn.thanhlong.common.http_response_code.ServerStatus;
import vn.thanhlong.common.response.ServerResponse;
import vn.thanhlong.services.UserServiceImpl;

@Log4j2
@RestController
@RequestMapping(value = {"/users"})
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = {"/"}, produces = "application/json")
    @ResponseBody
    public ServerResponse getAll() {
        return userService.getAll();
    }

    @PostMapping(value = {"/"})
    public ServerResponse insert(@RequestBody UserDTO user) {
        return userService.insert(user);
    }

    @GetMapping("/{username}")
    public ServerResponse findbyId(@PathVariable(value = "username") String username) {
        return userService.find(username);
    }

    @DeleteMapping("/{username}")
    public ServerResponse delete(@PathVariable(name = "username") String username) {
        return userService.delete(username);
    }

}
