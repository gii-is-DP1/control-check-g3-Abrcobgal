package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RecoveryRoom extends BaseEntity{
	@NotNull
	@Size(min=3, max=50)
    String name;
	
	@NotNull
	@Min(0)
    double size;
	
	@NotNull
    boolean secure;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "recovery_room_type_id")
    RecoveryRoomType roomType;
	
	@ManyToOne
	@JoinColumn(name = "visit_id")
    Visit visit;
}
