package cl.vr.Entrenador.utils;

public class Constants_Entrenador {

    public static final String fechaOcurrencia_JSON = "fechaOcurrencia";
    public static final String fechaConocimiento_JSON = "fechaConocimiento";
    public static final String fechaNotificacion_JSON = "fechaNotificacion";


    public static final String descripcionHechos_JSON = "descripcionHechos";
    public static final int descripcionHechos_Min = 3;
    public static final int descripcionHechos_Max = 250;
    public static final String descripcionHechos_ErrorSIze = descripcionHechos_JSON + " requiere de " + descripcionHechos_Min + " a " + descripcionHechos_Max + " Caracteres";


    public static final String tipoIngreso_JSON = "tipoIngreso";
    public static final int tipoIngreso_Min = 3;
    public static final int tipoIngreso_Max = 250;
    public static final String tipoIngreso_ErrorSIze = tipoIngreso_JSON + " requiere de " + tipoIngreso_Min + " a " + tipoIngreso_Max + " Caracteres";


    public static final String idLineaNegocio_JSON = "idLineaNegocio";
    public static final String prefijoPoliza_JSON = "prefijoPoliza";
    public static final String numeroPoliza_JSON = "numeroPoliza";
    public static final String secuenciaPoliza_JSON = "secuenciaPoliza";



    public static final String producto_JSON = "producto";
    public static final int producto_Min = 3;
    public static final int producto_Max = 250;
    public static final String producto_ErrorSIze = producto_JSON + " requiere de " + producto_Min + " a " + producto_Max + " Caracteres";


    public static final String inicioPoliza_JSON = "inicioPoliza";
    public static final String terminoPoliza_JSON = "terminoPoliza";
    public static final String fechaEstado_JSON = "fechaEstado";

    //Relaciones
    public static final String idTipoDenuncio_JSON = "idTipoDenuncio";
    public static final String idEstado_JSON = "idEstado";
    public static final String idDenunciante_JSON = "idDenunciante";
    public static final String idSiniestrado_JSON = "idSiniestrado";
    public static final String idTitular_JSON = "idTitular";
    public static final String idCanal_JSON = "idCanal";
    public static final String idLiquidador_JSON = "idLiquidador";
    public static final String idRelacionSiniestradoTitular_JSON = "idRelacionSiniestradoTitular";
    public static final String idRelacionSiniestradoDenunciante_JSON = "idRelacionSiniestradoDenunciante";



    public static final String tipoDenuncio_JSON = "tipoDenuncio";
    public static final String estado_JSON = "estado";
    public static final String denunciante_JSON = "denunciante";
    public static final String siniestrado_JSON = "siniestrado";
    public static final String titular_JSON = "titular";
    public static final String canal_JSON = "canal";
    public static final String liquidador_JSON = "liquidador";
    public static final String relacionSiniestradoTitular_JSON = "relacionSiniestradoTitular";
    public static final String relacionSiniestradoDenunciante_JSON = "relacionSiniestradoDenunciante";


    public static final String id_Estado_Resolucion_JSON = "idEstadoResolucion";
    public static final String id_Tipo_Rechazo_JSON = "idTipoRechazo";


    public static final String fundamentoLegal_JSON = "fundamentoLegal";
    public static final int fundamentoLegal_JSON_Min = 3;
    public static final int fundamentoLegal_JSON_Max = 250;
    public static final String fundamentoLegal_JSON_ErrorSIze = fundamentoLegal_JSON + " requiere de " + fundamentoLegal_JSON_Min + " a " + fundamentoLegal_JSON_Max + " Caracteres";


    public static final String causa_JSON = "causa";
    public static final int causa_JSON_Min = 3;
    public static final int causa_JSON_Max = 250;
    public static final String causa_JSON_ErrorSIze = causa_JSON + " requiere de " + causa_JSON_Min + " a " + causa_JSON_Max + " Caracteres";


}
