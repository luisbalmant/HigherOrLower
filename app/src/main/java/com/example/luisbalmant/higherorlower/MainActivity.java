package com.example.luisbalmant.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * O Random aqui ele é gerado só quando o app inicia.
         * Antes eu coloquei ele dentro do botão e assim toda vez que clicasse
         * no botão era gerado um numero.
         */
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
        // Nesse caso o Random é um número entre 1 e 20.

    }

    public void guess_Button(View view) {
//        Log.i("Info", "Button Test.");
        // Peguei o texto (número) da EditText e converti em integer.
        EditText type_EditText = findViewById(R.id.yourNumber_EditText);
//        String value = type_EditText.getText().toString();
//        int yourNumber = Integer.parseInt(value);
        /**
         * para o código ficar menor usei a opção abaixo, inves da de cima.
         */
        int yourNumber = Integer.parseInt(type_EditText.getText().toString());

        if (randomNumber < yourNumber) {

            makeToast("Lower!");

        } else if (randomNumber > yourNumber) {

            makeToast("Higher!");

        } else {

            makeToast("That's right! Try again!");

            Random rand = new Random();
            randomNumber = rand.nextInt(20) + 1;

        }
    }

    // Criei esse método e o chamei acima em cada condição.
    // Sempre que repetir muito algo, faça um método.
    // A manutenção será mais fácil.
    public void makeToast(String string) {

        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();

    }
}
