package ahmed.mabrouk.gestiondestock.model;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;



@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable{


	@SequenceGenerator(
			name = "sequence",
			sequenceName = "sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "sequence"
			)
	@Column (
			name = "id",
			updatable = false
			)
	private Integer id ;
	
	@CreatedDate
	@Column(name = "createDate", nullable = false)
	@JsonIgnore
	private Instant createDate;
	
	@LastModifiedDate
	@Column(name = "lastUpdateDate")
	@JsonIgnore
	private Instant lastUpdateDate;

}
