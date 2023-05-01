package ru.mirea.theClinicApplication.repository.artistInfo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.mirea.theClinicApplication.entity.artistInfo.ArtistInfo

@Repository
interface ArtistInfoRepository : JpaRepository<ArtistInfo, Long>
