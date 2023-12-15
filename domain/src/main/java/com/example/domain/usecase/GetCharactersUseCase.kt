package com.example.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.domain.model.Characters
import com.example.domain.pagination.CharactersPagingSource
import com.example.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCase(private val repository: CharacterRepository) {
    operator fun invoke(name: String? = null): Flow<PagingData<Characters>> =
        Pager(
            config = PagingConfig(
                pageSize = 20 // how many items per request, this value that will be passed into "params.loadSize" when we make our request.
            ),
            pagingSourceFactory = { CharactersPagingSource(repository,name = name) }
        ).flow

}