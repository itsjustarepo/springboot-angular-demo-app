package com.tymiller.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long photoId;
	private String photoName;
	private String title;
	private String description;
	private String imageName;
	
	@CreationTimestamp
	private Date created;
	
	@ManyToOne
	@JsonBackReference
	private User user;
	
	private int likes;
	
	@OneToMany(mappedBy = "photo", fetch=FetchType.EAGER)
	private List<Comment> commentList;
}
