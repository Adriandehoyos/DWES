

CREATE TABLE Toledo (
id BIGINT AUTO_INCREMENT  PRIMARY KEY,
fecha date,
max_temp double(2,1),
min_temp double(2,1),
media_temp double(2,1),
condicion ENUM('LLUVIA', 'SOLEADO', 'NUBLADO', 'TORMENTA', 'NIEVE', 'GRANIZO', 'GALERNA' ),
humedad int,
velocidad int
);

CREATE TABLE Santander (
id BIGINT AUTO_INCREMENT  PRIMARY KEY,
fecha date ,
max_temp double(2,1),
min_temp double(2,1),
media_temp double(2,1),
condicion ENUM('LLUVIA', 'SOLEADO', 'NUBLADO', 'TORMENTA', 'NIEVE', 'GRANIZO', 'GALERNA' ),
humedad int,
velocidad int
);

CREATE TABLE Torremolinos (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    fecha DATE,
    max_temp DOUBLE(2 , 1 ),
    min_temp DOUBLE(2 , 1 ),
    media_temp DOUBLE(2 , 1 ),
    condicion ENUM('LLUVIA', 'SOLEADO', 'NUBLADO', 'TORMENTA', 'NIEVE', 'GRANIZO', 'GALERNA'),
    humedad INT,
    velocidad INT
);