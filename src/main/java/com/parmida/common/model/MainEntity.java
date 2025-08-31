package com.parmida.common.model;

import java.io.Serial;
import java.io.Serializable;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

@MappedSuperclass
public abstract class MainEntity implements Cloneable, Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@JsonbProperty("id")
	protected Long id;

	@Version
	@Column(name = "VERSION")
	// @JsonbNumberFormat(locale = "en_US", value = "#0.0")
	protected Long version;

	@Column(name = "CREATE_ON")
	protected Long createOn;

	@Column(name = "UPDATE_ON")
	protected long updateOn;

//	@Column(name = "CREATE_USER_ID")
//	private Long createUserId;
//
//	@Column(name = "UPDATE_USER_ID")
//	private Long updateUserId;

	@Column(name = "DELETED")
	protected Boolean deleted = false;

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

	public long getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(long updateOn) {
		this.updateOn = updateOn;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@PrePersist
	public void createDate() {
		updateOn = createOn = System.currentTimeMillis();
	}

	@PreUpdate
	public void updateDate() {
		updateOn = System.currentTimeMillis();
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
	public static <E extends MainEntity> E fromString(String json, Class<E> e) {
		return JsonbBuilder.create().fromJson(json, e);
	}

	@Override
	@Transient
	@JsonbTransient
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	@Transient
	@JsonbTransient
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		MainEntity other = (MainEntity) obj;

		if (getId() != other.getId()) {
			return false;
		}
		return true;
	}
}
