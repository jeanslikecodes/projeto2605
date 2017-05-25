package jeancarlos.projetofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCriarAnuncios = (Button) findViewById(R.id.btn_criar_anuncios);
        btnCriarAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewAnuncioActivity.class);
                startActivity(intent);
            }
        });

        Button btnListarAnuncios = (Button) findViewById(R.id.btn_listar_anuncios);
        btnListarAnuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnuncioActivity.class);
                startActivity(intent);
            }
        });

    }


}
