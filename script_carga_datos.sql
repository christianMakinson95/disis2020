/************* ORGANIZACIONES *************/

INSERT INTO `gesoc`.`direccion_postal` (`id`, `altura`, `calle`, `ciudad`, `pais`, `provincia`) 
VALUES ('1', '951','Av. Medrano', 'CABA', 'Argentina', 'BA'); /* falta almagro */

INSERT INTO `gesoc`.`direccion_postal` (`id`, `altura`, `calle`, `ciudad`, `pais`, `provincia`) 
VALUES ('2', '720','Liberty Ave', 'Brooklyn', 'Estados Unidos', 'Nueva York');

INSERT INTO `gesoc`.`direccion_postal` (`id`, `altura`, `calle`, `ciudad`, `pais`) 
VALUES ('3', '55','Roberto Gayol', 'Ciudad de Mexico', 'Mexico');

INSERT INTO `gesoc`.`direccion_postal` (`id`, `altura`, `calle`, `ciudad`, `pais`, `provincia`) 
VALUES ('4', '2800','Jerónimo Salguero', 'CABA', 'Argentina', 'BA'); /* falta palermo */

INSERT INTO `gesoc`.`entidad_juridica` (`id`, `cuit`, `nombre_ficticio`, `razon_social`, `cant_empleados`, `rubro`, `ventas_total_anual`, `direccion_id`) 
VALUES ('1', '30152698572', 'Oficina Central Buenos Aires', 'EAAF BA', '150', 'Construcción','600000000','1'); /* falta nombre - rubro hardcodeado? */

INSERT INTO `gesoc`.`entidad_juridica` (`id`, `cuit`, `codigo_inscripcion`, `nombre_ficticio`, `razon_social`, `cant_empleados`, `rubro`, `ventas_total_anual`, `direccion_id`) 
VALUES ('2', '30157896557', 'Oficina Central Nueva York', 'EAAF NY', '580', 'Construcción','960000000','2'); /* falta nombre - rubro hardcodeado? */

INSERT INTO `gesoc`.`entidad_juridica` (`id`, `cuit`, `nombre_ficticio`, `razon_social`, `cant_empleados`, `rubro`, `ventas_total_anual`, `direccion_id`) 
VALUES ('3', '30778965836', 'Oficina Central México', 'EAAF M', '240', 'Construcción','643710000','3'); /* falta nombre - rubro hardcodeado? */

INSERT INTO `gesoc`.`entidad_juridica` (`id`, `cuit`, `nombre_ficticio`, `razon_social`, `cant_empleados`, `rubro`, `ventas_total_anual`, `direccion_id`) 
VALUES ('4', '30258888978', 'Surcos', 'Surcos CS', '8', 'Servicio de Alojamiento','8000000','4'); /* falta nombre - rubro hardcodeado? */

INSERT INTO `gesoc`.`entidad_base` (`id`, `nombre_ficticio`) 
VALUES ('1','Andhes');


/************* USUARIOS *************/

INSERT INTO `gesoc`.`password` (`id`, `pass`)
VALUES ('1', '*_aroco20!-?'); /* falta fecha de creacion de pass */

INSERT INTO `gesoc`.`password` (`id`, `pass`)
VALUES ('2', '*-_rrojas!?'); /* falta fecha de creacion de pass */

INSERT INTO `gesoc`.`password` (`id`, `pass`)
VALUES ('3', '!-*jazul_!?'); /* falta fecha de creacion de pass */

INSERT INTO `gesoc`.`bandeja_de_mensajes` (`id`)
VALUES ('1');

INSERT INTO `gesoc`.`bandeja_de_mensajes` (`id`)
VALUES ('2');

INSERT INTO `gesoc`.`bandeja_de_mensajes` (`id`)
VALUES ('3');

INSERT INTO `gesoc`.`usuario` (`id`, `nombre_usuario`, `bandeja_id`, `password_id`, `ent_juridica_id`) 
VALUES ('1', 'aroco', '1', '1', '1'); /* falta nombre y apellido, falta que es revisor */

INSERT INTO `gesoc`.`usuario` (`id`, `nombre_usuario`, `bandeja_id`, `password_id`, `ent_juridica_id`) 
VALUES ('2', 'rrojas', '2', '2', '1'); /* falta nombre y apellido, falta que es revisor */

INSERT INTO `gesoc`.`usuario` (`id`, `nombre_usuario`, `bandeja_id`, `password_id`, `ent_juridica_id`) 
VALUES ('3', 'jazul', '3', '3', '4'); /* falta nombre y apellido, falta que es revisor */


/************* EGRESOS *************/


