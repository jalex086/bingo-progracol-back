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

import com.progracol.backend.apirest.generic.types.BooleanArrayType;

/**
 * Clase que mapea los atributos de la tabla bingo_param_figure <br>
 * 
 * @Autor Jonathan Mosquera.</a></br>
 */

@TypeDefs({ @TypeDef(name = "boolean-array", typeClass = BooleanArrayType.class) })

@Entity
@Table(name = "bingo_param_figure")
public class BingoParamFigure implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2186129854457558658L;

	@Id
	@SequenceGenerator(name = "bingo_param_figure_figure_id_seq", sequenceName = "bingo_param_figure_figure_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "bingo_param_figure_figure_id_seq")
	@Column(name = "figure_id", nullable = false)
	private Long id;

	@NotNull
	@Column(name = "group_figure_id", nullable = false)
	private Long gropuFigureId;

	@Size(max = 100)
	@NotNull
	@Column(name = "figure_name", length = 100, nullable = false)
	private String figureName;

	@NotNull
	@Type(type = "boolean-array")
	@Column(name = "positions_winner", columnDefinition = "boolean[]", nullable = false)
	private Boolean[] positionWinner;

	@Size(max = 1)
	@NotNull
	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@NotNull
	@Column(name = "created_by", nullable = false)
	private Integer createdBy;

	@NotNull
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;

	@Column(name = "last_updated_at")
	private Instant lastUpdatedAt;

	@Column(name = "last_updated_by")
	private Integer lastUpdatedBy;

	@Column(name = "deleted_at")
	private Instant deletedAt;

	@Column(name = "deleted_by")
	private Integer deletedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGropuFigureId() {
		return gropuFigureId;
	}

	public void setGropuFigureId(Long gropuFigureId) {
		this.gropuFigureId = gropuFigureId;
	}

	public String getFigureName() {
		return figureName;
	}

	public void setFigureName(String figureName) {
		this.figureName = figureName;
	}

	public Boolean[] getPositionWinner() {
		return positionWinner;
	}

	public void setPositionWinner(Boolean[] positionWinner) {
		this.positionWinner = positionWinner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Instant lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public Integer getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Integer lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Instant getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Instant deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Integer getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Integer deletedBy) {
		this.deletedBy = deletedBy;
	}

}
