create database Gamificlass;

use Gamificlass;

create table Gamificlass.Estudiantes (
	Estudiante_id int not null auto_increment,
    Estudiante_nombre varchar(25) not null,
    Estudiante_apellido varchar(25) not null,
    Estudiante_puntaje long not null,
    Estudiante_nivel int not null,
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
    Actividad_estudiante_id int not null,
    Actividad_descripcion varchar(50) not null,
    Actividad_puntaje_base long not null,
    Actividad_fecha timestamp not null,
    Actividad_racha double not null,
    Actividad_puntaje_final long not null,
    primary key(Actividad_id),
    foreign key (Actividad_estudiante_id) references Gamificlass.Estudiantes (Estudiante_id)
    
);

create table Gamificlass.Rachas (
	Racha_id int not null auto_increment,
    Racha_estudiante_id int not null,
    Racha_racha double not null,
    primary key (Racha_id),
    foreign key (Racha_estudiante_id) references Gamificlass.Estudiantes (Estudiante_id)
);

create table Gamificlass.Asistencias (
	Asistencia_id int not null auto_increment,
    Asistencia_estudiante_id int not null,
    Asistencia_fecha date not null,
    Asistencia_estado varchar(1) not null,
    primary key (Asistencia_id),
    foreign key (Asistencia_estudiante_id) references Gamificlass.Estudiantes (Estudiante_id)
);

create table Gamificlass.Asignaturas (
	Asignatura_id int not null auto_increment,
    Asignatura_nombre varchar(40) not null,
    Asignatura_inicio date,
    primary key (Asignatura_id)
);

insert into Gamificlass.Asignaturas (Asignatura_nombre, Asignatura_inicio) value
('Armonia II', '2024-05-23');

create table Gamificlass.Estudiante_tiene_Asignatura (
	Estudiante_Asignatura_id int not null auto_increment,
    Estudiante_id int not null,
    Asignatura_id int not null,
    primary key (Estudiante_Asignatura_id),
    foreign key (Estudiante_id) references Gamificlass.Estudiantes (Estudiante_id),
    foreign key (Asignatura_id) references Gamificlass.Asignaturas (Asignatura_id)
);

insert into Gamificlass.Estudiantes (Estudiante_nombre, Estudiante_apellido, Estudiante_puntaje, Estudiante_nivel) value
('José','Angulo',0,1),
('Benjamín','Cornejo',0,1),
('Lucas','Cabello',0,1),
('Danae','Pereira',0,1),
('Ilians','Robles',0,1),
('Anaís','Silva',0,1);

insert into Gamificlass.Estudiante_tiene_Asignatura (Estudiante_id, Asignatura_id) value
(1,1),
(2,1),
(3,1),
(4,1),
(5,1),
(6,1);

insert into Gamificlass.Rachas (Racha_estudiante_id,Racha_racha) value
(1,1),
(2,1),
(3,1),
(4,1),
(5,1),
(6,1);

insert into Gamificlass.Niveles (Nivel_puntaje_inicio, Nivel_puntaje_final, Nivel_nivel) value
(0,299,1),
(300,599,2),
(600,1099,3),
(1100,1699,4),
(1700,2299,5),
(2300,4199,6),
(4200,5999,7),
(6000,7349,8),
(7350,9929,9),
(9930,11799,10),
(11800,15599,11),
(15600,19599,12),
(19600,23699,13),
(23700,26399,14),
(26400,30499,15),
(30500,35399,16),
(35400,40499,17),
(40500,45699,18),
(45700,50999,19),
(51000,56599,20),
(56600,63899,21),
(63900,71399,22),
(71400,79099,23),
(79100,87099,24),
(87100,95199,25),
(95200,109799,26),
(109800,124799,27),
(124800,140199,28),
(140200,155899,29),
(155900,162499,30),
(162500,175899,31),
(175900,189599,32),
(189600,203499,33),
(203500,217899,34),
(217900,232319,35),
(232320,249899,36),
(249900,267799,37),
(267800,286199,38),
(286200,304899,39),
(304900,323999,40),
(324000,340199,41),
(340200,356799,42),
(356800,373699,43),
(373700,390799,44),
(390800,408199,45),
(408200,437599,46),
(437600,467499,47),
(467500,497999,48),
(498000,528999,49),
(529000,863999,50);