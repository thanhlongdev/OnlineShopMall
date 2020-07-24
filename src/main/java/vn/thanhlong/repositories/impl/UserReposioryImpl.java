package vn.thanhlong.repositories.impl;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import vn.thanhlong.common.dto.UserDTO;
import vn.thanhlong.common.exceptions.DataBaseException;
import vn.thanhlong.common.helper.PassHelper;
import vn.thanhlong.db.tables.records.UserRecord;
import vn.thanhlong.repositories.interf.UserRepository;

import java.sql.Connection;
import java.util.List;

import static vn.thanhlong.db.tables.User.USER;

@Slf4j
@Repository
public class UserReposioryImpl implements UserRepository {

    private Connection connection;
    private DataSourceTransactionManager transactionManager;

    @Autowired
    public UserReposioryImpl(Connection connection, DataSourceTransactionManager transactionManager) {
        this.connection = connection;
        this.transactionManager = transactionManager;
    }

    @Override
    public List<UserDTO> getAll() {
        DSLContext context = DSL.using(connection);
        return context.select().from(USER).fetchInto(UserDTO.class);
    }

    @Override
    public Boolean insert(UserRecord user) {
        DSLContext context = DSL.using(connection);
        TransactionStatus ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {

            if (this.findByUsername(user.getUsername()) != null) {
                throw new DataBaseException("Duplicate entry '" + user.getUsername() + "' for key 'PRIMARY'");
            }

            if (this.findByEmail(user.getEmail()) != null) {
                throw new DataBaseException("Duplicate entry '" + user.getEmail() + "' for 'EMAIL'");
            }

            if (this.findByPhone(user.getPhone()) != null) {
                throw new DataBaseException("Duplicate entry '" + user.getPhone() + "' for 'PHONE'");
            }

            context.insertInto(USER)
                    .set(user)
                    .execute();
            log.info("Insert user success");
            transactionManager.commit(ts);
            return true;
        } catch (DataAccessException e) {
            throw e;
        }
    }

    @Override
    public Boolean update(UserRecord user) {
        DSLContext context = DSL.using(connection);
        TransactionStatus ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {

            context.update(USER).set(user).execute();
            log.info("Update user success");
            transactionManager.commit(ts);
            return true;
        } catch (Exception e) {
            log.info("Update user failed. Exception: " + e.toString());
            transactionManager.rollback(ts);
            throw e;
        } finally {
            context.close();
        }
    }

    @Override
    public Boolean delete(String username) {
        DSLContext context = DSL.using(connection);
        TransactionStatus ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            context.fetchOne(USER, USER.USERNAME.like(username)).delete();
            return true;
        } catch (DataAccessException e) {
            throw e;
        } catch (NullPointerException e) {
            throw e;
        } finally {
            context.close();
        }
    }

    @Override
    public UserDTO findByUsername(String username) {
        DSLContext context = DSL.using(connection);
        return context.select().from(USER).where(USER.USERNAME.like(username)).fetchOneInto(UserDTO.class);
    }

    @Override
    public UserDTO findByEmail(String email) {
        DSLContext context = DSL.using(connection);
        return context.select().from(USER).where(USER.EMAIL.like(email)).fetchOneInto(UserDTO.class);
    }

    @Override
    public UserDTO findByPhone(String phone) {
        DSLContext context = DSL.using(connection);
        return context.select().from(USER).where(USER.PHONE.like(phone)).fetchOneInto(UserDTO.class);
    }

    @Override
    public UserRecord convertToRecord(UserDTO user) {
        UserRecord userRecord = new UserRecord();
        String[] hash = new PassHelper().hash(user.getPassword());
        userRecord.setUsername(user.getUsername());
        userRecord.setHashValue(hash[0]);
        userRecord.setSalt(hash[1]);
        userRecord.setFullName(user.getFullName());
        userRecord.setGender(user.getGender());
        userRecord.setEmail(user.getEmail());
        userRecord.setPhone(user.getPhone());
        userRecord.setDateCreate(user.getDateCreate());
        return userRecord;
    }
}
