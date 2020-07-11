package vn.thanhlong.common.helper;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PassHelper {

    public String[] hash(String plantText) {
        String salt = BCrypt.gensalt(10);
        String hash = BCrypt.hashpw(salt + plantText, BCrypt.gensalt(10));
        System.out.println("salt: " + salt + ", hash: " + hash);
        return new String[]{salt, hash};
    }

    public Boolean verifyPass(String hash, String salt, String pass) {
        return BCrypt.checkpw(salt + pass, hash);
    }

}
