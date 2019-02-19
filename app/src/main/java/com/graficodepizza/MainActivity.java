package com.graficodepizza;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    float itensGrafico[] = {98.6f, 56.8f, 45.7f, 10.5f};
    String descricao[] = {"Janeiro","Fevereiro","Março","Abril","Maio"};
    PieChart grafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// o view sem que estar minisculo na classe activity!!!
        grafico = (PieChart) findViewById(R.id.graficoID);

        List<PieEntry> entradasGrafico = new ArrayList<>();
        for (int i = 0; i < itensGrafico.length; i++) {
          entradasGrafico.add(new PieEntry(itensGrafico[i],descricao[i]));
            }

        PieDataSet dataSet = new PieDataSet(entradasGrafico,  "Legenda do Gráfico");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData pieData = new PieData(dataSet);
        grafico.animateY(1300);
        grafico.setData(pieData);
        grafico.invalidate();

    }
}