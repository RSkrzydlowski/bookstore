package pl.skrzydlowski.bookstore.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Books implements Serializable {

	public Books() {
		
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String title;
	private String author;
	
	@OneToOne
	@JoinColumn(name = "bookInformationId")
	private BookInformation bookInformation;

	public Books(String title, String author, BookInformation bookInformation) {
		this.title = title;
		this.author = author;
		this.bookInformation = bookInformation;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookInformation getBookInformation() {
		return bookInformation;
	}

	public void setBookInformation(BookInformation bookInformation) {
		this.bookInformation = bookInformation;
	}

	

}
