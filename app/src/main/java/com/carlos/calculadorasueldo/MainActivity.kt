package com.carlos.calculadorasueldo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.carlos.calculadorasueldo.ui.theme.CalculadoraSueldoTheme

class MainActivity : ComponentActivity() {
    val cargos = mapOf(
        "Director" to 50000,
        "Diseñador" to 50000,
        "Recepcionista" to 50000,
        "Ingeniero" to 50000,
        "Arquitecto" to 50000,
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val spinnerCargo = findViewById<Spinner>(R.id.spinnerCargo)
        val etHoras = findViewById<EditText>(R.id.horas)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        // Lógica para calcular el salario
        btnCalcular.setOnClickListener {
            val cargoSeleccionado = spinnerCargo.selectedItem.toString()
            val horas = etHoras.text.toString().toIntOrNull()

            if (horas != null && horas > 0) {
                val tarifa = when (cargoSeleccionado) {
                    "Director" -> 55000
                    "Consultor" -> 40000
                    "Repartidor" -> 25000
                    "Recepcionista" -> 30000
                    "Ingeniero" -> 45000
                    else -> 0
                }

                val salario = horas * tarifa
                tvResultado.text = "Salario:$$salario COP"
            } else {
                Toast.makeText(this, "Ingrese un número válido de horas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

