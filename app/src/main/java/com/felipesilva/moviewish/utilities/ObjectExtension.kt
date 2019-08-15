package com.felipesilva.moviewish.utilities

import java.text.SimpleDateFormat
import java.util.*

fun Date.getCurrentFormmatedDate() = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())