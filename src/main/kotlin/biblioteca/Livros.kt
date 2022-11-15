package biblioteca

data class Livros (
    val titulo: String,
    val autor: String,
    val editora: String,
    val anoPublicacao: Long
):Comparable<Livros>{
    override fun compareTo(other: Livros): Int {
        return this.anoPublicacao.compareTo(other.anoPublicacao)
    }

}

