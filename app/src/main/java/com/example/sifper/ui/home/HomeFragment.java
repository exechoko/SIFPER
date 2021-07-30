package com.example.sifper.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sifper.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    CardView btnAdicionales, btnRecibos, btnWebPER, btnWebGob, btnNotas, btnLicencias, btnDependencias, btnOtros;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnAdicionales = root.findViewById(R.id.btnAdicionales);
        btnRecibos = root.findViewById(R.id.btnRecibos);
        btnWebPER = root.findViewById(R.id.btnWebPER);
        btnWebGob = root.findViewById(R.id.btnWebGob);
        btnNotas = root.findViewById(R.id.btnNotas);
        btnLicencias = root.findViewById(R.id.btnLicencias);
        btnDependencias = root.findViewById(R.id.btnDependencias);
        btnOtros = root.findViewById(R.id.btnOtros);

        btnAdicionales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link = Uri.parse("http://www.adicionalesper.com.ar/dpa/indexag.php");
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
            }
        });

        btnRecibos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link = Uri.parse("https://apps.entrerios.gov.ar/RecibosDigitales/#/login");
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
            }
        });

        btnWebPER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link = Uri.parse("https://www.policiadeentrerios.gob.ar/portal/");
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
            }
        });

        btnWebGob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri link = Uri.parse("https://www.entrerios.gov.ar/portal/");
                Intent i = new Intent(Intent.ACTION_VIEW, link);
                startActivity(i);
            }
        });

        btnNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Modelos de notas", Toast.LENGTH_SHORT).show();
            }
        });

        btnLicencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Licencias usadas y disponibles", Toast.LENGTH_SHORT).show();
            }
        });

        btnDependencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Dependencias Policiales", Toast.LENGTH_SHORT).show();
            }
        });

        btnOtros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Otros", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}