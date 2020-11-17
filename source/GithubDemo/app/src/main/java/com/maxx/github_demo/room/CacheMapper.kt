package com.maxx.github_demo.room

import com.maxx.github_demo.model.Commit
import com.maxx.github_demo.retrofit.model.GetCommitResponseItem
import com.maxx.github_demo.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<GetCommitResponseItem, Commit>{
    override fun mapFromEntity(entity: GetCommitResponseItem): Commit {
        return Commit(
            authorName = entity.commit.author.name,
            date = entity.commit.author.date,
            commitMessage = entity.commit.message
        )
    }

    fun mapFromEntityList(entities: ArrayList<GetCommitResponseItem>) : List<Commit>{
        return entities.map {
            mapFromEntity(it)
        }
    }

}
