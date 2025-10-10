package com.parmida.usermanagment.model;

import java.io.Serial;

import com.parmida.common.model.MainEntity;
import com.parmida.common.utils.PasswordTools;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;

@Entity
@Table(name = "PASSWORDS")
@NamedQueries({

})
@NamedNativeQueries({

})
public class PasswordEntity extends MainEntity {
	@Serial
	private static final long serialVersionUID = 1L;

	@Column(name = "ENCRYPTED_PASSWORD")
	private String encryptedPassword;

	public PasswordEntity() {
		super();
	}

	public PasswordEntity(String password) {
		super();
		setPassword(password);
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public void setPassword(String password) {
		this.encryptedPassword = PasswordTools.getHash(password);
	}

}
