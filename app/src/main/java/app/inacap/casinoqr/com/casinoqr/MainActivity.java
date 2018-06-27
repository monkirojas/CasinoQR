package app.inacap.casinoqr.com.casinoqr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btnIniciarSesion,btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarSesion = (Button) findViewById(R.id.btnIniciarSesion);
        btnRegistro = (Button) findViewById(R.id.btnRegistrarse);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iniciarSesion = new Intent(MainActivity.this,IniciarSesionActivity.class);
                startActivity(iniciarSesion);
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent registrarse = new Intent(MainActivity.this,RegistrarseActivity.class);
                startActivity(registrarse);

            }
        });
    }
}
