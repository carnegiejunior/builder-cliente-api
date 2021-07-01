set foreign_key_checks = 0;
delete from clientes;
set foreign_key_checks = 1;
alter table clientes auto_increment = 1;

insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO,DT_CLIENTE_DATA_CADASTRO,BOL_CLIENTE_ATIVO) values (1, 'Mauro Negromonte Chagas','403.508.390-93','Nayla Quinzeiro Vilela','1976-08-03','2021-06-30 10:55',true);
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO,DT_CLIENTE_DATA_CADASTRO,BOL_CLIENTE_ATIVO) values (2, 'Eduarda Passarinho Ribas','439.564.710-32','Raquel Alcaide Queiroga','1995-05-05','2021-06-09 07:38',true);
insert into clientes (INT_CLIENTE_ID, STR_CLIENTE_NOME, STR_CLIENTE_CPF, STR_CLIENTE_NOME_MAE, DT_CLIENTE_DATA_NASCIMENTO,DT_CLIENTE_DATA_CADASTRO,BOL_CLIENTE_ATIVO) values (3, 'Pablo Hilário Rico','164.429.990-92','Letícia Borba Espinosa','200-02-18','2021-01-30 11:55',true);
