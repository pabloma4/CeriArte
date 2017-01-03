ALTER TABLE usuario ADD COLUMN borrado boolean NOT NULL DEFAULT false;
ALTER TABLE permiso ADD COLUMN descripcion character varying(128) NOT NULL;


INSERT INTO permiso (id_permiso, nombre, descripcion) values (1, 'ADM_USUARIOS', 'Visualizar los Usuarios del Sistema para administrarlos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (2, 'NEW_USUARIO', 'Crear Usuarios');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (3, 'EDIT_USUARIO', 'Editar Usuarios');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (4, 'DELETE_USUARIO', 'Eliminar Usuarios');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (5, 'VIEW_ONLY_COMPANY_USUARIOS', 'Ver sólo los Usuarios pertenecientes a la empresa');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (6, 'VIEW_ALL_USUARIOS', 'Ver todos los usuarios del Sistema');

INSERT INTO permiso (id_permiso, nombre, descripcion) values (101, 'ADM_ROLES', 'Visualizar los Roles del Sistema para administrarlos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (102, 'NEW_ROL', 'Crear Roles');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (103, 'EDIT_ROL', 'Editar Roles');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (104, 'DELETE_ROL', 'Eliminar Roles');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (105, 'VIEW_ONLY_COMPANY_ROLES', 'Ver sólo los Roles que pueden ser administrados por una empresa');

INSERT INTO permiso (id_permiso, nombre, descripcion) values (201, 'ADM_CLIENTES', 'Visualizar los Clientes del Sistema para administrarlos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (202, 'NEW_CLIENTE', 'Crear Clientes');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (203, 'EDIT_CLIENTE', 'Editar Clientes');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (204, 'DELETE_CLIENTE', 'Eliminar Clientes');

INSERT INTO permiso (id_permiso, nombre, descripcion) values (301, 'ADM_PRESUPUESTOS', 'Visualizar los Presupuestos del Sistema para administrarlos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (302, 'NEW_PRESUPUESTO', 'Crear Presupuestos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (303, 'EDIT_PRESUPUESTO', 'Editar Presupuestos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (304, 'DELETE_PRESUPUESTO', 'Eliminar Presupuestos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (305, 'VIEW_ONLY_CREATED_ME_PRESUPUESTOS', 'Ver sólo Presupuestos creados por mi');

INSERT INTO permiso (id_permiso, nombre, descripcion) values (401, 'ADM_PEDIDOS', 'Visualizar los Pedidos del Sistema para administrarlos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (402, 'NEW_PEDIDO', 'Crear Pedidos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (403, 'EDIT_PEDIDO', 'Editar Pedidos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (404, 'DELETE_PEDIDO', 'Eliminar Pedidos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (405, 'VIEW_ONLY_CREATED_ME_PEDIDOS', 'Ver sólo Pedidos creados por mi');

INSERT INTO permiso (id_permiso, nombre, descripcion) values (501, 'ADM_ORDENES_TRABAJO', 'Visualizar las Ordenes de Trabajo del Sistema para administrarlos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (502, 'NEW_ORDEN_TRABAJO', 'Crear Ordenes de Trabajo');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (503, 'EDIT_ORDEN_TRABAJO', 'Editar Ordenes de Trabajo');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (504, 'DELETE_ORDEN_TRABAJO', 'Eliminar Ordenes de Trabajo');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (505, 'VIEW_ONLY_CREATED_ME_ORDENES_TRABAJO', 'Ver sólo Ordenes de Trabajo creadas por mi');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (506, 'VIEW_ONLY_ASSIGNED_ME_ORDENES_TRABAJO', 'Ver sólo Ordenes de Trabajo asignadas a mi');

INSERT INTO permiso (id_permiso, nombre, descripcion) values (601, 'ADM_PRODUCTOS', 'Visualizar los Productos del Sistema para administrarlos');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (602, 'NEW_PRODUCTO', 'Crear Producto');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (603, 'EDIT_PRODUCTO', 'Editar Producto');
INSERT INTO permiso (id_permiso, nombre, descripcion) values (604, 'DELETE_PRODUCTO', 'Eliminar Producto');

-- CREACION DE USUARIO SIERRA SOFT y ROL ADMINISTRADOR SIERRA SOFT
INSERT INTO rol (id_rol, nombre, descripcion) values (1, 'ADMINISTRADOR SIERRA SOFT', 'Administrador General de la Aplicación. Posee permisos para todos los módulos.');
INSERT INTO usuario (id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login, borrado) 
	values(1,'ssoft', 'b2b16b5a8fe5832c2d9ec8d11e523260', '','Administrador Sierra Soft', 'pabloma4@gmail.com', false,0,false);
INSERT INTO usuario_rol values(1,1);

INSERT INTO permiso_rol values (1,1);
INSERT INTO permiso_rol values (1,2);
INSERT INTO permiso_rol values (1,3);
INSERT INTO permiso_rol values (1,4);
INSERT INTO permiso_rol values (1,6);
INSERT INTO permiso_rol values (1,101);
INSERT INTO permiso_rol values (1,102);
INSERT INTO permiso_rol values (1,103);
INSERT INTO permiso_rol values (1,104);
INSERT INTO permiso_rol values (1,201);
INSERT INTO permiso_rol values (1,202);
INSERT INTO permiso_rol values (1,203);
INSERT INTO permiso_rol values (1,204);
INSERT INTO permiso_rol values (1,301);
INSERT INTO permiso_rol values (1,302);
INSERT INTO permiso_rol values (1,303);
INSERT INTO permiso_rol values (1,304);
INSERT INTO permiso_rol values (1,401);
INSERT INTO permiso_rol values (1,402);
INSERT INTO permiso_rol values (1,403);
INSERT INTO permiso_rol values (1,404);
INSERT INTO permiso_rol values (1,501);
INSERT INTO permiso_rol values (1,502);
INSERT INTO permiso_rol values (1,503);
INSERT INTO permiso_rol values (1,504);
INSERT INTO permiso_rol values (1,601);
INSERT INTO permiso_rol values (1,602);
INSERT INTO permiso_rol values (1,603);
INSERT INTO permiso_rol values (1,604);

-- CREACION DE USUARIO CERIARTE y ROL ADMINISTRADOR CERIARTE
INSERT INTO rol (id_rol, nombre, descripcion) values (2, 'ADMINISTRADOR CERIARTE', 'Administrador de la Empresa Ceriarte. Posee permisos para todos los módulos.');

INSERT INTO usuario (id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login, borrado) values(2,'admin', 'b2b16b5a8fe5832c2d9ec8d11e523260', '','Administrador Ceriarte', 'gcerino@ceriarte.com', false,0,false);
INSERT INTO usuario_rol values(2,2);

INSERT INTO permiso_rol values (2,1);
INSERT INTO permiso_rol values (2,2);
INSERT INTO permiso_rol values (2,3);
INSERT INTO permiso_rol values (2,4);
INSERT INTO permiso_rol values (2,5);
INSERT INTO permiso_rol values (2,201);
INSERT INTO permiso_rol values (2,202);
INSERT INTO permiso_rol values (2,203);
INSERT INTO permiso_rol values (2,204);
INSERT INTO permiso_rol values (2,301);
INSERT INTO permiso_rol values (2,302);
INSERT INTO permiso_rol values (2,303);
INSERT INTO permiso_rol values (2,304);
INSERT INTO permiso_rol values (2,401);
INSERT INTO permiso_rol values (2,402);
INSERT INTO permiso_rol values (2,403);
INSERT INTO permiso_rol values (2,404);
INSERT INTO permiso_rol values (2,501);
INSERT INTO permiso_rol values (2,502);
INSERT INTO permiso_rol values (2,503);
INSERT INTO permiso_rol values (2,504);
INSERT INTO permiso_rol values (2,601);
INSERT INTO permiso_rol values (2,602);
INSERT INTO permiso_rol values (2,603);
INSERT INTO permiso_rol values (2,604);	


ALTER TABLE producto ADD COLUMN elaborado boolean NOT NULL DEFAULT false;
ALTER TABLE producto ADD COLUMN stock integer;
ALTER TABLE producto ADD COLUMN stock_minimo integer;

-- Table: orden_trabajo_estado

-- DROP TABLE orden_trabajo_estado;

CREATE TABLE orden_trabajo_estado
(
  id_orden_trabajo_estado serial NOT NULL,
  nombre character varying(128) NOT NULL,
  descripcion character varying(256),
  CONSTRAINT orden_trabajo_estado_pkey PRIMARY KEY (id_orden_trabajo_estado )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orden_trabajo_estado
  OWNER TO postgres;

  
-- Table: orden_trabajo

-- DROP TABLE orden_trabajo;

CREATE TABLE orden_trabajo
(
  id_orden_trabajo serial NOT NULL,
  id_usuario_creacion integer NOT NULL,
  id_usuario_asignacion integer,
  id_orden_trabajo_estado integer NOT NULL,
  fecha_creacion date NOT NULL,
  fecha_modificacion date,
  borrado boolean NOT NULL DEFAULT false,
  id_detalle_pedido integer NOT NULL,
  CONSTRAINT orden_trabajo_pkey PRIMARY KEY (id_orden_trabajo ),
  CONSTRAINT orden_trabajo_fk_1 FOREIGN KEY (id_usuario_creacion)
      REFERENCES usuario (id_usuario) 
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT orden_trabajo_fk_2 FOREIGN KEY (id_usuario_asignacion)
      REFERENCES usuario (id_usuario)
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT orden_trabajo_fk_3 FOREIGN KEY (id_orden_trabajo_estado)
      REFERENCES orden_trabajo_estado (id_orden_trabajo_estado)
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT orden_trabajo_fk_4 FOREIGN KEY (id_detalle_pedido)
      REFERENCES detalle_pedido (id_detalle_pedido) 
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orden_trabajo
  OWNER TO postgres;

-- Table: detalle_orden_trabajo

-- DROP TABLE detalle_orden_trabajo;

CREATE TABLE detalle_orden_trabajo
(
  id_detalle_orden_trabajo serial NOT NULL,
  id_producto integer NOT NULL,
  cantidad double precision NOT NULL DEFAULT 1,
  id_orden_trabajo integer NOT NULL,
  CONSTRAINT detalle_orden_trabajo_pk PRIMARY KEY (id_detalle_orden_trabajo),
  CONSTRAINT detalle_orden_trabajo_fk_1 FOREIGN KEY (id_producto)
      REFERENCES producto (id_producto)
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT detalle_orden_trabajo_fk_2 FOREIGN KEY (id_orden_trabajo)
      REFERENCES orden_trabajo (id_orden_trabajo)
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE detalle_orden_trabajo
  OWNER TO postgres;
  
  
insert into orden_trabajo_estado (id_orden_trabajo_estado, nombre) values (1,'NUEVA');
insert into orden_trabajo_estado (id_orden_trabajo_estado, nombre) values (2,'EN CONSTRUCCIÓN');
insert into orden_trabajo_estado (id_orden_trabajo_estado, nombre) values (3,'FINALIZADA');
insert into orden_trabajo_estado (id_orden_trabajo_estado, nombre) values (4,'SUSPENDIDA');
insert into orden_trabajo_estado (id_orden_trabajo_estado, nombre) values (5,'CANCELADA');

CREATE TABLE detalle_pedido_estado
(
  id_detalle_pedido_estado serial NOT NULL,
  nombre character varying(128) NOT NULL,
  descripcion character varying(256),
  CONSTRAINT detalle_pedido_estado_pkey PRIMARY KEY (id_detalle_pedido_estado )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE detalle_pedido_estado
  OWNER TO postgres;

  
insert into detalle_pedido_estado (id_detalle_pedido_estado, nombre) values (1,'PENDIENTE ELABORACIÓN');
insert into detalle_pedido_estado (id_detalle_pedido_estado, nombre) values (2,'PENDIENTE ENTREGA');
insert into detalle_pedido_estado (id_detalle_pedido_estado, nombre) values (3,'EN CONSTRUCCIÓN');
insert into detalle_pedido_estado (id_detalle_pedido_estado, nombre) values (4,'ENTREGADO');
insert into detalle_pedido_estado (id_detalle_pedido_estado, nombre) values (5,'CANCELADO');
insert into detalle_pedido_estado (id_detalle_pedido_estado, nombre) values (6,'SUSPENDIDO');

ALTER TABLE detalle_pedido ADD COLUMN id_detalle_pedido_estado integer NOT NULL default 1;
ALTER TABLE detalle_pedido ADD CONSTRAINT detalle_pedido_fk_3 FOREIGN KEY (id_detalle_pedido_estado)
      REFERENCES detalle_pedido_estado (id_detalle_pedido_estado)
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE pedido DROP COLUMN id_pedido_estado;

ALTER TABLE producto ALTER COLUMN stock TYPE double precision;
ALTER TABLE producto ALTER COLUMN stock_minimo TYPE double precision;

ALTER TABLE orden_trabajo ADD COLUMN fecha_estimada_fin date;