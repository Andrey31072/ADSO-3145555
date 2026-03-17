-- Database: cafetin_postre

-- DROP DATABASE IF EXISTS cafetin_postre;

CREATE DATABASE "cafetin_postre";

\c "cafetin_postre";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE type_document (
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	name varchar(50) NOT NULL,
	description TEXT,

	created_at TIMESTAMPTZ DEFAULT NOW(),
	updated_at TIMESTAMPTZ,
	deleted_at TIMESTAMPTZ,
	status BOOLEAN DEFAULT TRUE
);


CREATE TABLE person(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	type_document_id UUID,
	document_number VARCHAR(50) UNIQUE,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	email VARCHAR(150),
	phone VARCHAR(15),

	created_at TIMESTAMPTZ DEFAULT NOW(),
	updated_at TIMESTAMPTZ,
	deleted_at TIMESTAMPTZ,
	status BOOLEAN DEFAULT TRUE,

	CONSTRAINT fk_person_document 
		FOREIGN KEY(type_document_id) REFERENCES type_document(id)
);


CREATE TABLE roles(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	name_role VARCHAR(50) NOT NULL
	description TEXT
);

CREATE TABLE modules(
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	name_module VARCHAR(50) NOT NULL
);

CREATE TABLE "view" (
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	modules_id UUID,
	name_view VARCHAR(80),
	route VARCHAR(150),

	FOREIGN KEY (modules_id) REFERENCES modules(id)
);

