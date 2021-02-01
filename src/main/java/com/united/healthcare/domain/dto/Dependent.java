package com.united.healthcare.domain.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
@Table(name="DEPENDENT")
public class Dependent {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NonNull
	private String name;
	
	@Nullable
	private String birthday;
	
	@NonNull
	private Long enrolleeId;

	public Dependent() {
		super();
	}
	
	public Dependent(Long id, String name, String birthday, Long enrolleeId) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.enrolleeId = enrolleeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Long getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(Long enrolleeId) {
		this.enrolleeId = enrolleeId;
	}

	@Override
	public String toString() {
		return "Dependent [id=" + id + ", name=" + name + ", birthday=" + birthday + ", enrolleeId=" + enrolleeId + "]";
	}
	
}
