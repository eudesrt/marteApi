CREATE TABLE ws_servico(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	os BIGINT(6) NOT NULL,
	titulo VARCHAR(50) NOT NULL,
	dt_entrada DATE ,
	dt_homologacao DATE ,
	dt_commit DATE ,
	descricao_id BIGINT(6) ,
	evento_id BIGINT(20) NOT NULL,
	codigo_usuario BIGINT(20) NOT NULL,
	FOREIGN KEY (descricao_id) REFERENCES ws_descricao(codigo),
	FOREIGN KEY (evento_id) REFERENCES ws_status(codigo),
	FOREIGN KEY (codigo_usuario) REFERENCES ws_usuario(codigo)
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into ws_servico (os,titulo,dt_entrada,dt_homologacao,dt_commit,evento_id,codigo_usuario) 
values (6643,'AJUSTES LISTA CONSOLIDADA CORREIOS ESC','2013-02-7','2013-02-7','2013-02-7',7,1)
