package edu.ub.pis2016.jlauarma9.appdivises;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View.OnClickListener;
import android.widget.TextView;


/*
els imports de més adalt s'han afegit per tal de poder fer ús dels botons creats dins la classe 

*/



public class MainActivity extends AppCompatActivity implements OnClickListener {


    // per tal que funcioni l'app, en aquesta classe hauria d'afegir listeners per als diferents buttons, events i mètodes 

    // es creen els camps necessaris per a recollir els compoents de la interficie grafica

    EditText dolars;
    EditText euros;
    EditText canvi;
    RadioButton dolarsAEuros;   // es crea un radiobutton per al canvi de dolars a euros
    RadioButton eurosADolars;    // es crea un radiobutton per al canvi d'euros a dolars
    Button convertir;            // es crea un button per a portar a terme la conversio desitjada



    @Override
    protected void onCreate(Bundle savedInstanceState) {   // el mètode 'onCreate' carrega el layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inicialitzacio de camps

        dolars = (EditText) this.findViewById(R.id.edtDolars);
        euros = (EditText) this.findViewById(R.id.edtEuros);
        canvi = (EditText) this.findViewById(R.id.etCanvi);

        dolarsAEuros = (RadioButton) this.findViewById(R.id.rbDolarsAEuros);
        dolarsAEuros.setChecked(true);
        eurosADolars = (RadioButton) this.findViewById(R.id.rbEurosADolars);

        convertir = (Button) this.findViewById(R.id.btnConvertir);


        // events

        convertir.setOnClickListener((View.OnClickListener) this);
        dolarsAEuros.setOnClickListener((View.OnClickListener) this);
        eurosADolars.setOnClickListener((View.OnClickListener) this);



    }



    /*
    Converteix dolars a euros
    */


    protected void convertirDolarsAEuros() {

        double val;
        double tmp;

        // Controla els camps introduits
        if ("".equals(dolars.getText().toString())) {
            val = 0;

        }
        else{
            val = Double.parseDouble(dolars.getText().toString());

        }

        if ("".equals(canvi.getText().toString())) {
            tmp = 0;

        }
        else{
            tmp = Double.parseDouble(canvi.getText().toString());

        }

        // Converteix el canvi a euros
        euros.setText(Double.toString(val * tmp));

    }


    /**
    Converteix els euros a dolars
    */

    protected void convertirEurosADolars() {

        double val;
        double tmp;

        // Controla els camps introduits
        if ("".equals(euros.getText().toString())){
            val = 0;
        }
        else{
            val = Double.parseDouble(euros.getText().toString());
        }

        if ("".equals(canvi.getText().toString())){
            tmp = 0;
        }
        else{
            tmp = Double.parseDouble(canvi.getText().toString());
        }


        // Convierteix el canvi a dolars
        dolars.setText(Double.toString(val/tmp));
    }




    /**
    Converteix euros a dolars , o dolars a euros

    */

    public void onClick(View v) {
        // Controla el radioButton comprovat
        if (v == convertir){
            if (dolarsAEuros.isChecked()) {
                convertirDolarsAEuros();
            }
            if (eurosADolars.isChecked()) {
                convertirEurosADolars();
            }
        }

        // Controla que no estiguin 2 radioButtons comprovats
        if (v == dolarsAEuros){
            eurosADolars.setChecked(false);
        }

        if (v == eurosADolars){
            dolarsAEuros.setChecked(false);
        }

    }


}
