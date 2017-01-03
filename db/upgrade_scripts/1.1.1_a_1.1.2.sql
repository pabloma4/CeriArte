CREATE TABLE caja
(
  id_caja serial NOT NULL,
  id_usuario integer NOT NULL,
  fecha_hora_apertura timestamp without time zone NOT NULL,
  fecha_hora_cierre timestamp without time zone,
  CONSTRAINT caja_pkey PRIMARY KEY (id_caja),
  CONSTRAINT caja_fk_1 FOREIGN KEY (id_usuario)
      REFERENCES usuario (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY IMMEDIATE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE caja OWNER TO postgres;


CREATE TABLE tipo_movimiento_caja
(
  id_tipo_movimiento_caja character varying(3) NOT NULL,
  nombre character varying(128) NOT NULL,
  descripcion character varying(256),
  CONSTRAINT tipo_movimiento_caja_pkey PRIMARY KEY (id_tipo_movimiento_caja)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tipo_movimiento_caja OWNER TO postgres;


CREATE TABLE medio_de_pago
(
  id_medio_de_pago serial NOT NULL,
  abreviatura character varying(3),
  descripcion character varying(256),
  habilitado boolean NOT NULL DEFAULT true,
  CONSTRAINT medio_de_pago_pkey PRIMARY KEY (id_medio_de_pago)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE medio_de_pago OWNER TO postgres;

CREATE TABLE movimiento_caja
(
  id_movimiento_caja serial NOT NULL,
  id_caja integer NOT NULL,
  id_usuario integer NOT NULL,
  id_tipo_movimiento_caja character varying(3) NOT NULL,
  fecha_hora timestamp without time zone NOT NULL,
  id_pedido integer,
  id_medio_de_pago integer,
  monto numeric(12,2) NOT NULL,
  CONSTRAINT movimiento_caja_pkey PRIMARY KEY (id_movimiento_caja),
  CONSTRAINT movimiento_caja_fk_1 FOREIGN KEY (id_caja)
      REFERENCES caja (id_caja) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY IMMEDIATE,
  CONSTRAINT movimiento_caja_fk_2 FOREIGN KEY (id_pedido)
      REFERENCES pedido (id_pedido) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY IMMEDIATE,
  CONSTRAINT movimiento_caja_fk_3 FOREIGN KEY (id_tipo_movimiento_caja)
      REFERENCES tipo_movimiento_caja (id_tipo_movimiento_caja) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY IMMEDIATE,
  CONSTRAINT movimiento_caja_fk_4 FOREIGN KEY (id_medio_de_pago)
      REFERENCES medio_de_pago (id_medio_de_pago) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION DEFERRABLE INITIALLY IMMEDIATE
)
WITH (
  OIDS=FALSE
);
ALTER TABLE movimiento_caja OWNER TO postgres;


CREATE INDEX idx_mov_caja_01_id_caja
  ON movimiento_caja
  USING btree
  (id_caja);

CREATE INDEX idx_mov_caja_02_id_pedido
  ON movimiento_caja
  USING btree
  (id_pedido);

CREATE INDEX idx_mov_caja_03_tipo_movmt
  ON movimiento_caja
  USING btree
  (id_tipo_movimiento_caja);

INSERT INTO tipo_movimiento_caja (id_tipo_movimiento_caja, nombre) values ('APE','Apertura de Caja');
INSERT INTO tipo_movimiento_caja (id_tipo_movimiento_caja, nombre) values ('CIE','Cierre de Caja');
INSERT INTO tipo_movimiento_caja (id_tipo_movimiento_caja, nombre) values ('ING','Ingreso de Dinero');
INSERT INTO tipo_movimiento_caja (id_tipo_movimiento_caja, nombre) values ('RET','Retiro de Dinero');
INSERT INTO tipo_movimiento_caja (id_tipo_movimiento_caja, nombre) values ('PAG','Pago de Cliente');
INSERT INTO tipo_movimiento_caja (id_tipo_movimiento_caja, nombre) values ('ANU','Anulación de Pago');


INSERT INTO MEDIO_DE_PAGO (id_medio_de_pago,abreviatura, descripcion,habilitado) values (1,'EFP', 'Contado Efectivo en Pesos', true);
INSERT INTO MEDIO_DE_PAGO (id_medio_de_pago,abreviatura, descripcion,habilitado) values (2,'EFD', 'Contado Efectivo en Dolares', false);
INSERT INTO MEDIO_DE_PAGO (id_medio_de_pago,abreviatura, descripcion,habilitado) values (3,'TC', 'Tarjeta de Crédito', false);
INSERT INTO MEDIO_DE_PAGO (id_medio_de_pago,abreviatura, descripcion,habilitado) values (4,'TD', 'Tarjeta de Débito', false);


INSERT INTO caja (id_caja, id_usuario, fecha_hora_apertura) values (1,2,current_timestamp);
INSERT INTO movimiento_caja (id_movimiento_caja, id_caja, id_usuario, id_tipo_movimiento_caja, fecha_hora, monto) values (1,1,2,'APE',current_timestamp,0);



