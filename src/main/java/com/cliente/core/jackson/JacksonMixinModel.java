package com.cliente.core.jackson;

import org.springframework.stereotype.Component;

import com.cliente.api.models.mixins.ClienteMixin;
import com.cliente.domain.models.Cliente;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
public class JacksonMixinModel extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public JacksonMixinModel() {
		setMixInAnnotation(Cliente.class, ClienteMixin.class);
	}
}
