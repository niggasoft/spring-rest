package com.springrest.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;

@MappedSuperclass
public class Entities implements Persistable<Long> {

	private static final long serialVersionUID = -6514416331803315469L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected Long id;
	
	public Entities(){}
	
	public void setId(Long id){
		this.id = id;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return (getId()==null);
	}

}
