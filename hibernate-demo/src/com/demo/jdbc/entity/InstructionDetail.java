package com.demo.jdbc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.CascadeType;

@Entity
@Table(name = "instructor_detail")
public class InstructionDetail {

	// annotate the class as an entity and map to the db table

	// define the fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "youtube_channel")
	private String youtubeChannel;

	@Column(name = "hobby")
	private String hobby;

//looked at the instructionDetail property of instruction class 
	// use information from the instruction class join column to find out associate
	// column
//	@OneToOne(mappedBy = "instructionDetail",cascade = CascadeType.ALL) 
	// bidirectional onetoone, refers to obj of instr class
//	private Instructor instructor;

	@OneToOne(mappedBy = "instructionDetail", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Instructor instructor;

	public InstructionDetail() {

	}

	public InstructionDetail(String youtubeChannel, String hobby) {

		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructionDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

}
