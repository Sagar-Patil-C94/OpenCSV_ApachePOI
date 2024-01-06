package com.sql;

import com.ivoyant.mysql.ConnectionHandler;
import com.ivoyant.mysql.CustomLogger;
import com.ivoyant.mysql.DataOperations;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DbResult {
    public static Scanner scanner = new Scanner(System.in);
    public static Map<String, Connection> connectionMap = new HashMap<>();
    public static String databaseType;
    public static String key;
    public static ResultSet getResult() throws IOException, SQLException {
        System.out.print("Please SQL Type\n1.MySQL\n2.Postgres : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                databaseType = "mysql";
                CustomLogger.info("User Selected " + databaseType);
                break;
            case 2:
                databaseType = "postgresql";
                CustomLogger.info("User Selected " + databaseType);
                break;
            default:
                CustomLogger.error("User Selected Invalid Option");
        }
        System.out.print("Please Enter Host Name : ");
        String hostName = scanner.nextLine();
        System.out.print("Please Enter Port Number : ");
        int portNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Please Enter Database Name : ");
        String databaseName = scanner.nextLine();
        System.out.print("Please Enter Username : ");
        String username = scanner.nextLine();
        System.out.print("Please Enter Password : ");
        String password = scanner.nextLine();
        key = username + "_" + databaseName;
        if (connectionMap.containsKey(key)) {
            CustomLogger.warn("Connection Already Present!!!");
        } else {
            connectionMap.put(key, ConnectionHandler.connect(hostName, databaseType, portNumber, databaseName, username, password));
            CustomLogger.info("Connection Established!!!");
        }
        System.out.print("Enter Table Name : ");
        String tableName = scanner.nextLine();
        System.out.print("Enter Column List : ");
        String columnList = scanner.nextLine();
        return DataOperations.displayData(connectionMap.get(key), columnList, tableName);
    }
}
