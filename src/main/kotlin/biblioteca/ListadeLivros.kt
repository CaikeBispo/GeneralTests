package biblioteca

fun main() {
    val livro1 = Livros(
        titulo = "Grande Sertao: Veredas",
        autor = "Joao Guimaraes Rosa",
        editora = "Desconhecida",
        anoPublicacao = 2004
    )

    val livro2 = Livros(
        titulo = "Minha vida de menina",
        autor = "Helena Morley",
        editora = "Editora A",
        anoPublicacao = 1994
    )

    val livro3 = Livros(
        titulo = "Memorias Postumas de Bras Cubas",
        autor = "Machado de Assis",
        editora = "Edugira A",
        anoPublicacao = 1984
    )

    val livro4 = Livros(
        titulo = "Iracema",
        autor = "Jose de Alencar",
        anoPublicacao = 1974,
        editora = "Editora B"
    )

    val livro5 = Livros(
        titulo = "Bíblia Sagrada",
        autor = "Diversos",
        anoPublicacao = 1,
        editora = "Hagnos"
    )

    val meusLivros: MutableList<Livros> =
        mutableListOf(livro1, livro2, livro3, livro4, livro5)

    meusLivros.sort()

    meusLivros.imprimeComMarcadores()

    meusLivros.remove(livro3)

    meusLivros
        .filter { it.autor.startsWith("Jo") }
        .imprimeComMarcadores()

    val titulos:List<String> = meusLivros
        .map { it.titulo }

    println(titulos)

    meusLivros
        .groupBy {it.editora }

    meusLivros.forEach { println(" ${it.titulo} de ${it.autor} - Editora ${it.editora}") }
}

fun List<Livros>.imprimeComMarcadores() {
    val formatado = this.joinToString(separator = "\n") {
        "- ${it.titulo} de ${it.autor} "
    }

    println("#### Lista de Livros #### \n${formatado}")

}