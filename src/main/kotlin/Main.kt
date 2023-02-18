class Quote(val num: Int, var quote: String) {
    override fun toString(): String {
        return "$num, $quote"
    }
}

fun main() {
    // create a quotesList to store the quote
    val quotesList = mutableListOf(

        Quote(1,"The greatest battles of life are fought out daily in the silent chambers of the soul. - David O. McKay"),
        Quote(2, "We can't direct the wind, but we can adjust the sails. - Thomas S. Monson"),
        Quote(3, "True happiness comes only by making others happy - Marion G. Romney"),
        Quote(4, "We can choose to be grateful, no matter what. - Dieter F. Uchtdorf")
    )

    // Ask user for input
    var userChoice: String

    do {
        println("=== Quote Management System ===")
        println("1. List all quotes")
        println("2. Add a quote")
        println("3. Remove an existing quote")
        println("4. Search for a quote")
        println("5. Count number of quotes")
        println("6. Edit a quote")
        println("7. Sort quotes by number")
        println("8. Quit")
        print("Enter your choice: ")

        userChoice = readLine() ?: ""
        println()

        when (userChoice) {
            "1" -> listQuotes(quotesList)
            "2" -> addQuote(quotesList)
            "3" -> removeQuote(quotesList)
            "4" -> searchQuote(quotesList)
            "5" -> countQuotes(quotesList)
            "6" -> editQuote(quotesList)
            "7" -> sortQuotes(quotesList)
            "8" -> println("Goodbye!")
            else -> println("Invalid choice. Please try again.")
        }

        println()
    } while (userChoice != "8")
}
// This function takes a list of Quote objects and prints them to the console.
fun listQuotes(quotes: List<Quote>) {
    if (quotes.isEmpty()) {
        println("No quote found.")
    } else {
        quotes.forEach { println(it) }
    }
}
// This function prompts the user to enter a quote number and text,
// creates a new Quote object with that data, and adds it to the list of quotes.
fun addQuote(quotes: MutableList<Quote>) {
    print("Enter quote number: ")
    val name = readLine() ?: ""
    print("Enter a quote: ")
    val title = readLine() ?: ""
    quotes.add(Quote(name.toInt(), title))
    println("Quote added.")
}
// This function Prompts the user to remove the quote by enter the Quote's number
fun removeQuote(quotes: MutableList<Quote>) {
    print("Enter quote number to remove: ")
    val num = readLine()?.toIntOrNull() ?: 0
    val removedQuote = quotes.find { it.num == num }
    if (removedQuote != null) {
        quotes.remove(removedQuote)
        println("Quote removed.")
    } else {
        println("Quote not found.")
    }
}

// By entering a key word the quote, user will be able to locate the quote they're searching for.
//Keywords can be any words in the Quote
fun searchQuote(quotes: List<Quote>) {
    print("Enter keyword to search for: ")
    val keyword = readLine() ?: ""
    val foundQuotes = quotes.filter { it.quote.contains(keyword, ignoreCase = true) }
    if (foundQuotes.isEmpty()) {
        println("No quotes found with keyword '$keyword'.")
    } else {
        foundQuotes.forEach { println(it) }
    }
}
//this function allow us to count the number of quote in the system
fun countQuotes(quotes: List<Quote>) {
    val count = quotes.size
    println("There are $count quotes in the system.")
}
//This function allow user to edit the existing quote. By entering quote's number, user will
//be able to edit the quote they want
fun editQuote(quotes: MutableList<Quote>) {
    print("Enter quote number to edit (ex: 1, 2, 3): ")
    val num = readLine()?.toIntOrNull()
    val quoteToEdit = quotes.find { it.num == num }
    if (quoteToEdit != null) {
        print("Enter a new quote: ")
        val quote = readLine() ?: ""
        quoteToEdit.quote = quote
        println("Quote edited.")
    } else {
        println("Quote not found.")
    }
}
// this function will sort the quotes in the system
fun sortQuotes(quotes: MutableList<Quote>) {
    if (quotes.isNotEmpty()) {
        quotes.sortBy { it.num }
        println("Quotes sorted by quote number.")
    } else {
        println("No quotes found.")
    }
}

