package biblioteca

data class Prateleira (
        val genero: String,
        val livros: MutableList<Livros>
){
        fun organizaPorAutor(): MutableList<Livros>{
                this.livros.sortBy { it.autor }
                return this.livros
        }

        fun organizaPorPublicacao(): MutableList<Livros>{
                this.livros.sortBy { it.anoPublicacao }
                return this.livros
        }

}


