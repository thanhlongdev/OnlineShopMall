package vn.thanhlong.services;

import vn.thanhlong.common.dto.UserDTO;
import vn.thanhlong.common.response.ServerResponse;

public interface UserService {

    ServerResponse getAll();

    ServerResponse insert(UserDTO user);

    ServerResponse update(UserDTO user);

    ServerResponse delete(String username);

    ServerResponse find(String username);

}
