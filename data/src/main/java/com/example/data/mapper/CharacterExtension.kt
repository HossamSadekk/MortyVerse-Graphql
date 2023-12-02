package com.example.data.mapper

import com.example.domain.model.Characters
import com.example.domain.model.Info
import com.example.ricknmorty.GetCharactersQuery

fun List<GetCharactersQuery.Result?>.toCharacterList():List<Characters> = map {
    Characters(
        name = it?.character?.name ?: "",
        image = it?.character?.image ?: "",
        status = it?.character?.status?: "",
        species = it?.character?.species?: "",
        type = it?.character?.type?: "",
        gender = it?.character?.gender,
        id = it?.character?.id ?: ""
    )
}
