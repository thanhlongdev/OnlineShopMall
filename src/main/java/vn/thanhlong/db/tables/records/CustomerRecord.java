/*
 * This file is generated by jOOQ.
 */
package vn.thanhlong.db.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;

import vn.thanhlong.db.tables.Customer;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomerRecord extends UpdatableRecordImpl<CustomerRecord> implements Record9<Integer, String, String, String, String, String, Long, String, String> {

    private static final long serialVersionUID = -1538398414;

    /**
     * Setter for <code>onlineshopmall.customer.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>onlineshopmall.customer.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>onlineshopmall.customer.full_name</code>.
     */
    public void setFullName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>onlineshopmall.customer.full_name</code>.
     */
    public String getFullName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>onlineshopmall.customer.email</code>.
     */
    public void setEmail(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>onlineshopmall.customer.email</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>onlineshopmall.customer.phone</code>.
     */
    public void setPhone(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>onlineshopmall.customer.phone</code>.
     */
    public String getPhone() {
        return (String) get(3);
    }

    /**
     * Setter for <code>onlineshopmall.customer.hash_value</code>.
     */
    public void setHashValue(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>onlineshopmall.customer.hash_value</code>.
     */
    public String getHashValue() {
        return (String) get(4);
    }

    /**
     * Setter for <code>onlineshopmall.customer.salt</code>.
     */
    public void setSalt(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>onlineshopmall.customer.salt</code>.
     */
    public String getSalt() {
        return (String) get(5);
    }

    /**
     * Setter for <code>onlineshopmall.customer.date_create</code>.
     */
    public void setDateCreate(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>onlineshopmall.customer.date_create</code>.
     */
    public Long getDateCreate() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>onlineshopmall.customer.forget_password</code>.
     */
    public void setForgetPassword(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>onlineshopmall.customer.forget_password</code>.
     */
    public String getForgetPassword() {
        return (String) get(7);
    }

    /**
     * Setter for <code>onlineshopmall.customer.active_email</code>.
     */
    public void setActiveEmail(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>onlineshopmall.customer.active_email</code>.
     */
    public String getActiveEmail() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, String, String, String, String, String, Long, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Integer, String, String, String, String, String, Long, String, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Customer.CUSTOMER.ID;
    }

    @Override
    public Field<String> field2() {
        return Customer.CUSTOMER.FULL_NAME;
    }

    @Override
    public Field<String> field3() {
        return Customer.CUSTOMER.EMAIL;
    }

    @Override
    public Field<String> field4() {
        return Customer.CUSTOMER.PHONE;
    }

    @Override
    public Field<String> field5() {
        return Customer.CUSTOMER.HASH_VALUE;
    }

    @Override
    public Field<String> field6() {
        return Customer.CUSTOMER.SALT;
    }

    @Override
    public Field<Long> field7() {
        return Customer.CUSTOMER.DATE_CREATE;
    }

    @Override
    public Field<String> field8() {
        return Customer.CUSTOMER.FORGET_PASSWORD;
    }

    @Override
    public Field<String> field9() {
        return Customer.CUSTOMER.ACTIVE_EMAIL;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getFullName();
    }

    @Override
    public String component3() {
        return getEmail();
    }

    @Override
    public String component4() {
        return getPhone();
    }

    @Override
    public String component5() {
        return getHashValue();
    }

    @Override
    public String component6() {
        return getSalt();
    }

    @Override
    public Long component7() {
        return getDateCreate();
    }

    @Override
    public String component8() {
        return getForgetPassword();
    }

    @Override
    public String component9() {
        return getActiveEmail();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getFullName();
    }

    @Override
    public String value3() {
        return getEmail();
    }

    @Override
    public String value4() {
        return getPhone();
    }

    @Override
    public String value5() {
        return getHashValue();
    }

    @Override
    public String value6() {
        return getSalt();
    }

    @Override
    public Long value7() {
        return getDateCreate();
    }

    @Override
    public String value8() {
        return getForgetPassword();
    }

    @Override
    public String value9() {
        return getActiveEmail();
    }

    @Override
    public CustomerRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public CustomerRecord value2(String value) {
        setFullName(value);
        return this;
    }

    @Override
    public CustomerRecord value3(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public CustomerRecord value4(String value) {
        setPhone(value);
        return this;
    }

    @Override
    public CustomerRecord value5(String value) {
        setHashValue(value);
        return this;
    }

    @Override
    public CustomerRecord value6(String value) {
        setSalt(value);
        return this;
    }

    @Override
    public CustomerRecord value7(Long value) {
        setDateCreate(value);
        return this;
    }

    @Override
    public CustomerRecord value8(String value) {
        setForgetPassword(value);
        return this;
    }

    @Override
    public CustomerRecord value9(String value) {
        setActiveEmail(value);
        return this;
    }

    @Override
    public CustomerRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, Long value7, String value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CustomerRecord
     */
    public CustomerRecord() {
        super(Customer.CUSTOMER);
    }

    /**
     * Create a detached, initialised CustomerRecord
     */
    public CustomerRecord(Integer id, String fullName, String email, String phone, String hashValue, String salt, Long dateCreate, String forgetPassword, String activeEmail) {
        super(Customer.CUSTOMER);

        set(0, id);
        set(1, fullName);
        set(2, email);
        set(3, phone);
        set(4, hashValue);
        set(5, salt);
        set(6, dateCreate);
        set(7, forgetPassword);
        set(8, activeEmail);
    }
}
