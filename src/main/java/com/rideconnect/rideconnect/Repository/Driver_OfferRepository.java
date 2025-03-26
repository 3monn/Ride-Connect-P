package com.rideconnect.rideconnect.Repository;

import com.rideconnect.rideconnect.Models.Driver_Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import jakarta.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface Driver_OfferRepository extends JpaRepository<Driver_Offer, Integer> {

    List<Driver_Offer> findByStatus(String status);
    

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT d FROM Driver_Offer d WHERE d.Offer_ID = :offerId")
    Optional<Driver_Offer> findIdWithLock(@Param("offerId") int offerId);

    @Modifying
    @Transactional
    @Query("UPDATE Driver_Offer d SET d.status = 'Accepted', d.Driver_ID = :driverId WHERE d.Offer_ID = :offerId")
    int accept_offer(@Param("offerId") int offerId, @Param("driverId") int driverId);


}

