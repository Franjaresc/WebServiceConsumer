package co.edu.icesi.woolf.webserviceconsumer;

import com.google.gson.Gson;

import java.io.IOException;

public class ServiceManager {

    public static final String SIMPLEGET_URL = "https://www.icesi.edu.co/";
    public static final String USUARIOS_URL = "https://appsmobile2019-1.firebaseio.com/users.json";
    public static final String COMENTARIOS_URL = "https://camara-4a96c.firebaseio.com/comentarios.json";
    public static final String VEHICULOS_URL = "https://camara-4a96c.firebaseio.com/vehiculos.json";
    public static final String MATERIAS_URL = "https://instalacion-bc3ad.firebaseio.com/materias.json";

    public static class SimpleGET{
        OnResponseListener listener;
        public SimpleGET(OnResponseListener listener){
            this.listener=listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                String answer = util.GETrequest(SIMPLEGET_URL);
                listener.onResponse(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String responce);
        }


    }
    public static class UsuariosGET{

        OnResponseListener listener;
        public UsuariosGET(OnResponseListener listener){
            this.listener=listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                String answer = util.GETrequest(USUARIOS_URL);
                listener.onResponse(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String responce);
        }
    }
    public static class ComentariosGET{

        OnResponseListener listener;
        public ComentariosGET(OnResponseListener listener){
            this.listener=listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                String answer = util.GETrequest(COMENTARIOS_URL);
                listener.onResponse(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String responce);
        }
    }
    public static class UsuariosPOST{

        OnResponseListener listener;
        public UsuariosPOST(Usuario usuario,OnResponseListener listener){
            this.listener=listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                Gson g = new Gson();
                String answer = util.POSTrequest(USUARIOS_URL,g.toJson(usuario));
                listener.onResponse(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String responce);
        }
    }
    public static class ComentariosPOST{

        OnResponseListener listener;
        public ComentariosPOST(Comentario comentario, OnResponseListener listener){
            this.listener=listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                Gson g = new Gson();
                String answer = util.POSTrequest(COMENTARIOS_URL,g.toJson(comentario));
                listener.onResponse(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String responce);
        }
    }
    public static class VehiculosGET{

        OnResponseListener listener;
        public VehiculosGET(OnResponseListener listener){
            this.listener=listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                String answer = util.GETrequest(VEHICULOS_URL);
                listener.onResponse(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String responce);
        }
    }
    public static class VehiculosPOST{

        OnResponseListener listener;
        public VehiculosPOST(Vehiculo vehiculo, OnResponseListener listener){
            this.listener=listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                Gson g = new Gson();
                String answer = util.POSTrequest(VEHICULOS_URL,g.toJson(vehiculo));
                listener.onResponse(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String responce);
        }
    }

    public static class MateriasGET{

        OnResponseListener listener;
        public MateriasGET(OnResponseListener listener){
            this.listener=listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                String answer = util.GETrequest(MATERIAS_URL);
                listener.onResponse(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String responce);
        }
    }
    public static class MateriasPOST{

        OnResponseListener listener;
        public MateriasPOST(Materia materia, OnResponseListener listener){
            this.listener=listener;
            HTTPSWebUtilDomi util = new HTTPSWebUtilDomi();
            try {
                Gson g = new Gson();
                String answer = util.POSTrequest(MATERIAS_URL,g.toJson(materia));
                listener.onResponse(answer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public interface OnResponseListener{
            void onResponse(String responce);
        }
    }


}
