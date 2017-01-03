ALTER TABLE detalle_presupuesto ADD COLUMN nombre character varying(128);
ALTER TABLE detalle_presupuesto ADD COLUMN descripcion character varying(1000);

UPDATE detalle_presupuesto d SET nombre = (select nombre from producto p where p.id_producto = d.id_producto);
UPDATE detalle_presupuesto d SET descripcion = (select descripcion from producto p where p.id_producto = d.id_producto);

ALTER TABLE detalle_presupuesto ALTER COLUMN nombre SET NOT NULL;
ALTER TABLE detalle_presupuesto ALTER COLUMN descripcion SET NOT NULL;