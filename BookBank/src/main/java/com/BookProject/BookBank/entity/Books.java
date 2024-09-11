package com.BookProject.BookBank.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.dialect.MySQLDialect;


// You don't need @RestController in an Entity class
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BOOK")

 // Make sure you import the correct Entity annotation
public class Books {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private int id;

	private String title;

	@OneToOne(cascade = CascadeType.ALL)
	 private Author author;

	public Books(int id, String title, Author author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}
}
