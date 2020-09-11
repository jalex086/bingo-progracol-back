package com.progracol.backend.apirest.models.juego.dto;

import java.time.Instant;

public class BingoParamBoardWinnersDTO {

	private Long id;
	private Integer[] boardNumbers;
	private String status;
	private Instant createdAt;
	private String createdBy;
	private Instant lastUpdatedAt;
	private String lastUpdatedBy;
	private Instant deletedAt;
	private String deletedBy;
	private Integer[] sensorValues;

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

	public Integer[] getSensorValues() {
		return sensorValues;
	}

	public void setSensorValues(Integer[] sensorValues) {
		this.sensorValues = sensorValues;
	}

}
