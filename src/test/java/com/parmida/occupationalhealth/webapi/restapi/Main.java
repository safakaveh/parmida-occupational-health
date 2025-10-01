package com.parmida.occupationalhealth.webapi.restapi;

import com.parmida.occupationalhealth.common.enumeration.Gender;
import com.parmida.occupationalhealth.dto.VisitedDto;
import com.parmida.occupationalhealth.dto.VisitedDto.VisitedRecord;

public class Main {

	public static void main(String[] args) {
		VisitedRecord vr = new VisitedRecord("Parmida", "Hosseini","123456", Gender.FEMALE);
		String json = vr.json();
		System.out.println(json);
	}

}
