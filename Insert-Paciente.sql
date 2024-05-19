-- -----------------------------------------------------
-- Data for table `SGCO`.`Pacientes`
-- -----------------------------------------------------
START TRANSACTION;
USE `SGCO`;
INSERT INTO `SGCO`.`Pacientes` (`id_Pacientes`, `nombre_Paciente`, `apellido_Paciente`, `direccion_Paciente`, `localidad_Paciente`, `pais_Paciente`, `email_Paciente`, `cel_wsp_Paciente`, `fecnac_Paciente`, `status_Paciente`) VALUES (001, 'Jose Alberto', 'Gomez', 'Bahia Blanca 1210', 'CABA', 'Argentina', 'jsobredo@gmail.com', 1145318680, '1965-08-11', 0);
INSERT INTO `SGCO`.`Pacientes` (`id_Pacientes`, `nombre_Paciente`, `apellido_Paciente`, `direccion_Paciente`, `localidad_Paciente`, `pais_Paciente`, `email_Paciente`, `cel_wsp_Paciente`, `fecnac_Paciente`, `status_Paciente`) VALUES (002, 'Santiago', 'Gomez', 'Bahia Blanca 1230', 'CABA', 'Argentina', 'sgomez@gmail.com', 1145488680, '1970-09-11', 0);
COMMIT;
