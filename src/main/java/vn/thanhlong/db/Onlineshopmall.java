/*
 * This file is generated by jOOQ.
 */
package vn.thanhlong.db;


import java.util.Arrays;
import java.util.List;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import vn.thanhlong.db.tables.Catalog;
import vn.thanhlong.db.tables.Customer;
import vn.thanhlong.db.tables.Invoice;
import vn.thanhlong.db.tables.InvoiceDetail;
import vn.thanhlong.db.tables.LoginHistory;
import vn.thanhlong.db.tables.Product;
import vn.thanhlong.db.tables.User;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Onlineshopmall extends SchemaImpl {

    private static final long serialVersionUID = 1327165063;

    /**
     * The reference instance of <code>onlineshopmall</code>
     */
    public static final Onlineshopmall ONLINESHOPMALL = new Onlineshopmall();

    /**
     * The table <code>onlineshopmall.catalog</code>.
     */
    public final Catalog CATALOG = Catalog.CATALOG;

    /**
     * The table <code>onlineshopmall.customer</code>.
     */
    public final Customer CUSTOMER = Customer.CUSTOMER;

    /**
     * The table <code>onlineshopmall.invoice</code>.
     */
    public final Invoice INVOICE = Invoice.INVOICE;

    /**
     * The table <code>onlineshopmall.invoice_detail</code>.
     */
    public final InvoiceDetail INVOICE_DETAIL = InvoiceDetail.INVOICE_DETAIL;

    /**
     * The table <code>onlineshopmall.login_history</code>.
     */
    public final LoginHistory LOGIN_HISTORY = LoginHistory.LOGIN_HISTORY;

    /**
     * The table <code>onlineshopmall.product</code>.
     */
    public final Product PRODUCT = Product.PRODUCT;

    /**
     * The table <code>onlineshopmall.user</code>.
     */
    public final User USER = User.USER;

    /**
     * No further instances allowed
     */
    private Onlineshopmall() {
        super("onlineshopmall", null);
    }


    @Override
    public org.jooq.Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Catalog.CATALOG,
            Customer.CUSTOMER,
            Invoice.INVOICE,
            InvoiceDetail.INVOICE_DETAIL,
            LoginHistory.LOGIN_HISTORY,
            Product.PRODUCT,
            User.USER);
    }
}