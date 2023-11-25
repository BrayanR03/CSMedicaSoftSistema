create database DB_SistemasCitas;

use DB_SistemasCitas;

CREATE TABLE Usuario (
	UsuarioID int not null auto_increment,
	Usuario nvarchar(15) not null,
    Password nvarchar(15) not null,
    primary key(UsuarioID)
);

CREATE TABLE Empleado ( 
	EmpleadoID int not null AUTO_INCREMENT,
    EmpleadoDescripcion nvarchar(20) not null,
    UsuarioID int not null,
    primary key(EmpleadoID),
    foreign key(UsuarioID) references Usuario (UsuarioID)
);

CREATE TABLE Asistente (
	AsistenteID int not null AUTO_INCREMENT,
    AsistenteApellidos nvarchar(50) not null,
    AsistenteNombres nvarchar(50) not null,
    AsistenteFechaNacimiento date not null,
    AsistenteDni char(8) not null,
    AsistenteDireccion nvarchar(70) not null,
    AsistenteTelefono nvarchar(9) not null,
    AsistenteCorreo nvarchar(30) not null,
    EmpleadoID int null,
    primary key(AsistenteID),
    foreign key(EmpleadoID) references Empleado (EmpleadoID)
);

CREATE TABLE Odontologo (
	OdontologoID int not null auto_increment,
    OdontologoApellidos nvarchar(50) not null,
    OdontologoNombres nvarchar(50) not null,
    OdontologoFechaNacimiento date not null,
    OdontologoDni nvarchar(8) not null,
    OdontologoDireccion nvarchar(70) not null,
    OdontologoTelefono nvarchar(9) not null,
    OdontologoCorreo nvarchar(30) not null,
    EmpleadoID int null,
    primary key(OdontologoID),
    foreign key(EmpleadoID) references Empleado (EmpleadoID)
);

CREATE TABLE HorarioAtencion (
	HorarioAtencionID int not null auto_increment,
    HorarioAtencionEstado nvarchar(15) not null,
    HorarioAtencionFechaRegistro date not null,
    HorarioAtencionHoraInicio nvarchar(15) not null,
    HorarioAtencionHoraFin nvarchar(8) not null,
    OdontologoID int not null,
    primary key(HorarioAtencionID),
    foreign key(OdontologoID) references Odontologo (OdontologoID)
);

CREATE TABLE Paciente (
	PacienteID int not null auto_increment,
    PacienteApellidos nvarchar(50) not null,
    PacienteNombres nvarchar(50) not null,
    PacienteFechaNacimiento date not null,
    PacienteDni nvarchar(8) not null,
    PacienteTelefono nvarchar(9) not null,
    PacienteDireccion nvarchar(70) not null,
    PacienteCorreo nvarchar(30) not null,
    primary key(PacienteID)
);

CREATE TABLE Cita (
	CitaID int not null auto_increment,
    HorarioAtencionID int not null,
    PacienteID int not null,
    CitaEstado nvarchar(10) not null,
    primary key(CitaID),
    foreign key(PacienteID) references Paciente(PacienteID),
    foreign key(HorarioAtencionID) references HorarioAtencion(HorarioAtencionID)
);

CREATE TABLE FormaPago (
	FormaPagoCodigo nvarchar(1) not null,
    FormaPagoDescripcion nvarchar(7) not null,
    primary key(FormaPagoCodigo)
);

CREATE TABLE Pagos (
	PagosID int not null auto_increment,
    CitaID int not null,
    FechaPago date not null,
    MontoTotal decimal(10,2) not null,
    FormaPagoCodigo nvarchar(1) not null,
    primary key(PagosID),
    foreign key(FormaPagoCodigo) references FormaPago(FormaPagoCodigo),
    foreign key(CitaID) references Cita(CitaID)
);

insert into usuario(Usuario, password) values("admin", "admin");