CREATE TABLE users (
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	person_id UUID UNIQUE,
	username VARCHAR(50) UNIQUE,
	password VARCHAR(200),

	FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE user_role (
    users_id UUID,
    roles_id UUID,

    PRIMARY KEY(users_id, roles_id),

    FOREIGN KEY (users_id) REFERENCES users(id),
    FOREIGN KEY (roles_id) REFERENCES roles(id)
);

CREATE TABLE module_view (
    modules_id UUID,
    view_id UUID,

    PRIMARY KEY(modules_id, view_id),

    FOREIGN KEY (modules_id) REFERENCES modules(id),
    FOREIGN KEY (view_id) REFERENCES "view"(id)
);

CREATE TABLE category (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(100)
);

CREATE TABLE product (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    category_id UUID,
    name VARCHAR(120),
    price NUMERIC(10,2),
    cost NUMERIC(10,2),

    FOREIGN KEY(category_id) REFERENCES category(id)
);

CREATE TABLE supplier (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    person_id UUID UNIQUE,
    company_name VARCHAR(120),

    FOREIGN KEY(person_id) REFERENCES person(id)
);

CREATE TABLE inventory (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    product_id UUID UNIQUE,
    supplier_id UUID,
    stock INT DEFAULT 0,
    min_stock INT DEFAULT 0,

    FOREIGN KEY(product_id) REFERENCES product(id),

    FOREIGN KEY(supplier_id) REFERENCES supplier(id)
);

CREATE TABLE customer (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    person_id UUID UNIQUE,

    FOREIGN KEY(person_id) REFERENCES person(id)
);


CREATE TABLE orders (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    customer_id UUID,
    order_date TIMESTAMPTZ DEFAULT NOW(),
    total NUMERIC(10,2),

    FOREIGN KEY(customer_id) REFERENCES customer(id)
);

CREATE TABLE order_item (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    orders_id UUID,
    product_id UUID,
    quantity INT,
    price NUMERIC(10,2),

    FOREIGN KEY(orders_id) REFERENCES orders(id),

    FOREIGN KEY(product_id) REFERENCES product(id)
);

CREATE TABLE method_payment (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(50)
);

CREATE TABLE invoice (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    orders_id UUID UNIQUE,
    invoice_date TIMESTAMPTZ DEFAULT NOW(),
    total NUMERIC(10,2),

    FOREIGN KEY(orders_id) REFERENCES orders(id)
);

CREATE TABLE invoice_item (
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    invoice_id UUID,
    product_id UUID,
    quantity INT,
    price NUMERIC(10,2),

    FOREIGN KEY(invoice_id) REFERENCES invoice(id),

    FOREIGN KEY(product_id) REFERENCES product(id)
);

CREATE TABLE payment (
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	invoice_id  UUID, 
	method_payment_id UUID,
	amount NUMERIC(10,2),
	payment_date TIMESTAMPTZ DEFUELT NOW(),

	FOREIGN KEY(invoice_id) REFERENCES invoice(id),
	FOREIGN KEY(method_payment_id) REFERENCES method_payment(id)

);

CREATE TABLE files (
	id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
	file_url TEXT,
	person_id UUID,
	product_id UUID,

	FOREIGN KEY(person_id) REFERENCES person(id),
	FOREIGN KEY(product_id) REFERENCES product(id)
);


INSERT INTO roles (id, name_role, description) VALUES
(uuid_generate_v4(),'Administrador','Control total del sistema'),
(uuid_generate_v4(),'Instructor','Usuario comprador con acceso a ventas'),
(uuid_generate_v4(),'Aprendiz','Usuario comprador con acceso limitado a ventas');

INSERT INTO modules (id, name_module) VALUES
(uuid_generate_v4(),'Security'),
(uuid_generate_v4(),'Parameter'),
(uuid_generate_v4(),'Inventory'),
(uuid_generate_v4(),'Sales'),
(uuid_generate_v4(),'Billing');


INSERT INTO type_document (id,name,description) VALUES
(uuid_generate_v4(),'CC','Cedula de ciudadania'),
(uuid_generate_v4(),'TI','Tarjeta de identidad'),
(uuid_generate_v4(),'CE','Cedula extranjera'),
(uuid_generate_v4(),'PAS','Pasaporte'),
(uuid_generate_v4(),'NIT','Numero tributario'),
(uuid_generate_v4(),'DL','Licencia conduccion'),
(uuid_generate_v4(),'RC','Registro civil'),
(uuid_generate_v4(),'PEP','Permiso especial permanencia'),
(uuid_generate_v4(),'DNI','Documento nacional identidad'),
(uuid_generate_v4(),'OTRO','Otro documento');


INSERT INTO category (id,name) VALUES
(uuid_generate_v4(),'Cafe caliente'),
(uuid_generate_v4(),'Cafe frio'),
(uuid_generate_v4(),'Postres'),
(uuid_generate_v4(),'Panaderia'),
(uuid_generate_v4(),'Bebidas'),
(uuid_generate_v4(),'Te'),
(uuid_generate_v4(),'Jugos'),
(uuid_generate_v4(),'Snacks'),
(uuid_generate_v4(),'Smoothies'),
(uuid_generate_v4(),'Accesorios');

INSERT INTO method_payment (id,name) VALUES
(uuid_generate_v4(),'Efectivo'),
(uuid_generate_v4(),'Tarjeta debito'),
(uuid_generate_v4(),'Tarjeta credito'),
(uuid_generate_v4(),'Nequi'),
(uuid_generate_v4(),'Daviplata'),
(uuid_generate_v4(),'Transferencia'),
(uuid_generate_v4(),'QR'),
(uuid_generate_v4(),'PayPal'),
(uuid_generate_v4(),'Apple Pay'),
(uuid_generate_v4(),'Google Pay');

INSERT INTO person
(id,type_document_id,document_number,first_name,last_name,email,phone)
SELECT
uuid_generate_v4(),
td.id,
'100'||generate_series,
'Nombre'||generate_series,
'Apellido'||generate_series,
'correo'||generate_series||'@mail.com',
'30000000'||generate_series
FROM generate_series(1,10), type_document td
LIMIT 10;

INSERT INTO user_role (users_id,roles_id)
SELECT u.id,r.id
FROM users u
JOIN roles r ON r.name_role='Administrador'
LIMIT 1;

CREATE TABLE role_module (
    roles_id UUID,
    modules_id UUID,

    PRIMARY KEY (roles_id, modules_id),

    FOREIGN KEY (roles_id) REFERENCES roles(id),
    FOREIGN KEY (modules_id) REFERENCES modules(id)
);

INSERT INTO role_module (roles_id, modules_id)
SELECT r.id, m.id
FROM roles r, modules m
WHERE r.name_role = 'Administrador';


INSERT INTO role_module (roles_id, modules_id)
SELECT r.id, m.id
FROM roles r
JOIN modules m ON m.name_module = 'Sales'
WHERE r.name_role = 'Instructor';

INSERT INTO role_module (roles_id, modules_id)
SELECT r.id, m.id
FROM roles r
JOIN modules m ON m.name_module = 'Sales'
WHERE r.name_role = 'Aprendiz';

SELECT 
r.name_role,
m.name_module
FROM role_module rm
JOIN roles r ON rm.roles_id = r.id
JOIN modules m ON rm.modules_id = m.id
ORDER BY r.name_role;




-- fUNTION


CREATE OR REPLACE FUNCTION calculate_order_total(p_order_id UUID)
RETURNS NUMERIC(10,2) AS $$
DECLARE
    total_order NUMERIC(10,2);
BEGIN
    SELECT SUM(quantity * price)
    INTO total_order
    FROM order_item
    WHERE orders_id = p_order_id;

    RETURN COALESCE(total_order, 0);
END;
$$ LANGUAGE plpgsql;


SELECT calculate_order_total('ID_DE_LA_ORDEN');


-- VISTA

CREATE OR REPLACE VIEW view_sales_summary AS
SELECT
    o.id AS order_id,
    o.order_date,
    
    p.first_name || ' ' || p.last_name AS customer_name,
    
    pr.name AS product_name,
    oi.quantity,
    oi.price,
    (oi.quantity * oi.price) AS subtotal,

    o.total

FROM orders o
JOIN customer c ON o.customer_id = c.id
JOIN person p ON c.person_id = p.id
JOIN order_item oi ON o.id = oi.orders_id
JOIN product pr ON oi.product_id = pr.id;

SELECT * FROM view_sales_summary;