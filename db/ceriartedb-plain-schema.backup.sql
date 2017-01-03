--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.14
-- Dumped by pg_dump version 9.1.14
-- Started on 2015-10-05 07:42:58

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 199 (class 3079 OID 11639)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 199
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 200 (class 3079 OID 69729)
-- Dependencies: 5
-- Name: dblink; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS dblink WITH SCHEMA public;


--
-- TOC entry 2133 (class 0 OID 0)
-- Dependencies: 200
-- Name: EXTENSION dblink; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION dblink IS 'connect to other PostgreSQL databases from within a database';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 162 (class 1259 OID 69798)
-- Dependencies: 1905 5
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cliente (
    id_cliente integer NOT NULL,
    nombre character varying(128) NOT NULL,
    apellido character varying(128) NOT NULL,
    email character varying(128),
    domicilio character varying(256),
    telefono character varying(128),
    fecha_creacion timestamp without time zone NOT NULL,
    id_cliente_estado character varying(3) NOT NULL,
    id_localidad character varying(3),
    id_responsabilidad_iva integer,
    cuit character varying(13),
    borrado boolean DEFAULT false NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 163 (class 1259 OID 69804)
-- Dependencies: 5
-- Name: cliente_estado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cliente_estado (
    id_cliente_estado character varying(3) NOT NULL,
    nombre character varying(128) NOT NULL,
    descripcion character varying(256)
);


ALTER TABLE public.cliente_estado OWNER TO postgres;

--
-- TOC entry 164 (class 1259 OID 69807)
-- Dependencies: 162 5
-- Name: cliente_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE cliente_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 2134 (class 0 OID 0)
-- Dependencies: 164
-- Name: cliente_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE cliente_id_cliente_seq OWNED BY cliente.id_cliente;


--
-- TOC entry 196 (class 1259 OID 71916)
-- Dependencies: 1920 5
-- Name: detalle_presupuesto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_presupuesto (
    id_detalle_presupuesto integer NOT NULL,
    id_producto integer NOT NULL,
    cantidad double precision DEFAULT 1 NOT NULL,
    precio_unitario double precision NOT NULL,
    id_presupuesto integer NOT NULL
);


ALTER TABLE public.detalle_presupuesto OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 71914)
-- Dependencies: 5 196
-- Name: detalle_presupuesto_id_detalle_presupuesto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE detalle_presupuesto_id_detalle_presupuesto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalle_presupuesto_id_detalle_presupuesto_seq OWNER TO postgres;

--
-- TOC entry 2135 (class 0 OID 0)
-- Dependencies: 195
-- Name: detalle_presupuesto_id_detalle_presupuesto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE detalle_presupuesto_id_detalle_presupuesto_seq OWNED BY detalle_presupuesto.id_detalle_presupuesto;


--
-- TOC entry 165 (class 1259 OID 69866)
-- Dependencies: 5
-- Name: id_operacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE id_operacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_operacion_seq OWNER TO postgres;

--
-- TOC entry 166 (class 1259 OID 69873)
-- Dependencies: 5
-- Name: importar_tipo_pago_svt_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE importar_tipo_pago_svt_seq
    START WITH -1
    INCREMENT BY -1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.importar_tipo_pago_svt_seq OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 71806)
-- Dependencies: 5
-- Name: localidad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE localidad (
    id_localidad character varying(3) NOT NULL,
    nombre character varying(128) NOT NULL
);


ALTER TABLE public.localidad OWNER TO postgres;

--
-- TOC entry 167 (class 1259 OID 69975)
-- Dependencies: 5
-- Name: parametro; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE parametro (
    id_parametro integer NOT NULL,
    clave character varying(40) NOT NULL,
    valor character varying(512),
    descripcion character varying(512)
);


ALTER TABLE public.parametro OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 69981)
-- Dependencies: 167 5
-- Name: parametro_id_parametro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE parametro_id_parametro_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.parametro_id_parametro_seq OWNER TO postgres;

--
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 168
-- Name: parametro_id_parametro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE parametro_id_parametro_seq OWNED BY parametro.id_parametro;


--
-- TOC entry 198 (class 1259 OID 71946)
-- Dependencies: 5
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pedido (
    id_pedido integer NOT NULL,
    fecha_hora_pedido timestamp without time zone NOT NULL,
    fecha_hora_impresion timestamp without time zone NOT NULL,
    fecha_hora_fin_pedido timestamp without time zone NOT NULL,
    id_usuario_pedido integer NOT NULL,
    id_usuario_impresion integer NOT NULL,
    id_usuario_fin_pedido integer NOT NULL,
    id_pedido_estado character varying(3) NOT NULL
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- TOC entry 169 (class 1259 OID 69987)
-- Dependencies: 5
-- Name: pedido_estado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pedido_estado (
    id_pedido_estado character varying(3) NOT NULL,
    nombre character varying(128) NOT NULL,
    descripcion character varying(256)
);


ALTER TABLE public.pedido_estado OWNER TO postgres;

--
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 169
-- Name: COLUMN pedido_estado.id_pedido_estado; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN pedido_estado.id_pedido_estado IS '
PED:Pedido
IMP:Impreso
FIN:Finalizado
CAN:Cancelado';


--
-- TOC entry 197 (class 1259 OID 71944)
-- Dependencies: 198 5
-- Name: pedido_id_pedido_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pedido_id_pedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pedido_id_pedido_seq OWNER TO postgres;

--
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 197
-- Name: pedido_id_pedido_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pedido_id_pedido_seq OWNED BY pedido.id_pedido;


--
-- TOC entry 170 (class 1259 OID 69992)
-- Dependencies: 5
-- Name: permiso; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE permiso (
    id_permiso integer NOT NULL,
    nombre character varying(40) NOT NULL,
    menu_nombre character varying(50),
    menu_orden smallint,
    menu_link character varying(255),
    id_padre integer
);


ALTER TABLE public.permiso OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 69995)
-- Dependencies: 5 170
-- Name: permiso_id_permiso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE permiso_id_permiso_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.permiso_id_permiso_seq OWNER TO postgres;

