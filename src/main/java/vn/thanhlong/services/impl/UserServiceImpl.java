package vn.thanhlong.services.impl;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.jooq.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhlong.common.code_resoponse.ServerStatus;
import vn.thanhlong.common.dto.UserDTO;
import vn.thanhlong.common.exceptions.DataBaseException;
import vn.thanhlong.common.response.ServerResponse;
import vn.thanhlong.repositories.interf.UserRepository;
import vn.thanhlong.services.interf.UserService;

import java.util.Date;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ServerResponse getAll() {
        ServerResponse serverResponse = new ServerResponse();
        try {
            serverResponse.setResponse(ServerStatus.OK, true, new Gson().toJsonTree(userRepository.getAll()));
            log.info("Get all user complete");
        } catch (DataAccessException e) {
            serverResponse.setResponse(ServerStatus.INTERNAL_SERVER_ERROR, false, e.getMessage());
            log.error("Get all user failed: Exception: " + e.getMessage());
        }
        return serverResponse;
    }

    @Override
    public ServerResponse insert(UserDTO user) {
        ServerResponse serverResponse = new ServerResponse();
        try {
            user.setDateCreate(new Date().getTime());
            userRepository.insert(userRepository.convertToRecord(user));
            serverResponse.setResponse(ServerStatus.OK, true, "Insert success");
            log.info("Insert user success");
        } catch (DataBaseException e) {
            serverResponse.setResponse(ServerStatus.INTERNAL_SERVER_ERROR, false, e.getMessage());
            log.error("Insert user failed: Exception: " + e.getMessage());
        }

        return serverResponse;
    }

    @Override
    public ServerResponse update(UserDTO user) {
        ServerResponse serverResponse = new ServerResponse();
        try {
            userRepository.update(userRepository.convertToRecord(user));
            serverResponse.setResponse(ServerStatus.OK, true, "Update success");
            log.info("Update user success");
        } catch (DataBaseException e) {
            serverResponse.setResponse(ServerStatus.INTERNAL_SERVER_ERROR, false, e.getMessage());
            log.error("Update user failed: Exception: " + e.getMessage());
        }

        return serverResponse;
    }

    @Override
    public ServerResponse delete(String username) {
        return null;
    }

    @Override
    public ServerResponse find(String s) {
        ServerResponse serverResponse = new ServerResponse();
        try {
            if (s.startsWith("0")) {
                serverResponse
                        .setResponse(ServerStatus.OK, true, new Gson().toJsonTree(userRepository.findByPhone(s)));
            } else if (s.contains("@")) {
                serverResponse
                        .setResponse(ServerStatus.OK, true, new Gson().toJsonTree(userRepository.findByEmail(s)));
            } else {
                serverResponse
                        .setResponse(ServerStatus.OK, true, new Gson().toJsonTree(userRepository.findByUsername(s)));
            }
        } catch (DataBaseException e) {
            serverResponse.setResponse(ServerStatus.INTERNAL_SERVER_ERROR, false, e.getMessage());
        }
        return serverResponse;
    }
}
