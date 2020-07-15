package vn.thanhlong.services;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhlong.common.dto.UserDTO;
import vn.thanhlong.common.exceptions.DataBaseException;
import vn.thanhlong.common.http_response_code.ServerStatus;
import vn.thanhlong.common.response.ServerResponse;
import vn.thanhlong.repositories.UserReposioryImpl;

@Service
public class UserServiceImpl implements UserService {

    private UserReposioryImpl userRepository;

    @Autowired
    public UserServiceImpl(UserReposioryImpl reposiory) {
        this.userRepository = reposiory;
    }

    @Override
    public ServerResponse getAll() {
        ServerResponse serverResponse = new ServerResponse();
        try {
            serverResponse.setResponse(ServerStatus.OK, true, new Gson().toJsonTree(userRepository.getAll()));
        } catch (Exception e) {
            serverResponse.setResponse(ServerStatus.INTERNAL_SERVER_ERROR, false);
            serverResponse.setMessages(e.getMessage());
        }
        return serverResponse;
    }

    @Override
    public ServerResponse insert(UserDTO user) {
        ServerResponse serverResponse = new ServerResponse();
        try {
            serverResponse.setResponse(ServerStatus.OK, true, new Gson().toJsonTree(userRepository.find(user.getUsername())));
        } catch (DataBaseException e) {
            serverResponse.setResponse(ServerStatus.INTERNAL_SERVER_ERROR, false, e.getMessage());
        }
        return serverResponse;
    }

    @Override
    public ServerResponse update(UserDTO user) {
        return null;
    }

    @Override
    public ServerResponse delete(String username) {
        return null;
    }

    @Override
    public ServerResponse find(String username) {
        ServerResponse serverResponse = new ServerResponse();
        try {
            serverResponse
                    .setResponse(ServerStatus.OK, true, new Gson().toJsonTree(userRepository.find(username)));
        } catch (DataBaseException e) {
            serverResponse.setResponse(ServerStatus.INTERNAL_SERVER_ERROR, false, e.getMessage());
        }
        return serverResponse;
    }
}
