package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository  extends CrudRepository<RecoveryRoom, Integer> {
	
	@Query("SELECT r FROM RecoveryRoom r")
    List<RecoveryRoom> findAll();
	
    @Query("SELECT r FROM RecoveryRoomType r")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    
    @Query("SELECT r FROM RecoveryRoom r WHERE RecoveryRoom.id =?1")
    Optional<RecoveryRoom> findById(int id);
        
    @Query("SELECT r FROM RecoveryRoomType r WHERE RecoveryRoom.name =?1")
    RecoveryRoomType getRecoveryRoomType(String nombre);
    
    @Query("SELECT r FROM RecoveryRoom r WHERE p.size>=?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
