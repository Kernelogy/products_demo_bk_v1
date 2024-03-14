package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
@Builder
public class Category {
	@Id
	@GeneratedValue
	private int categoryId;
	private String name;
	private String code;
}
