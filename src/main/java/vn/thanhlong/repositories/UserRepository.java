package vn.thanhlong.repositories;

import vn.thanhlong.common.dto.UserDTO;

import java.util.List;

public interface UserRepository {

    List<UserDTO> getAll();

    Boolean insert(UserDTO user);

    Boolean update(UserDTO user);

    UserDTO delete(String username);

    UserDTO find(String username);

}
