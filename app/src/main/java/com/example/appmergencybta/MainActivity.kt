package com.example.appmergencybta

import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appmergencybta.databinding.ActivityMainBinding
import com.example.appmergencybta.ui.typification.TypificationViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var mediaPlayerOpening: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        
        // Reproducir sonido de apertura
        playOpeningSound()

        // Inicializar la base de datos en segundo plano
        initializeDatabase()

        // Ocultar el FAB ya que no lo usamos en esta aplicación
        binding.appBarMain.fab.hide()
        
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        
        // Configurar los destinos de nivel superior
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.inicioFragment, R.id.modulesFragment, R.id.typificationCodesFragment,
                R.id.progressFragment, R.id.usersFragment
            ), drawerLayout
        )
        
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    
    /**
     * Inicializa la base de datos en segundo plano
     */
    private fun initializeDatabase() {
        // Inicializar el ViewModel para que se carguen los datos
        val viewModel = ViewModelProvider(this).get(TypificationViewModel::class.java)
        
        // También podemos inicializar la base de datos directamente si es necesario
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.loadCodes()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    
    /**
     * Reproduce el sonido de apertura de la aplicación
     */
    private fun playOpeningSound() {
        try {
            mediaPlayerOpening = MediaPlayer.create(this, R.raw.opening)
            mediaPlayerOpening?.setOnCompletionListener { mp ->
                mp.release()
                mediaPlayerOpening = null
            }
            mediaPlayerOpening?.start()
        } catch (e: Exception) {
            // Manejar la excepción silenciosamente
        }
    }
    
    override fun onDestroy() {
        super.onDestroy()
        // Liberar recursos de MediaPlayer
        mediaPlayerOpening?.release()
        mediaPlayerOpening = null
    }
}