--
-- TOC entry 2139 (class 0 OID 0)
-- Dependencies: 171
-- Name: permiso_id_permiso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE permiso_id_permiso_seq OWNED BY permiso.id_permiso;


--
-- TOC entry 172 (class 1259 OID 69997)
-- Dependencies: 5
-- Name: permiso_rol; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE permiso_rol (
    id_rol integer NOT NULL,
    id_permiso integer NOT NULL
);


ALTER TABLE public.permiso_rol OWNER TO postgres;

--
-- TOC entry 192 (class 1259 OID 71885)
-- Dependencies: 1918 5
-- Name: presupuesto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE presupuesto (
    id_presupuesto integer NOT NULL,
    id_cliente integer NOT NULL,
    id_presupuesto_estado integer NOT NULL,
    fecha_creacion date NOT NULL,
    fecha_modificacion date,
    fecha_valido_hasta date NOT NULL,
    borrado boolean DEFAULT false NOT NULL
);


ALTER TABLE public.presupuesto OWNER TO postgres;

--
-- TOC entry 194 (class 1259 OID 71903)
-- Dependencies: 5
-- Name: presupuesto_estado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE presupuesto_estado (
    id_presupuesto_estado integer NOT NULL,
    nombre character varying(128) NOT NULL,
    descripcion character varying(256)
);


ALTER TABLE public.presupuesto_estado OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 71901)
-- Dependencies: 5 194
-- Name: presupuesto_estado_id_presupuesto_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE presupuesto_estado_id_presupuesto_estado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.presupuesto_estado_id_presupuesto_estado_seq OWNER TO postgres;

--
-- TOC entry 2140 (class 0 OID 0)
-- Dependencies: 193
-- Name: presupuesto_estado_id_presupuesto_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE presupuesto_estado_id_presupuesto_estado_seq OWNED BY presupuesto_estado.id_presupuesto_estado;


--
-- TOC entry 191 (class 1259 OID 71883)
-- Dependencies: 192 5
-- Name: presupuesto_id_presupuesto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE presupuesto_id_presupuesto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.presupuesto_id_presupuesto_seq OWNER TO postgres;

--
-- TOC entry 2141 (class 0 OID 0)
-- Dependencies: 191
-- Name: presupuesto_id_presupuesto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE presupuesto_id_presupuesto_seq OWNED BY presupuesto.id_presupuesto;


--
-- TOC entry 187 (class 1259 OID 71820)
-- Dependencies: 1913 1915 5
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE producto (
    id_producto integer NOT NULL,
    nombre character varying(128) NOT NULL,
    descripcion character varying(1000),
    precio double precision,
    cantidad double precision DEFAULT 1,
    id_unidad_medida integer NOT NULL,
    fecha_creacion time without time zone NOT NULL,
    fecha_modificacion time without time zone,
    borrado boolean DEFAULT false NOT NULL
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 71818)
-- Dependencies: 187 5
-- Name: producto_id_producto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE producto_id_producto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.producto_id_producto_seq OWNER TO postgres;

--
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 186
-- Name: producto_id_producto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE producto_id_producto_seq OWNED BY producto.id_producto;


--
-- TOC entry 190 (class 1259 OID 71854)
-- Dependencies: 5
-- Name: responsabilidad_iva; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE responsabilidad_iva (
    id_responsabilidad_iva integer NOT NULL,
    descripcion character varying(128) NOT NULL
);


ALTER TABLE public.responsabilidad_iva OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 71852)
-- Dependencies: 5 190
-- Name: responsablilidad_iva_id_responsabilidad_iva_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE responsablilidad_iva_id_responsabilidad_iva_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.responsablilidad_iva_id_responsabilidad_iva_seq OWNER TO postgres;

--
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 189
-- Name: responsablilidad_iva_id_responsabilidad_iva_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE responsablilidad_iva_id_responsabilidad_iva_seq OWNED BY responsabilidad_iva.id_responsabilidad_iva;


--
-- TOC entry 173 (class 1259 OID 70040)
-- Dependencies: 5
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE rol (
    id_rol integer NOT NULL,
    nombre character varying(128) NOT NULL,
    descripcion character varying(256) NOT NULL,
    id_rol_ambito integer NOT NULL
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 70043)
-- Dependencies: 5
-- Name: rol_ambito; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE rol_ambito (
    id_rol_ambito integer NOT NULL,
    descripcion character varying(32) NOT NULL
);


ALTER TABLE public.rol_ambito OWNER TO postgres;

--
-- TOC entry 2144 (class 0 OID 0)
-- Dependencies: 174
-- Name: TABLE rol_ambito; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE rol_ambito IS 'Esta tabla, representa, para los distintos roles, a que ambitos pertenecen. Por ejemplo, hay roles que se aplican al SVT, otros al punto de venta fiscal, otros al servidor central, etc.';


--
-- TOC entry 175 (class 1259 OID 70046)
-- Dependencies: 174 5
-- Name: rol_ambito_id_rol_ambito_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE rol_ambito_id_rol_ambito_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_ambito_id_rol_ambito_seq OWNER TO postgres;

--
-- TOC entry 2145 (class 0 OID 0)
-- Dependencies: 175
-- Name: rol_ambito_id_rol_ambito_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE rol_ambito_id_rol_ambito_seq OWNED BY rol_ambito.id_rol_ambito;


