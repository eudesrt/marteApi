CREATE TABLE ws_status(
codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
evento_id BIGINT(4) NOT NULL,
status VARCHAR(30)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into ws_status (evento_id,status) values (1000,'NOVO');
insert into ws_status (evento_id,status) values (1100,'ABERTO');
insert into ws_status (evento_id,status) values (1300,'DESENVOLVENDO');
insert into ws_status (evento_id,status) values (1300,'HOMOLOGANDO');
insert into ws_status (evento_id,status) values (1400,'PENDENTE INFORMACAO');
insert into ws_status (evento_id,status) values (1500,'GERENCIA');
insert into ws_status (evento_id,status) values (9999,'FECHADO');