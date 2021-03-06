package com.arek00.xmlReader.db;


import com.arek00.xmlReader.db.interfaces.IDBConnector;
import com.arek00.xmlReader.db.interfaces.IDBHandler;

public class DBController {

    private static DBController instance = new DBController();

    private IDBConnector connector = null;
    private IDBHandler handler = null;

    private DBController() {
    }

    public static void setConnector(IDBConnector connector) {
        instance.connector = connector;
    }

    public static void setHandler(IDBHandler handler) {
        instance.handler = handler;
    }

    public IDBConnector getConnector() {
        return connector;
    }

    public IDBHandler getHandler() {
        return handler;
    }

    /**
     * Get instance of DBController.
     * Make sure that DBConnector and DBHandler had been set.
     *
     * @return Instance of DB Connector.
     * @throws java.lang.NullPointerException when DBConnector or DBHandler have null reference.
     */
    public static DBController getInstance() {
        if (instance.getConnector() == null) {
            throw new NullPointerException("DB Connector hadn't been set.");
        } else if (instance.getHandler() == null) {
            throw new NullPointerException("DB Handler hadn't been set.");
        } else {
            return instance;
        }
    }

}
