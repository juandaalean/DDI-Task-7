package com.example.dditask7

import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MainActivity : AppCompatActivity() {

    private lateinit var ivFavorite: ImageView
    private lateinit var tvFavoriteCount: TextView
    private lateinit var btnEnviar: Button
    private lateinit var btnOferta: Button
    private lateinit var btnComprar: Button
    private lateinit var tvMas: TextView
    private lateinit var ivToolbarMenu: ImageView


    private var isFavorite = false
    private var favoriteCount = 18

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivFavorite = findViewById(R.id.corazon)
        tvFavoriteCount = findViewById(R.id.corazon_numero)
        btnEnviar = findViewById(R.id.enviar_button)
        btnOferta = findViewById(R.id.offers_button)
        btnComprar = findViewById(R.id.buy_button)
        tvMas = findViewById(R.id.mas_text)
        ivToolbarMenu = findViewById(R.id.toolbar_menu)

        //Menu Toolbar
        ivToolbarMenu.setOnClickListener { view ->
            showPopMenu(view)
        }

        //Boton favoritos
        ivFavorite.setOnClickListener {
            if (isFavorite) {
                isFavorite = false
                favoriteCount--
                ivFavorite.setImageResource(R.drawable.baseline_favorite_border_24)
            } else {
                isFavorite = true
                favoriteCount++
                ivFavorite.setImageResource(R.drawable.baseline_favorite_24)
            }
            tvFavoriteCount.text = "$favoriteCount"
        }

        //Imagen redonda
        val imageView = findViewById<ImageView>(R.id.foto_perfil)
        Glide.with(this)
            .load(R.drawable.foto_perfil)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)

        //Toasts
        btnEnviar.setOnClickListener {
            Toast.makeText(this, "Botón enviar pulsado.", Toast.LENGTH_SHORT).show()
        }
        btnOferta.setOnClickListener {
            Toast.makeText(this, "Botón hacer oferta pulsado.", Toast.LENGTH_SHORT).show()
        }
        btnComprar.setOnClickListener {
            Toast.makeText(this, "Botón comprar pulsado.", Toast.LENGTH_SHORT).show()
        }
        tvMas.setOnClickListener {
            Toast.makeText(this, "Botón más pulsado.", Toast.LENGTH_SHORT).show()
        }
    }

    //Menu Toolbar desplegable
    private fun showPopMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater: MenuInflater = popupMenu.menuInflater
        inflater.inflate(R.menu.toolbar_menu, popupMenu.menu)
        popupMenu.show()
    }
}