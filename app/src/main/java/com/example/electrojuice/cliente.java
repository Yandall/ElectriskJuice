package com.example.electrojuice;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.electrojuice.entities.Clientes;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class cliente extends AppCompatActivity {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    RadioGroup rgSabores;
    RadioGroup rgTamanos;
    EditText edtNombre;
    Button btnPedir;
    String sabor;
    String tamano;
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        initComponents();
 //       getActionBar().hide();

        btnPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rbSabor = findViewById(rgSabores.getCheckedRadioButtonId());
                RadioButton rbTamano = findViewById(rgTamanos.getCheckedRadioButtonId());
                sabor = rbSabor.getText().toString();
                tamano = rbTamano.getText().toString();
                nombre = edtNombre.getText().toString();
                Clientes c = new Clientes(tamano, nombre, sabor);
                ref.child("user").child(nombre).setValue(c);
            }
        });


    }

    private void initComponents() {
        rgSabores = findViewById(R.id.rgSabores);
        rgTamanos = findViewById(R.id.rgTamanos);
        btnPedir = findViewById(R.id.buttonPedir);
        edtNombre = findViewById(R.id.txtNombre);
    }

}
