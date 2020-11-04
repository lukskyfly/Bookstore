package pl.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Book {


    private Integer id;

    private String title;

    private String author;

    private String isbn;

    private String description;

    private Integer year;

}
