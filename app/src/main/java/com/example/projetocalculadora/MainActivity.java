package com.example.projetocalculadora;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.projetocalculadora.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,
    numeroSete, numeroOito, numeroNove,ponto, soma, subtracao, multiplicacao, divisao,
            igual, limpar;

    private TextView txtExpressao, txtResultado;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iniciarComponentes();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0, var1);
                    expressao.setText(txtExpressao);
                }

                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Expression expression = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expression.evaluate();
                    long longResult = (long) resultado;

                    if(resultado == (double)longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e) {
                    txtResultado.setText("Expressão inválida");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void iniciarComponentes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.btn_ponto);
        soma = findViewById(R.id.btn_some);
        multiplicacao = findViewById(R.id.btn_multiplicacao);
        divisao = findViewById(R.id.divisao);
        subtracao = findViewById(R.id.btn_subtracao);
        backspace = findViewById(R.id.backspace);
        limpar = findViewById(R.id.btn_limpar);
        igual = findViewById(R.id.btn_igual);
        txtResultado = findViewById(R.id.txt_resultado);
        txtExpressao = findViewById(R.id.txt_expressao);

    }

    public void acresentarExpressao(String string, Boolean limparDados){
        if(txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if(limparDados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numero_zero:
                acresentarExpressao("0", true);
                break;
            case R.id.numero_um:
                acresentarExpressao("1", true);
                break;
            case R.id.numero_dois:
                acresentarExpressao("2", true);
                break;
            case R.id.numero_tres:
                acresentarExpressao("3", true);
                break;
            case R.id.numero_quatro:
                acresentarExpressao("4", true);
                break;
            case R.id.numero_cinco:
                acresentarExpressao("5", true);
                break;
            case R.id.numero_seis:
                acresentarExpressao("6", true);
                break;
            case R.id.numero_sete:
                acresentarExpressao("7", true);
                break;
            case R.id.numero_oito:
                acresentarExpressao("8", true);
                break;
            case R.id.numero_nove:
                acresentarExpressao("9", true);
                break;
            case R.id.btn_ponto:
                acresentarExpressao(".", true);
                break;
            case R.id.btn_some:
                acresentarExpressao("+", true);
                break;
            case R.id.btn_subtracao:
                acresentarExpressao("-", false);
                break;
            case R.id.btn_multiplicacao:
                acresentarExpressao("*", false);
                break;
            case R.id.divisao:
                acresentarExpressao("/", false);
                break;
        }
    }
}