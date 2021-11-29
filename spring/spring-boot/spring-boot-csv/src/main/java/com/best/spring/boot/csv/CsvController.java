package com.best.spring.boot.csv;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author lnsane
 */
@RestController
public class CsvController {
    @GetMapping
    public void csv(HttpServletResponse httpServletResponse) throws IOException {
        String csvFileName = "books.csv";

        httpServletResponse.setContentType("text/csv");

        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        httpServletResponse.setHeader(headerKey, headerValue);

        Book book1 = new Book("Effective Java", "Java Best Practices",
                "Joshua Bloch", "Addision-Wesley", "0321356683", "05/08/2008",
                38);

        Book book2 = new Book("Head First Java", "Java for Beginners",
                "Kathy Sierra & Bert Bates", "O'Reilly Media", "0321356683",
                "02/09/2005", 30);

        Book book3 = new Book("Thinking in Java", "Java Core In-depth",
                "Bruce Eckel", "Prentice Hall", "0131872486", "02/26/2006", 45);

        Book book4 = new Book("Java Generics and Collections",
                "Comprehensive guide to generics and collections",
                "Naftalin & Philip Wadler", "O'Reilly Media", "0596527756",
                "10/24/2006", 27);

        List<Book> listBooks = Arrays.asList(book1, book2, book3, book4);

        // uses the Super CSV API to generate CSV data from the model data
        ICsvBeanWriter csvWriter = new CsvBeanWriter(httpServletResponse.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);

        String[] header = { "Title", "Description", "Author", "Publisher",
                "isbn", "PublishedDate", "Price" };

        csvWriter.writeHeader(header);

        for (Book aBook : listBooks) {
            csvWriter.write(aBook, header);
        }

        csvWriter.close();
    }
}
