package com.example.ys.weather_ping;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.ys.weather_ping.R.id.spinner;

public class Second extends Activity implements AdapterView.OnItemSelectedListener {
    String anf;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Button button=(Button)findViewById(R.id.button);

        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<String>();
        categories.add("Greater Noida");
        categories.add("Kanpur");
        categories.add("Darbhanga");
        categories.add("Bhubaneshwar");
        categories.add("Andra Pradesh");
        categories.add("Arunachal Pradesh");
        categories.add("Assam");
        categories.add("Bihar");
        categories.add("Chhattisgarh");
        categories.add("Delhi");
        categories.add("Goa");
        categories.add("Gujarat");
        categories.add("Haryana");
        categories.add("Himachal Pradesh");
        categories.add("Jammu and Kashmir");
        categories.add("Jharkhand");
        categories.add("Karnataka");
        categories.add("Kerala");
        categories.add("Madya Pradesh");
        categories.add("Maharashtra");
        categories.add("Manipur");
        categories.add("Meghalaya");
        categories.add("Mizoram");
        categories.add("Nagaland");
        categories.add("Orissa");
        categories.add("Punjab");
        categories.add("Rajasthan");
        categories.add("Sikkim");
        categories.add("Tamil Nadu");
        categories.add("Tripura");
        categories.add("Uttaranchal");
        categories.add("Uttar Pradesh");
        categories.add("West Bengal");
        categories.add("Andaman and Nicobar Islands");
        categories.add("Dadar and Nagar Haveli");
        categories.add("Daman and Diu");
        categories.add("Lakshadeep");
        categories.add("Pondicherry");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Second.this,Third.class);
                intent.putExtra("data",anf);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        TextView tmpView = (TextView) parent.getSelectedView().findViewById(android.R.id.text1);
        tmpView.setTextColor(Color.WHITE);

        if (item == "Greater Noida") {
            anf = new String("INXX0338");}
        else if (item == "Kanpur") {
            anf = new String("INXX0067");}
        else if (item == "Darbhanga") {
            anf = new String("INXX0324");}
        else if (item == "Bhubaneshwar") {
            anf = new String("INXX0024");}
        else if (item == "Andra Pradesh") {
            anf = new String("INXX0057");}
        else if (item == "Arunachal Pradesh") {
            anf = new String("INXX0190");}
        else if (item == "Assam") {
            anf = new String("INXX0187");}
        else if (item == "Bihar") {
            anf = new String("INXX0100");}
        else if (item == "Chhattisgarh") {
            anf = new String("INXX0228");}
        else if (item == "Delhi") {
            anf = new String("INXX0038");}
        else if (item == "Goa") {
            anf = new String("INXX0387");}
        else if (item == "Gujarat") {
            anf = new String("INXX0048");}
        else if (item == "Haryana") {
            anf = new String("INXX0185");}
        else if (item == "Himachal Pradesh") {
            anf = new String("INXX0195");}
        else if (item == "Jammu and Kashmir") {
            anf = new String("INXX0197");}
        else if (item == "Jharkhand") {
            anf = new String("INXX0152");}
        else if (item == "Karnataka") {
            anf = new String("INXX0012");}
        else if (item == "Kerala") {
            anf = new String("INXX0198");}
        else if (item == "Madya Pradesh") {
            anf = new String("INXX0023");}
        else if (item == "Maharashtra") {
            anf = new String("INXX0087");}
        else if (item == "Manipur") {
            anf = new String("INXX0189");}
        else if (item == "Meghalaya") {
            anf = new String("INXX0196");}
        else if (item == "Mizoram") {
            anf = new String("INXX0429");}
        else if (item == "Nagaland") {
            anf = new String("INXX0191");}
        else if (item == "Orissa") {
            anf = new String("INXX0024");}
        else if (item == "Punjab") {
            anf = new String("INXX0185");}
        else if (item == "Rajasthan") {
            anf = new String("INXX0059");}
        else if (item == "Sikkim") {
            anf = new String("INXX0049");}
        else if (item == "Tamil Nadu") {
            anf = new String("INXX0202");}
        else if (item == "Tripura") {
            anf = new String("INXX0153");}
        else if (item == "Uttaranchal") {
            anf = new String("INXX0140");}
        else if (item == "Uttar Pradesh") {
            anf = new String("INXX0074");}
        else if (item == "West Bengal") {
            anf = new String("INXX0300");}
        else if (item == "Andaman and Nicobar Islands") {
            anf = new String("INXX0179");}
        else if (item == "Dadar and Nagar Haveli") {
            anf = new String("INXX5508");}
        else if (item == "Daman and Diu") {
            anf = new String("INXX0034");}
        else if (item == "Lakshadeep") {
            anf = new String("INXX0181");}
        else if (item == "Pondicherry") {
            anf = new String("INXX0101");}
        /*Toast toast = Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();*/
    }
    public void onNothingSelected(AdapterView<?> arg0) {


    }

}