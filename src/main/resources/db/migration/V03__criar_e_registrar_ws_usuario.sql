CREATE TABLE ws_usuario (
	codigo BIGINT(20) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	login VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO ws_usuario (codigo, nome, login, senha) values (1, 'Rafael', 'eudesrt', '123');
