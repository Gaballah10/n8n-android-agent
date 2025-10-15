

sealed interface AgentUiAction{
    object Thinking: AgentUiAction
    object Respond: AgentUiAction
}