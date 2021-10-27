package model.dao.constants;

public enum SQLConstants {

    //t_user CRUD-queries
    INSERT_USER("INSERT INTO t_user(name, email, password, accessLevel) VALUES(?, ?, ?, ?)"),
    GET_USER_BY_ID("SELECT * FROM t_user WHERE ID = ?"),
    GET_ALL_USERS("SELECT * FROM t_user"),
    UPDATE_USER("UPDATE t_user SET name = ?, email = ?, password = ?, accessLevel = ? WHERE ID = ?"),
    DELETE_USER_BY_ID("DELETE FROM t_user WHERE ID = ?"),

    //t_product CRUD-queries
    INSERT_PRODUCT("INSERT INTO t_product(name, category, color, size, price) VALUES(?, ?, ?, ?, ?)"),
    GET_PRODUCT_BY_ID("SELECT * FROM t_product WHERE ID = ?"),
    GET_ALL_PRODUCTS("SELECT * FROM t_product"),
    UPDATE_PRODUCT("UPDATE t_product SET name = ?, category = ?, color = ?, size = ?, price = ? WHERE ID = ?"),
    DELETE_PRODUCT_BY_ID("DELETE FROM t_product WHERE ID = ?"),

    //t_order CRUD-queries
    INSERT_ORDER("INSERT INTO t_order(userId, productId) VALUES(?, ?)"),
    GET_ORDER_BY_ID("SELECT * FROM t_order WHERE ID = ?"),
    GET_ALL_ORDERS("SELECT * FROM t_order"),
    UPDATE_ORDER("UPDATE t_order SET userId = ?, productId = ? WHERE ID = ?"),
    DELETE_ORDER_BY_ID("DELETE FROM t_order WHERE ID = ?"),

    //t_user queries
    SELECT_USER_BY_NAME("SELECT * FROM t_user WHERE name = ?"),
    SELECT_USER_BY_EMAIL("SELECT * FROM t_user WHERE email = ?"),

    //t_product queries
    SELECT_ID_OF_PRODUCT("SELECT * FROM t_product WHERE name = ? AND category = ? AND color = ? AND size = ? AND price = ?"),
    SELECT_PRODUCT_BY_COLOR("SELECT * FROM t_product WHERE color = ?"),
    SELECT_PRODUCT_BY_SIZE("SELECT * FROM t_product WHERE size = ?"),
    SELECT_PRODUCT_BY_CATEGORY("SELECT * FROM t_product WHERE category = ?"),

    //t_order queries
    SELECT_ORDER_BY_USERID("SELECT * FROM t_order WHERE userId = ?"),
    SELECT_ORDER_BY_PRODUCTID("SELECT * FROM t_order WHERE productId = ?"),
    INSERT_USER_ORDER("INSERT INTO t_order(user_id, product_id) VALUES (?, ?)"),
    SELECT_ALL_USER_ORDERS("SELECT id, name, category, color, size, price FROM t_product " +
            "JOIN t_order on t_product.id = t_order.product.id " +
            "WHERE user_id = ?");


    private final String constant;

    public String getConstant() {
        return constant;
    }

    SQLConstants(String constant) {
        this.constant = constant;
    }

}

