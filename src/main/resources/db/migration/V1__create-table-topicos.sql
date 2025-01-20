CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL unique,
    mensaje VARCHAR(255) NOT NULL unique,
    id_autor BIGINT NOT NULL,
    curso VARCHAR(255) NOT NULL,
    fecha_creacion datetime NOT NULL,
    estatus VARCHAR(100) NOT NULL
);