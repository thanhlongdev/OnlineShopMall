package vn.thanhlong.repositories;

import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import vn.thanhlong.common.dto.UserDTO;

import java.sql.Connection;
import java.util.List;

import static vn.thanhlong.db.tables.User.USER;

@Log4j2
@Repository
public class UserReposioryImpl implements UserRepository {

    @Autowired
    private Connection connection;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Override
    public List<UserDTO> getAll() {
        DSLContext context = DSL.using(connection);
        return context.select().from(USER).fetchInto(UserDTO.class);
    }

    @Override
    public Boolean insert(UserDTO user) {
        DSLContext context = DSL.using(connection);
        TransactionStatus ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            context.insertInto(USER)
                    .set(USER.USERNAME, user.getUsername())
                    .set(USER.HASH_VALUE, user.getHashValue())
                    .set(USER.SALT, user.getSalt())
                    .set(USER.FULL_NAME, user.getFullName())
                    .set(USER.GENDER, user.getGender())
                    .set(USER.EMAIL, user.getEmail())
                    .set(USER.PHONE, user.getPhone())
                    .set(USER.DATE_CREATE, user.getDateCreate())
                    .set(USER.ACTIVE_MAIL, user.getActiveMail())
                    .execute();
            log.info("Insert user success");
            transactionManager.commit(ts);
            return true;
        } catch (DataAccessException e) {
            log.info("Insert user failed. Exception: " + e.toString());
        } finally {
            context.close();
        }
        return false;
    }

    @Override
    public Boolean update(UserDTO user) {
        return null;
    }

    @Override
    public UserDTO delete(String username) {
        return null;
    }

    @Override
    public UserDTO find(String username) {
        return null;
    }
}
