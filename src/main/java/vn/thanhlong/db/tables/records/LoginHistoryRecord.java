/*
 * This file is generated by jOOQ.
 */
package vn.thanhlong.db.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import vn.thanhlong.db.tables.LoginHistory;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LoginHistoryRecord extends UpdatableRecordImpl<LoginHistoryRecord> implements Record3<Integer, Long, String> {

    private static final long serialVersionUID = 473961962;

    /**
     * Setter for <code>onlineshopmall.login_history.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>onlineshopmall.login_history.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>onlineshopmall.login_history.date_login</code>.
     */
    public void setDateLogin(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>onlineshopmall.login_history.date_login</code>.
     */
    public Long getDateLogin() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>onlineshopmall.login_history.username</code>.
     */
    public void setUsername(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>onlineshopmall.login_history.username</code>.
     */
    public String getUsername() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Long, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, Long, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return LoginHistory.LOGIN_HISTORY.ID;
    }

    @Override
    public Field<Long> field2() {
        return LoginHistory.LOGIN_HISTORY.DATE_LOGIN;
    }

    @Override
    public Field<String> field3() {
        return LoginHistory.LOGIN_HISTORY.USERNAME;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getDateLogin();
    }

    @Override
    public String component3() {
        return getUsername();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getDateLogin();
    }

    @Override
    public String value3() {
        return getUsername();
    }

    @Override
    public LoginHistoryRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public LoginHistoryRecord value2(Long value) {
        setDateLogin(value);
        return this;
    }

    @Override
    public LoginHistoryRecord value3(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public LoginHistoryRecord values(Integer value1, Long value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LoginHistoryRecord
     */
    public LoginHistoryRecord() {
        super(LoginHistory.LOGIN_HISTORY);
    }

    /**
     * Create a detached, initialised LoginHistoryRecord
     */
    public LoginHistoryRecord(Integer id, Long dateLogin, String username) {
        super(LoginHistory.LOGIN_HISTORY);

        set(0, id);
        set(1, dateLogin);
        set(2, username);
    }
}