// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String) { var cursos = mutableListOf<Formacao>()}

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    var inscritos = mutableListOf<Usuario>()
    var cargaHorariaTotal = 0
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        usuario.cursos.add(this)
    }
    
    fun calcularCargaHoraria() {
        for (conteudo in conteudos) { cargaHorariaTotal += conteudo.duracao }
    }
}

fun imprimirCurso(formacao: Formacao) {
    println("----------------------------------------------------")
    println("Bem-vindo(a) ao " + formacao.nome)
    println("Os conteúdos são: ")
    for (conteudo in formacao.conteudos) { 
        println("\t" 
                + conteudo.nome 
                + "(" 
                + conteudo.nivel 
                + ")" + " -> carga horária: "
                + conteudo.duracao) 
    }
    println("Carga horária total do Bootcamp: " + formacao.cargaHorariaTotal + " horas")
    println("Alunos matriculados: ")
    for (aluno in formacao.inscritos) { println("\t" + aluno.nome) }
    println("----------------------------------------------------")
}

fun imprimirUsuario(usuario: Usuario) {
    println("----------------------------------------------------")
    println("Bem-vindo(a), " + usuario.nome)
    println("Os cursos que você se inscreveu são: ")
    for (curso in usuario.cursos) { println("\t" + curso.nome) }
    println("----------------------------------------------------")
}

fun main() {
    val java = ConteudoEducacional("Java", 60, Nivel.BASICO)
    val docker = ConteudoEducacional("Docker", 40, Nivel.INTERMEDIARIO)
    val kotlin = ConteudoEducacional("Kotlin", 120, Nivel.AVANCADO)
    val javascript = ConteudoEducacional("Javascript", 120, Nivel.AVANCADO)
    val mySQL = ConteudoEducacional("MySQL", 60, Nivel.BASICO)
    val css = ConteudoEducacional("CSS", 80, Nivel.INTERMEDIARIO)
    val html = ConteudoEducacional("HTML", 40, Nivel.INTERMEDIARIO)
    
    val bootcampTQI = Formacao("Bootcamp TQI Kotlin - Backend Developer", listOf(java, mySQL, docker, kotlin))
    bootcampTQI.calcularCargaHoraria()
    val bootcampFront = Formacao("Bootcamp Frontend DIO", listOf(html, css, javascript))
    bootcampFront.calcularCargaHoraria()
    
    val joao = Usuario("João")
    val maria = Usuario("Maria")
    val ana = Usuario("Ana")
    
    bootcampTQI.matricular(joao)
    bootcampTQI.matricular(maria)
    bootcampFront.matricular(maria)
    bootcampFront.matricular(ana)
    	
    imprimirCurso(bootcampTQI)
    imprimirCurso(bootcampFront)
    
    imprimirUsuario(joao)
    imprimirUsuario(maria)
    imprimirUsuario(ana)
}