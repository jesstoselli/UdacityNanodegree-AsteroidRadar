package com.udacity.asteroidradar.data.mocks
//
//import com.udacity.asteroidradar.domain.Asteroid
//
//class AsteroidsListMock {
//
//    val asteroidsListMock = listOf<Asteroid>()
//
//    val asteroid1 = Asteroid(
//        id = "2085770",
//        codename = "85770 (1998 UP1)",
//
//    )
//
//
//
//
//}
//
////@Parcelize
////data class Asteroid(
////    val id: Long,
////    val codename: String,
////    val closeApproachDate: String,
////    val absoluteMagnitude: Double,
////    val estimatedDiameter: Double,
////    val relativeVelocity: Double,
////    val distanceFromEarth: Double,
////    val isPotentiallyHazardous: Boolean
////) : Parcelable
//
//{
//    "element_count": 95,
//    "near_earth_objects": {
//    "2021-10-10": [
//    {
//        "links": {
//        "self": "http://www.neowsapp.com/rest/v1/neo/2085770?api_key=l8SVdGp23pt5cm4KxHpukSyFe8mqTSzZ7fSA1qQQ"
//    },
//        "id": "2085770",
//        "neo_reference_id": "2085770",
//        "name": ,
//        "nasa_jpl_url": "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2085770",
//        "absolute_magnitude_h": 20.5,
//        "estimated_diameter": {
//        "kilometers": {
//        "estimated_diameter_min": 0.2111324448,
//        "estimated_diameter_max": 0.4721064988
//    },
//        "meters": {
//        "estimated_diameter_min": 211.1324447897,
//        "estimated_diameter_max": 472.1064988055
//    },
//        "miles": {
//        "estimated_diameter_min": 0.1311915784,
//        "estimated_diameter_max": 0.2933532873
//    },
//        "feet": {
//        "estimated_diameter_min": 692.6917701639,
//        "estimated_diameter_max": 1548.9058855411
//    }
//    },
//        "is_potentially_hazardous_asteroid": false,
//        "close_approach_data": [
//        {
//            "close_approach_date": "2021-10-10",
//            "close_approach_date_full": "2021-Oct-10 22:56",
//            "epoch_date_close_approach": 1633906560000,
//            "relative_velocity": {
//            "kilometers_per_second": "16.4184522773",
//            "kilometers_per_hour": "59106.4281981058",
//            "miles_per_hour": "36726.4358989841"
//        },
//            "miss_distance": {
//            "astronomical": "0.3285478827",
//            "lunar": "127.8051263703",
//            "kilometers": "49150063.444929849",
//            "miles": "30540433.2459719562"
//        },
//            "orbiting_body": "Earth"
//        }
//        ],
//        "is_sentry_object": false
//    },
//    {
//        "links": {
//        "self": "http://www.neowsapp.com/rest/v1/neo/2230111?api_key=l8SVdGp23pt5cm4KxHpukSyFe8mqTSzZ7fSA1qQQ"
//    },
//        "id": "2230111",
//        "neo_reference_id": "2230111",
//        "name": "230111 (2001 BE10)",
//        "nasa_jpl_url": "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2230111",
//        "absolute_magnitude_h": 19.1,
//        "estimated_diameter": {
//        "kilometers": {
//        "estimated_diameter_min": 0.4023045798,
//        "estimated_diameter_max": 0.8995803882
//    },
//        "meters": {
//        "estimated_diameter_min": 402.3045798343,
//        "estimated_diameter_max": 899.5803881691
//    },
//        "miles": {
//        "estimated_diameter_min": 0.2499803991,
//        "estimated_diameter_max": 0.5589731654
//    },
//        "feet": {
//        "estimated_diameter_min": 1319.8969577037,
//        "estimated_diameter_max": 2951.3793207207
//    }
//    },
//        "is_potentially_hazardous_asteroid": true,
//        "close_approach_data": [
//        {
//            "close_approach_date": "2021-10-10",
//            "close_approach_date_full": "2021-Oct-10 19:19",
//            "epoch_date_close_approach": 1633893540000,
//            "relative_velocity": {
//            "kilometers_per_second": "14.5943018388",
//            "kilometers_per_hour": "52539.4866196494",
//            "miles_per_hour": "32645.9937831927"
//        },
//            "miss_distance": {
//            "astronomical": "0.4815601163",
//            "lunar": "187.3268852407",
//            "kilometers": "72040367.675432281",
//            "miles": "44763808.7481202378"
//        },
//            "orbiting_body": "Earth"
//        }
//        ],
//        "is_sentry_object": false
//    },
//    {
//        "links": {
//        "self": "http://www.neowsapp.com/rest/v1/neo/2474585?api_key=l8SVdGp23pt5cm4KxHpukSyFe8mqTSzZ7fSA1qQQ"
//    },
//        "id": "2474585",
//        "neo_reference_id": "2474585",
//        "name": "474585 (2004 HC2)",
//        "nasa_jpl_url": "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2474585",
//        "absolute_magnitude_h": 19.5,
//        "estimated_diameter": {
//        "kilometers": {
//        "estimated_diameter_min": 0.3346223745,
//        "estimated_diameter_max": 0.7482383761
//    },
//        "meters": {
//        "estimated_diameter_min": 334.6223744549,
//        "estimated_diameter_max": 748.2383760735
//    },
//        "miles": {
//        "estimated_diameter_min": 0.2079246394,
//        "estimated_diameter_max": 0.464933628
//    },
//        "feet": {
//        "estimated_diameter_min": 1097.8424710066,
//        "estimated_diameter_max": 2454.8503937571
//    }
//    },
//        "is_potentially_hazardous_asteroid": false,
//        "close_approach_data": [
//        {
//            "close_approach_date": "2021-10-10",
//            "close_approach_date_full": "2021-Oct-10 08:31",
//            "epoch_date_close_approach": 1633854660000,
//            "relative_velocity": {
//            "kilometers_per_second": "25.9032240825",
//            "kilometers_per_hour": "93251.6066971015",
//            "miles_per_hour": "57942.9219502073"
//        },
//            "miss_distance": {
//            "astronomical": "0.4607421458",
//            "lunar": "179.2286947162",
//            "kilometers": "68926043.630909446",
//            "miles": "42828657.5210085148"
//        },
//            "orbiting_body": "Earth"
//        }
//        ],
//        "is_sentry_object": false
//    },
//    {
//        "links": {
//        "self": "http://www.neowsapp.com/rest/v1/neo/3368864?api_key=l8SVdGp23pt5cm4KxHpukSyFe8mqTSzZ7fSA1qQQ"
//    },
//        "id": "3368864",
//        "neo_reference_id": "3368864",
//        "name": "(2007 DL41)",
//        "nasa_jpl_url": "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3368864",
//        "absolute_magnitude_h": 20.7,
//        "estimated_diameter": {
//        "kilometers": {
//        "estimated_diameter_min": 0.1925550782,
//        "estimated_diameter_max": 0.4305662442
//    },
//        "meters": {
//        "estimated_diameter_min": 192.5550781879,
//        "estimated_diameter_max": 430.566244241
//    },
//        "miles": {
//        "estimated_diameter_min": 0.1196481415,
//        "estimated_diameter_max": 0.2675413778
//    },
//        "feet": {
//        "estimated_diameter_min": 631.7424027221,
//        "estimated_diameter_max": 1412.6189567557
//    }
//    },
//        "is_potentially_hazardous_asteroid": true,
//        "close_approach_data": [
//        {
//            "close_approach_date": "2021-10-10",
//            "close_approach_date_full": "2021-Oct-10 04:24",
//            "epoch_date_close_approach": 1633839840000,
//            "relative_velocity": {
//            "kilometers_per_second": "19.5582313941",
//            "kilometers_per_hour": "70409.6330186894",
//            "miles_per_hour": "43749.8078054184"
//        },
//            "miss_distance": {
//            "astronomical": "0.2053425983",
//            "lunar": "79.8782707387",
//            "kilometers": "30718815.325945621",
//            "miles": "19087786.7311107298"
//        },
//            "orbiting_body": "Earth"
//        }
//        ],
//        "is_sentry_object": false
//    },
//    {
//        "links": {
//        "self": "http://www.neowsapp.com/rest/v1/neo/3612845?api_key=l8SVdGp23pt5cm4KxHpukSyFe8mqTSzZ7fSA1qQQ"
//    },
//        "id": "3612845",
//        "neo_reference_id": "3612845",
//        "name": "(2012 UC34)",
//        "nasa_jpl_url": "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3612845",
//        "absolute_magnitude_h": 23.2,
//        "estimated_diameter": {
//        "kilometers": {
//        "estimated_diameter_min": 0.0608912622,
//        "estimated_diameter_max": 0.1361570015
//    },
//        "meters": {
//        "estimated_diameter_min": 60.8912622106,
//        "estimated_diameter_max": 136.1570015386
//    },
//        "miles": {
//        "estimated_diameter_min": 0.0378360645,
//        "estimated_diameter_max": 0.0846040122
//    },
//        "feet": {
//        "estimated_diameter_min": 199.7744887109,
//        "estimated_diameter_max": 446.7093369279
//    }
//    },
//        "is_potentially_hazardous_asteroid": false,
//        "close_approach_data": [
//        {
//            "close_approach_date": "2021-10-10",
//            "close_approach_date_full": "2021-Oct-10 00:12",
//            "epoch_date_close_approach": 1633824720000,
//            "relative_velocity": {
//            "kilometers_per_second": "18.902877818",
//            "kilometers_per_hour": "68050.360144863",
//            "miles_per_hour": "42283.8473911233"
//        },
//            "miss_distance": {
//            "astronomical": "0.3667182683",
//            "lunar": "142.6534063687",
//            "kilometers": "54860271.827768521",
//            "miles": "34088592.2047507498"
//        },
//            "orbiting_body": "Earth"
//        }
//        ],
//        "is_sentry_object": false
//    },
//    {
//        "links": {
//        "self": "http://www.neowsapp.com/rest/v1/neo/3781579?api_key=l8SVdGp23pt5cm4KxHpukSyFe8mqTSzZ7fSA1qQQ"
//    },
//        "id": "3781579",
//        "neo_reference_id": "3781579",
//        "name": "(2017 RN16)",
//        "nasa_jpl_url": "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3781579",
//        "absolute_magnitude_h": 28.9,
//        "estimated_diameter": {
//        "kilometers": {
//        "estimated_diameter_min": 0.004411182,
//        "estimated_diameter_max": 0.0098637028
//    },
//        "meters": {
//        "estimated_diameter_min": 4.411182,
//        "estimated_diameter_max": 9.8637028131
//    },
//        "miles": {
//        "estimated_diameter_min": 0.0027409806,
//        "estimated_diameter_max": 0.0061290189
//    },
//        "feet": {
//        "estimated_diameter_min": 14.4723823528,
//        "estimated_diameter_max": 32.3612307372
//    }
//    },
//        "is_potentially_hazardous_asteroid": false,
//        "close_approach_data": [
//        {
//            "close_approach_date": "2021-10-10",
//            "close_approach_date_full": "2021-Oct-10 21:34",
//            "epoch_date_close_approach": 1633901640000,
//            "relative_velocity": {
//            "kilometers_per_second": "4.7591106071",
//            "kilometers_per_hour": "17132.7981855313",
//            "miles_per_hour": "10645.6545170042"
//        },
//            "miss_distance": {
//            "astronomical": "0.2975172131",
//            "lunar": "115.7341958959",
//            "kilometers": "44507941.368096097",
//            "miles": "27655952.3425842586"
//        },
//            "orbiting_body": "Earth"
//        }
//        ],
//        "is_sentry_object": false
//    },
//    {
//        "links": {
//        "self": "http://www.neowsapp.com/rest/v1/neo/3805271?api_key=l8SVdGp23pt5cm4KxHpukSyFe8mqTSzZ7fSA1qQQ"
//    },
//        "id": "3805271",
//        "neo_reference_id": "3805271",
//        "name": "(2018 HA1)",
//        "nasa_jpl_url": "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=3805271",
//        "absolute_magnitude_h": 22.1,
//        "estimated_diameter": {
//        "kilometers": {
//        "estimated_diameter_min": 0.1010543415,
//        "estimated_diameter_max": 0.2259643771
//    },
//        "meters": {
//        "estimated_diameter_min": 101.054341542,
//        "estimated_diameter_max": 225.9643771094
//    },
//        "miles": {
//        "estimated_diameter_min": 0.0627922373,
//        "estimated_diameter_max": 0.140407711
//    },
//        "feet": {
//        "estimated_diameter_min": 331.5431259047,
//        "estimated_diameter_max": 741.3529669956
//    }
//    },
//        "is_potentially_hazardous_asteroid": false,
//        "close_approach_data": [
//        {
//            "close_approach_date": "2021-10-10",
//            "close_approach_date_full": "2021-Oct-10 20:08",
//            "epoch_date_close_approach": 1633896480000,
//            "relative_velocity": {
//            "kilometers_per_second": "20.1550182139",
//            "kilometers_per_hour": "72558.0655700033",
//            "miles_per_hour": "45084.7602426501"
//        },
//            "miss_distance": {
//            "astronomical": "0.3083956263",
//            "lunar": "119.9658986307",
//            "kilometers": "46135328.811795981",
//            "miles": "28667164.0095912978"
//        },
//            "orbiting_body": "Earth"
//        }
//        ],
//        "is_sentry_object": false
//    },