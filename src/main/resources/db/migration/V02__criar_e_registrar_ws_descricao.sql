CREATE TABLE ws_descricao(
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
os_id BIGINT(6) NOT NULL,
dt_entrada DATE ,
descricao TEXT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;