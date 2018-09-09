package projeto09.com.br.projeto09;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declarar os atributos da Classe
    EditText edtReal, edtDolar;
    Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtReal = (EditText) findViewById(R.id.edtReal);
        edtDolar = (EditText) findViewById(R.id.edtDolar);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtReal.getText().length() <= 0 ||
                        edtDolar.getText().length() <= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtReal.requestFocus();
                } else {

                    Double real = Double.parseDouble(edtReal.getText().toString());
                    Double dolar = Double.parseDouble(edtDolar.getText().toString());


                    Double dolarConv = (real * 4.06);

                    Double realConv = (dolar/4.0);

                    AlertDialog.Builder alerta = new
                            AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("DINHEIRO CONVERTIDO");
                    alerta.setMessage("O Dinheiro em Real : "
                            + new DecimalFormat("0.00").format(real)
                            + ("\n tem valor em Dolar de :")
                            + new DecimalFormat("0.00").format(dolarConv)
                            + ("\n O Dinheiro em Dolar: ")
                            + new DecimalFormat("0.00").format(dolar)
                            + ("\n tem valor em Real de :")
                            + new DecimalFormat("0.00").format(realConv));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtDolar.setText("");
                edtReal.setText("");
                edtReal.requestFocus();
            }
        });
    }
}
