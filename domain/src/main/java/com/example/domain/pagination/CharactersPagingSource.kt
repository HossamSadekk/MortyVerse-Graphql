package com.example.domain.pagination

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.model.Characters
import com.example.domain.repository.CharacterRepository
import java.io.IOException

class CharactersPagingSource(
    private val repository: CharacterRepository,
    private val name: String? = null
) :
    PagingSource<Int, Characters>() {
    override fun getRefreshKey(state: PagingState<Int, Characters>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Characters> {

        val position = params.key ?: 1
        return try {
            val response = repository.getCharacters(position,name)
            val items = response.results
            LoadResult.Page(
                data = items!!,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (response.results?.isEmpty() == true) null else position + 1
            )
        } catch (exception: IOException) {
            // IOException for network failures.
            return LoadResult.Error(exception)
        } catch (exception: Exception) {
            Log.d("hossams", exception.localizedMessage.toString())
            return LoadResult.Error(exception)
        }
    }
}