
CREATE SEQUENCE public.tb_local_pelada_id_local_pelada_seq;

CREATE TABLE public.TB_LOCAL_PELADA (
                ID_LOCAL_PELADA BIGINT NOT NULL DEFAULT nextval('public.tb_local_pelada_id_local_pelada_seq'),
                DESC_LOCAL VARCHAR NOT NULL,
                ENDERECO VARCHAR NOT NULL,
                EMAIL VARCHAR NOT NULL,
                TELEFONE VARCHAR NOT NULL,
                CONSTRAINT tb_local_pelada_pk PRIMARY KEY (ID_LOCAL_PELADA)
);


ALTER SEQUENCE public.tb_local_pelada_id_local_pelada_seq OWNED BY public.TB_LOCAL_PELADA.ID_LOCAL_PELADA;

CREATE SEQUENCE public.tb_telefone_id_telefone_seq;

CREATE TABLE public.TB_TELEFONE (
                ID_TELEFONE BIGINT NOT NULL DEFAULT nextval('public.tb_telefone_id_telefone_seq'),
                PRINCIPAL BOOLEAN NOT NULL,
                DESC_TELEFONE VARCHAR NOT NULL,
                CONSTRAINT tb_telefone_pk PRIMARY KEY (ID_TELEFONE)
);


ALTER SEQUENCE public.tb_telefone_id_telefone_seq OWNED BY public.TB_TELEFONE.ID_TELEFONE;

CREATE SEQUENCE public.tb_endereco_id_endereco_seq;

CREATE TABLE public.TB_ENDERECO (
                ID_ENDERECO BIGINT NOT NULL DEFAULT nextval('public.tb_endereco_id_endereco_seq'),
                PRINCIPAL BOOLEAN NOT NULL,
                DESC_ENDERECO VARCHAR NOT NULL,
                CEP VARCHAR NOT NULL,
                CONSTRAINT tb_endereco_pk PRIMARY KEY (ID_ENDERECO)
);


ALTER SEQUENCE public.tb_endereco_id_endereco_seq OWNED BY public.TB_ENDERECO.ID_ENDERECO;

CREATE SEQUENCE public.tb_plano_pagamento_id_plano_pagamento_seq;

CREATE TABLE public.TB_PLANO_PAGAMENTO (
                ID_PLANO_PAGAMENTO BIGINT NOT NULL DEFAULT nextval('public.tb_plano_pagamento_id_plano_pagamento_seq'),
                DESC_PLANO VARCHAR NOT NULL,
                VALOR_PLANO DOUBLE PRECISION NOT NULL,
                CONSTRAINT tb_plano_pagamento_pk PRIMARY KEY (ID_PLANO_PAGAMENTO)
);


ALTER SEQUENCE public.tb_plano_pagamento_id_plano_pagamento_seq OWNED BY public.TB_PLANO_PAGAMENTO.ID_PLANO_PAGAMENTO;

CREATE SEQUENCE public.tb_usuario_id_usuario_seq;

CREATE TABLE public.TB_USUARIO (
                ID_USUARIO BIGINT NOT NULL DEFAULT nextval('public.tb_usuario_id_usuario_seq'),
                ID_PLANO_PAGAMENTO BIGINT NOT NULL,
                NOME VARCHAR NOT NULL,
                CPF VARCHAR NOT NULL,
                APELIDO VARCHAR NOT NULL,
                EMAIL VARCHAR NOT NULL,
                CONSTRAINT tb_usuario_pk PRIMARY KEY (ID_USUARIO)
);


ALTER SEQUENCE public.tb_usuario_id_usuario_seq OWNED BY public.TB_USUARIO.ID_USUARIO;

CREATE TABLE public.TB_USUARIO_TELEFONE (
                ID_USUARIO BIGINT NOT NULL,
                ID_TELEFONE BIGINT NOT NULL
);


CREATE TABLE public.TB_USUARIO_ENDERECO (
                ID_USUARIO BIGINT NOT NULL,
                ID_ENDERECO BIGINT NOT NULL
);


CREATE SEQUENCE public.tb_pelada_id_pelada_seq;

CREATE TABLE public.TB_PELADA (
                ID_PELADA BIGINT NOT NULL DEFAULT nextval('public.tb_pelada_id_pelada_seq'),
                ID_LOCAL_PELADA BIGINT NOT NULL,
                DESC_PELADA VARCHAR NOT NULL,
                DATA DATE NOT NULL,
                VALOR DOUBLE PRECISION NOT NULL,
                HORA_FINAL TIME NOT NULL,
                HORA_INICIAL TIME NOT NULL,
                CONSTRAINT tb_pelada_pk PRIMARY KEY (ID_PELADA)
);


ALTER SEQUENCE public.tb_pelada_id_pelada_seq OWNED BY public.TB_PELADA.ID_PELADA;

CREATE TABLE public.TB_PELADA_USUARIO (
                ID_PELADA BIGINT NOT NULL,
                ID_USUARIO BIGINT NOT NULL,
                DONO_PELADA BOOLEAN NOT NULL
);


