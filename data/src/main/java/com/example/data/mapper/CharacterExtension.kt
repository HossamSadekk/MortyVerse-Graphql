package com.example.data.mapper

import com.example.domain.model.CharacterModel
import com.example.domain.model.Characters
import com.example.domain.model.Episode
import com.example.domain.model.Location
import com.example.ricknmorty.GetCharactersQuery
import com.example.ricknmorty.fragment.CharacterDetail

fun List<GetCharactersQuery.Result?>.toCharacterList(): List<Characters> = map {
    Characters(
        name = it?.character?.name ?: "",
        image = it?.character?.image ?: "",
        status = it?.character?.status ?: "",
        species = it?.character?.species ?: "",
        type = it?.character?.type ?: "",
        gender = it?.character?.gender,
        id = it?.character?.id ?: ""
    )
}

private fun mapLocation(location: CharacterDetail.Location?): Location {
    return Location(
        id = location?.id.orEmpty(),
        name = location?.name.orEmpty()
    )
}

private fun mapEpisodes(episodes: List<CharacterDetail.Episode?>?): List<Episode> {
    return episodes?.map {
        Episode(
            id = it?.id.orEmpty(),
            name = it?.name.orEmpty(),
            air_date = it?.air_date.orEmpty(),
        )
    } ?: emptyList()
}

fun mapCharacterResponseToDomainModel(graphqlResponse: CharacterDetail?): CharacterModel? {
    return graphqlResponse?.let { character ->
        CharacterModel(
            id = character?.id.orEmpty(),
            image = character?.image.orEmpty(),
            status = character?.status.orEmpty(),
            name = character?.name.orEmpty(),
            species = character?.species.orEmpty(),
            type = character?.type.orEmpty(),
            gender = character?.gender.orEmpty(),
            episodes = mapEpisodes(character?.episode),
            location = mapLocation(character?.location)
        )
    }
}