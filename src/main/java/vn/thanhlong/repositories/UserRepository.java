package vn.thanhlong.repositories;

import vn.thanhlong.common.dto.UserDTO;
import vn.thanhlong.common.exceptions.DataBaseException;

import java.util.List;

public interface UserRepository {

    List<UserDTO> getAll();

    Boolean insert(UserDTO user) throws DataBaseException;

    Boolean update(UserDTO user);

    Boolean delete(String username);

    UserDTO find(String username);

}
