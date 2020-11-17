package server;

import Dominio.controllers.*;
import Dominio.middleware.AuthMiddleware;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import utils.BooleanHelper;
import utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        LoginController loginController = new LoginController();

        AuthMiddleware authMiddleware = new AuthMiddleware();

        CategorizacionOpsController categorizacionOpsController = new CategorizacionOpsController();

        CategoriaController categoriaController = new CategoriaController();

        OperacionEgresoController opEgController = new OperacionEgresoController();

        OperacionIngresoController opInController = new OperacionIngresoController();

        ItemController itemController = new ItemController();

        BandejaDeMensajesController bandejaDeMensajesController = new BandejaDeMensajesController();

        Spark.before("/", authMiddleware::verificarSesion);

        Spark.get("/login",loginController::inicio,Router.engine);

        Spark.post("/login",loginController::login);

        Spark.get("/login=error", loginController::error,Router.engine);

        Spark.get("/logout", loginController::logout);

        Spark.before("/egresos", authMiddleware::verificarInicioSesion);

        Spark.get("/egresos", opEgController::inicioEgreso, Router.engine);

        Spark.post("/egresos", opEgController::cargarEgreso);

        Spark.get("/egresos/:idpais",opEgController::filtrarProvincias);

        Spark.get("/egresos/:idpais/:provincia", opEgController::filtrarCiudades);

        Spark.post("/egresos/cargarDocumento", opEgController::agregarDocumentoPdf);

        Spark.get( "/asociar_a_categoria", categorizacionOpsController::inicio, Router.engine);

        Spark.get( "/asociar_a_categoria/:id", categorizacionOpsController::asociar, Router.engine);

        Spark.get("/crear_categoria", categoriaController::inicio, Router.engine);

        Spark.post("/crear_categoria", categoriaController::crear);

        Spark.delete("/crear_categoria/:descripcion", categoriaController::eliminar);

        Spark.get("/mensajes", authMiddleware::verificarInicioSesion);

        Spark.get("/mensajes", bandejaDeMensajesController::inicio, Router.engine );

        Spark.get("/ingresos", opInController::inicioIngreso, Router.engine);

        Spark.before("/ingresos", authMiddleware::verificarInicioSesion);

        Spark.post("/ingresos", opInController::cargarIngreso);
    }
}
