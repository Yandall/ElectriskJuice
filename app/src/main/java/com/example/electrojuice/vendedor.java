package com.example.electrojuice;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.electrojuice.entities.Clientes;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class vendedor extends AppCompatActivity {
    DataSnapshot data = null;
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("user");
    TextView txtSabor;
    TextView txtTamano;
    TextView txtNombre;

    Button buttonPreparar;
    Button buttonCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor);
        initComponents();
//        getActionBar().hide();
        recuperarDatos();

        buttonPreparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.getRef().removeValue();
                recuperarDatos();
            }
        });

        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initComponents() {
        txtSabor = findViewById(R.id.txtSabor);
        txtTamano = findViewById(R.id.txtTamano);
        buttonPreparar = findViewById(R.id.buttonPreparar);
        buttonCancelar = findViewById(R.id.buttonCancelar);
        txtNombre = findViewById(R.id.txtNombre);


}
public void recuperarDatos(){
    ref.addChildEventListener(new ChildEventListener() {

        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            Clientes cliente = dataSnapshot.getValue(Clientes.class);
            txtSabor.setText(cliente.getTipo());
            txtTamano.setText(cliente.getTamaño());
            txtNombre.setText(cliente.getNombre());
            data = dataSnapshot;



        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });

       /* ref.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Clientes cliente = dataSnapshot.getValue(Clientes.class);
                if(cliente != null) {
                    txtSabor.setText(cliente.getTipo());
                    txtTamano.setText(cliente.getTamaño());
                    txtNombre.setText(cliente.getNombre());
                    data = dataSnapshot;
                }else {
                    txtSabor.setText("sabordsf :");
                    txtTamano.setText("tamañosdf :");
                    txtNombre.setText("nombrefds :");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
        }
    }

