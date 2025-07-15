package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*

class MainFragment : BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = "Memes Malos"

        val categories = ArrayObjectAdapter(ListRowPresenter())

        // Categoría Acción
        val accionVideos = ArrayObjectAdapter(Card())
        accionVideos.addAll(0, listOf(
            Video("Pinguinos", "accion", R.mipmap.accion, "Pinguinos de madagascar", R.raw.accion_1),
            Video("Tortuga", "accion", R.mipmap.amlo, "Tortuga bailando en accion", R.raw.accion_2),
            Video("Hola :D", "accion", R.mipmap.ani, "Un random diciendo Hola", R.raw.accion_3),
            Video("Melman de madagascar", "accion", R.mipmap.cabellorosa, "Melman dicendo C Melman", R.raw.accion_4),
            Video("MrGraso", "accion", R.mipmap.chuerk, "MrGraso con el Uriel", R.raw.accion_5)

        ))
        val accionHeader = HeaderItem(1, "Acción")
        categories.add(ListRow(accionHeader, accionVideos))

        // Categoría Romance
        val romanceVideos = ArrayObjectAdapter(Card())
        romanceVideos.addAll(0, listOf(
            Video("Hola :v", "romance", R.mipmap.amor, "Intro de hola", R.raw.amor_1),
            Video("Chavalos", "romance", R.mipmap.dewey, "No se droguen chavalos", R.raw.amor_2),
            Video("El chumchum", "romance", R.mipmap.foto_perfil, "El chucmchum me corro", R.raw.amor_3),
            Video("Dross cochino", "romance", R.mipmap.fua, "Dross haciendo señaes obscenas", R.raw.amor_4),
            Video("Un video mas", "romance", R.mipmap.jh, "Nose que voy a poner aqui, espero no seas obsceno", R.raw.amor_5)
        ))
        val romanceHeader = HeaderItem(2, "Romance")
        categories.add(ListRow(romanceHeader, romanceVideos))

        // Categoría Comedia
        val comediaVideos = ArrayObjectAdapter(Card())
        comediaVideos.addAll(0, listOf(
            Video("Alo", "comedia", R.mipmap.comedia, "Alo :D", R.raw.comedia_1),
            Video("Se ofendio", "comedia", R.mipmap.late, "Jajaj se ofendio", R.raw.comedia_2),
            Video("Se volvio a ofender", "comedia", R.mipmap.mau, "jajaj se volvio a ofender", R.raw.comedia_3),
            Video("Maau ofendiendo", "comedia", R.mipmap.pablo, "Mi lic mauricio", R.raw.comedia_4),
            Video("Calzones del admin", "comedia", R.mipmap.papadio, "Tengo los calzones del admin", R.raw.comedia_5)
        ))
        val comediaHeader = HeaderItem(3, "Comedia")
        categories.add(ListRow(comediaHeader, comediaVideos))

        // Categoría Terror
        val terrorVideos = ArrayObjectAdapter(Card())
        terrorVideos.addAll(0, listOf(
            Video("Carne asada", "terror", R.mipmap.terror, "Ya no hay carne asada", R.raw.terror_1),
            Video("Wacareada", "terror", R.mipmap.yomero, "Sonido de gomito", R.raw.terror_2),
            Video("Se va", "terror", R.mipmap.yvv, "Se va del chat", R.raw.terror_3),
            Video("Awebo", "terror", R.mipmap.webas, "Awebo", R.raw.terror_4),
            Video("Que me miras", "terror", R.mipmap.urigod, "Que chuchca me miras", R.raw.terror_5)
        ))
        val terrorHeader = HeaderItem(4, "Terror")
        categories.add(ListRow(terrorHeader, terrorVideos))

        // Categoría Drama
        val dramaVideos = ArrayObjectAdapter(Card())
        dramaVideos.addAll(0, listOf(
            Video("Wiwiwi", "drama", R.mipmap.drama, "Wiwiwi estoy endeudao", R.raw.drama_1),
            Video("Jomer sinson", "drama", R.mipmap.poue, "Jomer sinson bailando", R.raw.drama_2),
            Video("El jal grosero", "drama", R.mipmap.perro_oxxo, "El jal diciendo una groseria", R.raw.drama_3),
            Video("Pez bailando", "drama", R.mipmap.odto, "Un pez bailando con musica", R.raw.drama_4),
            Video("Silencio", "drama", R.mipmap.nft, "Guarda silencio", R.raw.drama_5)
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
