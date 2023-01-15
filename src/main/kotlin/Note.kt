import java.time.LocalDate

class Note (var author: String, var text: String)
{
    //region Variables

    lateinit var date: LocalDate
    var notebooks = mutableListOf<Notebook>()

    //endregion

    //region Methods

    fun printNote()
    {
        println("Autor: $author -> $text, Data $date")
    }

    fun search(word: String): Boolean
    {
        return text.contains(word)
    }

    //endregion
}
