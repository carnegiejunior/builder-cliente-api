create table clientes (
  INT_CLIENTE_ID bigint not null auto_increment,
  STR_CLIENTE_NOME varchar(50) not null,
  STR_CLIENTE_CPF varchar(14) not null,
  STR_CLIENTE_NOME_MAE varchar(50) not null,
  DT_CLIENTE_DATA_NASCIMENTO date not null,
  DT_CLIENTE_DATA_CADASTRO datetime not null default current_timestamp,    
  BOL_CLIENTE_ATIVO bool not null default true,  
  constraint UC_CLIENTE_NOME_MAE_NASCIMENTO unique (STR_CLIENTE_NOME,STR_CLIENTE_NOME_MAE,DT_CLIENTE_DATA_NASCIMENTO),
  primary key (INT_CLIENTE_ID)
) engine=InnoDB default charset=utf8;
