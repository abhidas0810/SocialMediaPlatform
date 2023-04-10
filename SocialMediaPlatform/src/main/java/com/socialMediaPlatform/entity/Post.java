package com.socialMediaPlatform.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	@Size(min = 1, max = 300)
	private String content;
	@JsonIgnore
	private LocalDateTime created_at = LocalDateTime.now();
	@JsonIgnore
	private LocalDateTime updated_at;
	@Min(value = 0)
	@JsonIgnore
	private Integer likes = 0;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
