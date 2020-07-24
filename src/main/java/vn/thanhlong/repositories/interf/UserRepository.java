package vn.thanhlong.repositories.interf;

import org.springframework.stereotype.Component;
import vn.thanhlong.common.dto.UserDTO;
import vn.thanhlong.common.exceptions.DataBaseException;
import vn.thanhlong.db.tables.records.UserRecord;

import java.util.List;

@Component
public interface UserRepository {

    List<UserDTO> getAll();

    Boolean insert(UserRecord user) throws DataBaseException;

    Boolean update(UserRecord user);

    Boolean delete(String username);

    UserDTO findByUsername(String username);

    UserDTO findByEmail(String username);

    UserDTO findByPhone(String username);

    UserRecord convertToRecord(UserDTO user);

}