CREATE SEQUENCE public.tb_perfil_id_perfil_seq;

CREATE TABLE public.TB_PERFIL (
                ID_PERFIL BIGINT NOT NULL DEFAULT nextval('public.tb_perfil_id_perfil_seq'),
                DESC_PERFIL VARCHAR NOT NULL,
                CONSTRAINT tb_perfil_pk PRIMARY KEY (ID_PERFIL)
);


ALTER SEQUENCE public.tb_perfil_id_perfil_seq OWNED BY public.TB_PERFIL.ID_PERFIL;

CREATE SEQUENCE public.tb_menu_id_menu_seq;

CREATE TABLE public.TB_MENU (
                ID_MENU BIGINT NOT NULL DEFAULT nextval('public.tb_menu_id_menu_seq'),
                ID_PERFIL BIGINT NOT NULL,
                ID_MENU_1 BIGINT NOT NULL,
                DESC_MENU VARCHAR NOT NULL,
                LINK VARCHAR NOT NULL,
                ATIVO BOOLEAN NOT NULL,
                CONSTRAINT tb_menu_pk PRIMARY KEY (ID_MENU)
);


ALTER SEQUENCE public.tb_menu_id_menu_seq OWNED BY public.TB_MENU.ID_MENU;

CREATE SEQUENCE public.tb_login_id_login_seq;

CREATE TABLE public.TB_LOGIN (
                ID_LOGIN BIGINT NOT NULL DEFAULT nextval('public.tb_login_id_login_seq'),
                ID_USUARIO BIGINT NOT NULL,
                USUARIO VARCHAR NOT NULL,
                SENHA VARCHAR NOT NULL,
                CONSTRAINT tb_login_pk PRIMARY KEY (ID_LOGIN)
);


ALTER SEQUENCE public.tb_login_id_login_seq OWNED BY public.TB_LOGIN.ID_LOGIN;

CREATE TABLE public.TB_LOGIN_PERFIL (
                ID_PERFIL BIGINT NOT NULL,
                ID_LOGIN BIGINT NOT NULL
);


ALTER TABLE public.TB_PELADA ADD CONSTRAINT tb_local_pelada_tb_pelada_fk
FOREIGN KEY (ID_LOCAL_PELADA)
REFERENCES public.TB_LOCAL_PELADA (ID_LOCAL_PELADA)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_USUARIO_TELEFONE ADD CONSTRAINT tb_telefone_tb_usuario_telefone_fk
FOREIGN KEY (ID_TELEFONE)
REFERENCES public.TB_TELEFONE (ID_TELEFONE)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_USUARIO_ENDERECO ADD CONSTRAINT tb_endereco_tb_usuario_endereco_fk
FOREIGN KEY (ID_ENDERECO)
REFERENCES public.TB_ENDERECO (ID_ENDERECO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_USUARIO ADD CONSTRAINT tb_plano_pagamento_tb_usuario_fk
FOREIGN KEY (ID_PLANO_PAGAMENTO)
REFERENCES public.TB_PLANO_PAGAMENTO (ID_PLANO_PAGAMENTO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_LOGIN ADD CONSTRAINT tb_usuario_tb_login_fk
FOREIGN KEY (ID_USUARIO)
REFERENCES public.TB_USUARIO (ID_USUARIO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_USUARIO_ENDERECO ADD CONSTRAINT tb_usuario_tb_usuario_endereco_fk
FOREIGN KEY (ID_USUARIO)
REFERENCES public.TB_USUARIO (ID_USUARIO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_PELADA_USUARIO ADD CONSTRAINT tb_usuario_tb_pelada_usuario_fk
FOREIGN KEY (ID_USUARIO)
REFERENCES public.TB_USUARIO (ID_USUARIO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_USUARIO_TELEFONE ADD CONSTRAINT tb_usuario_tb_usuario_telefone_fk
FOREIGN KEY (ID_USUARIO)
REFERENCES public.TB_USUARIO (ID_USUARIO)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_PELADA_USUARIO ADD CONSTRAINT tb_pelada_tb_pelada_usuario_fk
FOREIGN KEY (ID_PELADA)
REFERENCES public.TB_PELADA (ID_PELADA)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_LOGIN_PERFIL ADD CONSTRAINT tb_perfil_tb_login_perfil_fk
FOREIGN KEY (ID_PERFIL)
REFERENCES public.TB_PERFIL (ID_PERFIL)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_MENU ADD CONSTRAINT tb_perfil_tb_menu_fk
FOREIGN KEY (ID_PERFIL)
REFERENCES public.TB_PERFIL (ID_PERFIL)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_MENU ADD CONSTRAINT tb_menu_tb_menu_fk
FOREIGN KEY (ID_MENU_1)
REFERENCES public.TB_MENU (ID_MENU)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.TB_LOGIN_PERFIL ADD CONSTRAINT tb_login_tb_login_perfil_fk
FOREIGN KEY (ID_LOGIN)
REFERENCES public.TB_LOGIN (ID_LOGIN)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;