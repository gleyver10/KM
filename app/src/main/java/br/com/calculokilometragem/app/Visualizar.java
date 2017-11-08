package br.m.calculokilometragem.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 16254851 on 31/10/2017.
 */

public class Visualizar extends AppCompatActivity {
    ListView listView;

    Valor adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza);

        listView = (ListView) findViewById(R.id.listViewKmPorMes);

        List<br.m.calculokilometragem.app.KM> list = br.m.calculokilometragem.app.KM.listAll(br.m.calculokilometragem.app.KM.class);
//        list.add();
//        list.add();

        adapter = new Valor(this, list);


        listView.setAdapter(adapter);



    }

    //Adapter obejeto responsavel para pegar os itens do array list e joga na lista
    private  class Valor extends ArrayAdapter<br.m.calculokilometragem.app.KM> {
        public Valor(Context context, List<br.m.calculokilometragem.app.KM> itens){
            super(context, 0, itens);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            View v = convertView;

            if (v == null){
                v= LayoutInflater.from(getContext()).inflate(R.layout.item_lista, null);
            }

            br.m.calculokilometragem.app.KM item = getItem(position);

            TextView preco = v.findViewById(R.id.preco);
            TextView txt_mes = v.findViewById(R.id.txt_mes);

            preco.setText(item.getVALOR_ITEM() + "");
            txt_mes.setText(item.getMES().toString());

            return v;

        }
    }

}
