package dev.marcosouza.databinding.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class SimpleViewModel : ViewModel() {

    private val _name = MutableLiveData("Grace")
    private val _lastName = MutableLiveData("Hopper")
    private val _likes = MutableLiveData(0)

    var likes: LiveData<Int> = _likes
    var name: LiveData<String> = _name
    var lastName: LiveData<String> = _lastName



    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }

//    val popularity: Popularity
//        get() {
//            return when {
//                likes > 9 -> Popularity.STAR
//                likes > 4 -> Popularity.POPULAR
//                else -> Popularity.NORMAL
//            }
//        }
//    }

    /**
     * Atualizando a interface do usuário quando o valor for alterado
     */
    val popularity: LiveData<Popularity> = Transformations.map(_likes) {
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }

    }
}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}