insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');
insert into cozinha (nome) values ('Mocambicana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Muianga Food', 20, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Alice''s Cakes', 10.5, 2);

insert into estado (id, nome) values (1, 'Maputo Cidade');
insert into estado (id, nome) values (2, 'Maputo Provincia');
insert into estado (id, nome) values (3, 'Gaza');

insert into cidade (nome, estado_id) values ('Cidade de Maputo', 1);
insert into cidade (nome, estado_id) values ('Cidade da Matola', 2);
insert into cidade (nome, estado_id) values ('Xai Xai', 3);

insert into forma_pagamento (id, descricao) values (1, 'Cartao de credito');
insert into forma_pagamento (id, descricao) values (2, 'Cartao de debito');
insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');