--
-- TOC entry 176 (class 1259 OID 70048)
-- Dependencies: 173 5
-- Name: rol_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE rol_id_rol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_id_rol_seq OWNER TO postgres;

--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 176
-- Name: rol_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE rol_id_rol_seq OWNED BY rol.id_rol;


--
-- TOC entry 177 (class 1259 OID 70296)
-- Dependencies: 5
-- Name: ticket_ubicacion_numerada_id_ticket_ubicacion_numerada_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ticket_ubicacion_numerada_id_ticket_ubicacion_numerada_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ticket_ubicacion_numerada_id_ticket_ubicacion_numerada_seq OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 70320)
-- Dependencies: 5
-- Name: tipo_doc_identidad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_doc_identidad (
    id_tipo_doc_identidad character varying(3) NOT NULL,
    nombre character varying(128) NOT NULL,
    descripcion character varying(256)
);


ALTER TABLE public.tipo_doc_identidad OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 70343)
-- Dependencies: 5
-- Name: tipo_valor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_valor (
    id_tipo_valor integer NOT NULL,
    nombre character varying(128) NOT NULL
);


ALTER TABLE public.tipo_valor OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 70346)
-- Dependencies: 179 5
-- Name: tipo_valor_id_tipo_valor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipo_valor_id_tipo_valor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_valor_id_tipo_valor_seq OWNER TO postgres;

--
-- TOC entry 2147 (class 0 OID 0)
-- Dependencies: 180
-- Name: tipo_valor_id_tipo_valor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipo_valor_id_tipo_valor_seq OWNED BY tipo_valor.id_tipo_valor;


--
-- TOC entry 181 (class 1259 OID 70348)
-- Dependencies: 5
-- Name: unidad_medida; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE unidad_medida (
    nombre character varying(128) NOT NULL,
    id_unidad_medida integer NOT NULL,
    simbolo character varying(5) NOT NULL
);


ALTER TABLE public.unidad_medida OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 71831)
-- Dependencies: 181 5
-- Name: unidad_medida_id_unidad_medida_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE unidad_medida_id_unidad_medida_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.unidad_medida_id_unidad_medida_seq OWNER TO postgres;

--
-- TOC entry 2148 (class 0 OID 0)
-- Dependencies: 188
-- Name: unidad_medida_id_unidad_medida_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE unidad_medida_id_unidad_medida_seq OWNED BY unidad_medida.id_unidad_medida;


--
-- TOC entry 182 (class 1259 OID 70351)
-- Dependencies: 1911 5
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    id_usuario integer NOT NULL,
    login character varying(64) NOT NULL,
    password character varying(256) NOT NULL,
    apellido character varying(64),
    nombre character varying(64),
    email character varying(128) NOT NULL,
    cambiar_pwd boolean DEFAULT false,
    tiempo_login integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 70358)
-- Dependencies: 5 182
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 2149 (class 0 OID 0)
-- Dependencies: 183
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuario_id_usuario_seq OWNED BY usuario.id_usuario;


--
-- TOC entry 184 (class 1259 OID 70360)
-- Dependencies: 5
-- Name: usuario_rol; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario_rol (
    id_usuario integer NOT NULL,
    id_rol integer NOT NULL
);


ALTER TABLE public.usuario_rol OWNER TO postgres;

--
-- TOC entry 1904 (class 2604 OID 70386)
-- Dependencies: 164 162
-- Name: id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente ALTER COLUMN id_cliente SET DEFAULT nextval('cliente_id_cliente_seq'::regclass);


--
-- TOC entry 1921 (class 2604 OID 71919)
-- Dependencies: 196 195 196
-- Name: id_detalle_presupuesto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalle_presupuesto ALTER COLUMN id_detalle_presupuesto SET DEFAULT nextval('detalle_presupuesto_id_detalle_presupuesto_seq'::regclass);


--
-- TOC entry 1922 (class 2604 OID 71949)
-- Dependencies: 198 197 198
-- Name: id_pedido; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido ALTER COLUMN id_pedido SET DEFAULT nextval('pedido_id_pedido_seq'::regclass);


--
-- TOC entry 1906 (class 2604 OID 70410)
-- Dependencies: 171 170
-- Name: id_permiso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY permiso ALTER COLUMN id_permiso SET DEFAULT nextval('permiso_id_permiso_seq'::regclass);


--
-- TOC entry 1917 (class 2604 OID 71933)
-- Dependencies: 192 191 192
-- Name: id_presupuesto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY presupuesto ALTER COLUMN id_presupuesto SET DEFAULT nextval('presupuesto_id_presupuesto_seq'::regclass);


--
-- TOC entry 1919 (class 2604 OID 71906)
-- Dependencies: 194 193 194
-- Name: id_presupuesto_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY presupuesto_estado ALTER COLUMN id_presupuesto_estado SET DEFAULT nextval('presupuesto_estado_id_presupuesto_estado_seq'::regclass);


--
-- TOC entry 1914 (class 2604 OID 71828)
-- Dependencies: 187 186 187
-- Name: id_producto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto ALTER COLUMN id_producto SET DEFAULT nextval('producto_id_producto_seq'::regclass);


--
-- TOC entry 1916 (class 2604 OID 71857)
-- Dependencies: 189 190 190
-- Name: id_responsabilidad_iva; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY responsabilidad_iva ALTER COLUMN id_responsabilidad_iva SET DEFAULT nextval('responsablilidad_iva_id_responsabilidad_iva_seq'::regclass);


--
-- TOC entry 1907 (class 2604 OID 70414)
-- Dependencies: 176 173
-- Name: id_rol; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rol ALTER COLUMN id_rol SET DEFAULT nextval('rol_id_rol_seq'::regclass);


