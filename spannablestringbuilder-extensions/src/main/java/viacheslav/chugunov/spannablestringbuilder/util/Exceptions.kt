package viacheslav.chugunov.spannablestringbuilder.util

// An exception that can be seen if the color hex is in the wrong format.
internal class IllegalColorHexException(invalidColorHex: String) : IllegalArgumentException(
    "color's hex must be in a hex format (like #FFFFFF), but provided: \"$invalidColorHex\""
)

// An exception that can be seen if the html tag pair is in the wrong format.
internal class IllegalHtmlTagsException(invalidStartTag: String, invalidEndTag: String) : IllegalArgumentException(
    "invalid tags provided, were: \"$invalidStartTag\" and \"$invalidEndTag\""
)