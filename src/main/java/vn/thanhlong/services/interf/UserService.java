package vn.thanhlong.services.interf;

import org.springframework.stereotype.Component;
import vn.thanhlong.common.dto.UserDTO;
import vn.thanhlong.common.response.ServerResponse;

@Component
public interface UserService {

    ServerResponse getAll();

    ServerResponse insert(UserDTO user);

    ServerResponse update(UserDTO user);

    ServerResponse delete(String username);

    ServerResponse find(String username);

}
