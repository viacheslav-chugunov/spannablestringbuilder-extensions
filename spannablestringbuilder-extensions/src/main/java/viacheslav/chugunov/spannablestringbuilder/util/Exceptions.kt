package viacheslav.chugunov.spannablestringbuilder.util

internal class IllegalColorHexException(invalidColorHex: String) : IllegalArgumentException(
    "color's hex must be in a hex format (like #FFFFFF), but provided: \"$invalidColorHex\""
)

internal class IllegalHtmlTagsException(invalidStartTag: String, invalidEndTag: String) : IllegalArgumentException(
    "invalid tags provided, were: \"$invalidStartTag\" and \"$invalidEndTag\""
)