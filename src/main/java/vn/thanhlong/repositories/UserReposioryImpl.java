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
import vn.thanhlong.common.helper.PassHelper;
import vn.thanhlong.db.tables.records.UserRecord;

import java.sql.Connection;
import java.util.Date;
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
            String[] hashSalt = new PassHelper().hash(user.getPassword());
            context.insertInto(USER)
                    .set(USER.USERNAME, user.getUsername())
                    .set(USER.HASH_VALUE, hashSalt[1])
                    .set(USER.SALT, hashSalt[0])
                    .set(USER.FULL_NAME, user.getFullName())
                    .set(USER.GENDER, user.getGender())
                    .set(USER.EMAIL, user.getEmail())
                    .set(USER.PHONE, user.getPhone())
                    .set(USER.DATE_CREATE, new Date().getTime())
                    .execute();
            log.info("Insert user success");
            transactionManager.commit(ts);
            return true;
        } catch (DataAccessException e) {
            log.info("Insert user failed. Exception: " + e.toString());
            throw e;
        } finally {
            context.close();
        }
    }

    @Override
    public Boolean update(UserDTO user) {
        return null;
    }

    @Override
    public Boolean delete(String username) {
        DSLContext context = DSL.using(connection);
        TransactionStatus ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            UserRecord userRecord = context.fetchOne(USER, USER.USERNAME.like(username));
            userRecord.delete();
            return true;
        } catch (DataAccessException e) {
            log.info("Detele user failed. Exception: " + e.toString());
            throw e;
        } catch (NullPointerException e) {
            log.info("Detele user failed. Exception: " + e.toString());
            throw e;
        } finally {
            context.close();
        }
    }

    @Override
    public UserDTO find(String username) {
        DSLContext context = DSL.using(connection);
        return context.select().from(USER).where(USER.USERNAME.like(username)).fetchOneInto(UserDTO.class);
    }
}
