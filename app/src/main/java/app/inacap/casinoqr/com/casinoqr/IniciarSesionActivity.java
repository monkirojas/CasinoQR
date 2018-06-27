package app.inacap.casinoqr.com.casinoqr;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import app.inacap.casinoqr.com.casinoqr.Modelo.User;

public class IniciarSesionActivity extends AppCompatActivity {

    EditText edtRut, edtPassword;
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        edtRut = (MaterialEditText)findViewById(R.id.edtRut);
        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);

        btnIniciarSesion = (Button)findViewById(R.id.btnIniciarSesion);

        //Levantar Firebase
        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference tabla_users = db.getReference("Users");

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog pDialog = new ProgressDialog(IniciarSesionActivity.this);
                pDialog.setMessage("Espere por favor...");
                pDialog.show();


                tabla_users.addValueEventListener(new ValueEventListener() {




                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                      //Si el usuario no existe en la bd
                        if(dataSnapshot.child(edtRut.getText().toString()).exists()) {


                            //Obtener información del usuario

                            pDialog.dismiss();

                            User u = dataSnapshot.child(edtRut.getText().toString()).getValue(User.class);

                          // Toast.makeText(IniciarSesionActivity.this, edtPassword.getText().toString(), Toast.LENGTH_SHORT).show();

                            if (u.getPassword().equals(edtPassword.getText().toString())) {
                                Toast.makeText(IniciarSesionActivity.this, "Logueado correctamente!", Toast.LENGTH_SHORT).show();
                            } else {

                                Toast.makeText(IniciarSesionActivity.this, "Error al iniciar sesion :(", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            pDialog.dismiss();
                            Toast.makeText(IniciarSesionActivity.this, "Usuario no registrado", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
