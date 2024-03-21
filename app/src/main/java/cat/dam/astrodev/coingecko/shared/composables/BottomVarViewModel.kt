package cat.dam.astrodev.coingecko.shared.composables

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BottomVarViewModel : ViewModel() {
    var selectedPage by mutableStateOf(BottomNavigationItem.HOME)
    companion object {
        val instance = BottomVarViewModel()
    }
}