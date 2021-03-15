-- Cria o schema
create schema ecomerce;

use ecomerce;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on ecomerce.* to user@'localhost';

-- Cria Tabela Cliente
create table cli_cliente (
  cli_id bigint unsigned not null auto_increment,
  cli_nome varchar(20) not null,
  cli_email varchar(50) not null,
  cli_age int not null,
  
  PRIMARY KEY (cli_id),
  UNIQUE KEY uni_cli_email (cli_email),  
);

-- Cria tabela Pedido
create table ped_pedido (
  ped_id bigint unsigned not null auto_increment,
  ped_nome varchar(50) not null,
  ped_valor float not null,
  primary key (ped_id),  
  unique key uni_ped_nome (ped_nome)
);


-- Cria tabela Pedidos Tabelados de acordo com o Cliente
create table tab_cliente_pedido(
  cli_id bigint unsigned not null,
  ped_id bigint unsigned not null,
  primary key (cli_id, ped_id),
  foreign key tab_cliente_fk (cli_id) references cli_cliente (cli_id) on delete restrict on update cascade,
  foreign key tab_pedido_fk (ped_id) references ped_pedido (ped_id) on delete restrict on update cascade	
);
