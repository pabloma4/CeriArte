alter table movimiento_caja alter column monto type double precision;
alter table orden_trabajo alter column fecha_creacion type timestamp without time zone;
alter table orden_trabajo alter column fecha_modificacion type timestamp without time zone;
alter table orden_trabajo alter column fecha_estimada_fin type timestamp without time zone;
alter table pedido alter column fecha_creacion type timestamp without time zone;
alter table pedido alter column fecha_modificacion type timestamp without time zone;
alter table presupuesto alter column fecha_creacion type timestamp without time zone;
alter table presupuesto alter column fecha_modificacion type timestamp without time zone;
alter table presupuesto alter column fecha_valido_hasta type timestamp without time zone;
