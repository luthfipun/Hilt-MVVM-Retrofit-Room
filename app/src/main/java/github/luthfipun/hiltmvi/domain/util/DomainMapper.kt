package github.luthfipun.hiltmvi.domain.util

interface DomainMapper<T, DomainModel>{
    fun mapToDomainModel(model: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T
}