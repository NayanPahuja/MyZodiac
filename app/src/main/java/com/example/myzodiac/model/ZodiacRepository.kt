package com.example.myzodiac.model
import android.annotation.SuppressLint
import com.example.myzodiac.R
import java.time.LocalDate
import java.time.Month

class ZodiacRepository {
    private val zodiacList = listOf(
        ZodiacSign("Aries",
            startDate = Pair(3, 21),
            endDate = Pair(4, 19),
            "Aries contains no very bright stars; the brightest star, Hamal (Arabic for “sheep”), has a magnitude of 2.0. The first point of Aries, or vernal equinox, is an intersection of the celestial equator with the apparent annual pathway of the Sun and the point in the sky from which celestial longitude and right ascension are measured. The vernal equinox no longer lies in Aries but has been moved into Pisces by the precession of the equinoxes.",
            "In astrology, Aries is the first sign of the zodiac, considered as governing the period from about March 21 to about April 19. Its representation as a ram is identified with the Egyptian god Amon and, in Greek mythology, with the ram with the golden fleece, on the back of which Phrixus, the son of King Athamas, safely fled Thessaly to Colchis, where he sacrificed the ram to Zeus, who placed it in the heavens as the constellation. The ram’s golden fleece was recovered by Jason, leader of the Argonauts.",
            R.drawable.aries_icon, R.drawable.aries),
        ZodiacSign("Taurus",
            startDate = Pair(4, 20),
            endDate = Pair(5, 20),
            "Taurus, in astronomy, zodiacal constellation lying in the northern sky between Aries and Gemini, at about 4 hours 20 minutes right ascension and 16° north declination. The constellation’s brightest star, Aldebaran (Arabic for “the follower”; also called Alpha Tauri), is the 14th brightest star in the sky, with a magnitude of 0.85. The constellation also contains the Crab Nebula (M1) and the Pleiades and Hyades star clusters.",
            "In astrology, Taurus is the second sign of the zodiac, considered as governing that portion of the year from about April 20 to about May 20. Its representation as a bull is related to the Greek myth of Zeus, who assumed the form of a bull to abduct Europa.",
            R.drawable.taurus_icon, R.drawable.taurus),
        ZodiacSign("Gemini",
            startDate = Pair(5, 21),
            endDate = Pair(6, 20),
            "Gemini is the third sign of the zodiac and is said to govern between May 21 and June 21.\n" +
                    "The constellation is located between Taurus and Cancer in the northern sky and is said to resemble a set of twins, the symbol of Gemini.\n" +
                    "The “head” of each twin is made up of a star: Pollux, the head of the left twin, is notably brighter than Castor, the head of the right twin.\n" +
                    "The stars’ names are drawn from the famous set of twins in Greek mythology who sailed with Jason and the Argonauts.\n" +
                    "According to one version of the myth, Castor and Pollux were made into the constellation Gemini by the god Zeus to honor the brothers’ love.",
            "In other cultures, the two are represented by different symbols, including a pair of peacocks in Arabian astrology and a pair of goats in Egyptian astrology.\n" +
                    "In terms of personality, Geminis are said to be versatile and perceptive, with the ability to read people and adjust to match their energy.\n" +
                    "Geminis may prefer to be in the company of others, much like the twins of their symbol.\n" +
                    "It’s fitting that Mary-Kate and Ashley Olsen, one of the most famous sets of twins in the world, were born under the influence of Gemini.",
            R.drawable.gemini_icon, R.drawable.gemini),
        ZodiacSign("Leo",
            startDate = Pair(7, 23),
            endDate = Pair(8, 22),
            "Leo, in astronomy, zodiacal constellation lying in the northern sky between Cancer and Virgo, at about 10 hours 30 minutes right ascension and 15° north declination. Regulus (Latin for “little king”; also called Alpha Leonis), the brightest star, is of magnitude 1.35. The November meteor shower called the Leonids has its radiant, or point of apparent origin, in Leo. Many of the stars in Leo form an asterism called the Sickle.",
            "In astrology, Leo is the fifth sign of the zodiac, considered as governing the period from about July 23 to about August 22. Its representation as a lion is usually linked with the Nemean lion slain by Heracles (Hercules) as part of the 12 Labours he was forced to do as penance for killing his wife and children..",
            R.drawable.leo_icon, R.drawable.leo),
        ZodiacSign("Virgo",
            startDate = Pair(8, 23),
            endDate = Pair(9, 22),
            "Virgo, in astronomy, zodiacal constellation lying in the southern sky between Leo and Libra, at about 13 hours right ascension and 2° south declination. The constellation’s brightest star, Spica (Latin for “head of grain,” also called Alpha Virginis), is the 15th brightest star in the sky, with a magnitude of 1.04. Virgo contains the nearest large cluster of galaxies, the Virgo cluster, in which is located the giant elliptical galaxy Virgo A and PSR 1257+12, the pulsar around which the first extrasolar planets were discovered in 1992.",
            "In astrology, Virgo is the sixth sign of the zodiac, considered as governing the period from about August 23 to about September 22. It is represented as a young maiden carrying a sheaf of wheat. She is variously identified as a fertility goddess (the Babylonian and Assyrian Ishtar, among others) or the harvest maiden (the Greek Persephone and others).",
            R.drawable.virgo_icon, R.drawable.virgo),
        ZodiacSign("Libra",
            startDate = Pair(9, 23),
            endDate = Pair(10, 22),
            "Libra, in astronomy, zodiacal constellation in the southern sky lying between Scorpius and Virgo, at about 15 hours 30 minutes right ascension and 15° south declination. Its stars are faint; the brightest star, Zubeneschamali (Arabic for “northern claw,” as it was earlier regarded as part of Scorpius; also called Beta Librae), has a magnitude of 2.6.",
            "In astrology, Libra is the seventh sign of the zodiac, considered as governing the period from about September 22 to about October 23. It is represented by a woman (sometimes identified with Astraea, the Roman goddess of justice), holding a balance scale or by the balance alone."
            ,R.drawable.libra_icon, R.drawable.libra),
        ZodiacSign("Scorpio",
            startDate = Pair(10, 23),
            endDate = Pair(11, 21),
            "Scorpius, in astronomy, zodiacal constellation lying in the southern sky between Libra and Sagittarius, at about 16 hours 30 minutes right ascension and 30° south declination. Its brightest star, Antares (Alpha Scorpii), the 15th brightest star in the sky, has a magnitude of 1.1. Its name comes from the Greek for “rival of Ares” (i.e., rival of the planet Mars) and was probably given because of the star’s red colour and brightness. The brightest X-ray source in the sky, Scorpius X-1, is found in this constellation.",
            "In astrology, Scorpius (or Scorpio) is the eighth sign of the zodiac, considered as governing the period from about October 24 to about November 21. Its representation as a scorpion is related to the Greek legend of the scorpion that stung Orion to death (said to be why Orion sets as Scorpius rises in the sky). Another Greek myth relates that a scorpion caused the horses of the Sun to bolt when they were being driven for a day by the inexperienced youth Phaeton.",
            R.drawable.scorpio_icon, R.drawable.scorpio),
        ZodiacSign("Capricornus",
            startDate = Pair(12, 22),
            endDate = Pair(1, 19),
            "Capricorn, in astrology, the 10th sign of the zodiac, considered as governing the period from about December 22 to about January 19. One explanation of the fishtail with which the goat is often represented is found in the Greek myth of Pan, who, to avoid the monster Typhon, jumped into the water just as he was changing into animal shape. The half above water assumed the shape of a goat while the lower half, the tail, assumed the shape of a fish.",
            "In astronomy, Capricornus is a zodiacal constellation lying in the southern sky between Aquarius and Sagittarius, at about 21 hours right ascension and 20° south declination. Its stars are faint; Deneb Algedi (Arabic for “kid’s tail”) is the brightest star, with a magnitude of 2.9. Capricornus usually refers to the constellation, and Capricorn usually refers to the astrological sign.",
            R.drawable.capricorn_icon, R.drawable.capricorn),
        ZodiacSign("Aquarius",
            startDate = Pair(1, 20),
            endDate = Pair(2, 18),
            "Aquarius, in astronomy, zodiacal constellation lying in the southern sky between Capricornus and Pisces, at about 22 hours right ascension and 10° south declination. It lacks striking features, the brightest star, Sadalmelik (Arabic for “the lucky stars of the king”), being of magnitude 3.0.",
            "In astrology, Aquarius is the 11th sign of the zodiac, considered as governing the period from about January 20 to about February 18. Its representation as a man pouring a stream of water out of a jug came about, it has been suggested, because in ancient times the rising of Aquarius coincided in the Middle East with a period of floods and rain.",
            R.drawable.aquarius_icon, R.drawable.aquarius),
        ZodiacSign("Pisces",
            startDate = Pair(2, 19),
            endDate = Pair(3, 20),
            "Pisces, in astronomy, zodiacal constellation in the northern sky between Aries and Aquarius, at about 1 hour right ascension and 15° north declination. The vernal equinox, the point where the Sun’s annual apparent path takes it north of the celestial equator and from which celestial longitude and right ascension are measured, lies in Pisces. The constellation contains only faint stars without any striking grouping; the brightest star, Eta Piscium, has a magnitude of 3.6.",
            "In astrology, Pisces is the 12th sign of the zodiac, considered as governing the period from about February 19 to about March 20. Its representation as two fish tied together is usually related to the Greek myth of Aphrodite and Eros, who jumped into a river to escape the monster Typhon and changed into fish, or, alternatively, the two fish that carried them to safety.",
            R.drawable.pisces_icon, R.drawable.pisces),
        ZodiacSign("Sagittarius",
            startDate = Pair(11, 22),
            endDate = Pair(12, 21),
            "Sagittarius, in astronomy, zodiacal constellation in the southern sky lying between Capricornus and Scorpius, at about 19 hours right ascension and 25° south declination. The centre of the Milky Way Galaxy lies in the radio source Sagittarius A*. Near the western border of Sagittarius is the winter solstice, the southernmost point reached by the Sun in its apparent annual journey among the stars. This constellation also contains the Lagoon and Trifid nebulas. The brightest star is Kaus Australis (from the Arabic for “bow” and the Latin for “southern,” respectively; it is also called Epsilon Sagittarii), with a magnitude of 1.9. Many of the stars are arranged in the prominent asterism called the Teapot.",
            "In astrology, Sagittarius is the ninth sign of the zodiac, considered as governing the period from about November 22 to about December 21. It is represented either by a centaur shooting a bow and arrow or by an arrow drawn across a bow. The identification of Sagittarius as a mounted archer was made by the Babylonians as early as the 11th century bce.",
            R.drawable.sagittarius_icon, R.drawable.sagittarius),
        ZodiacSign("Cancer",
            startDate = Pair(6, 21),
            endDate = Pair(7, 22),
            "Cancer, in astronomy, zodiacal constellation lying in the northern sky between Leo and Gemini, at about 8 hours 25 minutes right ascension and 20° north declination. It contains the well-known star cluster called Praesepe, or the Beehive. Its brighest star, Al Tarf (Arabic for “the end” [of one of the crab’s legs]), also called Beta Cancri, is quite dim, with a magnitude of 3.6.",
            "In astrology, Cancer is the fourth sign of the zodiac, considered as governing the period from about June 22 to about July 22. Its representation as a crab (or lobster or crayfish) is related to the crab in Greek mythology that pinched Heracles while he was fighting the Lernaean hydra. Crushed by Heracles, the crab was rewarded by Heracles’ enemy, Hera, by being placed in the heavens.",
            R.drawable.cancer_icon, R.drawable.cancer),
    )

    @SuppressLint("NewApi")
     fun getZodiacSign(month: Int, day: Int): ZodiacSign {
        return zodiacList.find { sign ->
            val (startMonth, startDay) = sign.startDate
            val (endMonth, endDay) = sign.endDate

            // Handle the case where the sign spans across the end of the year (e.g., Capricorn)
            when {
                // Normal case where the sign is within the same year
                startMonth < endMonth -> (month == startMonth && day >= startDay) || (month == endMonth && day <= endDay) || (month > startMonth && month < endMonth)
                // Handle signs that span the end of the year, e.g., Capricorn
                startMonth > endMonth -> (month == startMonth && day >= startDay) || (month == endMonth && day <= endDay) || (month > startMonth || month < endMonth)
                else -> false
            }
        } ?: zodiacList.first() // Default to the first sign if no match is found (shouldn't happen)
    }
}
