package com.book.bookservice.entity;

import javax.persistence.*;

import com.book.bookservice.enums.ERole;


@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;
}
