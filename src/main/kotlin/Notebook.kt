import java.time.LocalDate

class Notebook
{
    //region Variables

    private var notesList= mutableListOf<Note>()

    //endregion

    //region Methods

    fun addNote(note: Note)
    {
        notesList.add(note)
    }

    fun removeNote(note: Note) : Boolean
    {
        var removed = false
        for(nt in notesList)
            if(nt.author == note.author && nt.text == note.text && nt.date == note.date) {
                removed = notesList.remove(nt)
                break
            }
        if(removed) {
            println("Notatka została skasowana.")
        } else {
            println("Nie znaleziono notatki.")
        }
        return removed
    }

    fun searchNotes(text: String) : List<Note>
    {
        val list = mutableListOf<Note>()
        for(note in notesList)
        {
            if(note.search(text))
                list.add(note)
        }
        return list
    }

    fun getNotesByAuthor(author: String) : List<Note>
    {
        val list = mutableListOf<Note>()
        for(note in notesList)
        {
            if(note.author == author)
                list.add(note)
        }
        return list
    }

    fun removeNotesByAuthor(author: String)
    {
        val list = mutableListOf<Note>()
        var count = 0
        for(note in notesList)
        {
            if(note.author == author)
            {
                count += 1
                list.add(note)
            }
        }
        notesList.removeAll(list)
        println("Ilość skasowanych notatek autora: $count")
    }

    fun getNotesByDate(begin: LocalDate, end: LocalDate) : List<Note>
    {
        val list = mutableListOf<Note>()
        for(note in notesList)
        {
            if(note.date in begin..end)
                list.add(note)
        }
        return list
    }

    fun sortNotes() : List<Note>
    {
        val list = mutableListOf<Note>()
        for(note in notesList){
            list.add(note)
        }
        list.sortBy { it.date }
        return list
    }

    fun printNotes()
    {
        if(notesList.isNotEmpty()){
            for(note in notesList)
                note.printNote()
            return
        }
        println("Brak notatek w bazie!")
    }

    //endregion
}