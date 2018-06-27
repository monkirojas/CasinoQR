package app.inacap.casinoqr.com.casinoqr;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import app.inacap.casinoqr.com.casinoqr.Modelo.User;

public class RegistrarseActivity extends AppCompatActivity {

    MaterialEditText edtRut, edtName, edtLastName, edtSecondLastName, edtEmail, edtPassword;
    Button btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        edtRut = (MaterialEditText)findViewById(R.id.edtRut);
        edtName = (MaterialEditText)findViewById(R.id.edtName);
        edtLastName = (MaterialEditText)findViewById(R.id.edtLastName);
        edtSecondLastName = (MaterialEditText)findViewById(R.id.edtSecondLastName);
        edtEmail = (MaterialEditText)findViewById(R.id.edtEmail);
        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);

        btnRegistrarse = (Button)findViewById(R.id.btnRegistrarse);

        //Levantar Firebase
        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference tabla_users = db.getReference("Users");

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog pDialog = new ProgressDialog(RegistrarseActivity.this);
                pDialog.setMessage("Espere por favor...");
                pDialog.show();

                tabla_users.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(edtRut.getText().toString()).exists())
                        {
                            
                            pDialog.dismiss();
                            Toast.makeText(RegistrarseActivity.this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
                            
                            
                        }
                        else
                        {
                            pDialog.dismiss();
                            User u = new User(edtName.getText().toString(),edtLastName.getText().toString(),edtSecondLastName.getText().toString(),edtPassword.getText().toString(),edtEmail.getText().toString());
                            tabla_users.child(edtRut.getText().toString()).setValue(u);
                            Toast.makeText(RegistrarseActivity.this, "Usuario registrado! ", Toast.LENGTH_SHORT).show();
                            finish();


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
