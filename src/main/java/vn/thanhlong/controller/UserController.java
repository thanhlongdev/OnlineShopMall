package vn.thanhlong.controller;

import com.sun.istack.internal.NotNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.thanhlong.common.code_resoponse.ServerStatus;
import vn.thanhlong.common.dto.UserDTO;
import vn.thanhlong.common.helper.ObjectHelper;
import vn.thanhlong.common.response.ServerResponse;
import vn.thanhlong.services.interf.UserService;

@Log4j2
@RestController
@RequestMapping(value = {"/users"})
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/"}, produces = "application/json")
    @ResponseBody
    public ServerResponse getAll() {
        return userService.getAll();
    }

    @PostMapping(value = {"/"})
    public ServerResponse insert(@RequestBody UserDTO user) {
        System.out.println(user.toString());
        ServerResponse response = new ServerResponse();
        try {
            if (ObjectHelper.isNotNullOrEmptyFiedRequied(user)) {
                response = userService.insert(user);
            }
        } catch (Exception e) {
            response.setResponse(ServerStatus.INTERNAL_SERVER_ERROR, false, e.getMessage());
        }

        return response;
    }

    @PutMapping(value = {"/{username}"})
    public ServerResponse update(
            @RequestBody UserDTO user) {
        return userService.update(user);
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
