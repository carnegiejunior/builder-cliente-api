set foreign_key_checks = 0;
delete from clientes;
set foreign_key_checks = 1;
alter table clientes auto_increment = 1;



insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO) values (1, 'Mauro Negromonte Chagas','403.508.390-93','Nayla Quinzeiro Vilela','1976-08-03');
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO) values (2, 'Eduarda Passarinho Ribas','439.564.710-32','Raquel Alcaide Queiroga','1995-05-05');
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO) values (3, 'Pablo Hilário Rico','164.429.990-92','Letícia Borba Espinosa','2000-02-18');
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO) values (4, 'Airton José da Silva','882.738.130-96','Maria Teresa da Silva','1998-01-18');
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO) values (5, 'Antônio José da Costa','026.278.430-01','Leopoldina da Costa','2000-01-18');
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO) values (6, 'Carlos Alberto Figueiredo','968.542.200-17','Jessica do Amaral Figueiredo','2000-09-14');
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO) values (7, 'Mauro de Carvalho','360.436.080-30','Augusta de Carvalho','1988-08-21');
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO) values (8, 'Andressa Rodrigues','817.693.510-78','Bruna Rodrigues','2002-07-15');
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO) values (9, 'Ludimila de Jesus Prado','212.618.530-32','Beijamin Prado','2005-07-03');
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO) values (10, 'Zuila Cardoso de Melo','494.999.280-57','George Gullar de Melo','2013-07-05');