--
-- TOC entry 1908 (class 2604 OID 70415)
-- Dependencies: 175 174
-- Name: id_rol_ambito; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rol_ambito ALTER COLUMN id_rol_ambito SET DEFAULT nextval('rol_ambito_id_rol_ambito_seq'::regclass);


--
-- TOC entry 1909 (class 2604 OID 70452)
-- Dependencies: 180 179
-- Name: id_tipo_valor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipo_valor ALTER COLUMN id_tipo_valor SET DEFAULT nextval('tipo_valor_id_tipo_valor_seq'::regclass);


--
-- TOC entry 1910 (class 2604 OID 71833)
-- Dependencies: 188 181
-- Name: id_unidad_medida; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY unidad_medida ALTER COLUMN id_unidad_medida SET DEFAULT nextval('unidad_medida_id_unidad_medida_seq'::regclass);


--
-- TOC entry 1912 (class 2604 OID 70453)
-- Dependencies: 183 182
-- Name: id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario ALTER COLUMN id_usuario SET DEFAULT nextval('usuario_id_usuario_seq'::regclass);


--
-- TOC entry 2088 (class 0 OID 69798)
-- Dependencies: 162 2125
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente (id_cliente, nombre, apellido, email, domicilio, telefono, fecha_creacion, id_cliente_estado, id_localidad, id_responsabilidad_iva, cuit, borrado) FROM stdin;
5	Soledad	Alám	sole.alam@gmail.com	Rodriguez del Busto 4023	0351156696960	2015-03-15 12:40:44.112	act	4	1		f
6	Pablo	Marengo	pabloma4@gmail.com	San Martín 108	0351153269278	2015-03-15 12:41:18.021	act	2	3	30-26728222-2	f
9	Horacio	Gómez	hgomez@hotmail.com	9 de Julio 1546	0353-4562899	2015-03-15 23:51:17.554	act	1	\N	\N	t
13	Guido	Fonseca				2015-07-13 13:42:56.045	act	3	3		f
12	Norberto	Fonseca				2015-07-13 13:42:36.449	act	3	3		f
14	Ramiro	Gutierrez				2015-07-13 13:46:50.97	act	\N	\N		f
15	Rubén	Rolón	rrolon@gmail.com	Santa Fé 1514		2015-07-13 13:55:41.095	act	2	2		f
11	Romeo	Santo	rsanto@gmail.com	Lavalleja 499		2015-03-28 09:38:53.554	act	2	3		f
10	Mateo 	Palmieri	mpalmieri@fm2000.com	Liniers 789	0353-4576282	2015-03-17 00:02:12.571	act	1	2	30-29282821-2	f
16	Ricardo	Alberti				2015-07-13 15:45:39.472	act	1	1		t
\.


--
-- TOC entry 2089 (class 0 OID 69804)
-- Dependencies: 163 2125
-- Data for Name: cliente_estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY cliente_estado (id_cliente_estado, nombre, descripcion) FROM stdin;
act	activo	Cliente activo.
ina	inactivo	Cliente inactivo.
\.


--
-- TOC entry 2150 (class 0 OID 0)
-- Dependencies: 164
-- Name: cliente_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('cliente_id_cliente_seq', 16, true);


--
-- TOC entry 2122 (class 0 OID 71916)
-- Dependencies: 196 2125
-- Data for Name: detalle_presupuesto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detalle_presupuesto (id_detalle_presupuesto, id_producto, cantidad, precio_unitario, id_presupuesto) FROM stdin;
36	9	2	1200	16
37	8	1	1500	16
41	5	10	165	17
42	8	5	1100	17
39	9	10	1200	17
45	10	1	382.5	18
46	5	2	850	18
47	12	15	3300	19
48	13	2	2900	19
49	14	1	800	19
50	14	4.2000000000000002	80	15
33	5	2.7000000000000002	170	15
52	14	1	80	20
53	7	1	7.5	21
54	14	5	80	21
55	11	1.8	850	15
56	8	1.76	1500	22
57	15	1.22	2550	22
\.


--
-- TOC entry 2151 (class 0 OID 0)
-- Dependencies: 195
-- Name: detalle_presupuesto_id_detalle_presupuesto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('detalle_presupuesto_id_detalle_presupuesto_seq', 57, true);


--
-- TOC entry 2152 (class 0 OID 0)
-- Dependencies: 165
-- Name: id_operacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('id_operacion_seq', 1, false);


--
-- TOC entry 2153 (class 0 OID 0)
-- Dependencies: 166
-- Name: importar_tipo_pago_svt_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('importar_tipo_pago_svt_seq', -1, false);


--
-- TOC entry 2111 (class 0 OID 71806)
-- Dependencies: 185 2125
-- Data for Name: localidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY localidad (id_localidad, nombre) FROM stdin;
1	Hernando
2	Pampayasta
3	Dalmacio Velez Sarfield
4	Villa María
\.


--
-- TOC entry 2093 (class 0 OID 69975)
-- Dependencies: 167 2125
-- Data for Name: parametro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY parametro (id_parametro, clave, valor, descripcion) FROM stdin;
\.


--
-- TOC entry 2154 (class 0 OID 0)
-- Dependencies: 168
-- Name: parametro_id_parametro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('parametro_id_parametro_seq', 11, true);


--
-- TOC entry 2124 (class 0 OID 71946)
-- Dependencies: 198 2125
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pedido (id_pedido, fecha_hora_pedido, fecha_hora_impresion, fecha_hora_fin_pedido, id_usuario_pedido, id_usuario_impresion, id_usuario_fin_pedido, id_pedido_estado) FROM stdin;
\.


