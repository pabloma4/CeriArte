CREATE TABLE pedido_estado
(
  id_pedido_estado serial NOT NULL,
  nombre character varying(128) NOT NULL,
  descripcion character varying(256),
  CONSTRAINT pedido_estado_pkey PRIMARY KEY (id_pedido_estado)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pedido_estado OWNER TO postgres;

CREATE TABLE pedido
(
  id_pedido serial NOT NULL,
  id_cliente integer NOT NULL,
  id_pedido_estado integer NOT NULL,
  fecha_creacion date NOT NULL,
  fecha_modificacion date,
  borrado boolean NOT NULL DEFAULT false,
  id_presupuesto integer,
  CONSTRAINT pedido_pkey PRIMARY KEY (id_pedido),
  CONSTRAINT presupuesto_fk_1 FOREIGN KEY (id_cliente)
      REFERENCES cliente (id_cliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT presupuesto_fk_2 FOREIGN KEY (id_pedido_estado)
      REFERENCES pedido_estado (id_pedido_estado) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT presupuesto_fk_3 FOREIGN KEY (id_presupuesto)
      REFERENCES presupuesto (id_presupuesto) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE pedido OWNER TO postgres;


insert into pedido_estado (id_pedido_estado, nombre) values (1,'CREADO');
insert into pedido_estado (id_pedido_estado, nombre) values (2,'ENTREGADO');
insert into pedido_estado (id_pedido_estado, nombre) values (3,'CANCELADO');


CREATE TABLE detalle_pedido
(
  id_detalle_pedido serial NOT NULL,
  id_producto integer NOT NULL,
  cantidad double precision NOT NULL DEFAULT 1,
  precio_unitario double precision NOT NULL,
  id_pedido integer NOT NULL,
  nombre character varying(128) NOT NULL,
  descripcion character varying(1000) NOT NULL,
  CONSTRAINT detalle_pedido_pk PRIMARY KEY (id_detalle_pedido),
  CONSTRAINT detalle_pedido_fk_1 FOREIGN KEY (id_producto)
      REFERENCES producto (id_producto) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT detalle_pedido_fk_2 FOREIGN KEY (id_pedido)
      REFERENCES pedido (id_pedido) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE detalle_pedido OWNER TO postgres;
