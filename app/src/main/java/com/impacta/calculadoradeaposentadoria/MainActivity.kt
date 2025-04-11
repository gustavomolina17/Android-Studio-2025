package com.impacta.calculadoradeaposentadoria

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.Toast




class MainActivity : AppCompatActivity() {
    private lateinit var spinnerSexo: Spinner
    private lateinit var editText: EditText
    private lateinit var buttonCalcular: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerSexo = findViewById(R.id.spinner_sexo)
        editText = findViewById(R.id.editText_idade)
        buttonCalcular = findViewById(R.id.button_calcular)

        // Configurar o Spinner
        val opcoesSexo = arrayOf("Masculino", "Feminino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcoesSexo)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSexo.adapter = adapter

        //Configurar o clique do botão

        buttonCalcular.setOnClickListener() {
            calcularAposentadoria()
        }
    }

        private fun calcularAposentadoria() {
            val idade = editText.text.toString().toIntOrNull()
            val sexo = spinnerSexo.selectedItem.toString()

            if (idade != null) {
                val idadeAposentadoria = if (sexo == "Masculino") 65 else 62
                val anosRestantes = idadeAposentadoria - idade

                if (anosRestantes > 0) {
                    Toast.makeText(
                        this,
                        "Faltam $anosRestantes anos para a aposentadoria.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(this, "você já pode  se aposentar!", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this, "Por favor, Insira uma idade válida.", Toast.LENGTH_LONG)
                    .show()
            }

            }

        }



