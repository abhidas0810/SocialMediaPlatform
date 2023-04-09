package com.socialMediaPlatform.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@Email
	@Column(unique = true)
	@NotNull
	private String email;
	@Size(min = 0, max = 200)
	private String bio;
	@JsonIgnore
	private LocalDateTime created = LocalDateTime.now();
	@JsonIgnore
	private LocalDateTime updated_at;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private List<Post> posts = new ArrayList<>();

}
