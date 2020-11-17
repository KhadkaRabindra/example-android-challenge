package com.maxx.github_demo.util

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity) : DomainModel

    //fun mapToEntity(domainModel: DomainModel) : Entity

}