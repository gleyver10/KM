package br.m.calculokilometragem.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Integer MES;
    Spinner spn;
    EditText edtPreco;
//    String janeiro;
//    String fevereiro;
//    String marco;
//    String abril;
//    String maio;
//    String junho;
//    String julho;
//    String agosto;
//    String setembro;
//    String outubro;
//    String novembro;
//    String dezembro;
//    String mesAno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> mesAnos = new ArrayList<>();
        mesAnos.add("Janeiro");
        mesAnos.add("Fevereiro");
        mesAnos.add("Março");
        mesAnos.add("Abril");
        mesAnos.add("Maio");
        mesAnos.add("Junho");
        mesAnos.add("Julho");
        mesAnos.add("Agosto");
        mesAnos.add("Setembro");
        mesAnos.add("Outubro");
        mesAnos.add("Novembro");
        mesAnos.add("Dezembro");

        spn = (Spinner) findViewById(R.id.spnMes);
        edtPreco =(EditText)findViewById(R.id.edtPreco);

        ArrayAdapter adapter =new ArrayAdapter(this, android.R.layout.simple_spinner_item, mesAnos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spn.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if(id == R.id.visualize){
            startActivity(new Intent(this, br.m.calculokilometragem.app.Visualizar.class));
        }
        return true;
    }


    public void inserir(View view) {
        String preco = edtPreco.getText().toString();

        if (preco.isEmpty()){
            edtPreco.setError("Informe o valor!");
        }

        Integer posicao = spn.getSelectedItemPosition()+1;


        MES = posicao;

        br.m.calculokilometragem.app.KM item = new br.m.calculokilometragem.app.KM(MES, Float.parseFloat(preco));

        //adiconando no banco
        item.save();

        edtPreco.setText(null);
    }
}
