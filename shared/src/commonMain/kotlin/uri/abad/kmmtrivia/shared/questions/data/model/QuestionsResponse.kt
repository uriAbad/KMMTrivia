package uri.abad.kmmtrivia.shared.questions.data.model

import kotlinx.serialization.Serializable

@Serializable
data class QuestionsResponse (
    val response_code : Int,
    val results : List<Results>
)

@Serializable
data class Results (
    val category : String,
    val type : String,
    val difficulty : String,
    val question : String,
    val correct_answer : String,
    val incorrect_answers : List<String>
)