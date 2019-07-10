package ru.skillbranch.devintensive.extensions

fun String.truncate(value: Int = 16) : String
{
    val string = this.trim()
    return if (value < string.length)
        "${string.subSequence(0, value).trim()}..."
    else
        string
}


fun String.stripHtml() : String
{
    var string = this.replace("<[^>]*>".toRegex(), "")
    string = string.replace("[ ]+".toRegex(), " ")
    string = string.replace("&\\w+;".toRegex(), "")

    return string.trim()
}