--
-- TOC entry 2095 (class 0 OID 69987)
-- Dependencies: 169 2125
-- Data for Name: pedido_estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pedido_estado (id_pedido_estado, nombre, descripcion) FROM stdin;
PED	Pedido	\N
IMP	Impreso	\N
CNF	Confirmado	\N
CAN	Cancelado	\N
\.


--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 197
-- Name: pedido_id_pedido_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pedido_id_pedido_seq', 1, false);


--
-- TOC entry 2096 (class 0 OID 69992)
-- Dependencies: 170 2125
-- Data for Name: permiso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY permiso (id_permiso, nombre, menu_nombre, menu_orden, menu_link, id_padre) FROM stdin;
1	ADM_CATEGORIA	\N	\N	\N	\N
2	ADM_EVENTO	\N	\N	\N	\N
3	ADM_SHOW	\N	\N	\N	\N
4	ADM_COMPLEJO	\N	\N	\N	\N
5	ADM_PRODUCTOR	\N	\N	\N	\N
6	ADM_MEDIO_PAGO	\N	\N	\N	\N
7	ADM_SUCURSAL	\N	\N	\N	\N
8	ADM_SVT	\N	\N	\N	\N
9	ADM_USUARIO	\N	\N	\N	\N
10	CONSULTAR_RECAUDACION	\N	\N	\N	\N
\.


--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 171
-- Name: permiso_id_permiso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('permiso_id_permiso_seq', 10, true);


--
-- TOC entry 2098 (class 0 OID 69997)
-- Dependencies: 172 2125
-- Data for Name: permiso_rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY permiso_rol (id_rol, id_permiso) FROM stdin;
11	1
11	2
11	3
11	4
11	5
11	6
11	7
11	8
11	9
12	10
\.


--
-- TOC entry 2118 (class 0 OID 71885)
-- Dependencies: 192 2125
-- Data for Name: presupuesto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY presupuesto (id_presupuesto, id_cliente, id_presupuesto_estado, fecha_creacion, fecha_modificacion, fecha_valido_hasta, borrado) FROM stdin;
16	5	1	2015-05-18	2015-05-18	2015-05-20	t
15	11	1	2015-05-17	2015-08-17	2015-05-19	f
17	6	1	2015-06-20	2015-08-17	2015-06-23	f
19	5	1	2015-06-21	2015-08-17	2015-06-21	f
20	12	1	2015-08-10	2015-08-17	2015-08-13	f
18	9	1	2015-06-21	2015-08-17	2015-06-30	f
22	15	1	2015-08-17	2015-08-17	2015-08-17	f
21	13	1	2015-08-10	2015-08-17	2015-08-28	f
\.


--
-- TOC entry 2120 (class 0 OID 71903)
-- Dependencies: 194 2125
-- Data for Name: presupuesto_estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY presupuesto_estado (id_presupuesto_estado, nombre, descripcion) FROM stdin;
1	CREADO	\N
2	APROBADO	\N
3	NO APROBADO	\N
4	CANCELADO	\N
\.


--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 193
-- Name: presupuesto_estado_id_presupuesto_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('presupuesto_estado_id_presupuesto_estado_seq', 1, false);


--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 191
-- Name: presupuesto_id_presupuesto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('presupuesto_id_presupuesto_seq', 22, true);


--
-- TOC entry 2113 (class 0 OID 71820)
-- Dependencies: 187 2125
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY producto (id_producto, nombre, descripcion, precio, cantidad, id_unidad_medida, fecha_creacion, fecha_modificacion, borrado) FROM stdin;
7	Melamina Transp	Melamina Transparente de 5x4 mts.	150	20	3	13:36:34.055	\N	f
8	Mueble Bajo Mesada	Mueble Bajo Mesada	1500	1	2	22:40:51.535	\N	f
9	Placard Dormitorio	Placard 4 puertas	1200	1	2	19:54:04.024	\N	f
10	Melamina Gris	Melamina Gris	382.5	15	3	11:42:27.268	\N	f
11	Melamina Blanca 15 mm	Melamina Blanca 15 mm	850	1	1	19:04:01.442	\N	f
13	Banitoris	Mueble banitori en melamina	2900	1	2	19:27:50.446	19:34:34.431	f
14	Corredera Telescópica	Corredera Telescópica	800	10	1	19:45:59.071	\N	f
15	Modular	Modular en melamina blanca con correderas telescópicas.	2550	1	2	14:14:04.182	14:15:43.788	f
12	Amoblamiento de Cocina	Amoblamiento de Cocina en Melamina Blanca para interior y de color para frente, puertas y cajones.\r\nCorrederas telescópicas, bisagras cazoletas, hidraulicos, etc.	3300	1	2	19:05:45.752	19:15:40.477	f
18	Modular Melamina	Modular Melamina	0	1	3	15:46:39.449	\N	t
5	Melamina Blanca	Melamina Blanca	935	5.5	3	13:21:39.258	07:44:04.273	f
\.


--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 186
-- Name: producto_id_producto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('producto_id_producto_seq', 18, true);


--
-- TOC entry 2116 (class 0 OID 71854)
-- Dependencies: 190 2125
-- Data for Name: responsabilidad_iva; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY responsabilidad_iva (id_responsabilidad_iva, descripcion) FROM stdin;
1	Responsable Inscripto
2	Responsable No Inscripto
3	Consumidor Final
\.


--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 189
-- Name: responsablilidad_iva_id_responsabilidad_iva_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('responsablilidad_iva_id_responsabilidad_iva_seq', 3, true);


