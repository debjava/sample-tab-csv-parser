package com.ddlab.rnd;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;

public class TabCSVParser {
  public static void main(String[] args) throws Exception {
    Reader in =
        new FileReader(
            "testdata\\przedmioty11.csv");
    Iterable<CSVRecord> records =
        CSVFormat.TDF
    .withRecordSeparator("\r\n")
            .withFirstRecordAsHeader()
            .withHeader("Name", "Teacher", "Years")
            .withIgnoreHeaderCase()
            .parse(in);

    for (CSVRecord csvRecord : records) {
      String name = csvRecord.get(1);
      // Accessing the values by column header name
      String Teacher = csvRecord.get(2);
      String years = csvRecord.get(3);

      // Printing the record
      System.out.println("Record Number -> " + csvRecord.getRecordNumber());
      System.out.println("Name: " + name);
      System.out.println("Teacher: " + Teacher);
      System.out.print("Years : " + years);
      System.out.println("\n\n");
    }
  }
}
