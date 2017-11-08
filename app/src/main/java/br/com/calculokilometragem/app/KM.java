package br.m.calculokilometragem.app;

import android.widget.Spinner;

import com.orm.SugarRecord;

/**
 * Created by 16254851 on 01/11/2017.
 */

public class KM extends SugarRecord{

    private Integer KM;
    private Integer MES;

    public void setKM(Integer KM) {
        this.KM = KM;
    }

    public Integer getMES() {
        return MES;
    }

    public void setMES(Integer MES) {
        this.MES = MES;
    }

    public Float getVALOR_ITEM() {
        return VALOR_ITEM;
    }

    public void setVALOR_ITEM(Float VALOR_ITEM) {
        this.VALOR_ITEM = VALOR_ITEM;
    }

    private Float VALOR_ITEM;


    //CONTRUTOR OBRIGATORIO
    public KM(Spinner spn, String preco){

    }

    public KM(Integer MES,Float VALOR_ITEM){
        this.MES = MES;
        this.VALOR_ITEM = VALOR_ITEM;
    }
    public Integer getKM() {
        return KM;
    }

}
