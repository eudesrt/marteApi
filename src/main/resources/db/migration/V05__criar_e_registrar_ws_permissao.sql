CREATE TABLE ws_permissao (
	codigo BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO ws_permissao (codigo, descricao) values (1, 'CADASTRAR_ORDEM_SERVICO');

