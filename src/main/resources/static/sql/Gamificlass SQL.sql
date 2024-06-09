create database Gamificlass;

use Gamificlass;

create table Gamificlass.Estudiantes (
	Estudiante_id int not null auto_increment,
    Estudiante_nombre varchar(25) not null,
    Estudiante_apellido varchar(25) not null,
    Estudiante_puntaje long not null,
    primary key (Estudiante_id)
);

create table Gamificlass.Niveles (
	Nivel_id int not null auto_increment,
    Nivel_puntaje_inicio long not null,
    Nivel_puntaje_final long not null,
    Nivel_nivel int not null,
    primary key (Nivel_id)
);

create table Gamificlass.Actividades (
	Actividad_id int not null auto_increment,
    Actividad_descripcion varchar(50) not null,
    Actividad_puntaje_base long not null,
    Actividad_fecha timestamp not null,
    Actividad_racha double not null,
    Actividad_puntaje_final long not null,
    primary key(Actividad_id)
);

create table Gamificlass.Rachas (
	Racha_id int not null auto_increment,
    Racha_estudiante_id int not null,
    
);

create table Gamificlass.Asistencias (

);