package com.progracol.backend.apirest.models.juego.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.progracol.backend.apirest.generic.types.IntArrayType;

/**
 * Clase que mapea los atributos de la tabla bingo_param_board <br>
 * 
 * @Autor Jonathan Mosquera.</a></br>
 */

@TypeDefs({ @TypeDef(name = "int-array", typeClass = IntArrayType.class) })

@Entity
@Table(name = "bingo_param_board")
public class BingoParamBoard implements Serializable {

	private static final long serialVersionUID = -2559767390604256502L;

	@Id
	@SequenceGenerator(name = "bingo_param_board_board_id_seq", sequenceName = "bingo_param_board_board_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "bingo_param_board_board_id_seq")
	@Column(name = "board_id", nullable = false)
	private Long id;

	@NotNull
	@Type(type = "int-array")
	@Column(name = "board_numbers", columnDefinition = "int[]", nullable = false)
	private Integer[] boardNumbers;

	@NotNull
	@Type(type = "int-array")
	@Column(name = "sensor_values", columnDefinition = "int[]", nullable = false)
	private Integer[] sensorValues;

	@Size(max = 1)
	@NotNull
	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@NotNull
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@NotNull
	@Size(max = 36)
	@Column(name = "created_by", nullable = false, length = 36)
	private String createdBy;

	@Column(name = "last_updated_at")
	private Instant lastUpdatedAt;

	@Size(max = 36)
	@Column(name = "last_updated_by", length = 36)
	private String lastUpdatedBy;

	@Column(name = "deleted_at")
	private Instant deletedAt;

	@Size(max = 36)
	@Column(name = "deleted_by", length = 36)
	private String deletedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer[] getBoardNumbers() {
		return boardNumbers;
	}

	public void setBoardNumbers(Integer[] boardNumbers) {
		this.boardNumbers = boardNumbers;
	}

	public Integer[] getSensorValues() {
		return sensorValues;
	}

	public void setSensorValues(Integer[] sensorValues) {
		this.sensorValues = sensorValues;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Instant lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Instant getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Instant deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

}
