package ipvc.estg.cm_tb

data class UserModel (
    var userId: String? = null,
    var userNome: String? = null,
    var userEmail: String? = null,
    val userPassword: String? = null,
    var userNumero: String? = null,
    val userTelemovel: String? = null,
    val userPontos: Int? = null
)