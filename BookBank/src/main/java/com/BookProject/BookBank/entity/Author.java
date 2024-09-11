package com.BookProject.BookBank.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int authorId;
	private String authorName;
	private String authorSurname;

	@OneToOne(cascade = CascadeType.ALL)
	private BookInfo bookInfo;

	public Author(int authorId, String authorName, String authorSurname , BookInfo bookInfo) {
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorSurname = authorSurname;
		this.bookInfo = bookInfo;

	}

}
