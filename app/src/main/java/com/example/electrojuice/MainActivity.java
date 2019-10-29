package com.example.electrojuice;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button vendedor;
    Button cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getActionBar().hide();
        initComponents();

        vendedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), vendedor.class));

            }
        });

        cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), cliente.class));
            }
        });
    }

    private void initComponents() {
        vendedor = findViewById(R.id.buttonVendedor);
        cliente = findViewById(R.id.buttonCliente);

    }

}
