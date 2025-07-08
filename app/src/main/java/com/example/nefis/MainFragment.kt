package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*

class MainFragment : BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = "PelisPlus +"

        val categories = ArrayObjectAdapter(ListRowPresenter())

        // Categoría Acción
        val accionVideos = ArrayObjectAdapter(Card())
        accionVideos.addAll(0, listOf(
            Video("icono", "dibujo", R.mipmap.mishito, "Esta es la descripcion de mishito", R.raw.nutella),
            Video("sin luz", "foto", R.mipmap.mandarino, "Esta es la descripcion de mandarino", R.raw.utzmg)
        ))
        val accionHeader = HeaderItem(1, "Acción")
        categories.add(ListRow(accionHeader, accionVideos))

        // Categoría Romance
        val romanceVideos = ArrayObjectAdapter(Card())
        romanceVideos.addAll(0, listOf(
            Video("Amor eterno", "romance", R.mipmap.romance1, "Una historia de amor inolvidable", R.raw.romance_video1),
            Video("Encuentro inesperado", "romance", R.mipmap.romance2, "Dos almas se cruzan en el destino", R.raw.romance_video2)
        ))
        val romanceHeader = HeaderItem(2, "Romance")
        categories.add(ListRow(romanceHeader, romanceVideos))

        // Categoría Comedia
        val comediaVideos = ArrayObjectAdapter(Card())
        comediaVideos.addAll(0, listOf(
            Video("Risas garantizadas", "comedia", R.mipmap.comedia1, "Prepárate para reír sin parar", R.raw.comedia_video1),
            Video("Locuras en casa", "comedia", R.mipmap.comedia2, "Una familia muy peculiar", R.raw.comedia_video2)
        ))
        val comediaHeader = HeaderItem(3, "Comedia")
        categories.add(ListRow(comediaHeader, comediaVideos))

        // Categoría Terror
        val terrorVideos = ArrayObjectAdapter(Card())
        terrorVideos.addAll(0, listOf(
            Video("La casa maldita", "terror", R.mipmap.terror1, "Un lugar del que nadie regresa", R.raw.terror_video1),
            Video("Susurros en la oscuridad", "terror", R.mipmap.terror2, "Algo se esconde en las sombras", R.raw.terror_video2)
        ))
        val terrorHeader = HeaderItem(4, "Terror")
        categories.add(ListRow(terrorHeader, terrorVideos))

        // Categoría Drama
        val dramaVideos = ArrayObjectAdapter(Card())
        dramaVideos.addAll(0, listOf(
            Video("Decisiones difíciles", "drama", R.mipmap.drama1, "Un hombre lucha por su familia", R.raw.drama_video1),
            Video("Segundas oportunidades", "drama", R.mipmap.drama2, "El pasado siempre regresa", R.raw.drama_video2)
        ))
        val dramaHeader = HeaderItem(5, "Drama")
        categories.add(ListRow(dramaHeader, dramaVideos))

        adapter = categories

        onItemViewClickedListener = OnItemViewClickedListener { _, video, _, _ ->
            val intent = Intent(requireContext(), PlayActivity::class.java).apply {
                putExtra(PlayActivity.MOVIE_EXTRA, video as Video)
            }
            startActivity(intent)
        }
    }
}
