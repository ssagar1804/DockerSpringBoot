package com.QATechTesting.HMS.DockerSpringBoot.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HMS {
	@Id
	@GeneratedValue
	private int id;
	private String patientname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	@Override
	public String toString() {
		return "HMS [id=" + id + ", Record Name=" + patientname + "]";
	}

}