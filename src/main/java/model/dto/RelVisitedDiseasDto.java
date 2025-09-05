package model.dto;

import com.parmida.occupationalhealth.model.Column;
import com.parmida.occupationalhealth.model.Disease;
import com.parmida.occupationalhealth.model.JoinColumn;
import com.parmida.occupationalhealth.model.ManyToOne;
import com.parmida.occupationalhealth.model.Visited;

public class RelVisitedDiseasDto {

	
	private DiseasDto disease;
	
	private VistedDto visited;
	
	private Long datetime;
	
	private Float value;
	
	
	public DiseasDto getDisease() {
		return disease;
	}

	public void setDisease(DiseasDto disease) {
		this.disease = disease;
	}

	public VistedDto getVisited() {
		return visited;
	}

	public void setVisited(VistedDto visited) {
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

	
}
