package app.helloteam.sportsbuddyapp

class SportEvents constructor(
    val type: SportTypes,
    val userName: String,
    val hour: Int,
    val minute: Int,
    val year: Int,
    val month: Int,
    val day: Int,
    val eventPlaceID: String
) {
}