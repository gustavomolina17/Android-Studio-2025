package com.impacta.calculadoraaposentadoria2025

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerSexo: Spinner
    private lateinit var editTextIdade: EditText
    private lateinit var buttonCalcular: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialização dos componentes
        spinnerSexo = findViewById(R.id.spinner_sexo)
        editTextIdade = findViewById(R.id.editText_idade)
        buttonCalcular = findViewById(R.id.button_calcular)

        // Configurar o Spinner para selecionar sexo
        val opcoesSexo = arrayOf("Masculino", "Feminino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcoesSexo)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSexo.adapter = adapter

        // Configurar o botão de calcular
        buttonCalcular.setOnClickListener {
            calcularAposentadoria()
        }
    }

    private fun calcularAposentadoria() {
        // Obter os dados do usuário
        val idade = editTextIdade.text.toString().toIntOrNull()
        val sexo = spinnerSexo.selectedItem.toString()

        // Verificar se a idade foi inserida corretamente
        if (idade == null) {
            Toast.makeText(this, "Por favor, insira uma idade válida.", Toast.LENGTH_SHORT).show()
            return
        }

        val aposentadoria = when (sexo) {
            "Masculino" -> 65 - idade  // Idade de aposentadoria para homens
            "Feminino" -> 62 - idade   // Idade de aposentadoria para mulheres
            else -> 0
        }

        if (aposentadoria <= 0) {
            Toast.makeText(this, "Você já pode se aposentar!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Faltam $aposentadoria anos para sua aposentadoria.", Toast.LENGTH_LONG).show()
        }
    }
}
