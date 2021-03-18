package com.example.sifper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.sifper.Common.Common;
import com.example.sifper.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Exe";
    private FirebaseAuth auth;
    private Button btnLogin;
    private EditText inputLP, inputPassword;
    //private FirebaseAuth.AuthStateListener mAuthListener;

    private ProgressBar miProgress;
    //private ObjectAnimator anim;

    FirebaseDatabase database;
    DatabaseReference tabla_user;

    private LottieAnimationView mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtener instancia de autenticacion de Firebase
        auth = FirebaseAuth.getInstance();


        mAnimation = findViewById(R.id.animation);
        //Obtener la referencia de los controles
        inputLP = (EditText) findViewById(R.id.lp);
        inputPassword = (EditText) findViewById(R.id.password);

        btnLogin = (Button) findViewById(R.id.btn_login);

        //Obtener instancia de autenticacion de Firebase
        //auth = FirebaseAuth.getInstance();

        //Init Firebase
        database = FirebaseDatabase.getInstance();
        tabla_user = database.getReference("User");


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(LoginActivity.this, "Inicio correcto de sesion", Toast.LENGTH_SHORT).show();
                /*final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
                mDialog.setMessage("Por favor espere...");
                mDialog.show();*/

                mAnimation.playAnimation();
                mAnimation.setVisibility(View.VISIBLE);

                if (inputLP.getText().toString().equals("") || inputPassword.getText().toString().equals("")){
                    //mDialog.dismiss();

                    mAnimation.cancelAnimation();
                    mAnimation.setVisibility(View.GONE);

                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
                    alerta.setMessage("Por favor complete todos los campos")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    //Sino no aparece el alertDialog
                    alerta.show();

                } else {
                    tabla_user.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //check if user noy exist in database
                            if (dataSnapshot.child(inputLP.getText().toString()).exists()) {
                                //get user information
                                //mDialog.dismiss();

                                mAnimation.cancelAnimation();
                                mAnimation.setVisibility(View.GONE);

                                User user = dataSnapshot.child(inputLP.getText().toString()).getValue(User.class);
                                user.setLp(inputLP.getText().toString()); // Set LP
                                if (user.getPassword().equals(inputPassword.getText().toString())) {
                                    Toast.makeText(MainActivity.this, "Ingreso correctamente", Toast.LENGTH_SHORT).show();
                                    /*{
                                        Intent homeIntent = new Intent(MainActivity.this,CasaActivity.class);
                                        Common.currentUser = user;
                                        startActivity(homeIntent);
                                        finish();
                                    }*/
                                } else {
                                    Toast.makeText(MainActivity.this, "Fallo el ingreso", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                //mDialog.dismiss();

                                mAnimation.cancelAnimation();
                                mAnimation.setVisibility(View.GONE);

                                Toast.makeText(MainActivity.this, "El usuario no existe", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

    }
}