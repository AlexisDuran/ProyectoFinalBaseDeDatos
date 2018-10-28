create database Rent
use Rent
create table Cliente(
	id_cliente int identity(1,1) primary key not null,
	nombre varchar(50) not null,
	rfc varchar(50) not null,
	direccion varchar(50) not null,
	telefono varchar(50) not null,
	correo varchar(50) not null
)
create table Laptop(
	id_lap int identity(1,1) primary key not null,
	estado varchar(50) not null,
	add_car int not null
)
create table Caracterisicas(
	id_activo int identity(1,1) primary key not null,
	marca varchar(50) NULL,
	model varchar(50) null, 
	es_cpu varchar(50) not null,
	es_ram varchar(50) not null,
	es_DD varchar(50) not null,
	es_TV varchar(50) null,
	serie varchar(50) not null,
)
create table Renter(
	id_user int identity(1,1) primary key not null,
	nombre varchar(50) not null,
	correo varchar(50) not null,
)
create table Venta(
	id_venta int identity(1,1) primary key not null,
	date_inicio datetime not null,
	date_fin datetime not null,
	join_cliente int,
	join_renter int,
	join_contrato int
)