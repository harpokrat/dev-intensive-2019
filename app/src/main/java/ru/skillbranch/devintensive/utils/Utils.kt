package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        if (firstName != null && firstName.isEmpty())
            firstName = null

        if (lastName != null && lastName.isEmpty())
            lastName = null

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val alphabet: Map<Char, String> = mapOf(
            'а' to "a",
            'б' to "b",
            'в' to "v",
            'г' to "g",
            'д' to "d",
            'е' to "e",
            'ё' to "e",
            'ж' to "zh",
            'з' to "z",
            'и' to "i",
            'й' to "i",
            'к' to "k",
            'л' to "l",
            'м' to "m",
            'н' to "n",
            'о' to "o",
            'п' to "p",
            'р' to "r",
            'с' to "s",
            'т' to "t",
            'у' to "u",
            'ф' to "f",
            'х' to "h",
            'ц' to "c",
            'ч' to "ch",
            'ш' to "sh",
            'щ' to "sh'",
            'ъ' to "",
            'ы' to "i",
            'ь' to "",
            'э' to "e",
            'ю' to "yu",
            'я' to "ya",
            'А' to "A",
            'Б' to "B",
            'В' to "V",
            'Г' to "G",
            'Д' to "D",
            'Е' to "E",
            'Ё' to "E",
            'Ж' to "ZH",
            'З' to "Z",
            'И' to "I",
            'Й' to "I",
            'К' to "K",
            'Л' to "L",
            'М' to "M",
            'Н' to "N",
            'О' to "O",
            'П' to "P",
            'Р' to "R",
            'С' to "S",
            'Т' to "T",
            'У' to "U",
            'Ф' to "F",
            'Х' to "H",
            'Ц' to "C",
            'Ч' to "CH",
            'Ш' to "SH",
            'Щ' to "SH'",
            'Ъ' to "",
            'Ъ' to "I",
            'Ь' to "",
            'Э' to "E",
            'Ю' to "YU",
            'Я' to "YA"
        )

        var result = ""
        for (char in payload)
            result += alphabet.getOrElse(char) {char}

        return result.replace(" ", divider)
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstInitial= firstName?.trim()?.firstOrNull()
        val lastInitial = lastName?.trim()?.firstOrNull()

        var result = ""
        if (firstInitial != null)
            result += firstInitial.toUpperCase()
        if (lastInitial != null)
            result += lastInitial.toUpperCase()

        return if (result.isEmpty()) null else result
    }
}