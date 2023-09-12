enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        inscritos.addAll(usuarios)
    }

    override fun toString(): String {
        return "Formação: $nome\nNível: $nivel\nConteúdos: $conteudos\nInscritos: $inscritos"
    }
}

fun main() {
    val kotlinBasico = ConteudoEducacional("Kotlin Básico", 30)
    val kotlinAvancado = ConteudoEducacional("Kotlin Avançado", 45)
    val androidBasico = ConteudoEducacional("Android Básico", 60)

    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin",
        nivel = Nivel.INTERMEDIARIO,
        conteudos = listOf(kotlinBasico, kotlinAvancado)
    )

    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")
    val usuario3 = Usuario("Carol")

    formacaoKotlin.matricular(usuario1, usuario2, usuario3)

    println(formacaoKotlin)
}

