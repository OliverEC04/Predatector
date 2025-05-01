package com.example.predatector.repository

import com.example.predatector.models.Predator
import com.example.predatector.R

object PredatorRepository {
    fun getAllPredators(): List<Predator>{
      return listOf(
          Predator(
              "John Bryant",
              listOf("Five times predator offender", "Seen at aros", "etnicity: idk", "very dangerous"),
              R.drawable.puppy
          )
      )
    }
}