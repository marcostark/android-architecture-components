package dev.marcosouza.databinding.util

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import dev.marcosouza.databinding.R
import dev.marcosouza.databinding.data.Popularity


@BindingAdapter("app:hideIfZero")
fun hideIfZero(view: View, number: Int) {
    view.visibility = if (number == 0) View.GONE else View.VISIBLE
}

    /**
     * Seta o valor da barra de programsso, o valor máximo para o progresso
     * será 5. Mostra adaptadores de ligacão com vários atributos. Observe uqe o adaptador é chamado
     * sempre que agum atributo for alterado.
     * Esse adaptador não será utilizado caso algum dos atributos esteja ausente.
     */
    @BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
    fun setProgress(progressBar: ProgressBar, likes: Int, max: Int) {
        progressBar.progress = (likes * max / 5).coerceAtMost(max)
    }

    @BindingAdapter("app:iconByPopulatiry")
    fun setIconByPopularity(view: ImageView, popularity: Popularity) {

        val color = changeAssociatedColor(popularity, view.context)

        ImageViewCompat.setImageTintList(view, ColorStateList.valueOf(color))

        view.setImageDrawable(changeIcon(popularity, view.context))
    }

    fun changeIcon( popularity: Popularity, context: Context): Drawable? {
        return when (popularity) {
            Popularity.NORMAL -> {
                ContextCompat.getDrawable(context, R.drawable.ic_person_black_96dp)
            }
            Popularity.POPULAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
            Popularity.STAR -> {
                ContextCompat.getDrawable(context, R.drawable.ic_whatshot_black_96dp)
            }
        }
    }

    private fun changeAssociatedColor(popularity: Popularity, context: Context): Int {
        return when (popularity) {
            Popularity.NORMAL -> context.theme.obtainStyledAttributes(
                intArrayOf(android.R.attr.colorForeground)
            ).getColor(0, 0x000000)
            Popularity.POPULAR -> ContextCompat.getColor(context, R.color.popular)
            Popularity.STAR -> ContextCompat.getColor(context, R.color.star)
        }
    }
