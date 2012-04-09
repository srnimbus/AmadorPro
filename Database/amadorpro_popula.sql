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

insert into tb_submenu values (1, 1, 'Telefone', '/html/telefone.xhtml', true);
insert into tb_submenu values (2, 1, 'Endereco', '/html/endereco.xhtml', true);
insert into tb_submenu values (3, 2, 'Agenda', '/html/agenda.xhtml', true);
