package com.sql;

import com.ivoyant.mysql.ConnectionHandler;
import com.ivoyant.mysql.CustomLogger;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.sql.DbResult.connectionMap;
import static com.sql.DbResult.key;

public class DbToCsv {

    public static void getCsv() throws IOException, SQLException {
        ResultSet resultSet = DbResult.getResult();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file Name : ");
        String filePath = scanner.nextLine();
        CSVWriter csvWriter = new CSVWriter(new FileWriter("src/main/resources/" + filePath + ".csv"));
        csvWriter.writeAll(resultSet, true);
        csvWriter.close();
        ConnectionHandler.disconnect(connectionMap.get(key));
        CustomLogger.info("Converted To CSV Successfully!!");
        System.out.println("CSV file has been created successfully!");
    }

    public static void main(String[] args) throws SQLException, IOException {
        getCsv();
    }
}
