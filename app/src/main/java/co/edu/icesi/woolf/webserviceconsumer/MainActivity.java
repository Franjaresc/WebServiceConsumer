package co.edu.icesi.woolf.webserviceconsumer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button btn_get,btn_post,btn_getComentarios,btn_getVehiculos,btn_getMaterias;
    private TextView txt_console;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_get = findViewById(R.id.btn_get);
        txt_console = findViewById(R.id.txt_console);
        btn_get.setOnClickListener(v -> new Thread(()->{
            new ServiceManager.UsuariosGET(responce -> runOnUiThread(()->{
                txt_console.setText(responce);
                Type tipo = new TypeToken<HashMap<String,Usuario>>(){

                }.getType();
                Gson g = new Gson();
                HashMap<String,Usuario> usuarios = g.fromJson(responce, tipo);
                txt_console.append("\n\n+Usuarios: "+ usuarios.size());
                txt_console.append("\n+Usuario 0 :"+usuarios.get("lwlBUK43PuX3ZEyCWocqsL5x0xH3").nombre);
            })
            );
        }).start());
        btn_post=findViewById(R.id.btn_post);
        btn_post.setOnClickListener(v -> {
            new Thread(()->{
                Usuario usuario = new Usuario();
                usuario.nombre="as";
                usuario.correo="sas@sas.com";
                usuario.id = "0";
                usuario.telefono = "12121";
                usuario.pass="asasas";
                new ServiceManager.UsuariosPOST(usuario, responce -> runOnUiThread(()->{
                    txt_console.setText(responce);
                }));
            }).start();

        });
        btn_getComentarios= findViewById(R.id.btn_getComentarios);
        btn_getComentarios.setOnClickListener(v -> new Thread(()->{
            new ServiceManager.ComentariosGET(responce -> runOnUiThread(()->{
                txt_console.setText(responce);
                Type tipo = new TypeToken<HashMap<String,Comentario>>(){

                }.getType();
                Gson g = new Gson();
                HashMap<String,Comentario> usuarios = g.fromJson(responce, tipo);
                txt_console.append("\n\n+Comentarios: "+ usuarios.size());
                txt_console.append("\n+Comentarios 0 :"+usuarios.get("-LRODOhP2VzigX1TcLee").mensaje);
            })
            );
        }).start());
        btn_getVehiculos= findViewById(R.id.btn_getVehiculos);
        btn_getVehiculos.setOnClickListener(v -> new Thread(()->{
            new ServiceManager.VehiculosGET(responce -> runOnUiThread(()->{
                txt_console.setText(responce);
                Type tipo = new TypeToken<HashMap<String,Vehiculo>>(){
                }.getType();
                Gson g = new Gson();
                HashMap<String,Vehiculo> Vehiculos = g.fromJson(responce, tipo);
                txt_console.append("\n\n+Vehiculos: "+ Vehiculos.size());
                txt_console.append("\n+Vehiculos 0 :"+Vehiculos.get("alfa").placa);
            })
            );
        }).start());
        btn_getMaterias= findViewById(R.id.btn_getMaterias);
        btn_getMaterias.setOnClickListener(v -> new Thread(()->{
            new ServiceManager.MateriasGET(responce -> runOnUiThread(()->{
                txt_console.setText(responce);
                Type tipo = new TypeToken<HashMap<String,Materia>>(){ 

                }.getType();
                Gson g = new Gson();
                HashMap<String,Materia> Materias = g.fromJson(responce, tipo);
                txt_console.append("\n\n+Usuarios: "+ Materias.size());
                txt_console.append("\n+Usuario 0 :"+Materias.get("A001212").codigo);
            })
            );
        }).start());

    }


}
