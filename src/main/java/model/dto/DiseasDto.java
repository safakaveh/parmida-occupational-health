package model.dto;

import com.parmida.occupationalhealth.model.Column;
import com.parmida.occupationalhealth.model.JoinColumn;
import com.parmida.occupationalhealth.model.ManyToOne;
import com.parmida.occupationalhealth.model.Measure;

public class DiseasDto {
	
	private String code;
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public MeasureDto getMeasure() {
		return MeasureDto;
	}


	public void MeasureDto(MeasureDto measure) {
		this.MeasureDto = measure;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	private String name;

	private MeasureDto measure;
	
	
	private String description;


}
