package vn.thanhlong.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import vn.thanhlong.common.anno.NotNullOrEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDTO {

    @NotNullOrEmpty
    private String username;
    @NotNullOrEmpty
    private String fullName;
    @NotNullOrEmpty
    private String password;
    @NotNullOrEmpty
    private Boolean gender;
    @NotNullOrEmpty
    private String email;
    private String phone;
    @NotNullOrEmpty
    private Long dateCreate;

}
