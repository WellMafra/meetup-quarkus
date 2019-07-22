package com.meetup.attendee;

import javax.persistence.Entity;

import lombok.Data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Data
public class Attendee extends PanacheEntity {

	private String name;
	private boolean active;

}
