package com.parmida.occupationalhealth.model;

public class RelVisitedDiseasEntity {

	@JoinColumn(name = "ID_DISEASE")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@Column(name = "DISEASE")
	private Disease disease;
	
	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public Visited getVisited() {
		return visited;
	}

	public void setVisited(Visited visited) {
		this.visited = visited;
	}

	public Long getDatetime() {
		return datetime;
	}

	public void setDatetime(Long datetime) {
		this.datetime = datetime;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	@JoinColumn(name = "ID_VISITED")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@Column(name = "VISITED")
	private Visited visited;
	
	@Column(name = "DATETIME")
	private Long datetime;
	
	@Column(name = "VALUE")
	private Float value;
	
	
	
	
}
