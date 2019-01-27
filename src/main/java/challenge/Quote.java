package challenge;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scripts")
public class Quote {

    @Id
    private Integer id;

    private String actor;

    @Column(name = "detail")
    private String quote;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
        this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
        this.actor = actor;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
        this.quote = quote;
	}

}
