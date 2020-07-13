package vn.thanhlong.controller;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.thanhlong.common.dto.UserDTO;
import vn.thanhlong.common.http_response_code.ServerStatus;
import vn.thanhlong.common.response.ServerResponse;
import vn.thanhlong.repositories.UserReposioryImpl;

@Log4j2
@RestController
@RequestMapping(value = {"/users"})
public class UserController {

    @Autowired
    private UserReposioryImpl userReposiory;

    @GetMapping(value = {"/"}, produces = "application/json")
    @ResponseBody
    public ServerResponse getAll() {
        ServerResponse serverResponse = new ServerResponse();
        try {
            serverResponse
                    .setResponse(ServerStatus.OK, true, new Gson().toJsonTree(userReposiory.getAll()));
        } catch (DataAccessException e) {
            serverResponse
                    .setResponse(ServerStatus.INTERNAL_SERVER_ERROR, false);
        }
        return serverResponse;
    }

    @PostMapping(value = {"/"})
    public Boolean insert(@RequestBody UserDTO user) {
        return userReposiory.insert(user);
    }

    @GetMapping("/{username}")
    public UserDTO findbyId(@PathVariable(value = "username") String username) {
        return userReposiory.find(username);
    }

    @DeleteMapping("/{username}")
    public Boolean delete(@PathVariable(name = "username") String username) {
        return userReposiory.delete(username);
    }

}