--
-- TOC entry 2099 (class 0 OID 70040)
-- Dependencies: 173 2125
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY rol (id_rol, nombre, descripcion, id_rol_ambito) FROM stdin;
1	Cajero	Cajero del Punto de Venta (fiscal).	1
2	Supervisor	Supervisor del Punto de Venta (fiscal).	1
3	administrador	Administrador (SVT).	2
4	supervisor	Supervisor (SVT).	2
5	vendedor	Vendedor (SVT).	2
6	productor	Productor (SVT).	2
7	acreditacion	Acreditacion (SVT).	2
8	autorizador	Autorizador (SVT).	2
9	control	Control (SVT).	2
10	organizacion	Organizacion (SVT).	2
11	Administrador	Administrador del Servidor Central	3
12	Responsable Comercial	Responsable Comercial de Autoentrada	3
\.


--
-- TOC entry 2100 (class 0 OID 70043)
-- Dependencies: 174 2125
-- Data for Name: rol_ambito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY rol_ambito (id_rol_ambito, descripcion) FROM stdin;
1	Punto de Venta Fiscal
2	SVT
3	Servidor Central
\.


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 175
-- Name: rol_ambito_id_rol_ambito_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('rol_ambito_id_rol_ambito_seq', 3, true);


--
-- TOC entry 2162 (class 0 OID 0)
-- Dependencies: 176
-- Name: rol_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('rol_id_rol_seq', 100, true);


--
-- TOC entry 2163 (class 0 OID 0)
-- Dependencies: 177
-- Name: ticket_ubicacion_numerada_id_ticket_ubicacion_numerada_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ticket_ubicacion_numerada_id_ticket_ubicacion_numerada_seq', 1, false);


--
-- TOC entry 2104 (class 0 OID 70320)
-- Dependencies: 178 2125
-- Data for Name: tipo_doc_identidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_doc_identidad (id_tipo_doc_identidad, nombre, descripcion) FROM stdin;
DNI	Documento Nacional de Identidad	
CI	Cédula de Identidad	
LC	Libreta Cívica	
LE	Libreta de Enrolamiento	
PAS	Pasaporte	
MGN	Cliente Portal Web	
\.


--
-- TOC entry 2105 (class 0 OID 70343)
-- Dependencies: 179 2125
-- Data for Name: tipo_valor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipo_valor (id_tipo_valor, nombre) FROM stdin;
1	Monto
2	Porcentaje
3	Monto Fijo
\.


--
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 180
-- Name: tipo_valor_id_tipo_valor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipo_valor_id_tipo_valor_seq', 3, true);


--
-- TOC entry 2107 (class 0 OID 70348)
-- Dependencies: 181 2125
-- Data for Name: unidad_medida; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY unidad_medida (nombre, id_unidad_medida, simbolo) FROM stdin;
Metro Cuadrado(m²)	3	m²
Metro Lineal(m)	2	m
Unidad(u)	1	u
\.


--
-- TOC entry 2165 (class 0 OID 0)
-- Dependencies: 188
-- Name: unidad_medida_id_unidad_medida_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('unidad_medida_id_unidad_medida_seq', 3, true);


--
-- TOC entry 2108 (class 0 OID 70351)
-- Dependencies: 182 2125
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (id_usuario, login, password, apellido, nombre, email, cambiar_pwd, tiempo_login) FROM stdin;
1	admin@autoentrada.com		Autoentrada	Administrador		f	-1
2	v1		Oficina	Vendedor		f	-1
3	vendedorInternet		Internet	Venta		f	-1
4	solmos@autoentrada.com		Patio Olmos	Supervisor		f	-1
5	volmos@autoentrada.com		Patio Olmos	Vendedor		f	-1
6	snuevocentro@autoentrada.com		Nuevo Centro	Supervisor		f	-1
7	vnuevocentro@autoentrada.com		Nuevo Centro	Vendedor		f	-1
8	ssanti@autoentrada.com		Cba Shopping	Supervisor		f	-1
9	vsanti@autoentrada.com		Cba Shopping	Vendedor		f	-1
10	saraceli		ARACELI	Supervisor		f	-1
11	varaceli		ARACELI	Vendedor		f	-1
12	sriocuarto		Rio Cuarto	Supervisor		f	-1
13	vriocuarto		Rio Cuarto	Vendedor		f	-1
14	descuento		Descuento	Descuento		f	-1
15	eugenia.ralph@autoentrada.com		Ralph	Eugenia	eugenia.ralph@autoentrada.com	f	-1
16	julietaverdu		Julieta Verdu	Agencia 2014		f	-1
17	lauramontoya		Laura Montoya	Agencia 2014		f	-1
18	pamelamurua		Pamela Murua	Agencia 2014		f	-1
19	anaguevara		Analia Guevara	Agencia 2014		f	-1
20	mariboero		Maria Boero	Agencia 2014		f	-1
21	maxi		Pita	Maximiliano 		f	-1
22	lisandro.scalenghe@autoentrada.com	aepwd	Scalenghe	Lisandro	lisandro.scalenghe@autoentrada.com	f	-1
101	cajero_1_pdv	cjr1	(PDV)	Cajero 1	cajero1pdv@autoentrada.com	f	-1
102	cajero_2_pdv	cjr2	(PDV)	Cajero 2	cajero2pdv@autoentrada.com	f	-1
103	cajero_3_pdv	cjr3	(PDV)	Cajero 3	cajero3pdv@autoentrada.com	f	-1
104	admin_1_pdv	sprvsr1	(PDV)	Supervisor 1	supervisor1pdv@autoentrada.com	f	-1
105	admin_2_pdv	sprvsr2	(PDV)	Supervisor 2	supervisor2pdv@autoentrada.com	f	-1
106	admin_3_pdv	sprvsr3	(PDV)	Supervisor 3	supervisor3pdv@autoentrada.com	f	-1
\.


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 183
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuario_id_usuario_seq', 1000, true);


