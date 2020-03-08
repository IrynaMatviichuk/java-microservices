package com.euclient.apartmentsService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentsRepository extends JpaRepository<Apartments, Long> {
}
