package com.progracol.backend.apirest.models.juego.dto;

import java.time.Instant;

/**
 * Clase que mapea los atributos de la tabla bingo_param_figure <br>
 * 
 * @Autor Jonathan Mosquera.</a></br>
 */

public class BingoParamFigureDTO {

	private Long id;
	private Long gropuFigureId;
	private String figureName;
	private Boolean[] positionWinner;
	private String status;
	private String createdBy;
	private Instant createdAt;
	private Instant lastUpdatedAt;
	private String lastUpdatedBy;
	private Instant deletedAt;
	private String deletedBy;

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
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
