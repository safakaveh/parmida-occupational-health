package com.parmida.auth.token;

import java.io.InputStream;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
@Startup
public class KeyCheck {
	@Inject
	@ConfigProperty(name = "mp.jwt.verify.publickey.location")
	private String publicKeyPath;

	@PostConstruct
	public void check() {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(publicKeyPath);
		if (is == null) {
			System.err.println("🔴 Key not found!");
		} else {
			System.out.println("🟢 Key founded.");
		}
	}
}
