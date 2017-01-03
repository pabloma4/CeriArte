-- ######################################################################################################################################################
-- #############              Este archivo, contiene los datos iniciales requeridos para poder correr los scripts de migracion              #############
-- ######################################################################################################################################################
\encoding 'UTF8'

\echo  'Se agregan los datos de los paises';

-- inserto datos de paises
INSERT INTO pais (id_pais, nombre) VALUES ('   ', '');
INSERT INTO pais (id_pais, nombre) VALUES ('ARG', 'Argentina');
INSERT INTO pais (id_pais, nombre) VALUES ('CHL', 'Chile');
INSERT INTO pais (id_pais, nombre) VALUES ('URY', 'Uruguay');
INSERT INTO pais (id_pais, nombre) VALUES ('BOL', 'Bolivia');
INSERT INTO pais (id_pais, nombre) VALUES ('BRA', 'Brasil');
INSERT INTO pais (id_pais, nombre) VALUES ('PRY', 'Paraguay');
INSERT INTO pais (id_pais, nombre) VALUES ('PER', 'Peru');

\echo  'Se agregan los datos de provincias de Argentina';

-- Data for provincia
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('XXX', 'no definida', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('BAC', 'Ciudad Autónoma de Buenos Aires', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('BA', 'Buenos Aires', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('CAT', 'Catamarca', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('CHO', 'Chaco', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('CHT', 'Chubut', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('CBA', 'Córdoba', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('COR', 'Corrientes', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('ER', 'Entre Ríos', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('FSA', 'Formosa', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('JUJ', 'Jujuy', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('LP', 'La Pampa', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('LR', 'La Rioja', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('MZA', 'Mendoza', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('MIS', 'Misiones', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('NEU', 'Neuquén', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('RN', 'Río Negro', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('SAL', 'Salta', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('SJ', 'San Juan', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('SL', 'San Luis', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('SC', 'Santa Cruz', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('SF', 'Santa Fe', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('SE', 'Santiago del Estero', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('TF', 'Tierra del Fuego', 'ARG');
INSERT INTO provincia (id_provincia, nombre, id_pais) VALUES ('TUC', 'Tucumán', 'ARG');

\echo  'Se agregan los datos de los tipos de terminal';
-- terminal tipo : agregamos los valores que obtuvimos de una clase Java : PuntoDeVenta.java (CONFIRMAR !!!!!)
INSERT INTO terminal_tipo (id_terminal_tipo , nombre , descripcion) VALUES ( 0 , 'Diferido' , 'Tipo de Terminal : Diferido - confirmar ' );
INSERT INTO terminal_tipo (id_terminal_tipo , nombre , descripcion) VALUES ( 1 , 'On-Line' , 'Tipo de Terminal : On-Line - confirmar ' );
INSERT INTO terminal_tipo (id_terminal_tipo , nombre , descripcion) VALUES ( 2 , 'On-Line/Diferido' , 'Tipo de Terminal : On-Line/Diferido - confirmar ' );
SELECT setval('public.terminal_tipo_id_terminal_tipo_seq', (SELECT MAX(id_terminal_tipo) FROM terminal_tipo), true);

\echo  'Se agregan registro de imagen [sin imagen]';
-- imagen
INSERT INTO imagen(id_imagen, descripcion, nombre_archivo ,url) VALUES (-1, 'Imagen no asignada', '', '');
INSERT INTO imagen(id_imagen, descripcion, nombre_archivo ,url) VALUES (1, 'Imagen por defecto', 'autoentrada.jpg', '/images/autoentrada.jpg');
SELECT setval('public.imagen_id_imagen_seq', (SELECT MAX(id_imagen) FROM imagen), true);

\echo  'Se agregan registro de productor [productor no asignado]';
-- productor (tabla para inicializar)
INSERT INTO productor( id_productor, nombre, razon_social, cuit, nps_merchant_id, nps_hashcode)
    VALUES           (-1           , 'Productor No Asignado', 'Productor No Asignado', NULL, NULL, NULL);
INSERT INTO productor( id_productor, nombre, razon_social, cuit, nps_merchant_id, nps_hashcode)
    VALUES           ( 1 , 'Autoentrada', 'AUTOENTRADA SA', '30710354622', 'autoentrada2', 'Zt7xMcRnNOVg8ov58BnNXxLvRejVqwLNnTKA5mvQ8Q4EC0JKB4hj01cRfJuTDGq1');
SELECT setval('public.productor_id_productor_seq', (SELECT MAX(id_productor) FROM productor), true);

\echo  'Se agregan datos de los estados de los tickets';
-- estados tickets
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('dis', 'Disponible', 'Disponible.[EsT_Id = 1 - EsT_Referencia = ''dis''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('ven', 'Vendido', 'Vendido.[EsT_Id = 2 - EsT_Referencia = ''ven''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('res', 'Reservado', 'Reservado.[EsT_Id = 3 - EsT_Referencia = ''res''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('blq', 'Bloqueado', 'Bloqueado.[EsT_Id = 4 - EsT_Referencia = ''blo''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('pvt', 'En Proceso de Venta', 'EnProcesoDeVta.[EsT_Id = 5 - EsT_Referencia = ''pvta''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('pre', 'Preventa', 'Preventa.[EsT_Id = 6 - EsT_Referencia = ''pre''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('inv', 'Invitación', 'Invitacion.[EsT_Id = 7 - EsT_Referencia = ''inv''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('ele', 'Venta Electrónica', 'Venta Electronica no ent.[EsT_Id = 8 - EsT_Referencia = ''elect''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('ent', 'Entregado', 'Ticket Entregado (V. E.).[EsT_Id = 9 - EsT_Referencia = ''entre''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('pim', 'Imprimiendo', 'EnProcesoDeVtaImprimiendo.[EsT_Id = 10 - EsT_Referencia = ''impr''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('caj', 'Actualizando Caja', 'ActualizandoCaja.[EsT_Id = 11 - EsT_Referencia = ''actcaj''].' );
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('ped', 'Pedido', 'Pedido.[EsT_Id = 12 - EsT_Referencia = ''ped''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('pei', 'Pedido Impreso', 'PedidoImpreso.[EsT_Id = 13 - EsT_Referencia = ''pedimp''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('pec', 'Pedido Confirmado', 'PedidoConfirmado.[EsT_Id = 14 - EsT_Referencia = ''pedcon''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('rin', 'Reserva Internet', 'ReservaInternet.[EsT_Id = 15 - EsT_Referencia = ''rsi''].');
INSERT INTO ticket_estado (id_ticket_estado, nombre, descripcion) VALUES ('ret', 'Reservado (retiro)', 'Reservado (retiro).[EsT_Id = 16 - EsT_Referencia = ''ret''].');

-- estados tickets del svt (svt_ticket_estado)
\echo  'Se agregan datos de los estados de los tickets [equivalencia con los estados de los tickets en el SVT]';
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('dis', 1);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('ven', 2);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('res', 3);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('blq', 4);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('pvt', 5);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('pre', 6);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('inv', 7);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('ele', 8);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('ent', 9);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('pim',10);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('caj',11);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('ped',12);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('pei',13);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('pec',14);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('rin',15);
INSERT INTO svt_ticket_estado ( id_ticket_estado , est_id ) VALUES ('ret',16);


\echo  'Se agregan datos de color [color no asignado]';

-- color
INSERT INTO color ( id_color , nombre               , codigo_html )
VALUES            ( -1       , 'Sin color asignado' , ''          );

\echo  'Se agregan datos de tipo de documentos de identidad';

-- Data for tipo_doc_identidad
INSERT INTO tipo_doc_identidad (id_tipo_doc_identidad, nombre, descripcion) VALUES ('DNI', 'Documento Nacional de Identidad', '');
INSERT INTO tipo_doc_identidad (id_tipo_doc_identidad, nombre, descripcion) VALUES ('CI', 'Cédula de Identidad', '');
INSERT INTO tipo_doc_identidad (id_tipo_doc_identidad, nombre, descripcion) VALUES ('LC', 'Libreta Cívica', '' );
INSERT INTO tipo_doc_identidad (id_tipo_doc_identidad, nombre, descripcion) VALUES ('LE', 'Libreta de Enrolamiento', '');
INSERT INTO tipo_doc_identidad (id_tipo_doc_identidad, nombre, descripcion) VALUES ('PAS', 'Pasaporte', '');
INSERT INTO tipo_doc_identidad (id_tipo_doc_identidad, nombre, descripcion) VALUES ('MGN', 'Cliente Portal Web','');

\echo  'Se agregan datos de tipo de valor';

-- Tipos de valor
DELETE FROM tipo_valor;
INSERT INTO tipo_valor (id_tipo_valor, nombre) VALUES (1, 'Monto');
INSERT INTO tipo_valor (id_tipo_valor, nombre) VALUES (2, 'Porcentaje');
INSERT INTO tipo_valor (id_tipo_valor, nombre) VALUES (3, 'Monto Fijo');
SELECT setval('public.tipo_valor_id_tipo_valor_seq', (SELECT MAX(id_tipo_valor) FROM tipo_valor) , true);


\echo  'Se agregan datos de los estados de los tickets pedidos';

-- Estados de un ticket de un pedido
INSERT INTO ticket_pedido_estado (id_ticket_pedido_estado, nombre, descripcion) VALUES ('PED', 'Pedido', NULL);
INSERT INTO ticket_pedido_estado (id_ticket_pedido_estado, nombre, descripcion) VALUES ('IMP', 'Impreso', NULL);
INSERT INTO ticket_pedido_estado (id_ticket_pedido_estado, nombre, descripcion) VALUES ('VEN', 'Vendido', NULL);
INSERT INTO ticket_pedido_estado (id_ticket_pedido_estado, nombre, descripcion) VALUES ('DEV', 'Devuelto', NULL);
INSERT INTO ticket_pedido_estado (id_ticket_pedido_estado, nombre, descripcion) VALUES ('CAN', 'Pedido Cancelado', NULL);

\echo  'Se agregan datos de los estados de los pedidos';
-- Estados de un pedido
INSERT INTO pedido_estado (id_pedido_estado, nombre, descripcion) VALUES ('PED', 'Pedido', NULL);
INSERT INTO pedido_estado (id_pedido_estado, nombre, descripcion) VALUES ('IMP', 'Impreso', NULL);
INSERT INTO pedido_estado (id_pedido_estado, nombre, descripcion) VALUES ('CNF', 'Confirmado', NULL);
INSERT INTO pedido_estado (id_pedido_estado, nombre, descripcion) VALUES ('CAN', 'Cancelado', NULL);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --
\echo  'Se agregan datos de los tipos de movimientos de caja';

-- Tipos de movimiento de caja
INSERT INTO tipo_movimiento_caja     ( id_tipo_movimiento_caja , nombre , descripcion ) VALUES ( 'APE' , 'Apertura Caja' , 'Apertura de una caja' );
INSERT INTO tipo_movimiento_caja     ( id_tipo_movimiento_caja , nombre , descripcion ) VALUES ( 'CIE' , 'Cierre Caja' , 'Cierre de una caja' );
INSERT INTO tipo_movimiento_caja     ( id_tipo_movimiento_caja , nombre , descripcion ) VALUES ( 'VTA' , 'Venta Ticket' , 'Venta de Ticket(s)' );
INSERT INTO tipo_movimiento_caja     ( id_tipo_movimiento_caja , nombre , descripcion ) VALUES ( 'RET' , 'Retiro Dinero Caja' , 'Retiro Dinero Caja' );
INSERT INTO tipo_movimiento_caja     ( id_tipo_movimiento_caja , nombre , descripcion ) VALUES ( 'ING' , 'Ingreso Dinero Caja' , 'Ingreso Dinero Caja' );
INSERT INTO tipo_movimiento_caja     ( id_tipo_movimiento_caja , nombre , descripcion ) VALUES ( 'ANU' , 'Anulacion' , 'Anulacion' );
INSERT INTO tipo_movimiento_caja     ( id_tipo_movimiento_caja , nombre , descripcion ) VALUES ( 'ACC' , 'Anulacion Generica' , 'Anulacion Generica' );
INSERT INTO tipo_movimiento_caja     ( id_tipo_movimiento_caja , nombre , descripcion ) VALUES ( 'VEE' , 'Venta Ticket Electronico' , 'Venta Ticket(s) Electronico(s)' );

-- Tipos de movimiento de caja (equivalencia con el SVT)
INSERT INTO svt_tipo_movimiento_caja ( id_tipo_movimiento_caja , tmc_id ) VALUES ( 'APE' , 1 );
INSERT INTO svt_tipo_movimiento_caja ( id_tipo_movimiento_caja , tmc_id ) VALUES ( 'CIE' , 2 );
INSERT INTO svt_tipo_movimiento_caja ( id_tipo_movimiento_caja , tmc_id ) VALUES ( 'VTA' , 3 );
INSERT INTO svt_tipo_movimiento_caja ( id_tipo_movimiento_caja , tmc_id ) VALUES ( 'RET' , 4 );
INSERT INTO svt_tipo_movimiento_caja ( id_tipo_movimiento_caja , tmc_id ) VALUES ( 'ING' , 5 );
INSERT INTO svt_tipo_movimiento_caja ( id_tipo_movimiento_caja , tmc_id ) VALUES ( 'ANU' , 6 );
INSERT INTO svt_tipo_movimiento_caja ( id_tipo_movimiento_caja , tmc_id ) VALUES ( 'ACC' , 7 );
INSERT INTO svt_tipo_movimiento_caja ( id_tipo_movimiento_caja , tmc_id ) VALUES ( 'VEE' , 8 );

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de los estados de las reservas';

-- Estados de las reservas
INSERT INTO reserva_estado ( id_reserva_estado , nombre , descripcion ) VALUES ('sol','Solicitada','La ha sido solicitada, pero no ha sido confirmada.');
INSERT INTO reserva_estado ( id_reserva_estado , nombre , descripcion ) VALUES ('con','Confirmada','La reserva ha sido confirmada.');
INSERT INTO reserva_estado ( id_reserva_estado , nombre , descripcion ) VALUES ('imp','Impresa','La reserva ha sido impresa.');
INSERT INTO reserva_estado ( id_reserva_estado , nombre , descripcion ) VALUES ('anu','Anulada','La reserva ha sido anulada.');
INSERT INTO reserva_estado ( id_reserva_estado , nombre , descripcion ) VALUES ('fin','Finalizada','La reserva ha finalizado, se registró la venta para esa reserva.');

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de los estados de los clientes';

-- Estados de los clientes
INSERT INTO cliente_estado(id_cliente_estado, nombre, descripcion) VALUES ('act', 'activo', 'Cliente activo.');
INSERT INTO cliente_estado(id_cliente_estado, nombre, descripcion) VALUES ('ina', 'inactivo', 'Cliente inactivo.');

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de tipo de envio [Retiro en Boleteria]';

-- Tipo de envio ( Retiro en Boleteria )
INSERT INTO tipo_de_envio (id_tipo_de_envio, nombre, costo) values ( 1, 'Retiro en Boleteria'         , 0.0) ;
INSERT INTO tipo_de_envio (id_tipo_de_envio, nombre, costo) values ( 2, 'Retiro en Punto de Venta'    , 0.0) ;
INSERT INTO tipo_de_envio (id_tipo_de_envio, nombre, costo) values ( 3, 'Envio a domicilio'           , 0.0) ;
INSERT INTO tipo_de_envio (id_tipo_de_envio, nombre, costo) values (51, 'Radio La Red - La Rioja'     , 0.0) ;
INSERT INTO tipo_de_envio (id_tipo_de_envio, nombre, costo) values (52, 'Retiro en Comodoro y Caleta' , 0.0) ;
INSERT INTO tipo_de_envio (id_tipo_de_envio, nombre, costo) values (53, 'Retiro en San Luis'          , 0.0) ;
-- SELECT setval('public.tipo_de_envio_id_tipo_de_envio_seq', (SELECT MAX(id_tipo_de_envio) FROM tipo_de_envio) , true);
SELECT setval('public.tipo_de_envio_id_tipo_de_envio_seq', 100 , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --
--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de tipo de operacion [venta o anulacion]';

-- Tipos de operacion [Venta (1)  o Anulación (2) )
INSERT INTO tipo_operacion (id_tipo_operacion, abreviatura , descripcion ) values (1, 'V' , 'Venta' ) ;
INSERT INTO tipo_operacion (id_tipo_operacion, abreviatura , descripcion ) values (2, 'A' , 'Anulación' ) ;
SELECT setval('public.tipo_operacion_id_tipo_operacion_seq', (SELECT MAX(id_tipo_operacion) FROM tipo_operacion) , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de Unidades de Aplicacion (de los descuentos y los recargos)';

-- Unidades de Aplicacion (De los descuentos y los recargos)
INSERT INTO unidad_aplicacion (
                                id_unidad_aplicacion ,  -- character varying(3) NOT NULL,
                                nombre               ,  -- character varying(128) NOT NULL,
                                descripcion             -- character varying(256)
                              )
                       VALUES ( 'TCK', 'Ticket', 'La unidad de aplicación es un ticket.');


INSERT INTO unidad_aplicacion (
                                id_unidad_aplicacion ,  -- character varying(3) NOT NULL,
                                nombre               ,  -- character varying(128) NOT NULL,
                                descripcion             -- character varying(256)
                              )
                       VALUES ( 'VTA', 'Venta', 'La unidad de aplicación es una venta completa.');

INSERT INTO unidad_aplicacion (
                                id_unidad_aplicacion ,  -- character varying(3) NOT NULL,
                                nombre               ,  -- character varying(128) NOT NULL,
                                descripcion             -- character varying(256)
                              )
                       VALUES ( 'PLN','Plan de Pago','La unidad de aplicación es un plan de pago');

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de descuento o recargo [invitacion]';

-- Descuentos y/o recargos
INSERT INTO descuento_recargo (id_descuento_recargo , nombre       , descripcion  , id_tipo_valor, valor   , id_unidad_aplicacion , requiere_cupon , cupon_precargado)
VALUES                        ( 1                   , 'INVITACION' , 'INVITACION' , 2            , 100.00  ,             'TCK'    , false          , false           ) ;

INSERT INTO descuento_recargo (id_descuento_recargo , nombre            , descripcion                  , id_tipo_valor, valor   , id_unidad_aplicacion , requiere_cupon , cupon_precargado)
VALUES                        ( 2                   , 'Envio de Ticket' , 'Envio de Ticket por Correo' , 1            , 0.00    ,                'VTA' , false          , false           ) ;

SELECT setval('public.descuento_recargo_id_descuento_recargo_seq', (SELECT MAX(id_descuento_recargo) FROM descuento_recargo) , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de moneda';

-- Monedas
INSERT INTO moneda (id_moneda , nombre  , descripcion , simbolo , cotizacion , es_default , nps_codigo_moneda , habilitada )
VALUES             ( 1        , 'PESOS' , 'PESOS'     , '$'     , 1.0        , true       , 'ARS'             , true       ) ;

INSERT INTO moneda (id_moneda , nombre  , descripcion , simbolo , cotizacion , es_default , nps_codigo_moneda , habilitada )
VALUES             ( 2        , 'DOLARES' , 'DOLARES ESTADOUNIDENSES'     , 'U$S'     , 8.01        , false      , 'USD'             , false       ) ;

SELECT setval('public.moneda_id_moneda_seq', (SELECT MAX(id_moneda) FROM moneda) , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de tipo de tarjeta';

-- Tipos de Tarjeta (Crédito y Débito)
INSERT INTO tipo_tarjeta (id_tipo_tarjeta, nombre, descripcion , habilitado) values ('CRD' , 'Tarj.Crédito', 'Tarjeta de Crédito' , true ) ;
INSERT INTO tipo_tarjeta (id_tipo_tarjeta, nombre, descripcion , habilitado) values ('DEB' , 'Tarj.Débito' , 'Tarjeta de Débito'  , true ) ;

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de tipo de medio de pago';

-- Tipos de Medios de Pago ( Efectivo, Tarjetas, Cupones , etc. )
INSERT INTO tipo_medio_de_pago (
                                  id_tipo_medio_de_pago  , -- serial NOT NULL,
                                  nombre                 , --character varying(128) NOT NULL,
                                  abreviatura            , -- character varying(3) NOT NULL,
                                  descripcion            , -- character varying(256),
                                  tiene_id               , -- boolean NOT NULL DEFAULT false,
                                  tiene_vencimiento      , -- boolean NOT NULL DEFAULT false,
                                  habilitado               -- boolean NOT NULL DEFAULT true,
                               )
                    values     ( -1 , 'Para Migracion', 'MIG' , 'Para Migracion' , false , false , false  ) ;

INSERT INTO tipo_medio_de_pago (
                                  id_tipo_medio_de_pago  , -- serial NOT NULL,
                                  nombre                 , --character varying(128) NOT NULL,
                                  abreviatura            , -- character varying(3) NOT NULL,
                                  descripcion            , -- character varying(256),
                                  tiene_id               , -- boolean NOT NULL DEFAULT false,
                                  tiene_vencimiento      , -- boolean NOT NULL DEFAULT false,
                                  habilitado               -- boolean NOT NULL DEFAULT true,
                               )
                    values     ( 1 , 'Efectivo', 'EFE' , 'Efectivo' , false , false , true  ) ;

INSERT INTO tipo_medio_de_pago (
                                  id_tipo_medio_de_pago  , -- serial NOT NULL,
                                  nombre                 , --character varying(128) NOT NULL,
                                  abreviatura            , -- character varying(3) NOT NULL,
                                  descripcion            , -- character varying(256),
                                  tiene_id               , -- boolean NOT NULL DEFAULT false,
                                  tiene_vencimiento      , -- boolean NOT NULL DEFAULT false,
                                  habilitado               -- boolean NOT NULL DEFAULT true,
                               )
                    values     ( 2 , 'Tarjetas', 'TAR' , 'Tarjetas' , true , true , true  ) ;

INSERT INTO tipo_medio_de_pago (
                                  id_tipo_medio_de_pago  , -- serial NOT NULL,
                                  nombre                 , --character varying(128) NOT NULL,
                                  abreviatura            , -- character varying(3) NOT NULL,
                                  descripcion            , -- character varying(256),
                                  tiene_id               , -- boolean NOT NULL DEFAULT false,
                                  tiene_vencimiento      , -- boolean NOT NULL DEFAULT false,
                                  habilitado               -- boolean NOT NULL DEFAULT true,
                               )
                    values     ( 3 , 'Cupón de Descuento', 'CDT' , 'Cupón de Descuento' , true , true , true  ) ;

SELECT setval('public.tipo_medio_de_pago_id_tipo_medio_de_pago_seq', (SELECT MAX(id_tipo_medio_de_pago) FROM tipo_medio_de_pago) , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de tarjetas (de crédito y débito)';

-- Datos de tarjetas (de crédito y débito)
INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      1 ,
                      'Tarjeta Naranja' ,
                      'TN' ,
                      'CRD' ,
                      -1 ,
                      1 ,
                      'Tarjeta Naranja - Inf.Adic.' ,
                      true
                     );

INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      2 ,
                      'Tarjeta Naranja - PLAN Z' ,
                      'TNZ' ,
                      'CRD' ,
                      -1 ,
                      1 ,
                      'Tarjeta Naranja - Plan Z - Inf.Adic.' ,
                      true
                     );

INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      3 ,
                      'Tarjeta Visa' ,
                      'VISA' ,
                      'CRD' ,
                      -1 ,
                      3 ,
                      'Tarjeta Visa - Inf. Adicional' ,
                      true
                     );

INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      4 ,
                      'Tarjeta Bancor' ,
                      'BANCOR' ,
                      'CRD' ,
                      -1 ,
                      4 ,
                      'Tarjeta Bancor - Inf. Adicional' ,
                      true
                     );

INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      5 ,
                      'Visa Electron' ,
                      'Electron' ,
                      'DEB' ,
                      -1 ,
                      5 ,
                      'Tarjeta Visa Electrón - Inf. Adicional' ,
                      true
                     );

INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      6 ,
                      'Maestro' ,
                      'Maestro' ,
                      'DEB' ,
                      -1 ,
                      6 ,
                      'Tarjeta Débito Maestro - Inf. Adicional' ,
                      true
                     );

INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      7 ,
                      'Mastercard' ,
                      'MC' ,
                      'CRD' ,
                      -1 ,
                      7 ,
                      'Tarjeta Mastercard - Inf. Adicional' ,
                      true
                     );

INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      8 ,
                      'American Express' ,
                      'AMEX' ,
                      'CRD' ,
                      -1 ,
                      8 ,
                      'Tarjeta American Express- Inf. Adicional' ,
                      true
                     );

INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      9 ,
                      'Tarjeta Crédito' ,
                      'TARJ.CRD' ,
                      'CRD' ,
                      -1 ,
                      9 ,
                      'Tarjeta Credito - (sin datos)' ,
                      true
                     );

INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      10 ,
                      'Tarjeta Débito' ,
                      'TARJ.DEB' ,
                      'DEB' ,
                      -1 ,
                      10 ,
                      'Tarjeta Débito - (sin datos)' ,
                      true
                     );

INSERT INTO tarjeta (
                      id_tarjeta            , -- serial NOT NULL,
                      nombre                , -- character varying(128) NOT NULL,
                      abreviatura           , --  character varying(8),
                      id_tipo_tarjeta       , -- character varying(3) NOT NULL,
                      id_img_logo           , -- integer,
                      nps_codigo_tarjeta    , -- integer,
                      informacion_adicional , -- character varying(256),
                      habilitada              -- boolean NOT NULL DEFAULT true,
                    )
             VALUES (
                      11 ,
                      'Tarjeta Nevada' ,
                      'NEVADA' ,
                      'CRD' ,
                      -1 ,
                      11 ,
                      'Tarjeta Nevada - Inf. Adicional' ,
                      true
                     );

SELECT setval('public.tarjeta_id_tarjeta_seq', (SELECT MAX(id_tarjeta) FROM tarjeta) , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --
\echo  'Se agregan datos de bancos emisores (para tarjetas que deban especificar el banco o la entidad emisora.)';

INSERT INTO banco_emisor(id_banco_emisor, nombre, descripcion, habilitado) VALUES (1, 'Banco de Neuquen', 'Banco de Neuquen', true);

SELECT setval('public.banco_emisor_id_banco_emisor_seq', (SELECT MAX(id_banco_emisor) FROM banco_emisor) , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --
\echo  'Se agregan datos de planes de pago (para tarjetas o para otro tipo de medio de pago)';

-- Planes de Pago (para tarjetas - de credito o debito o todas)

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          -1                         ,  -- id_plan_de_pago
                          NULL                       ,  -- id_tarjeta
                          NULL                       ,  -- id_banco_emisor
                          1                          ,  -- id_moneda
                          'Plan de Pago no definido' ,  -- nombre
                          0                          ,  -- cuotas
                          'Plan de Pago no definido' ,  -- descripcion
                          NULL                       ,  -- id_descuento_recargo
                          NULL                       ,  -- nps_codigo_plan
                          NULL                       ,  -- informacion_adicional
                          false                         -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          1                        ,  -- id_plan_de_pago
                          NULL                     ,  -- id_tarjeta
                          NULL                     ,  -- id_banco_emisor
                          1                        ,  -- id_moneda
                          'CONTADO'                ,  -- nombre
                          1                        ,  -- cuotas
                          'CONTADO EFECTIVO PESOS' ,  -- descripcion
                          NULL                     ,  -- id_descuento_recargo
                          NULL                     ,  -- nps_codigo_plan
                          NULL                     ,  -- informacion_adicional
                          true                        -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          2                         ,  -- id_plan_de_pago
                          1                         ,  -- id_tarjeta
                          NULL                      ,  -- id_banco_emisor
                          1                         ,  -- id_moneda
                          'Tarj.Naranja (1 pago)'   ,  -- nombre
                          1                         ,  -- cuotas
                          'Tarj.Naranja (1 pago)'   ,  -- descripcion
                          NULL                      ,  -- id_descuento_recargo
                          NULL                      ,  -- nps_codigo_plan
                          NULL                      ,  -- informacion_adicional
                          true                        -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          3                         ,  -- id_plan_de_pago
                          2                         ,  -- id_tarjeta
                          NULL                      ,  -- id_banco_emisor
                          1                         ,  -- id_moneda
                          'Tarj.Naranja (Plan Z)'   ,  -- nombre
                          3                         ,  -- cuotas
                          'Tarj.Naranja (Plan Z)'   ,  -- descripcion
                          NULL                      ,  -- id_descuento_recargo
                          NULL                      ,  -- nps_codigo_plan
                          NULL                      ,  -- informacion_adicional
                          true                        -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          4                         ,  -- id_plan_de_pago
                          3                         ,  -- id_tarjeta
                          NULL                      ,  -- id_banco_emisor
                          1                         ,  -- id_moneda
                          'Visa (1 pago)'           ,  -- nombre
                          1                         ,  -- cuotas
                          'Visa (1 pago)'           ,  -- descripcion
                          NULL                      ,  -- id_descuento_recargo
                          NULL                      ,  -- nps_codigo_plan
                          NULL                      ,  -- informacion_adicional
                          true                        -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          5                         ,  -- id_plan_de_pago
                          4                         ,  -- id_tarjeta
                          NULL                      ,  -- id_banco_emisor
                          1                         ,  -- id_moneda
                          'Tarj.Bancor (1 pago)'    ,  -- nombre
                          1                         ,  -- cuotas
                          'Tarj.Bancor (1 pago)'    ,  -- descripcion
                          NULL                      ,  -- id_descuento_recargo
                          NULL                      ,  -- nps_codigo_plan
                          NULL                      ,  -- informacion_adicional
                          true                        -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          6                         ,  -- id_plan_de_pago
                          5                         ,  -- id_tarjeta
                          NULL                      ,  -- id_banco_emisor
                          1                         ,  -- id_moneda
                          'Visa.Electrón (débito)'  ,  -- nombre
                          1                         ,  -- cuotas
                          'Visa.Electrón (débito)'  ,  -- descripcion
                          NULL                      ,  -- id_descuento_recargo
                          NULL                      ,  -- nps_codigo_plan
                          NULL                      ,  -- informacion_adicional
                          true                        -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          7                         ,  -- id_plan_de_pago
                          6                         ,  -- id_tarjeta
                          NULL                      ,  -- id_banco_emisor
                          1                         ,  -- id_moneda
                          'Maestro (débito)'        ,  -- nombre
                          1                         ,  -- cuotas
                          'Maestro (débito)'        ,  -- descripcion
                          NULL                      ,  -- id_descuento_recargo
                          NULL                      ,  -- nps_codigo_plan
                          NULL                      ,  -- informacion_adicional
                          true                        -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          8                         ,  -- id_plan_de_pago
                          7                         ,  -- id_tarjeta
                          NULL                      ,  -- id_banco_emisor
                          1                         ,  -- id_moneda
                          'MasterCard (1 pago)'     ,  -- nombre
                          1                         ,  -- cuotas
                          'MasterCard (1 pago)'     ,  -- descripcion
                          NULL                      ,  -- id_descuento_recargo
                          NULL                      ,  -- nps_codigo_plan
                          NULL                      ,  -- informacion_adicional
                          true                        -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          9                         ,  -- id_plan_de_pago
                          8                         ,  -- id_tarjeta
                          NULL                      ,  -- id_banco_emisor
                          1                         ,  -- id_moneda
                          'Amex (1 pago)'           ,  -- nombre
                          1                         ,  -- cuotas
                          'American Express (1 pago)',  -- descripcion
                          NULL                      ,  -- id_descuento_recargo
                          NULL                      ,  -- nps_codigo_plan
                          NULL                      ,  -- informacion_adicional
                          true                        -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          10                               ,  -- id_plan_de_pago
                          9                                ,  -- id_tarjeta
                          NULL                             ,  -- id_banco_emisor
                          1                                ,  -- id_moneda
                          'Tarj.Crédito (sin datos)'       ,  -- nombre
                          1                                ,  -- cuotas
                          'Tarjeta de Crédito (sin datos)' ,  -- descripcion
                          NULL                             ,  -- id_descuento_recargo
                          NULL                             ,  -- nps_codigo_plan
                          NULL                             ,  -- informacion_adicional
                          true                                -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          11                               ,  -- id_plan_de_pago
                          10                               ,  -- id_tarjeta
                          NULL                             ,  -- id_banco_emisor
                          1                                ,  -- id_moneda
                          'Tarj.Débito (sin datos)'        ,  -- nombre
                          1                                ,  -- cuotas
                          'Tarjeta de Débito (sin datos)'  ,  -- descripcion
                          NULL                             ,  -- id_descuento_recargo
                          NULL                             ,  -- nps_codigo_plan
                          NULL                             ,  -- informacion_adicional
                          true                                -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          12                               ,  -- id_plan_de_pago
                          11                               ,  -- id_tarjeta
                          NULL                             ,  -- id_banco_emisor
                          1                                ,  -- id_moneda
                          'Tarjeta Nevada'                 ,  -- nombre
                          1                                ,  -- cuotas
                          'Tarjeta Nevada'                 ,  -- descripcion
                          NULL                             ,  -- id_descuento_recargo
                          NULL                             ,  -- nps_codigo_plan
                          NULL                             ,  -- informacion_adicional
                          true                                -- habilitado
                        ) ;

INSERT INTO plan_de_pago (
                           id_plan_de_pago       ,  -- integer                 NOT NULL
                           id_tarjeta            ,  -- integer                     NULL
                           id_banco_emisor       ,  -- integer                     NULL
                           id_moneda             ,  -- integer                 NOT NULL
                           nombre                ,  -- character varying(128)      NULL
                           cuotas                ,  -- integer                 NOT NULL
                           descripcion           ,  -- character varying(256)      NULL
                           id_descuento_recargo  ,  -- integer                     NULL
                           nps_codigo_plan       ,  -- character varying(2)        NULL
                           informacion_adicional ,  -- character varying(128)      NULL
                           habilitado
                        )
                 VALUES (
                          13                       ,  -- id_plan_de_pago
                          NULL                     ,  -- id_tarjeta
                          NULL                     ,  -- id_banco_emisor
                          1                        ,  -- id_moneda
                          'Abono'                  ,  -- nombre
                          1                        ,  -- cuotas
                          'Abono'                  ,  -- descripcion
                          NULL                     ,  -- id_descuento_recargo
                          NULL                     ,  -- nps_codigo_plan
                          NULL                     ,  -- informacion_adicional
                          true                        -- habilitado
                        ) ;


SELECT setval('public.plan_de_pago_id_plan_de_pago_seq', (SELECT MAX(id_plan_de_pago) FROM plan_de_pago) , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de medios de pago. (Este dato es el que se asocia finalmente a un movimiento de caja)';

-- Medio de Pago (incluye el tipo de medio de pago y el plan de pago , este atributo es el que califica a los movimientos de caja)

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (     1           ,      1                , 1               , 'CONTADO EFECTIVO'    , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (     2           ,      2                , 2               , 'Naranja (1 pago)'    , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (     3           ,      2                , 3               , 'Naranja (Plan Z)'    , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (     4           ,      2                , 4               , 'Visa (1 pago)'       , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (     5           ,      2                , 5               , 'Cordobesa (1 pago)'  , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (     6           ,      2                , 6               , 'Visa Electrón (debito)' , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (     7           ,      2                , 7               , 'Maestro (debito)'             , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (     8           ,      2                , 8               , 'MasterCard (1 pago)' , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional       , habilitado )
                   VALUES (     9           ,      2                , 9               , 'American Express (1 pago)' , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (    10           ,      2                , 10               , 'Tarjeta de Crédito (sin más datos)'    , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (    11           ,      2                , 11              , 'Tarjeta de Débito (sin mas datos)'    , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (    12           ,      2                , 12              , 'Tarjeta Nevada'                        , true       );

INSERT INTO medio_de_pago (id_medio_de_pago , id_tipo_medio_de_pago , id_plan_de_pago , informacion_adicional , habilitado )
                   VALUES (    13           ,      3                , 13              , 'Abono'                                 , true       );

-- SELECT setval('public.medio_de_pago_id_medio_de_pago_seq', (SELECT MAX(id_medio_de_pago) FROM medio_de_pago) , true);
SELECT setval('public.medio_de_pago_id_medio_de_pago_seq', 100 , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de los ambitos de los roles';

-- ambitos de los roles
INSERT INTO rol_ambito ( id_rol_ambito , descripcion) VALUES ( 1 , 'Punto de Venta Fiscal' );
INSERT INTO rol_ambito ( id_rol_ambito , descripcion) VALUES ( 2 , 'SVT' );
INSERT INTO rol_ambito ( id_rol_ambito , descripcion) VALUES ( 3 , 'Servidor Central' );
SELECT setval('public.rol_ambito_id_rol_ambito_seq', (SELECT MAX(id_rol_ambito) FROM rol_ambito) , true);

\echo  'Se agregan datos de roles';

-- roles del punto de venta
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES ( 1 , 'Cajero'     , 'Cajero del Punto de Venta (fiscal).' , 1 ) ;
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES ( 2 , 'Supervisor' , 'Supervisor del Punto de Venta (fiscal).' , 1 ) ;

-- roles del svt
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES (  3 , 'administrador'    , 'Administrador (SVT).' , 2 ) ;
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES (  4 , 'supervisor'       , 'Supervisor (SVT).'    , 2 ) ;
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES (  5 , 'vendedor'         , 'Vendedor (SVT).'      , 2 ) ;
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES (  6 , 'productor'        , 'Productor (SVT).'     , 2 ) ;
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES (  7 , 'acreditacion'     , 'Acreditacion (SVT).'  , 2 ) ;
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES (  8 , 'autorizador'      , 'Autorizador (SVT).'   , 2 ) ;
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES (  9 , 'control'          , 'Control (SVT).'       , 2 ) ;
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES ( 10 , 'organizacion'     , 'Organizacion (SVT).'  , 2 ) ;

-- roles del servidor central (aplicacion web)
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES ( 11 , 'Administrador', 'Administrador del Servidor Central'           , 3);
INSERT INTO rol (id_rol, nombre, descripcion, id_rol_ambito) VALUES ( 12 , 'Responsable Comercial', 'Responsable Comercial de Autoentrada' , 3);

-- SELECT setval('public.rol_id_rol_seq', (SELECT MAX(id_rol) FROM rol) , true);
SELECT setval('public.rol_id_rol_seq', 100 , true);

INSERT INTO svt_defaults_roles (nombre) values ( 'administrador' ) ;
INSERT INTO svt_defaults_roles (nombre) values ( 'supervisor'    ) ;
INSERT INTO svt_defaults_roles (nombre) values ( 'vendedor'      ) ;
INSERT INTO svt_defaults_roles (nombre) values ( 'productor'     ) ;
INSERT INTO svt_defaults_roles (nombre) values ( 'acreditacion'  ) ;
INSERT INTO svt_defaults_roles (nombre) values ( 'autorizador'   ) ;
INSERT INTO svt_defaults_roles (nombre) values ( 'control'       ) ;
INSERT INTO svt_defaults_roles (nombre) values ( 'organizacion'  ) ;

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --
\echo  'Se agregan los permisos definidos.';

INSERT INTO permiso (id_permiso, nombre) VALUES (  1 , 'ADM_CATEGORIA');
INSERT INTO permiso (id_permiso, nombre) VALUES (  2 , 'ADM_EVENTO');
INSERT INTO permiso (id_permiso, nombre) VALUES (  3 , 'ADM_SHOW');
INSERT INTO permiso (id_permiso, nombre) VALUES (  4 , 'ADM_COMPLEJO');
INSERT INTO permiso (id_permiso, nombre) VALUES (  5 , 'ADM_PRODUCTOR');
INSERT INTO permiso (id_permiso, nombre) VALUES (  6 , 'ADM_MEDIO_PAGO');
INSERT INTO permiso (id_permiso, nombre) VALUES (  7 , 'ADM_SUCURSAL');
INSERT INTO permiso (id_permiso, nombre) VALUES (  8 , 'ADM_SVT');
INSERT INTO permiso (id_permiso, nombre) VALUES (  9 , 'ADM_USUARIO');
INSERT INTO permiso (id_permiso, nombre) VALUES ( 10 , 'CONSULTAR_RECAUDACION');

-- SELECT setval('public.permiso_id_permiso_seq', 100 , true);
SELECT setval('public.permiso_id_permiso_seq', (SELECT MAX(id_permiso) FROM permiso) , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --
\echo  'Se agregan las asociaciones entre los permisos y roles definidos.';

-- Permisos asociados a cada Rol (configuración inicial)
-- ROL Administrador SC
INSERT INTO permiso_rol (id_rol, id_permiso) VALUES (11,1);
INSERT INTO permiso_rol (id_rol, id_permiso) VALUES (11,2);
INSERT INTO permiso_rol (id_rol, id_permiso) VALUES (11,3);
INSERT INTO permiso_rol (id_rol, id_permiso) VALUES (11,4);
INSERT INTO permiso_rol (id_rol, id_permiso) VALUES (11,5);
INSERT INTO permiso_rol (id_rol, id_permiso) VALUES (11,6);
INSERT INTO permiso_rol (id_rol, id_permiso) VALUES (11,7);
INSERT INTO permiso_rol (id_rol, id_permiso) VALUES (11,8);
INSERT INTO permiso_rol (id_rol, id_permiso) VALUES (11,9);

-- ROL Responsable Comercial SC
INSERT INTO permiso_rol (id_rol, id_permiso) values (12,10);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --
\echo  'Se agregan los datos de sucursal';
-- sucursales
INSERT INTO sucursal (id_sucursal, nombre, direccion, id_provincia, telefono) VALUES (-1, 'Sucursal No definida', '', 'XXX', '');
INSERT INTO sucursal (id_sucursal, nombre, direccion, id_provincia, telefono) VALUES ( 1, 'Sucursal Autoentrada', '', 'CBA', '');
--SELECT setval('public.sucursal_id_sucursal_seq', (SELECT MAX(id_sucursal) FROM sucursal) , true);
SELECT setval('public.sucursal_id_sucursal_seq', 100 , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan datos de servidor [servidor no asignado]';

-- Servidor ( servidor no asignado )
INSERT INTO servidor (id_servidor , nombre, url , id_sucursal , id_cliente_mqtt , uri_wsdl ) VALUES ( -1 , 'Servidor No Asignado' , 'no.asignado.autoentrada.com', 1 , 'SVTnoasignado' , '') ;
INSERT INTO servidor (id_servidor , nombre, url , id_sucursal , id_cliente_mqtt , uri_wsdl ) VALUES (  1 , 'Servidor Central' , 'www.autoentrada.com', 1 , 'servidorcentral' , '') ;
-- SELECT setval('public.servidor_id_servidor_seq', (SELECT MAX(id_servidor) FROM servidor) , true);
SELECT setval('public.servidor_id_servidor_seq', 100 , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

-- En el SVT existen entidades denominadas 'punto de venta' y el equivaliente en el Servidor Central es la entidad 'terminal'.
-- Lo que en el Servidor Central es un punto de venta, no existe como entidad en el SVT.

\echo 'Agregamos los puntos de venta que existen al crear el Servidor Central, y que se pueden asociar a terminales de varios SVT existentes'

-- Punto de venta que existen al crear el Servidor Central, y que se pueden asociar a terminales de varios SVT existentes.
-- ATENCION : La tabla punto de venta esta muy relacionada con la tabla terminal, y no tiene ninguna descripcion, por lo cual resulta muy poco intuitivo
--            Una convencion que hemos adoptado para la importacion de los datos es que el campo 'codigo' de esta tabla, tiene el mismo valor que la PK (id_punto_de_venta)
--            Eso no esta muy claro por que es asi y si es necesario cambiarlo, o agregarle algun campo con una descripcion.
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES (  1,   '1' , 'Internet (pto vta)'        , 1);
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES (  2,   '2' , 'Oficina (pto vta)'         , 1);
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES (  3,   '3' , 'Patio Olmos (pto vta)'     , 1);
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES (  6,   '6' , 'Nuevo Cento (pto vta)'     , 1);
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES (  7,   '7' , 'Cba Shopping (pto vta)'    , 1);
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES (  8,   '8' , 'Araceli (pto vta)'         , 1);
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES (  9,   '9' , 'Rio Cuarto (pto vta)'      , 1);
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES ( 10,  '10' , 'Fiorani Rivera (pto vta)'  , 1);
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES ( 11,  '11' , 'Teatro Real (pto vta)'     , 1);
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES ( 12,  '12' , 'Terminal Villa Carlos Paz' , 1);
INSERT INTO punto_de_venta (id_punto_de_venta, codigo, nombre, id_sucursal) VALUES ( 13,  '13' , 'Terminal - Cordoba'        , 1);

-- SELECT setval('public.punto_de_venta_id_punto_de_venta_seq', (SELECT MAX(id_punto_de_venta) FROM punto_de_venta) , true);
SELECT setval('public.punto_de_venta_id_punto_de_venta_seq', 100 , true);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo 'Agregamos las terminales que existen al momento de crear el Servidor Central y que existen en todos (o casi todos) los SVT (en el SVT, es un punto de venta).'

-- terminales comunes a todos los SVT (o casi todos), que cada vez que se encuentran en una tabla representan a la misma terminal
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (    1      ,    1             , 'tInternet'      , 'tInternet'       , '', '2015-01-01'      , 'tinternet'             , NULL                       , 2               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (    2      ,    2             , 'toficina'       , 'tOficina'        , '', '2015-01-01'      , 'toficina'              , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (    3      ,    3             , 'AEOLMOS'        , 'AEOLMOS'         , '', '2015-01-01'      , 'aeolmos'               , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (    4      ,    3             , 'AEOLMOS2'       , 'AEOLMOS2'        , '', '2015-01-01'      , 'aeolmos2'              , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (    5      ,    3             , 'tpatioolmos'    , 'tpatioolmos'     , '', '2015-01-01'      , 'tpatioolmos (viejo)'   , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (    6      ,    6             , 'tnuevocentro'   , 'tnuevocentro'    , '', '2015-01-01'      , 'tnuevocentro'          , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (    7      ,    7             , 'tcbashopping'   , 'tcbashopping'    , '', '2015-01-01'      , 'tcbashopping'          , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (    8      ,    8             , 'taraceli'       , 'taraceli'        , '', '2015-01-01'      , 'taraceli'              , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (    9      ,    9             , 'triocuarto'     , 'triocuarto'      , '', '2015-01-01'      , 'triocuarto'            , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (   10      ,   10             , 'tfioranirivera' , 'tfioranirivera'  , '', '2015-01-01'      , 'tfioranirivera'        , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (   11      ,   10             , 'tsheraton'      , 'tsheraton'       , '', '2014-12-31'      , 'tsheraton'             , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (   12      ,   10             , 'tvioleta'       , 'tvioleta'        , '', '2014-12-31'      , 'tvioleta'              , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (   13      ,   11             , 'treal1'         , 'tvioleta'        , '', '2014-12-31'      , 'treal1'                , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (   14      ,   11             , 'treal2'         , 'treal2'          , '', '2014-12-31'      , 'treal2'                , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (   15      ,   12             , 'tterminal'      , 'tterminal'       , '', '2014-12-31'      , 'Terminal Carlos Paz'   , NULL                       , 1               , NULL      );
INSERT INTO terminal(id_terminal, id_punto_de_venta, nombre           , password          , ip, fecha_valida_hasta, descripcion             , id_impresora_predeterminada, id_terminal_tipo, id_usuario)
             VALUES (   16      ,   13             , 'tterminalcba'   , 'tterminalcba'    , '', '2014-12-31'      , 'Terminal Cordoba'      , NULL                       , 1               , NULL      );

-- SELECT setval('public.terminal_id_terminal_seq', (SELECT MAX(id_terminal) FROM terminal) , true);
SELECT setval('public.terminal_id_terminal_seq', 100 , true);

\echo 'Agregamos las terminales comunes a todos los SVT (en el SVT es "Punto de Venta" - PdV), para que la stored procedure de importacion de SVT, las reconozca.'
-- En la tabla 'svt_defaults_terminales', ponemos los nombres de las terminales que al momento de importar una base de datos de un SVT, sabemos que se consolidan con una terminal existente en el Servidor Central, por que ya la creamos.
-- Hay que tener cuidado por que se puede dar el caso que en varios SVT exista una terminal 'boleteria', pero eso no implica que esa terminal sea la misma terminal en los distintos SVT (por que corresponde a distintos teatros, obvio).
-- Las terminales cuyos nombres agregamos a continuacion, por mas que provengan de distintos SVT, si son la misma terminal y se consolidan al momento de importar la base de datos del SVT.


INSERT INTO svt_defaults_terminales (nombre) VALUES ('tinternet'       );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('toficina'        );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('AEOLMOS'         );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('AEOLMOS2'        );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('tpatioolmos'     );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('tnuevocentro'    );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('tcbashopping'    );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('taraceli'        );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('triocuarto'      );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('tfioranirivera'  );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('tsheraton'       );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('tvioleta'        );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('treal1'          );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('treal2'          );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('tterminal'       );
INSERT INTO svt_defaults_terminales (nombre) VALUES ('tterminalcba'    );

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo 'Se agregan los usuarios comunes a todos (o casi todos) los SVT, de esta forma podemos consolidarlos al momento de importar las bases de datos de cada SVT.'

-- Usuarios comunes a todos (o casi todos) los SVT, de esta forma podemos consolidarlos al momento de importar las bases de datos de cada SVT. (por que los reconocemos por el login y ya estan generado en la tabla usuarios)
INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES ( 1, 'admin@autoentrada.com'        , '' , 'Autoentrada' , 'Administrador', '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 1 , 3 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES ( 2, 'v1'                           , '' , 'Oficina'     , 'Vendedor'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 2 , 5 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES ( 3, 'vendedorInternet'             , '' , 'Internet'    , 'Venta'        , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 3 , 5 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES ( 4, 'solmos@autoentrada.com'       , '' , 'Patio Olmos' , 'Supervisor'   , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 4 , 4);

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES ( 5, 'volmos@autoentrada.com'       , '' , 'Patio Olmos' , 'Vendedor'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 5 , 5);

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES ( 6, 'snuevocentro@autoentrada.com' , '' , 'Nuevo Centro', 'Supervisor'   , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 6 , 4);

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES ( 7, 'vnuevocentro@autoentrada.com' , '' , 'Nuevo Centro', 'Vendedor'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 7 , 5 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES ( 8, 'ssanti@autoentrada.com'       , '' , 'Cba Shopping', 'Supervisor'   , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 8 , 4 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES ( 9, 'vsanti@autoentrada.com'       , '' , 'Cba Shopping', 'Vendedor'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 9 , 5 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (10, 'saraceli'                     , '' , 'ARACELI'     , 'Supervisor'   , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 10 , 4 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (11, 'varaceli'                     , '' , 'ARACELI'     , 'Vendedor'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 11 , 5 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (12, 'sriocuarto'                   , '' , 'Rio Cuarto'  , 'Supervisor'   , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 12 , 4 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (13, 'vriocuarto'                   , '' , 'Rio Cuarto'  , 'Vendedor'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 13 , 5 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (14, 'descuento'                    , '' , 'Descuento'        , 'Descuento'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 14 , 6 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (15, 'eugenia.ralph@autoentrada.com', '' , 'Ralph'            , 'Eugenia'       , 'eugenia.ralph@autoentrada.com', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 15 , 3 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (16, 'julietaverdu'                 , '' , 'Julieta Verdu'    , 'Agencia 2014'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 16 , 6 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (17, 'lauramontoya'                 , '' , 'Laura Montoya'    , 'Agencia 2014'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 17 , 6 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (18, 'pamelamurua'                  , '' , 'Pamela Murua'     , 'Agencia 2014'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 18 , 6 );

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (19, 'anaguevara'                   , '' , 'Analia Guevara'   , 'Agencia 2014'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 19 , 6);

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (20, 'mariboero'                    , '' , 'Maria Boero'      , 'Agencia 2014'     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 20 , 6);

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (21, 'maxi'                         , '' , 'Pita'             , 'Maximiliano '     , '', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 21 , 6);

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (22, 'lisandro.scalenghe@autoentrada.com' , 'aepwd' ,'Scalenghe', 'Lisandro', 'lisandro.scalenghe@autoentrada.com', false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 22 , 12);

\echo 'Agregamos los usuarios que se utilizan en el punto de venta de Maer Software.'
-- Agregamos usuarios que se utilizan en el punto de venta de Maer Software.

INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (101, 'cajero_1_pdv'                 , 'cjr1'    , '(PDV)'     , 'Cajero 1'      , 'cajero1pdv@autoentrada.com'     , false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 101 , 1);
INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (102, 'cajero_2_pdv'                 , 'cjr2'    , '(PDV)'     , 'Cajero 2'      , 'cajero2pdv@autoentrada.com'     , false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 102 , 1);
INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (103, 'cajero_3_pdv'                 , 'cjr3'    , '(PDV)'     , 'Cajero 3'      , 'cajero3pdv@autoentrada.com'     , false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 103 , 1);
INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (104, 'admin_1_pdv'                  , 'sprvsr1' , '(PDV)'     , 'Supervisor 1'  , 'supervisor1pdv@autoentrada.com' , false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 104 , 2);
INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (105, 'admin_2_pdv'                  , 'sprvsr2' , '(PDV)'     , 'Supervisor 2'  , 'supervisor2pdv@autoentrada.com' , false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 105 , 2);
INSERT INTO usuario( id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) VALUES (106, 'admin_3_pdv'                  , 'sprvsr3' , '(PDV)'     , 'Supervisor 3'  , 'supervisor3pdv@autoentrada.com' , false , -1);
INSERT INTO usuario_rol ( id_usuario , id_rol ) VALUES ( 106 , 2);

-- SELECT setval('public.usuario_id_usuario_seq', (SELECT MAX(id_usuario) FROM usuario) , true);
SELECT setval('public.usuario_id_usuario_seq', 1000 , true);

\echo 'Asociamos los usuarios creados para el punto de venta de Maer Software a las terminales del Patio Olmos (por que alli se va a utilizar el punto de venta de Maer).'
-- Asociamos los usuarios creados para el punto de venta de Maer Software a las terminales del Patio Olmos (por que alli se va a utilizar el punto de venta de Maer).

INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 3 , 101 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 3 , 102 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 3 , 103 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 3 , 104 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 3 , 105 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 3 , 106 ) ;

INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 4 , 101 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 4 , 102 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 4 , 103 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 4 , 104 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 4 , 105 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 4 , 106 ) ;

INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 5 , 101 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 5 , 102 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 5 , 103 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 5 , 104 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 5 , 105 ) ;
INSERT INTO terminal_usuario ( id_terminal , id_usuario ) VALUES ( 5 , 106 ) ;

\echo 'Agregamos los usuarios comunes a todos los defaults, para que la stored procedure de importacion de SVT, los reconozca.'
-- En la tabla 'svt_defaults_usuarios', ponemos los logins de los usuarios que al momento de importar una base de datos de un SVT, que sabemos que se consolidan con un usuario existente en el Servidor Central, por que ya lo creamos.
-- Hay que tener cuidado por que se puede dar el caso que en varios SVT exista un usuario 'vendedor_boleteria', pero eso no implica que ese usuario sea la misma persona (por que son distintos SVT)
-- Los usuarios cuyos logins agregamos a continuacion, por mas que provengan de distintos SVT, si son la misma persona y se consolidan al momento de importar la base de datos del SVT.

INSERT INTO svt_defaults_usuarios (login) VALUES ('admin@autoentrada.com'       );
INSERT INTO svt_defaults_usuarios (login) VALUES ('v1'                          );
INSERT INTO svt_defaults_usuarios (login) VALUES ('vendedorInternet'            );
INSERT INTO svt_defaults_usuarios (login) VALUES ('solmos@autoentrada.com'      );
INSERT INTO svt_defaults_usuarios (login) VALUES ('volmos@autoentrada.com'      );
INSERT INTO svt_defaults_usuarios (login) VALUES ('snuevocentro@autoentrada.com');
INSERT INTO svt_defaults_usuarios (login) VALUES ('vnuevocentro@autoentrada.com');
INSERT INTO svt_defaults_usuarios (login) VALUES ('ssanti@autoentrada.com'      );
INSERT INTO svt_defaults_usuarios (login) VALUES ('vsanti@autoentrada.com'      );
INSERT INTO svt_defaults_usuarios (login) VALUES ('saraceli'                    );
INSERT INTO svt_defaults_usuarios (login) VALUES ('varaceli'                    );
INSERT INTO svt_defaults_usuarios (login) VALUES ('sriocuarto'                  );
INSERT INTO svt_defaults_usuarios (login) VALUES ('vriocuarto'                  );

INSERT INTO svt_defaults_usuarios (login)            VALUES ('descuento'                    );
INSERT INTO svt_defaults_usuarios (login)            VALUES ('eugenia.ralph@autoentrada.com');
INSERT INTO svt_defaults_usuarios (login)            VALUES ('julietaverdu'                 );
INSERT INTO svt_defaults_usuarios (login)            VALUES ('lauramontoya'                 );
INSERT INTO svt_defaults_usuarios (login)            VALUES ('pamelamurua'                  );
INSERT INTO svt_defaults_usuarios (login)            VALUES ('anaguevara'                   );
INSERT INTO svt_defaults_usuarios (login)            VALUES ('mariboero'                    );
INSERT INTO svt_defaults_usuarios (login)            VALUES ('maxi'                         );
INSERT INTO svt_defaults_usuarios (login,id_usuario) VALUES ('snuevocentro'                 ,6);
INSERT INTO svt_defaults_usuarios (login,id_usuario) VALUES ('solmos'                       ,4);
INSERT INTO svt_defaults_usuarios (login,id_usuario) VALUES ('ssanti'                       ,8);
INSERT INTO svt_defaults_usuarios (login,id_usuario) VALUES ('vnuevocentro'                 ,7);
INSERT INTO svt_defaults_usuarios (login,id_usuario) VALUES ('volmos'                       ,5);
INSERT INTO svt_defaults_usuarios (login,id_usuario) VALUES ('vsanti'                       ,9);
INSERT INTO svt_defaults_usuarios (login,id_usuario) VALUES ('laura'                        ,17);

--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --
--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --

\echo  'Se agregan parámetros';

-- Versión de la DB
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 1, 'version_db', '1.0.0', 'Versión de la Base de Datos');

-- Parámetros de Configuración de NPS
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 2, 'nps_version_mensajeria', '1.0', 'Versión de mensajería a utilizar.');
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 3, 'nps_origen_trans', 'WEB', 'Especifica el origen de la transacción.');
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 4, 'nps_url_respuesta', 'http://www.autoentrada.com/ConfirmacionTarjeta.do?method=procesarRespuesta', 'La URL sera utilizada por el servidor PSP para direccionar el navegador del tarjetahabiente al sitio del comercio una vez que obtenga la respuesta del procesador.');
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 5, 'nps_url_retorno', 'http://www.autoentrada.com/ConfirmacionTarjeta.do?method=volver', 'URL para retornar al comercio.BackButton');
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 6, 'nps_idioma', 'es_AR', 'Lenguaje con el que se muestra el formulario de carga.');
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 7, 'nps_mail_comercio', 'portal@autoentrada.com', 'Mail del comercio.');
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 8, 'nps_desc_compra', 'Entradas', 'Descripción de la compra.');
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 9, 'nps_filtro', 'T', 'Criterio utilizado en el filtro de la consulta');

-- Parámetros de Configuración de Uploads
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 10, 'uploads_ubicacion', '/var/servidor-central-web/uploads/', 'Ubicación donde se guardan los archivos subidos por el usuario');
INSERT INTO parametro (id_parametro, clave, valor, descripcion) VALUES ( 11, 'uploads_contexto', '/uploads/', 'Contexto desde donde se puede acceder a los archivos subidos por el usuario');

SELECT setval('public.parametro_id_parametro_seq', (SELECT MAX(id_parametro) FROM parametro) , true);
--  ###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---###---### --
