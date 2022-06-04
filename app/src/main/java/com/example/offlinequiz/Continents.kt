package com.example.offlinequiz

object Continents {
    const val name: String= "NAME"
    fun getQuestionAmerica(): List<Question> {
        return listOf(
            Question(1,"Capital of Brazil?", listOf("Rio de Janeiro","Brazil","Salvador","São Paulo"),1),
            Question(2,"Capital of Chili?", listOf("Santiago","Pozo Almonte","Antofagasta","Calama"),0),
            Question(3,"Capital of Canada?", listOf("Edmonton","Ottawa","Victoria","Vankuver"),1),
            Question(4,"Capital of Urugvay?", listOf("Salto","Las Piedras","Artigas","Montevideo"),3),
            Question(5,"Capital of Paragvay?", listOf("Ciudad del Este","San Lorenzo","Asunción","Limpio"),2),
        )
    }
    fun getQuestionAfrika(): List<Question> {
        return listOf(
            Question(1,"Capital of Nigerya?", listOf("Lagos","Douala","Ibadan","Abuja"),3),
            Question(2,"Capital of Ethiopia?", listOf("Kano","Addis Ababa","Kumasi","Luanda"),1),
            Question(3,"Capital of Kenya?", listOf("Harare","Lomé","Nairobi","Nampula"),2),
            Question(4,"Capital of Sudan?", listOf("Khartoum","Tanta","Ikorodu","Bouaké"),0),
            Question(5,"Capital of Morocco?", listOf("Warri","Benghazi","Rabat","Beira"),2),
        )
    }
    fun getQuestionAsia(): List<Question> {
        return listOf(
            Question(1,"Capital of Afganistan?", listOf("Lagos","Kabul","Kandahar","Herat"),1),
            Question(2,"Capital of China?", listOf("Beijing","Chaohu","Pekin","Fuyang"),2),
            Question(3,"Capital of Iran?", listOf("Mashhad","Isfahan","Shiraz","Tehran"),3),
            Question(4,"Capital of Israil?", listOf("Khartoum","Tanta","Ikorodu","Jerusalem"),3),
            Question(5,"Capital of Quwait?", listOf("Kuwait City","Benghazi","Rabat","Beira"),0),
        )
    }
    fun getQusestionEurope(): List<Question> {
          return listOf(
            Question(1,"Capital of Ispain?", listOf("Paris","London","Madrid","Rima"),2),
              Question(2,"Capital of Chexia?", listOf("Praga","Brno","Pilsen","Karvina"),0),
              Question(3,"Capital of Serbiya?", listOf("Smederevo","Vranje","Novi Sad","Belgrad"),3),
              Question(4,"Capital of Shvetsariya?", listOf("Zurish","Jeneva","Shur","Bern"),3),
              Question(4,"Capital of German?", listOf("Bavaria","Berlin","Shur","Bern"),1)
          )
    }
}