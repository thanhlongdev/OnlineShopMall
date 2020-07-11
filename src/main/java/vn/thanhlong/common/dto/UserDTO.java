package vn.thanhlong.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDTO {

    private String username;
    private String hashValue;
    private String salt;
    private String fullName;
    private Boolean gender;
    private String email;
    private String phone;
    private Long dateCreate;
    private String forgetPassword;
    private String activeMail;

}
