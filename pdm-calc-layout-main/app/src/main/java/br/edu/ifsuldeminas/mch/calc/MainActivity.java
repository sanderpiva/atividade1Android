package br.edu.ifsuldeminas.mch.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9,
            virgula, soma, sub, mult, divisao, botao_limpar, btnDeletarCaracter, porcentagem;

    //
    private static final String TAG = "ifsuldeminas.mch.calc";
    private Button buttonIgual;
    private TextView textViewResultado;
    private TextView textViewUltimaExpressao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicio();
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        virgula.setOnClickListener(this);
        soma.setOnClickListener(this);
        sub.setOnClickListener(this);
        mult.setOnClickListener(this);
        divisao.setOnClickListener(this);
        porcentagem.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewUltimaExpressao.setText("");
                textViewResultado.setText("");
            }
        });

        btnDeletarCaracter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.textViewUltimaExpressaoID);
                String string = expressao.getText().toString();
                if(!string.isEmpty()){
                    byte v0 =0 ;
                    int v1 = string.length()-1;
                    String txtexpressao = string.substring(v0, v1);
                    expressao.setText(txtexpressao);

                }
                textViewResultado.setText("");
            }
        });

        //---
        textViewResultado = findViewById(R.id.textViewResultadoID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);

        buttonIgual = findViewById(R.id.buttonIgualID);
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
                    //Log.d(TAG, e.getMessage());
                    if (e.getMessage() != null) {
                        Log.d(TAG, e.getMessage());
                    } else {
                       Log.d(TAG, "Erro ao tentar calculo da porcentagem.");
                       
                    }
                }
            }
        });
    }

    private void inicio(){

        num0 = findViewById(R.id.buttonZeroID);
        num1 = findViewById(R.id.buttonUmID);
        num2 = findViewById(R.id.buttonDoisID);
        num3 = findViewById(R.id.buttonTresID);
        num4 = findViewById(R.id.buttonQuatroID);
        num5 = findViewById(R.id.buttonCincoID);
        num6 = findViewById(R.id.buttonSeisID);
        num7 = findViewById(R.id.buttonSeteID);
        num8 = findViewById(R.id.buttonOitoID);
        num9 = findViewById(R.id.buttonNoveID);
        virgula = findViewById(R.id.buttonVirgulaID);
        soma = findViewById(R.id.buttonSomaID);
        sub = findViewById(R.id.buttonSubtracaoID);
        mult = findViewById(R.id.buttonMultiplicacaoID);
        divisao = findViewById(R.id.buttonDivisaoID);
        porcentagem = findViewById(R.id.buttonPorcentoID);
        buttonIgual = findViewById(R.id.buttonIgualID);
        botao_limpar = findViewById(R.id.buttonResetID);
        textViewUltimaExpressao = findViewById(R.id.textViewUltimaExpressaoID);
        textViewResultado = findViewById(R.id.textViewResultadoID);
        btnDeletarCaracter = findViewById(R.id.buttonDeleteID);

    }
    //boolean aqui representa um estado
    //fazemos validações
    public void acrescenta(String string, boolean limpar_dados){

        if(textViewResultado.getText().equals("")){
            textViewUltimaExpressao.setText(" ");
        }

        if(limpar_dados){
            textViewResultado.setText(" ");
            //acrescenta uma string para a expressao
            textViewUltimaExpressao.append(string);
        }
        //limpar dados false:
        else{
            textViewUltimaExpressao.append(textViewResultado.getText());
            textViewUltimaExpressao.append(string);
            textViewResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.buttonZeroID:
                acrescenta("0", true);
                break;
            case R.id.buttonUmID:
                acrescenta("1", true);
                break;
            case R.id.buttonDoisID:
                acrescenta("2", true);
                break;
            case R.id.buttonTresID:
                acrescenta("3", true);
                break;
            case R.id.buttonQuatroID:
                acrescenta("4", true);
                break;
            case R.id.buttonCincoID:
                acrescenta("5", true);
                break;
            case R.id.buttonSeisID:
                acrescenta("6", true);
                break;
            case R.id.buttonSeteID:
                acrescenta("7", true);
                break;
            case R.id.buttonOitoID:
                acrescenta("8", true);
                break;
            case R.id.buttonNoveID:
                acrescenta("9", true);
                break;
            case R.id.buttonVirgulaID:
                acrescenta(".", true);
                break;
            case R.id.buttonSomaID:
                acrescenta("+", false);
                break;
            case R.id.buttonSubtracaoID:
                acrescenta("-", false);
                break;
            case R.id.buttonMultiplicacaoID:
                acrescenta("*", false);
                break;
            case R.id.buttonDivisaoID:
                acrescenta("/", false);
                break;

            case R.id.buttonPorcentoID:
                acrescenta("%", false);
                break;
        }
    }
}