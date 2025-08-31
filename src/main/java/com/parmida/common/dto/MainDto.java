package com.parmida.common.dto;

import java.io.Serial;
import java.io.Serializable;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Transient;

public abstract class MainDto implements Cloneable, Serializable {
	@Serial
	private static final long serialVersionUID = -1486519919077639334L;

	protected Long id;

	protected Long version;

	protected Long createOn;

	protected Long updateOn;

//	@Column(name = "CREATE_USER_ID")
//	private Long createUserId;
//
//	@Column(name = "UPDATE_USER_ID")
//	private Long updateUserId;

	protected Boolean deleted = false;

	public MainDto() {
	}

	public MainDto(Long id, Long version, Long createOn, Long updateOn, Boolean deleted) {
		this.id = id;
		this.version = version;
		this.createOn = createOn;
		this.updateOn = updateOn;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Long createOn) {
		this.createOn = createOn;
	}

	public Long getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(Long updateOn) {
		this.updateOn = updateOn;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	@Transient
	@JsonbTransient
	public String toString() {
		Jsonb jsonb = JsonbBuilder.create();
		return jsonb.toJson(this);
	}

	@Transient
	@JsonbTransient
	public static <E extends MainDto> E fromString(String json, Class<E> e) {
		return JsonbBuilder.create().fromJson(json, e);
	}

	@Override
	@Transient
	@JsonbTransient
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Transient
	@JsonbTransient
	public abstract <T extends RecordDto> T getRecord();
}