--
-- TOC entry 2110 (class 0 OID 70360)
-- Dependencies: 184 2125
-- Data for Name: usuario_rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario_rol (id_usuario, id_rol) FROM stdin;
1	3
2	5
3	5
4	4
5	5
6	4
7	5
8	4
9	5
10	4
11	5
12	4
13	5
14	6
15	3
16	6
17	6
18	6
19	6
20	6
21	6
22	12
101	1
102	1
103	1
104	2
105	2
106	2
\.


--
-- TOC entry 1927 (class 2606 OID 70468)
-- Dependencies: 163 163 2126
-- Name: cliente_estado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente_estado
    ADD CONSTRAINT cliente_estado_pkey PRIMARY KEY (id_cliente_estado);


--
-- TOC entry 1924 (class 2606 OID 70470)
-- Dependencies: 162 162 2126
-- Name: cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 1964 (class 2606 OID 71908)
-- Dependencies: 194 194 2126
-- Name: cliente_presupuesto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY presupuesto_estado
    ADD CONSTRAINT cliente_presupuesto_pkey PRIMARY KEY (id_presupuesto_estado);


--
-- TOC entry 1966 (class 2606 OID 71922)
-- Dependencies: 196 196 2126
-- Name: detalle_presupuesto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_presupuesto
    ADD CONSTRAINT detalle_presupuesto_pk PRIMARY KEY (id_detalle_presupuesto);


--
-- TOC entry 1956 (class 2606 OID 71810)
-- Dependencies: 185 185 2126
-- Name: localidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY localidad
    ADD CONSTRAINT localidad_pkey PRIMARY KEY (id_localidad);


--
-- TOC entry 1929 (class 2606 OID 70524)
-- Dependencies: 167 167 2126
-- Name: parametro_clave_unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parametro
    ADD CONSTRAINT parametro_clave_unique UNIQUE (clave);


--
-- TOC entry 1931 (class 2606 OID 70526)
-- Dependencies: 167 167 2126
-- Name: parametro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY parametro
    ADD CONSTRAINT parametro_pkey PRIMARY KEY (id_parametro);


--
-- TOC entry 1933 (class 2606 OID 70528)
-- Dependencies: 169 169 2126
-- Name: pedido_estado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pedido_estado
    ADD CONSTRAINT pedido_estado_pkey PRIMARY KEY (id_pedido_estado);


--
-- TOC entry 1968 (class 2606 OID 71952)
-- Dependencies: 198 198 2126
-- Name: pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id_pedido);


--
-- TOC entry 1935 (class 2606 OID 70532)
-- Dependencies: 170 170 2126
-- Name: permiso_nombre_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permiso
    ADD CONSTRAINT permiso_nombre_key UNIQUE (nombre);


--
-- TOC entry 1937 (class 2606 OID 70534)
-- Dependencies: 170 170 2126
-- Name: permiso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permiso
    ADD CONSTRAINT permiso_pkey PRIMARY KEY (id_permiso);


--
-- TOC entry 1939 (class 2606 OID 70536)
-- Dependencies: 172 172 172 2126
-- Name: permiso_rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY permiso_rol
    ADD CONSTRAINT permiso_rol_pkey PRIMARY KEY (id_rol, id_permiso);


--
-- TOC entry 1962 (class 2606 OID 71890)
-- Dependencies: 192 192 2126
-- Name: presupuesto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY presupuesto
    ADD CONSTRAINT presupuesto_pkey PRIMARY KEY (id_presupuesto);


--
-- TOC entry 1958 (class 2606 OID 71830)
-- Dependencies: 187 187 2126
-- Name: producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id_producto);


--
-- TOC entry 1960 (class 2606 OID 71859)
-- Dependencies: 190 190 2126
-- Name: responsabilidad_iva_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY responsabilidad_iva
    ADD CONSTRAINT responsabilidad_iva_pkey PRIMARY KEY (id_responsabilidad_iva);


--
-- TOC entry 1943 (class 2606 OID 70554)
-- Dependencies: 174 174 2126
-- Name: rol_ambito_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY rol_ambito
    ADD CONSTRAINT rol_ambito_pkey PRIMARY KEY (id_rol_ambito);


--
-- TOC entry 1941 (class 2606 OID 70556)
-- Dependencies: 173 173 2126
-- Name: rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id_rol);


--
-- TOC entry 1945 (class 2606 OID 70674)
-- Dependencies: 178 178 2126
-- Name: tipo_doc_identidad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_doc_identidad
    ADD CONSTRAINT tipo_doc_identidad_pkey PRIMARY KEY (id_tipo_doc_identidad);


--
-- TOC entry 1947 (class 2606 OID 70684)
-- Dependencies: 179 179 2126
-- Name: tipo_valor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_valor
    ADD CONSTRAINT tipo_valor_pkey PRIMARY KEY (id_tipo_valor);


--
-- TOC entry 1949 (class 2606 OID 71838)
-- Dependencies: 181 181 2126
-- Name: unidad_medida_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY unidad_medida
    ADD CONSTRAINT unidad_medida_pkey PRIMARY KEY (id_unidad_medida);


--
-- TOC entry 1952 (class 2606 OID 70688)
-- Dependencies: 182 182 2126
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 1954 (class 2606 OID 70690)
-- Dependencies: 184 184 184 2126
-- Name: usuario_rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario_rol
    ADD CONSTRAINT usuario_rol_pkey PRIMARY KEY (id_usuario, id_rol);


--
-- TOC entry 1925 (class 1259 OID 71865)
-- Dependencies: 162 2126
-- Name: fki_cliente_fk_3; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_cliente_fk_3 ON cliente USING btree (id_responsabilidad_iva);


