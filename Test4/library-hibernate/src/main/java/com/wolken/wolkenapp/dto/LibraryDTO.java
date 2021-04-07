package com.wolken.wolkenapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@NamedQueries({@NamedQuery(name="updateLibData", query="update LibraryDTO lib set lib.noOfBooks=:nbks where lib.bookName=:bnm")
	,@NamedQuery(name="getLibData", query="from LibraryDTO lib")})
@Entity
@Table(name="library_details")
public class LibraryDTO {
	
	@Id
	@Column(name = "library_id")
	private int libraryId;
	@Column(name = "library_name")
	private String libraryName;
	@Column(name = "no_of_books")
	private int noOfBooks;
	@Column(name = "book_name")
	private String bookName;
	
	
	
	
}
