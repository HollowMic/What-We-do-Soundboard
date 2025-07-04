package com.example.newyorkcity

class SoundLibrary {
    private val listOfSounds = mutableListOf(
        Sound("New York City", R.raw.you_really_are_the_most_devious_bastard_in_new_york_city),
        Sound("Creature of the Night", R.raw.creature_of_the_night),
        Sound("Beg your Pardon", R.raw.beg_your_pardon),
        Sound("Manahattaa", R.raw.manahattaa),
        Sound("Mardon!", R.raw.mardon),
        Sound("She Speaks the BullSh*t", R.raw.she_speaks_the_bs),
        Sound("How Would You Like Me To Answer That?", R.raw.how_would_you_like_me_to_answer_that),
        Sound("Good Lady Wife", R.raw.good_lady_wife),
        Sound("She Died", R.raw.she_died),
        Sound("You F*cking Didnt", R.raw.you_fing_didnt),
        Sound("House Hole", R.raw.house_hole),
        Sound("Breakfast Burrito", R.raw.breakfast_burrito),
        Sound("Good Time Boy", R.raw.good_time_boy),
        Sound("Because I Killed Him", R.raw.because_i_killed_him),
        Sound("I Said I'm Sorry!", R.raw.i_said_im_sorry),
        Sound("WTF Did You Just Say?", R.raw.wtf_did_you_just_say),
        Sound("No, I've Gone Hard", R.raw.no_ive_gone_hard),
        Sound("Gay is In, Gay is Hot \uD83C\uDFF3\uFE0F\u200D\uD83C\uDF08", R.raw.gay_is_in),
        Sound("You're Not in Love", R.raw.youre_not_in_love),
        Sound("Gizmo STFU!", R.raw.gismo_stfu),
        Sound("Pizza Pie!", R.raw.pizza_pie),

//
//        Sound("Default", R.raw.you_really_are_the_most_devious_bastard_in_new_york_city),
//        Sound("Default", R.raw.you_really_are_the_most_devious_bastard_in_new_york_city),
//        Sound("Default", R.raw.you_really_are_the_most_devious_bastard_in_new_york_city),
//        Sound("Default", R.raw.you_really_are_the_most_devious_bastard_in_new_york_city),
//        Sound("Default", R.raw.you_really_are_the_most_devious_bastard_in_new_york_city),
//        Sound("Default", R.raw.you_really_are_the_most_devious_bastard_in_new_york_city),
//        Sound("Default", R.raw.you_really_are_the_most_devious_bastard_in_new_york_city),


    )

    fun getLength(): Int {
        return listOfSounds.size
    }

    fun getSound(index: Int): Sound? {
        return if (index < listOfSounds.size) {
            listOfSounds[index]
        } else {
            null
        }
    }

    fun addSound(sound: Sound) {
        listOfSounds.add(sound)
    }
}