--
-- TOC entry 1950 (class 1259 OID 71776)
-- Dependencies: 182 2126
-- Name: idx_usuario_login; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX idx_usuario_login ON usuario USING btree (login);


--
-- TOC entry 1969 (class 2606 OID 70727)
-- Dependencies: 162 1926 163 2126
-- Name: cliente_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_fk_1 FOREIGN KEY (id_cliente_estado) REFERENCES cliente_estado(id_cliente_estado) DEFERRABLE;


--
-- TOC entry 1970 (class 2606 OID 71811)
-- Dependencies: 162 185 1955 2126
-- Name: cliente_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_fk_2 FOREIGN KEY (id_localidad) REFERENCES localidad(id_localidad) DEFERRABLE;


--
-- TOC entry 1971 (class 2606 OID 71860)
-- Dependencies: 162 190 1959 2126
-- Name: cliente_fk_3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT cliente_fk_3 FOREIGN KEY (id_responsabilidad_iva) REFERENCES responsabilidad_iva(id_responsabilidad_iva);


--
-- TOC entry 1981 (class 2606 OID 71923)
-- Dependencies: 196 1957 187 2126
-- Name: detalle_presupuesto_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalle_presupuesto
    ADD CONSTRAINT detalle_presupuesto_fk_1 FOREIGN KEY (id_producto) REFERENCES producto(id_producto);


--
-- TOC entry 1982 (class 2606 OID 71928)
-- Dependencies: 1961 196 192 2126
-- Name: detalle_presupuesto_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detalle_presupuesto
    ADD CONSTRAINT detalle_presupuesto_fk_2 FOREIGN KEY (id_presupuesto) REFERENCES presupuesto(id_presupuesto);


--
-- TOC entry 1986 (class 2606 OID 71953)
-- Dependencies: 198 1932 169 2126
-- Name: pedido_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_fk_1 FOREIGN KEY (id_pedido_estado) REFERENCES pedido_estado(id_pedido_estado) DEFERRABLE;


--
-- TOC entry 1985 (class 2606 OID 71958)
-- Dependencies: 1951 182 198 2126
-- Name: pedido_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_fk_2 FOREIGN KEY (id_usuario_fin_pedido) REFERENCES usuario(id_usuario) DEFERRABLE;


--
-- TOC entry 1984 (class 2606 OID 71963)
-- Dependencies: 198 182 1951 2126
-- Name: pedido_fk_3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_fk_3 FOREIGN KEY (id_usuario_impresion) REFERENCES usuario(id_usuario) DEFERRABLE;


--
-- TOC entry 1983 (class 2606 OID 71968)
-- Dependencies: 198 1951 182 2126
-- Name: pedido_fk_4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_fk_4 FOREIGN KEY (id_usuario_pedido) REFERENCES usuario(id_usuario) DEFERRABLE;


--
-- TOC entry 1972 (class 2606 OID 70987)
-- Dependencies: 1936 170 170 2126
-- Name: permiso_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY permiso
    ADD CONSTRAINT permiso_fk_2 FOREIGN KEY (id_padre) REFERENCES permiso(id_permiso) DEFERRABLE;


--
-- TOC entry 1973 (class 2606 OID 70992)
-- Dependencies: 170 1936 172 2126
-- Name: permiso_rol_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY permiso_rol
    ADD CONSTRAINT permiso_rol_fk_1 FOREIGN KEY (id_permiso) REFERENCES permiso(id_permiso) DEFERRABLE;


--
-- TOC entry 1974 (class 2606 OID 70997)
-- Dependencies: 173 172 1940 2126
-- Name: permiso_rol_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY permiso_rol
    ADD CONSTRAINT permiso_rol_fk_2 FOREIGN KEY (id_rol) REFERENCES rol(id_rol) DEFERRABLE;


--
-- TOC entry 1979 (class 2606 OID 71891)
-- Dependencies: 162 1923 192 2126
-- Name: presupuesto_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY presupuesto
    ADD CONSTRAINT presupuesto_fk_1 FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente);


--
-- TOC entry 1980 (class 2606 OID 71909)
-- Dependencies: 192 1963 194 2126
-- Name: presupuesto_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY presupuesto
    ADD CONSTRAINT presupuesto_fk_2 FOREIGN KEY (id_presupuesto_estado) REFERENCES presupuesto_estado(id_presupuesto_estado);


--
-- TOC entry 1978 (class 2606 OID 71839)
-- Dependencies: 187 181 1948 2126
-- Name: producto_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT producto_fk_1 FOREIGN KEY (id_unidad_medida) REFERENCES unidad_medida(id_unidad_medida) DEFERRABLE;


--
-- TOC entry 1975 (class 2606 OID 71057)
-- Dependencies: 174 173 1942 2126
-- Name: rol_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rol
    ADD CONSTRAINT rol_fk_1 FOREIGN KEY (id_rol_ambito) REFERENCES rol_ambito(id_rol_ambito) DEFERRABLE;


--
-- TOC entry 1976 (class 2606 OID 71567)
-- Dependencies: 184 182 1951 2126
-- Name: usuario_rol_fk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario_rol
    ADD CONSTRAINT usuario_rol_fk_1 FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario) DEFERRABLE;


--
-- TOC entry 1977 (class 2606 OID 71572)
-- Dependencies: 184 173 1940 2126
-- Name: usuario_rol_fk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario_rol
    ADD CONSTRAINT usuario_rol_fk_2 FOREIGN KEY (id_rol) REFERENCES rol(id_rol) DEFERRABLE;


--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-10-05 07:43:03

--
-- PostgreSQL database dump complete
--

