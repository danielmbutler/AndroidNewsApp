package com.example.newsapp

import com.example.newsapp.models.NewsPost

//class DataSourceDummy{
//
//    companion object{
//
//        fun createDataSet(): ArrayList<NewsPost>{
//            val list = ArrayList<NewsPost>()
//
//            list.add(
//                NewsPost(
//                    "Congratulations!",
//                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png",
//                    "You made it to the end of the course!\r\n\r\nNext we'll be building the REST API!",
//                    "Sally"
//                )
//            )
//            list.add(
//                NewsPost(
//                    "Time to Build a Kotlin App!",
//                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/time_to_build_a_kotlin_app.png",
//                    "The REST API course is complete. You can find the videos here: https://codingwithmitch.com/courses/build-a-rest-api/.",
//                    "mitch"
//                )
//            )
//
//            list.add(
//               NewsPost(
//                    "Interviewing a Web Developer and YouTuber",
//                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/coding_for_entrepreneurs.png",
//                   "Justin has been producing online courses for YouTube, Udemy, and his website CodingForEntrepreneurs.com for over 5 years.",
//                    "John"
//                )
//            )
//            list.add(
//                NewsPost(
//                    "Freelance Android Developer (Vasiliy Zukanov)",
//                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_vasiliy_zukanov.png",
//                    "Vasiliy has been a freelance android developer for several years. He also has some of the best android development courses I've had the pleasure of taking on Udemy.com.",
//                    "Steven"
//                )
//            )
//            list.add(
//                NewsPost(
//                    "Freelance Android Developer, Donn Felker",
//                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_donn_felker.png",
//                    "Freelancing as an Android developer with Donn Felker.\\r\\n\\r\\nDonn is also:\\r\\n\\r\\n1) Founder of caster.io\\r\\n\\r\\n2) Co-host of the fragmented podcast (fragmentedpodcast.com).",
//                    "Richelle"
//                )
//            )
//            list.add(
//                NewsPost(
//                    "Work Life Balance for Software Developers",
//                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/work_life_balance.png",
//                    "What kind of hobbies do software developers have? It sounds like many software developers don't have a lot of hobbies and choose to focus on work. Is that a good idea?",
//                    "Jessica"
//                )
//            )
//            list.add(
//                NewsPost(
//                    "Full Stack Web Developer - Nicholas Olsen",
//                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/fullsnack_developer.png",
//                    "In this podcast I interviewed the Fullsnack Developer (AKA Nicholas Olsen).\\r\\n\\r\\nNicholas is many things. What I mean by that is, he's good at many things.\\r\\n\\r\\n1. He’s an entrepreneur\\r\\n\\r\\n2. Web developer\\r\\n\\r\\n3. Artist\\r\\n\\r\\n4. Graphic designer\\r\\n\\r\\n5. Musician (drums)\\r\\n\\r\\n6. Professional BodyBuilder.",
//                    "Guy"
//                )
//            )
//            list.add(
//                NewsPost(
//                    "Javascript Expert - Wes Bos",
//                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/javascript_expert_wes_bos.png",
//                    "Interviewing a web developer, javascript expert, entrepreneur, freelancer, podcaster, and much more.",
//                    "Ruby"
//                )
//            )
//            list.add(
//                NewsPost(
//                    "Senior Android Engineer - Kaushik Gopal",
//                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/senior_android_engineer_kaushik_gopal.png",
//                    "Kaushik Gopal is a Senior Android Engineer working in Silicon Valley.\r\n\r\nHe works as a Senior Staff engineer at Instacart.\r\n\r\nInstacart: https://www.instacart.com/",
//                    "mitch"
//                )
//            )
//            return list
//        }
//    }
//}

//GlobalScope.launch(Dispatchers.IO) {
//    val apires = async { getData(API().NewsLink) }
//
//
//    if (apires.await().toString() == "") {
//        println("error")
//    } else {
//        for (i in 0 until apires.await().length()) {
//            val data = apires.await().getJSONObject(i)
//
//
//            // Your code here
//        }
//    }