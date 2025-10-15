
import com.example.domain.entities.ChatResponse

sealed interface ChatUiState {
    object Idle : ChatUiState
    object Loading : ChatUiState
    data class Success(val response: List<ChatResponse>) : ChatUiState
    data class Error(val message: String) : ChatUiState
}
