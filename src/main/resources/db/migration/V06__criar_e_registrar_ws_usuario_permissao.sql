CREATE TABLE ws_usuario_permissao (
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_permissao),
	FOREIGN KEY (codigo_usuario) REFERENCES ws_usuario(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES ws_permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- admin
INSERT INTO ws_usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);