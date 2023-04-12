package br.edu.ifsuldeminas.mch.calc;

//https://www.youtube.com/watch?v=jTuxCv_XjlA
//Stack Mobile: Calculadora

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
//implements View.OnClickListener
public class MainActivity extends AppCompatActivity  {
    private Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9,
            btnVirgula, btnSoma, btnSubtracao, btnMultiplicacao, btnDivisao, btnPorcentagem;
    //
    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonIgual, buttonLimpar, buttonDeletarCaracter;
    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializacaoDosComponentes();

        btnNum0.setOnClickListener(view -> acrescentaExpressao("0", true));

        btnNum1.setOnClickListener(view -> acrescentaExpressao("1", true));

        btnNum2.setOnClickListener(view -> acrescentaExpressao("2", true));

        btnNum3.setOnClickListener(view -> acrescentaExpressao("3", true));

        btnNum4.setOnClickListener(view -> acrescentaExpressao("4", true));

        btnNum5.setOnClickListener(view -> acrescentaExpressao("5", true));

        btnNum6.setOnClickListener(view -> acrescentaExpressao("6", true));

        btnNum7.setOnClickListener(view -> acrescentaExpressao("7", true));

        btnNum8.setOnClickListener(view -> acrescentaExpressao("8", true));

        btnNum9.setOnClickListener(view -> acrescentaExpressao("9", true));

        btnVirgula.setOnClickListener(view -> acrescentaExpressao(".", true));

        btnSoma.setOnClickListener(view -> acrescentaExpressao("+", false));

        btnSubtracao.setOnClickListener(view -> acrescentaExpressao("-", false));

        btnMultiplicacao.setOnClickListener(view -> acrescentaExpressao("*", false));

        btnDivisao.setOnClickListener(view -> acrescentaExpressao("/", false));

        btnPorcentagem.setOnClickListener(view -> acrescentaExpressao("%", false));

        buttonLimpar.setOnClickListener(view -> {
            textViewUltimaExpressao.setText("");
            textViewResultado.setText("");
        });

        buttonDeletarCaracter.setOnClickListener(view -> {
            TextView expressao = findViewById(R.id.textViewUltimaExpressaoID);
            String string = expressao.getText().toString();
            if(!string.isEmpty()){
                byte v0 =0 ;
                int v1 = string.length()-1;
                String txtexpressao = string.substring(v0, v1);
                expressao.setText(txtexpressao);
            }
            textViewResultado.setText("");
        });

        //--- Codigo fornecido
        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculable avaliadorExpressao = null;
                try {
                    //"5+1+4*2"
                    String expressao = textViewUltimaExpressao.getText().toString();
                    avaliadorExpressao = new ExpressionBuilder(expressao).build();

                    Double resultado = avaliadorExpressao.calculate();

                    textViewUltimaExpressao.setText(expressao);
                    textViewResultado.setText(resultado.toString());
                } catch (Exception e) {
                    Log.d(TAG, "Error");
                    Toast toast = Toast.makeText(view.getContext(), "Erro, aperte C", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        //Fim codigo fornecido
    }
    private void inicializacaoDosComponentes(){

        btnNum0 = findViewById(R.id.buttonZeroID);
        btnNum1 = findViewById(R.id.buttonUmID);
        btnNum2 = findViewById(R.id.buttonDoisID);
        btnNum3 = findViewById(R.id.buttonTresID);
        btnNum4 = findViewById(R.id.buttonQuatroID);
        btnNum5 = findViewById(R.id.buttonCincoID);
        btnNum6 = findViewById(R.id.buttonSeisID);
        btnNum7 = findViewById(R.id.buttonSeteID);
        btnNum8 = findViewById(R.id.buttonOitoID);
        btnNum9 = findViewById(R.id.buttonNoveID);
        btnVirgula = findViewById(R.id.buttonVirgulaID);
        btnSoma = findViewById(R.id.buttonSomaID);
        btnSubtracao = findViewById(R.id.buttonSubtracaoID);
        btnMultiplicacao = findViewById(R.id.buttonMultiplicacaoID);
        btnDivisao = findViewById(R.id.buttonDivisaoID);
        btnPorcentagem = findViewById(R.id.buttonPorcentoID);
        buttonIgual = findViewById(R.id.buttonIgualID);
        buttonLimpar = findViewById(R.id.buttonResetID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);
        textViewResultado = findViewById(R.id.textViewResultadoID);
        buttonDeletarCaracter = findViewById(R.id.buttonDeleteID);
        buttonIgual = findViewById(R.id.buttonIgualID);
    }
    public void acrescentaExpressao(String string, boolean limpar_dados){

        if(textViewResultado.getText().equals("") && !buttonDeletarCaracter.isClickable()){
            textViewUltimaExpressao.setText(" ");
        }

        if(limpar_dados){
            textViewResultado.setText(" ");
            textViewUltimaExpressao.append(string);
        }
        else{
            textViewUltimaExpressao.append(textViewResultado.getText());
            textViewUltimaExpressao.append(string);
            textViewResultado.setText(" ");
        }
    }
}