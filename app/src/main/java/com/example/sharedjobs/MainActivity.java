package com.example.sharedjobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sharedjobs.databinding.ActivityMainBinding;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

       // bindViews();

        activityMainBinding.editTextTelefoneCelular.setVisibility(View.GONE);
        activityMainBinding.editInstit.setVisibility(View.GONE);
        activityMainBinding.editConclusaoAno.setVisibility(View.GONE);
        activityMainBinding.editOrientador.setVisibility(View.GONE);
        activityMainBinding.editMonografia.setVisibility(View.GONE);
        activityMainBinding.editTextDataFormatura.setVisibility(View.GONE);

        activityMainBinding.spinnerFormacao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if ( ((TextView) view).getText().equals("Fundamental")){
                    activityMainBinding.editTextDataFormatura.setVisibility(View.VISIBLE);
                    activityMainBinding.editOrientador.setVisibility(View.GONE);
                    activityMainBinding.editMonografia.setVisibility(View.GONE);
                    activityMainBinding.editInstit.setVisibility(View.GONE);
                    activityMainBinding.editConclusaoAno.setVisibility(View.GONE);
                } else if ( ((TextView) view).getText().equals("Médio")){
                    activityMainBinding.editTextDataFormatura.setVisibility(View.VISIBLE);
                    activityMainBinding.editOrientador.setVisibility(View.GONE);
                    activityMainBinding.editMonografia.setVisibility(View.GONE);
                    activityMainBinding.editInstit.setVisibility(View.GONE);
                    activityMainBinding.editConclusaoAno.setVisibility(View.GONE);
                }
                else if ( ((TextView) view).getText().equals("Graduação")){
                    activityMainBinding.editTextDataFormatura.setVisibility(View.GONE);
                    activityMainBinding.editConclusaoAno.setVisibility(View.VISIBLE);
                    activityMainBinding.editInstit.setVisibility(View.VISIBLE);
                    activityMainBinding.editOrientador.setVisibility(View.GONE);
                    activityMainBinding.editMonografia.setVisibility(View.GONE);
                }
                else if ( ((TextView) view).getText().equals("Especialização")){
                    activityMainBinding.editTextDataFormatura.setVisibility(View.GONE);
                    activityMainBinding.editConclusaoAno.setVisibility(View.VISIBLE);
                    activityMainBinding.editInstit.setVisibility(View.VISIBLE);
                    activityMainBinding.editOrientador.setVisibility(View.GONE);
                    activityMainBinding.editMonografia.setVisibility(View.GONE);
                }
                else if ( ((TextView) view).getText().equals("Mestradado")){
                    activityMainBinding.editTextDataFormatura.setVisibility(View.GONE);
                    activityMainBinding.editInstit.setVisibility(View.VISIBLE);
                    activityMainBinding.editConclusaoAno.setVisibility(View.VISIBLE);
                    activityMainBinding.editOrientador.setVisibility(View.VISIBLE);
                    activityMainBinding.editMonografia.setVisibility(View.VISIBLE);
                }
                else if ( ((TextView) view).getText().equals("Doutorado")){
                    activityMainBinding.editTextDataFormatura.setVisibility(View.GONE);
                    activityMainBinding.editInstit.setVisibility(View.VISIBLE);
                    activityMainBinding.editConclusaoAno.setVisibility(View.VISIBLE);
                    activityMainBinding.editOrientador.setVisibility(View.VISIBLE);
                    activityMainBinding.editMonografia.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onCheckBoxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.checkBoxCelular:
                //R.id.checkBoxCelular
                if (checked){
                    activityMainBinding.editTextTelefoneCelular.setVisibility(View.VISIBLE);
                } else {
                    activityMainBinding.editTextTelefoneCelular.setVisibility(View.GONE);
                }
                break;
        }

    }

    public void onClickButton(View view){
        switch(view.getId()) {
            case R.id.salvar:
                saveForm();
                break;
            case R.id.limpar:
                cleanform();
                Toast.makeText(this,"limpo", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void cleanform(){
        activityMainBinding.editTextNome.setText("");
        activityMainBinding.editTextEmail.setText("");
        activityMainBinding.editTextTelefone.setText("");
        activityMainBinding.editTextTelefoneCelular.setText("");
        activityMainBinding.editTextNascimento.setText("");
        activityMainBinding.editInstit.setText("");
        activityMainBinding.editMonografia.setText("");
        activityMainBinding.editOrientador.setText("");
        activityMainBinding.editTextDataFormatura.setText("");
    }

    private void saveForm(){
        StringBuffer sumarioSb = new StringBuffer();
        sumarioSb.append("Nome completo: ").append(activityMainBinding.editTextNome.getText()).append("\n");
        sumarioSb.append("E-mail: ").append(activityMainBinding.editTextEmail.getText().toString()).append("\n");
        sumarioSb.append("Tipo de telefone: ");
        switch (activityMainBinding.telefoneRb.getCheckedRadioButtonId()) {
            case 0:
                sumarioSb.append("Residencial");
                break;
            case 1:
                sumarioSb.append("Comercial");
                break;
        }
        sumarioSb.append("\n");
        sumarioSb.append("Deseja receber novidades?: ").append(activityMainBinding.switchEmail.getText()).append("\n");
        sumarioSb.append("Telefone: ").append(activityMainBinding.editTextTelefone.getText().toString()).append("\n");
        sumarioSb.append("Celular: ").append(activityMainBinding.editTextTelefoneCelular.getText().toString()).append("\n");
        sumarioSb.append("Formação: ").append(((TextView) activityMainBinding.spinnerFormacao.getSelectedView()).getText()).append("\n");
        sumarioSb.append("Data de nascimento: ").append(activityMainBinding.editTextNascimento.getText().toString()).append("\n");

        sumarioSb.append("Sexo: ");
        switch (activityMainBinding.sexoRg.getCheckedRadioButtonId()) {
            case 0:
                sumarioSb.append("masculino");
                break;
            case 1:
                sumarioSb.append("feminino");
                break;
        }
        sumarioSb.append("\n");

        String formacaoSelected = (String) activityMainBinding.spinnerFormacao.getSelectedItem();
        if (formacaoSelected.equals("Fundamental") || formacaoSelected.equals("Médio") ) {
            sumarioSb.append("Ano de formatura:: ")
                    .append(activityMainBinding.editTextDataFormatura.getText()).append("\n ");

        } else if (formacaoSelected.equals("Graduação") || formacaoSelected.equals("Especialização")){
            sumarioSb.append("Ano de conclusao: ")
                    .append(activityMainBinding.editConclusaoAno.getText()).append("\n ")
                    .append("Instituição: ").append(activityMainBinding.editInstit.getText()).append("\n");
        } else if (formacaoSelected.equals("Mestradado") || formacaoSelected.equals("Doutorado")){
            sumarioSb.append("Ano de conclusao: ")
                    .append(activityMainBinding.editConclusaoAno.getText()).append("\n ")
                    .append("Instituição: ").append(activityMainBinding.editInstit.getText()).append("\n ")
                    .append("Título monigrafia: ").append(activityMainBinding.editMonografia.getText()).append("\n ")
            .append("Orientador: ").append(activityMainBinding.editInstit.getText()).append("\n");
        }
        if(activityMainBinding.editTextTextMultiLine.getText().equals(""))
            sumarioSb.append("Vagas de interesse: SEM INFORMAÇÂO").append(activityMainBinding.editTextTextMultiLine.getText()).append("\n");
        else
            sumarioSb.append("Vagas de interesse: ").append(activityMainBinding.editTextTextMultiLine.getText()).append("\n");
        sumarioSb.append("\n");

        Toast.makeText(this, sumarioSb.toString(), Toast.LENGTH_SHORT).show();
    }
}